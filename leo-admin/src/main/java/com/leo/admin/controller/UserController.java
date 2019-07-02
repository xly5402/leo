package com.leo.admin.controller;

import com.leo.admin.model.dto.QueryParam;
import com.leo.admin.model.dto.UserInfo;
import com.leo.admin.model.vo.UserVO;
import com.leo.admin.service.MenuService;
import com.leo.admin.service.RoleService;
import com.leo.admin.service.UserService;
import com.leo.common.model.domain.RoleDO;
import com.leo.common.model.domain.UserDO;
import com.leo.common.model.dto.Page;
import com.leo.common.model.dto.Responses;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @Author XieLY
 * @Description //TODO 用户
 * @Date 16:41 2019/7/2
 * @Param
 * @Eamil 540236979@qq.com
 * @return
 */
@Api(tags = "用户服务")
@RequestMapping("user")
@RestController
public class UserController extends BaseController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private MenuService menuService;

    @GetMapping("{id}")
    @ApiOperation("获取用户详情")
    public Responses get(@PathVariable("id") Long id) {
        UserDO user = userService.get(id);
        Responses r = Responses.success();
        r.setData(user);
        return r;
    }

    @GetMapping("{id}/role")
    @ApiOperation("获取用户角色详情")
    public List<RoleDO> getUserRole(@PathVariable("id") Long id) {
        return roleService.findByUserId(id);
    }

    @GetMapping
    @ApiOperation("查询用户列表")
    public Responses find(QueryParam queryParam) {
        Page page = userService.findPage(queryParam);
        Responses r = Responses.success();
        r.setData(page);
        return r;
    }

    @PostMapping
    @ApiOperation("添加用户")
    public Responses save(@Valid @RequestBody UserVO userVO) {
        userVO.setPassword(userService.encryptPassword(userVO.getNewPassword()));
        return Responses.operate(userService.save(userVO));
    }

    @PutMapping
    @ApiOperation("更新用户信息")
    public Responses update(@RequestBody UserVO userVO) {
        if (StringUtils.isNotBlank(userVO.getNewPassword())) {
            userVO.setPassword(userService.encryptPassword(userVO.getNewPassword()));
        }
        return Responses.operate(userService.update(userVO));
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "删除用户", notes = "根据用户ID删除")
    public Responses delete(@PathVariable("id") Long id) {
        return Responses.operate(userService.delete(id));
    }

    @GetMapping("username/{username}")
    @ApiOperation(value = "获取用户详情", notes = "根据用户名获取用户详情")
    public UserDO getByUsername(@PathVariable("username") String username) {
        return userService.getByUsername(username);
    }

    @GetMapping("email/{email}")
    @ApiOperation(value = "获取用户详情", notes = "根据邮箱获取用户详情")
    public UserDO getByEmail(@PathVariable("email") String email) {
        return userService.getByEmail(email);
    }

    @GetMapping("mobilephone/{mobilephone}")
    @ApiOperation(value = "获取用户详情", notes = "根据手机获取用户详情")
    public UserDO getByMobilephone(@PathVariable("mobilephone") String mobilephone) {
        return userService.getByMobilephone(mobilephone);
    }

    @GetMapping("info")
    @ApiOperation("个人信息")
    public UserInfo info() {
        String username = getUsername();
        UserDO user = userService.getByUsername(username);
        UserInfo userInfo = new UserInfo();
        userInfo.setUser(user);
        userInfo.setPermissions(menuService.getUserPermission(user.getId()));
        return userInfo;
    }
}
