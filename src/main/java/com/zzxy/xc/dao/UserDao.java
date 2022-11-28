package com.zzxy.xc.dao;

import com.zzxy.xc.entity.User;
import com.zzxy.xc.vo.UsermemberVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

//用户数据层接口
@Mapper
public interface UserDao {


    /**
     * 通过用户id修改用户状态
     * @param id
     * @param valid
     * @return
     */
    @Update("update xc_users set valid = #{valid} where id = #{id}")
    Integer updateValid(@Param("id") Integer id, @Param("valid") Integer valid);

    /**
     * 通过用户名查找用户
     * @param username
     * @return
     */
    @Select("select * from xc_users where username = #{username}")
    User findUserByName(String username);

    /**
     * 添加用户
     * @param user
     * @return
     */
    Integer insertUser(User user);

    /**
     * 通过用户id查找角色
     * @param userId
     * @return
     */
    List<Integer> findRoleByUserId(Integer userId);

    /**
     * 修改用户
     * @param user
     * @return
     */
    Integer updateUser(User user);
}
