package com.handsome.jay.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.handsome.jay.common.RetResponse;
import com.handsome.jay.common.RetResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.handsome.jay.service.DetailedService;
import com.handsome.jay.entity.Detailed;
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
@RequestMapping("/detailed")
public class DetailedController {

    @Resource
    private DetailedService detailedService;

    /**
     * 分页查询接口
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/page")
    public RetResult<IPage<Detailed>> page(@RequestParam Integer pageNum,@RequestParam Integer pageSize){
        QueryWrapper<Detailed> queryWrapper= new QueryWrapper<>();
        return RetResponse.success(detailedService.page(new Page<>(pageNum, pageSize),queryWrapper));
    }

}