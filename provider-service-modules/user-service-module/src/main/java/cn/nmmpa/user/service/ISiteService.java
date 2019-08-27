package cn.nmmpa.user.service;

import cn.nmmpa.user.model.Site;
import cn.nmmpa.common.base.service.IBaseService;
import cn.nmmpa.user.vo.SiteLoginRespVo;
import cn.nmmpa.user.vo.SiteSecretVo;

/**
 * @author TanShuai
 * @version 1.0 2019年8月26日
 */
public interface ISiteService extends IBaseService<Site> {


    /**
     * 站点登陆
     * @param account
     * @param passWord
     * @param sign
     * @return
     */
    SiteLoginRespVo login(String account , String passWord , String sign) throws Exception;

    /**
     * 获取当前站点的appId和secret
     * @return
     */
    SiteSecretVo getSecret() throws Exception;



}