package com.handsome.jay.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.handsome.jay.constants.DetailStatus;
import com.handsome.jay.dao.DetailedDao;
import com.handsome.jay.entity.Detailed;
import com.handsome.jay.entity.Wallet;
import com.handsome.jay.dao.WalletDao;
import com.handsome.jay.service.WalletService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.handsome.jay.vo.ConsumeVo;
import com.handsome.jay.vo.DrawbackVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jay
 * @since 2023-03-16
 */
@Service
public class WalletServiceImpl extends ServiceImpl<WalletDao, Wallet> implements WalletService {

    @Autowired
    private DetailedDao detailedDao;

    public Wallet getWalletByUserId(Integer userId) {
        LambdaQueryWrapper<Wallet> wrapper = new LambdaQueryWrapper<Wallet>();
        wrapper.eq(Wallet::getUserId, userId);
        Wallet wallet = baseMapper.selectOne(wrapper);
        return wallet;
    }

    @Transactional
    public boolean consume(ConsumeVo vo) {
        LambdaQueryWrapper<Wallet> wrapper = new LambdaQueryWrapper<Wallet>();
        wrapper.eq(Wallet::getUserId, vo.getUserId());
        Wallet wallet = baseMapper.selectOne(wrapper); // 先查询出来钱包金额
        if (wallet.getMoney() < vo.getAmount()) {
            return false;
        }
        Wallet newWallet = new Wallet();
        newWallet.setMoney(wallet.getMoney() - vo.getAmount());
        newWallet.setId(wallet.getId());
        int updateFlag = baseMapper.updateById(newWallet);// 更新钱包金额
        if (updateFlag<1) {
            throw new RuntimeException();
        }
        Detailed detailed = new Detailed();
        detailed.setAmount(vo.getAmount());
        detailed.setWalletId(wallet.getId());
        detailed.setStatus(DetailStatus.OUT.getAmount());
        int insert = detailedDao.insert(detailed);
        if (insert < 1) {
            throw new RuntimeException();
        }
        return true;
    }

    @Transactional
    public boolean drawback(DrawbackVo vo) {
        LambdaQueryWrapper<Wallet> wrapper = new LambdaQueryWrapper<Wallet>();
        wrapper.eq(Wallet::getUserId, vo.getUserId());
        Wallet wallet = baseMapper.selectOne(wrapper); // 先查询出来钱包金额
        Wallet newWallet = new Wallet();
        newWallet.setMoney(wallet.getMoney() + vo.getAmount());
        newWallet.setId(wallet.getId());
        int updateFlag = baseMapper.updateById(newWallet);// 更新钱包金额
        if (updateFlag<1) {
            throw new RuntimeException();
        }
        Detailed detailed = new Detailed();
        detailed.setAmount(vo.getAmount());
        detailed.setWalletId(wallet.getId());
        detailed.setStatus(DetailStatus.IN.getAmount());
        int insert = detailedDao.insert(detailed);
        if (insert < 1) {
            throw new RuntimeException();
        }
        return true;
    }
}
