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
import com.handsome.jay.service.UserService;
import com.handsome.jay.entity.User;
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
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 查询所有接口
     * @return
     */
    @GetMapping
    public RetResult<List<User>> list(){
        return RetResponse.success(userService.list());
    }

    /**
     * 根据id查询数据接口
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public RetResult<User> getById(@PathVariable Integer id){
        return RetResponse.success(userService.getById(id));
    }

    /**
     * 分页查询接口
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/page")
    public RetResult<IPage<User>> page(@RequestParam Integer pageNum,@RequestParam Integer pageSize){
        QueryWrapper<User> queryWrapper=new QueryWrapper<User>();
        return RetResponse.success(userService.page(new Page<User>(pageNum,pageSize),queryWrapper));
    }

    /**
     * 新增和更新接口
     * @param user
     * @return
     */
    @PostMapping
    public RetResult<User> saveOrUpdate(@RequestBody User user){
        userService.saveOrUpdate(user);
        return RetResponse.success(user);
    }
    /**
     * 删除接口
     * @param id
     * @return
     */
    @PostMapping("/del/{id}")
    public RetResult<Boolean> delete(@PathVariable Integer id){
        return RetResponse.success(userService.removeById(id));
    }
    /**
     * 批量删除接口
     * @param ids
     * @return
     */
    @PostMapping("/del/batch")
    public RetResult<Boolean> deleteBatch(@RequestBody List<Integer> ids){
        return RetResponse.success(userService.removeByIds(ids));
    }

}