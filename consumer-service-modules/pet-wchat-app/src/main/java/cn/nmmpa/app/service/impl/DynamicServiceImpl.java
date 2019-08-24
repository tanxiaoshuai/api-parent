package cn.nmmpa.app.service.impl;

import cn.nmmpa.app.service.IDynamicService;
import cn.nmmpa.common.response.FeignUtil;
import cn.nmmpa.common.response.ResultEntity;
import cn.nmmpa.dynamic.api.DynamicApi;
import cn.nmmpa.dynamic.model.Dynamic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: tan shuai
 * @Date: 2019/7/31 15:03
 * @Version 1.0
 */

@Service
public class DynamicServiceImpl implements IDynamicService {

    @Autowired
    private DynamicApi dynamicApi;


    @Override
    public ResultEntity<Dynamic> selectById(Long id) throws Exception {
        ResultEntity<Dynamic> dynamicResultEntity = dynamicApi.selectById(id);
        Dynamic dynamic = FeignUtil.getData(dynamicResultEntity);
        return ResultEntity.success(dynamic);
    }
}
