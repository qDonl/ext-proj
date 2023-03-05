package top.donl.health.common.util;

import top.donl.health.common.ConstantPair;
import top.donl.util.common.domain.info.UserInfo;
import top.donl.util.jwt.JwtTokenUtil;

/**
 * token 处理工具
 */


public final class JwtUtils {

    /**
     * 生成token
     */
    public static String generateToken(Object obj) {
        assert obj != null;
        return JwtTokenUtil.generateJwtToken(obj, ConstantPair.CLAIM_KEY, ConstantPair.PRIVATE_TOKEN, ConstantPair.EXPIRE);
    }

    /**
     * 解析token
     */
    public static UserInfo parseToken(String token) {
        assert token != null;
        return JwtTokenUtil.parseObjFromToken(token, ConstantPair.PUBLIC_TOKEN, ConstantPair.ALGORITHM, ConstantPair.CLAIM_KEY, UserInfo.class);
    }
}
