package com.leo.admin.service.impl;

import com.leo.common.model.dto.Page;
import com.leo.admin.dao.DeptDAO;
import com.leo.admin.model.dto.QueryParam;
import com.leo.admin.service.DeptService;
import com.leo.common.model.domain.DeptDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author XieLY
 * @Description //TODO 部门服务
 * @Date 16:47 2019/7/2
 * @Param
 * @Eamil 540236979@qq.com
 * @return
 */
@Transactional(rollbackFor = {RuntimeException.class})
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptDAO deptDAO;

    /**
     * 通过主键获取部门
     *
     * @param id 主键
     * @return {@link DeptDO}
     */
    @Transactional(readOnly = true, rollbackFor = {RuntimeException.class})
    @Override
    public DeptDO get(Long id) {
        return deptDAO.get(id);
    }

    /**
     * 查询部门列表页
     *
     * @param queryParam 查询参数
     * @return {@link Page}
     */
    @Transactional(readOnly = true, rollbackFor = {RuntimeException.class})
    @Override
    public Page findPage(QueryParam queryParam) {
        Page page = new Page();
        List<DeptDO> depts;
        int total = deptDAO.count(queryParam);
        page.setTotal(total);
        if (total > 0) {
            depts = deptDAO.find(queryParam);
            page.setRows(depts);
        } else {
            page.setRows(new ArrayList<>());
        }
        return page;
    }

    /**
     * 新增部门
     *
     * @param deptDO
     * @return true 成功 false 失败
     */
    @Override
    public boolean save(DeptDO deptDO) {
        return deptDAO.save(deptDO) > 0;
    }

    /**
     * 更新部门
     *
     * @param deptDO
     * @return true 成功 false 失败
     */
    @Override
    public boolean update(DeptDO deptDO) {
        return deptDAO.update(deptDO) > 0;
    }

    /**
     * 删除部门
     *
     * @param id 部门ID
     * @return true 成功 false 失败
     */
    @Override
    public boolean delete(Long id) {
        return deptDAO.delete(id) > 0;
    }

    /**
     * 获取所有部门
     *
     * @return List<DeptDO>
     */
    @Transactional(readOnly = true, rollbackFor = {RuntimeException.class})
    @Override
    public List<DeptDO> findAll() {
        return deptDAO.find(new QueryParam());
    }
}
