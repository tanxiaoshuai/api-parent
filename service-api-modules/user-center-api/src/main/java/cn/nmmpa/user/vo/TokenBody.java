package cn.nmmpa.user.vo;

import cn.nmmpa.token.vo.BaseBody;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created by TS on 2019/8/26.
 */
@Data
@Accessors(chain = true)
public class TokenBody extends BaseBody{

    private String siteCode;

}
