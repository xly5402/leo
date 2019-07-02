package com.leo.admin.service;

import com.leo.admin.model.dto.QueryParam;
import com.leo.common.model.domain.DeptDO;
import com.leo.common.model.dto.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author XieLY
 * @Description //TODO
 * @Date 16:53 2019/7/2
 * @Param
 * @Eamil 540236979@qq.com
 * @return
 */
@Service
public interface DeptService {
    /**
     * 通过主键获取部门
     *
     * @param id 主键
     * @return {@link DeptDO}
     */
    DeptDO get(Long id);

    /**
     * 查询部门列表页
     *
     * @param queryParam 查询参数
     * @return {@link Page}
     */
    Page findPage(QueryParam queryParam);

    /**
     * 新增部门
     *
     * @param deptDO
     * @return true 成功 false 失败
     */
    boolean save(DeptDO deptDO);

    /**
     * 更新部门
     *
     * @param deptDO
     * @return true 成功 false 失败
     */
    boolean update(DeptDO deptDO);

    /**
     * 删除部门
     *
     * @param id 部门ID
     * @return true 成功 false 失败
     */
    boolean delete(Long id);

    /**
     * 获取所有部门
     *
     * @return List<DeptDO>
     */
    List<DeptDO> findAll();
}
