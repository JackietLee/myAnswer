package com.handsome.jay.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.handsome.jay.entity.Wallet;
import com.handsome.jay.vo.ConsumeVo;
import com.handsome.jay.vo.DrawbackVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jay
 * @since 2023-03-16
 */
public interface WalletService extends IService<Wallet> {

    boolean consume(ConsumeVo vo);

    boolean drawback(DrawbackVo vo);

    Wallet getWalletByUserId(Integer userId);
}
