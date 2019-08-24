package cn.nmmpa.app.service;

import cn.nmmpa.common.response.ResultEntity;
import cn.nmmpa.dynamic.model.Dynamic;

/**
 * @Author: tan shuai
 * @Date: 2019/7/31 15:03
 * @Version 1.0
 */
public interface IDynamicService {

    ResultEntity<Dynamic> selectById(Long id) throws Exception;
}
