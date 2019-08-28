package cn.nmmpa.user.service.impl;

import cn.nmmpa.user.model.TableExtendTemplate;
import cn.nmmpa.user.service.ITableExtendTemplateService;
import cn.nmmpa.common.base.service.impl.BaseServiceImpl;
import cn.nmmpa.user.vo.TableExtendTemplateAddReqVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import cn.nmmpa.user.mapper.TableExtendTemplateMapper;

import java.util.Date;

/**
 * @author TanShuai
 * @version 1.0 2019年8月28日
 */
@Service
public class TableExtendTemplateServiceImpl extends BaseServiceImpl<TableExtendTemplateMapper , TableExtendTemplate> implements ITableExtendTemplateService {

    @Autowired
    private TableExtendTemplateMapper tableExtendTemplateMapper;

    @Override
    public TableExtendTemplateMapper getMapper(){ 
       return tableExtendTemplateMapper;
    }

    @Override
    public void add(TableExtendTemplateAddReqVo templateAddReqVo) {
        Date date = new Date();
        TableExtendTemplate tableExtendTemplate = new TableExtendTemplate();
        BeanUtils.copyProperties(templateAddReqVo , tableExtendTemplate);
        tableExtendTemplate.setIsDelete(0);
        tableExtendTemplate.setCreateTime(date);
        tableExtendTemplate.setUpdateTime(date);
        this.tableExtendTemplateMapper.insert(tableExtendTemplate);
    }
}