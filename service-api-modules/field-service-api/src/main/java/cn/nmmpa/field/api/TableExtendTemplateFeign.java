package cn.nmmpa.field.api;

import cn.nmmpa.common.response.ResultEntity;
import cn.nmmpa.field.vo.TableExtendTemplateAddReqVo;
import cn.nmmpa.field.vo.TableExtendTemplateDeleteReqVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author: tan shuai
 * @Date: 2019/8/30 15:58
 * @Version 1.0
 */
@FeignClient(value = "FIELD-SERVICE-MODULES")
public interface TableExtendTemplateFeign {

    /**
     * 新增扩展字段模板
     * @param templateAddReqVo
     * @return
     */
    @PostMapping("/add")
    ResultEntity add(@RequestBody TableExtendTemplateAddReqVo templateAddReqVo);

    /**
     * 查询当前站点对应库扩展字段模板
     * @param siteCode
     * @param tableCode
     * @return
     */
    @GetMapping("/selectByFields")
    ResultEntity<List<String>> selectByFields(@RequestParam String siteCode,
                                                     @RequestParam String tableCode);

    /**
     * 查询当前站点下对应扩展字段模板
     * @param templateDeleteReqVo
     * @return
     */
    @PostMapping("/deleteById")
    ResultEntity deleteById(@RequestBody TableExtendTemplateDeleteReqVo templateDeleteReqVo);
}
