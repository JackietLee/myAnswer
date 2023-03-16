package com.handsome.jay.dao;

import com.handsome.jay.entity.Wallet;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jay
 * @since 2023-03-16
 */
@Mapper
public interface WalletDao extends BaseMapper<Wallet> {

    Wallet getWalletByUserId(@Param("userId") int userId);
}
