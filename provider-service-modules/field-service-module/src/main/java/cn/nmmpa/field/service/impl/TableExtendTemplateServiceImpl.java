package cn.nmmpa.field.service.impl;

import cn.nmmpa.field.model.TableExtendTemplate;
import cn.nmmpa.field.service.ITableExtendTemplateService;
import cn.nmmpa.common.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import cn.nmmpa.field.mapper.TableExtendTemplateMapper;

/**
 * @author TanShuai
 * @version 1.0 2019年8月29日
 */
@Service
public class TableExtendTemplateServiceImpl extends BaseServiceImpl<TableExtendTemplateMapper , TableExtendTemplate> implements ITableExtendTemplateService {

    @Autowired
    private TableExtendTemplateMapper tableExtendTemplateMapper;

    @Override
    public TableExtendTemplateMapper getMapper(){ 
       return tableExtendTemplateMapper;
    }

}