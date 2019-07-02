package com.leo.admin.controller;

import com.leo.admin.model.dto.QueryParam;
import com.leo.admin.service.RoleService;
import com.leo.common.model.domain.RoleDO;
import com.leo.common.model.dto.Page;
import com.leo.common.model.dto.Responses;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Author XieLY
 * @Description //TODO 角色
 * @Date 16:36 2019/7/2
 * @Param
 * @Eamil 540236979@qq.com
 * @return
 */
@Api(tags = "角色服务")
@RequestMapping("role")
@RestController
public class RoleController extends BaseController {
    @Autowired
    private RoleService roleService;

    @GetMapping("{id}")
    @ApiOperation("获取角色详情")
    public Responses get(@PathVariable("id") Long id) {
        RoleDO role = roleService.get(id);
        Responses r = Responses.success();
        r.setData(role);
        return r;
    }

    @GetMapping
    @ApiOperation("查询角色列表")
    public Responses find(QueryParam queryParam) {
        Page page = roleService.findPage(queryParam);
        Responses r = Responses.success();
        r.setData(page);
        return r;
    }

    @PostMapping
    @ApiOperation("添加角色")
    public Responses save(@Valid @RequestBody RoleDO roleDO) {
        return Responses.operate(roleService.save(roleDO));
    }

    @PutMapping
    @ApiOperation("更新角色信息")
    public Responses update(@RequestBody RoleDO roleDO) {
        return Responses.operate(roleService.update(roleDO));
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "删除角色", notes = "根据角色ID删除")
    public Responses delete(@PathVariable("id") Long id) {
        return Responses.operate(roleService.delete(id));
    }
}
