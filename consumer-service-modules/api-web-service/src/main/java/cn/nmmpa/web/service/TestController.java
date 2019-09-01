package cn.nmmpa.web.service;

import cn.nmmpa.common.response.ResultEntity;
import cn.nmmpa.field.api.TableExtendTemplateFeign;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by TS on 2019/8/31.
 */
@RestController
@RequestMapping("/web")
@Api(description = "测试")
public class TestController {

    @Autowired
    private TableExtendTemplateFeign tableExtendTemplateFeign;

    @ApiOperation("获取当前表扩展字段")
    @GetMapping("/selectByFields")
    public ResultEntity<List<String>> selectByFields(@RequestParam String siteCode,
                                                     @RequestParam String tableCode){
        return tableExtendTemplateFeign.selectByFields(siteCode , tableCode);
    }
}
