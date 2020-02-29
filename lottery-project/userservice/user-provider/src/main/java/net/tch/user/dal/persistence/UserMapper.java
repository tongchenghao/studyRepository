package net.tch.user.dal.persistence;

import net.tch.user.dal.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @description:user的数据层操作
 * @auth tongchenghao
 * @date 2020/2/25
 */
public interface UserMapper {

    User getUser(@Param("username") String username, @Param("password") String password);

    User getUserByName(String username);

    User getUserByUid(String uid);

    void insertSelective(User user);

}
