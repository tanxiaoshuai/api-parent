package cn.nmmpa.user.controller;

import cn.nmmpa.common.response.ResultEntity;
import cn.nmmpa.user.service.ISiteService;
import cn.nmmpa.user.vo.SiteLoginRespVo;
import cn.nmmpa.user.vo.SiteSecretVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by TS on 2019/8/26.
 */
@RestController
@RequestMapping("/site")
@Api(description = "站点")
public class SiteController {

    @Autowired
    private ISiteService siteService;

    @ApiOperation("站点登陆")
    @GetMapping("/login")
    public ResultEntity<SiteLoginRespVo> login(@RequestParam String account,
                                               @RequestParam String passWord,
                                               @RequestParam String sign){
        return ResultEntity.success(siteService.login(account , passWord , sign));
    }

    @ApiOperation("查看appId和Secret")
    @GetMapping("/secret")
    public ResultEntity<SiteSecretVo> getSecret(){
        return ResultEntity.success(siteService.getSecret());
    }

}
