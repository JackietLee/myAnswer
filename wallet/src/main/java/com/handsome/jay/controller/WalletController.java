package com.handsome.jay.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.handsome.jay.common.RetResponse;
import com.handsome.jay.common.RetResult;
import com.handsome.jay.vo.ConsumeVo;
import com.handsome.jay.vo.DrawbackVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.handsome.jay.service.WalletService;
import com.handsome.jay.entity.Wallet;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jay
 * @since 2023-03-16
 */
@RestController
@RequestMapping("/wallet")
public class WalletController {

    @Resource
    private WalletService walletService;

    /**
     * 查询用户钱包余额
     * @return
     */
    @GetMapping("/getWalletByUserId")
    public RetResult<Wallet> getWalletByUserId(@RequestParam Integer userId){
        return RetResponse.success(walletService.getWalletByUserId(userId));
    }

    /**
     * 消费100元
     * @return
     */
    @PostMapping("/consume")
    public RetResult<Boolean> consume(@RequestBody ConsumeVo vo){
        return RetResponse.success(walletService.consume(vo));
    }

    /**
     * 退款20元
     * @return
     */
    @PostMapping("/drawback")
    public RetResult<Boolean> drawback(@RequestBody DrawbackVo vo){
        return RetResponse.success(walletService.drawback(vo));
    }
}