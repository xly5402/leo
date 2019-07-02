package com.leo.gateway.remote.fallback;

import com.leo.common.model.domain.MenuDO;
import com.leo.gateway.remote.MenuApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: fineJadeParent
 * @Date: 2019/6/20 11:32
 * @Version 1.0
 * @Author: XieLY
 * @Description: 菜单服务熔断回调
 */

@Slf4j
@Service
public class MenuApiServiceFallbackImpl implements MenuApiService {
    /**
     * 查询角色菜单
     *
     * @param roleKeys 角色Key
     * @return 菜单列表
     */
    @Override
    public List<MenuDO> findRoleMenu(List<String> roleKeys) {
        log.error("调用{}异常{}","findRoleMenu",roleKeys);
        return new ArrayList<>();
    }
}
