package com.handsome.jay.dao;

import com.handsome.jay.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jay
 * @since 2023-03-16
 */
@Mapper
public interface UserDao extends BaseMapper<User> {

}
