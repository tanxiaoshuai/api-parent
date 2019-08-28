package cn.nmmpa.user.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import cn.nmmpa.common.base.model.BaseModel;

/**
 * @author TanShuai
 * @version 1.0 2019年8月28日
 */
@Data
@EqualsAndHashCode
@SuppressWarnings("serial")
@ApiModel(value = "")
public class TableExtendTemplate extends BaseModel {

    @ApiModelProperty("站点")
    private String siteCode;
    @ApiModelProperty("字段")
    private String field;
    @ApiModelProperty("字段描述")
    private String describe;
    @ApiModelProperty("扩展表code")
    private String tableCode;
    @ApiModelProperty("逻辑删除 0未删除 1删除")
    private Integer isDelete;

}