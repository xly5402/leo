package com.leo.auth.userdetails;

import com.leo.auth.remote.UserApiService;
import com.leo.common.model.domain.RoleDO;
import com.leo.common.model.domain.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: fineJadeParent
 * @Date: 2019/6/17 15:16
 * @Version 1.0
 * @Author: XieLY
 * @Description:
 */
@Service("userDetailService")
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserApiService userApiService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDO userDO = userApiService.getByUsername(username);
        List<RoleDO> roles = userApiService.getUserRole(userDO.getId());
        return new UserDetailsImpl(userDO, roles);
    }
}
