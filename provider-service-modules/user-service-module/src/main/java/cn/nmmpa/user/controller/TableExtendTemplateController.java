package cn.nmmpa.user.controller;

import cn.nmmpa.common.response.ResultEntity;
import cn.nmmpa.user.service.ITableExtendTemplateService;
import cn.nmmpa.user.vo.TableExtendTemplateAddReqVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: tan shuai
 * @Date: 2019/8/28 17:30
 * @Version 1.0
 */
@RestController
@RequestMapping("/tableExtendTemplate")
@Api(description = "表字段扩展")
public class TableExtendTemplateController {

    @Autowired
    private ITableExtendTemplateService tableExtendTemplateService;

    @ApiOperation("新增字段")
    @PostMapping("/add")
    public ResultEntity add(@RequestBody TableExtendTemplateAddReqVo templateAddReqVo){
        tableExtendTemplateService.add(templateAddReqVo);
        return ResultEntity.success();
    }

    @ApiOperation("获取当前表扩展字段")
    public ResultEntity<List<String>> selectByFields(String siteCode, String tableCode){
        return ResultEntity
                .success(tableExtendTemplateService.selectByFields(siteCode , tableCode));

    }
}
