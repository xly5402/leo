package com.leo.auth.remote.fallback;

import com.leo.auth.remote.UserApiService;
import com.leo.common.model.domain.RoleDO;
import com.leo.common.model.domain.UserDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: fineJadeParent
 * @Date: 2019/6/17 15:00
 * @Version 1.0
 * @Author: XieLY
 * @Description: 用户服务熔断回调
 */
@Slf4j
@Service
public class UserApiServiceFallbackImpl implements UserApiService {
    @Override
    public UserDO getByUsername(String username) {
        log.error("调用{}异常{}","getByUsername", username);
        return null;
    }

    @Override
    public List<RoleDO> getUserRole(Long id) {
        log.error("调用{}异常{}","getUserRole", id);
        return new ArrayList<>();
    }
}
