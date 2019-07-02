package com.leo.admin.controller;

import com.leo.admin.model.dto.QueryParam;
import com.leo.admin.model.vo.DeptTreeVO;
import com.leo.admin.service.DeptService;
import com.leo.admin.util.TreeUtil;
import com.leo.common.model.domain.DeptDO;
import com.leo.common.model.dto.Page;
import com.leo.common.model.dto.Responses;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author XieLY
 * @Description //TODO 部门
 * @Date 16:36 2019/7/2
 * @Param
 * @Eamil 540236979@qq.com
 * @return
 */
@Api(tags = "部门服务")
@RequestMapping("dept")
@RestController
public class DeptController extends BaseController {
    @Autowired
    private DeptService deptService;

    @GetMapping("{id}")
    @ApiOperation("获取部门详情")
    public Responses get(@PathVariable("id") Long id) {
        DeptDO dept = deptService.get(id);
        Responses r = Responses.success();
        r.setData(dept);
        return r;
    }

    @GetMapping
    @ApiOperation("查询部门列表")
    public Responses find(QueryParam queryParam) {
        Page page = deptService.findPage(queryParam);
        Responses r = Responses.success();
        r.setData(page);
        return r;
    }

    @PostMapping
    @ApiOperation("添加部门")
    public Responses save(@Valid @RequestBody DeptDO deptDO) {
        return Responses.operate(deptService.save(deptDO));
    }

    @PutMapping
    @ApiOperation("更新部门信息")
    public Responses update(@RequestBody DeptDO deptDO) {
        return Responses.operate(deptService.update(deptDO));
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "删除部门", notes = "根据部门ID删除")
    public Responses delete(@PathVariable("id") Long id) {
        return Responses.operate(deptService.delete(id));
    }

    @GetMapping("tree")
    @ApiOperation("查询部门树")
    public Responses findDeptTree() {
        Responses r = Responses.success();
        List<DeptDO> depts = deptService.findAll();
        List<DeptTreeVO> deptTrees = new ArrayList<>();
        depts.forEach(deptDO -> {
            deptTrees.add(new DeptTreeVO(deptDO));
        });
        Collections.sort(deptTrees, Comparator.comparingInt(DeptTreeVO::getSequence));
        r.setData(TreeUtil.build(deptTrees, 0L));
        return r;
    }
}
