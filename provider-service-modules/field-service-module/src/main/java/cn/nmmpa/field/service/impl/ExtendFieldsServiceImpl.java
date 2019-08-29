package cn.nmmpa.field.service.impl;

import cn.nmmpa.field.model.ExtendFields;
import cn.nmmpa.field.service.IExtendFieldsService;
import cn.nmmpa.common.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import cn.nmmpa.field.mapper.ExtendFieldsMapper;

/**
 * @author TanShuai
 * @version 1.0 2019年8月29日
 */
@Service
public class ExtendFieldsServiceImpl extends BaseServiceImpl<ExtendFieldsMapper , ExtendFields> implements IExtendFieldsService {

    @Autowired
    private ExtendFieldsMapper extendFieldsMapper;

    @Override
    public ExtendFieldsMapper getMapper(){ 
       return extendFieldsMapper;
    }

}