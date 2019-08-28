package cn.nmmpa.user.mapper;

import cn.nmmpa.user.model.TableExtendTemplate;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import cn.nmmpa.common.base.mapper.BaseMapper;

import java.util.List;

/**
 * @author TanShuai
 * @version 1.0 2019年8月28日
 */
@Repository
@Mapper
public interface TableExtendTemplateMapper extends BaseMapper<TableExtendTemplate> {

    /**
     * 查询表对应的扩展字段
     * @param siteCode
     * @param tableCode
     * @return
     */
    List<String> selectByFields(String siteCode , String tableCode);
}