package com.leo.admin.controller;

import com.leo.admin.model.dto.QueryParam;
import com.leo.admin.model.dto.VueRouter;
import com.leo.admin.model.vo.MenuTreeVO;
import com.leo.admin.service.MenuService;
import com.leo.admin.util.TreeUtil;
import com.leo.common.constant.Constants;
import com.leo.common.model.domain.MenuDO;
import com.leo.common.model.dto.Page;
import com.leo.common.model.dto.Responses;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;


/**
 * @Author XieLY
 * @Description //TODO 菜单
 * @Date 16:36 2019/7/2
 * @Param
 * @Eamil 540236979@qq.com
 * @return
 */
@Api(tags = "菜单服务")
@RequestMapping("menu")
@RestController
public class MenuController extends BaseController {
    @Autowired
    private MenuService menuService;

    @GetMapping("{id}")
    @ApiOperation("获取菜单详情")
    public Responses get(@PathVariable("id") Long id) {
        MenuDO menu = menuService.get(id);
        Responses r = Responses.success();
        r.setData(menu);
        return r;
    }

    @GetMapping
    @ApiOperation("查询菜单列表")
    public Responses find(QueryParam queryParam) {
        Page page = menuService.findPage(queryParam);
        Responses r = Responses.success();
        r.setData(page);
        return r;
    }

    @PostMapping
    @ApiOperation("添加菜单")
    public Responses save(@Valid @RequestBody MenuDO menuDO) {
        return Responses.operate(menuService.save(menuDO));
    }

    @PutMapping
    @ApiOperation("更新菜单信息")
    public Responses update(@RequestBody MenuDO menuDO) {
        return Responses.operate(menuService.update(menuDO));
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "删除菜单", notes = "根据菜单ID删除")
    public Responses delete(@PathVariable("id") Long id) {
        return Responses.operate(menuService.delete(id));
    }

    @GetMapping("roleMenu")
    @ApiOperation("查询角色菜单")
    public List<MenuDO> findRoleMenu(@NotBlank @RequestParam String[] roleKeys) {
        List<String> keys = Arrays.asList(roleKeys);
        return menuService.getRoleMenu(keys);
    }

    @GetMapping("userMenu")
    @ApiOperation("查询用户路由树")
    public Responses findUserMenu() {
        Responses r = Responses.success();
        List<String> roleKeys = getRole();
        List<MenuDO> menus = menuService.getRoleMenu(roleKeys);
        List<VueRouter> routers = new ArrayList<>();
        menus.forEach(menuDO -> {
            if (Constants.MENU == menuDO.getType()) {
                routers.add(new VueRouter(menuDO));
            }
        });
        Collections.sort(routers, Comparator.comparingInt(VueRouter::getSort));
        r.setData(TreeUtil.build(routers, 0L));
        return r;
    }

    @GetMapping("tree")
    @ApiOperation("查询菜单树")
    public Responses findMenuTree() {
        Responses r = Responses.success();
        List<MenuDO> menus = menuService.findAll();
        List<MenuTreeVO> menuTrees = new ArrayList<>();
        menus.forEach(menuDO -> {
            menuTrees.add(new MenuTreeVO(menuDO));
        });
        Collections.sort(menuTrees, Comparator.comparingInt(MenuTreeVO::getSequence));
        r.setData(TreeUtil.build(menuTrees, 0L));
        return r;
    }
}
