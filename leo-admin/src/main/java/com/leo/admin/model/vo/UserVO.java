package com.leo.admin.model.vo;

import com.leo.common.model.domain.UserDO;
import lombok.Data;

/**
 * @Author XieLY
 * @Description //TODO 用户
 * @Date 16:46 2019/7/2
 * @Param
 * @Eamil 540236979@qq.com
 * @return
 */
@Data
public class UserVO extends UserDO {
    /**
     * 用户密码
     */
    private String newPassword;
}
