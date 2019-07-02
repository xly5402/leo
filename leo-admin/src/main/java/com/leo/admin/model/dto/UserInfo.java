package com.leo.admin.model.dto;

import com.leo.common.model.domain.UserDO;
import lombok.Data;

import java.util.List;

/**
 * @Author XieLY
 * @Description //TODO 系统用户信息
 * @Date 16:45 2019/7/2
 * @Param
 * @Eamil 540236979@qq.com
 * @return
 */
@Data
public class UserInfo extends BaseDTO {
    /**
     * 用户信息
     */
    private UserDO user;

    /**
     * 权限标识集合
     */
    private List<String> permissions;
}
