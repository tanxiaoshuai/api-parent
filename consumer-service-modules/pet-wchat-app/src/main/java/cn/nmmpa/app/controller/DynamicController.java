package cn.nmmpa.app.controller;

import cn.nmmpa.aop.formvalidation.AvoidRepeatableCommit;
import cn.nmmpa.aop.formvalidation.RequestLimit;
import cn.nmmpa.app.service.IDynamicService;
import cn.nmmpa.common.response.ResultEntity;
import cn.nmmpa.dynamic.model.Dynamic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: tan shuai
 * @Date: 2019/7/31 15:18
 * @Version 1.0
 */
@RestController
@RequestMapping("/dynamic")
public class DynamicController {

    @Autowired
    private IDynamicService dynamicService;

    @RequestLimit(time = 100)
    @PostMapping("/selectById/{id}")
    public ResultEntity<Dynamic> selectById(@PathVariable("id") Long id , @RequestBody Dynamic dynamic , String name) throws Exception{
        return dynamicService.selectById(id);
    }
}
