package top.donl.health;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import top.donl.health.common.ConstantPair;
import top.donl.util.common.domain.info.UserInfo;
import top.donl.util.json.JacksonUtil;
import top.donl.util.jwt.JwtTokenUtil;

/**
 * <p></p>
 *
 * @author crux
 * @since 2023/02/10 10:12:37
 */


@SpringBootTest
public class MentalHealthApplicationTest {

    @Test
    public void contextLoads() {

    }

    @Test
    public void testGenerateToken() {
        JwtTokenUtil.KeyPairs keyPairs = JwtTokenUtil.generatePublicKeyAndPrivateKey(ConstantPair.ALGORITHM);
        System.out.println(keyPairs.getPrivateKeyStr());
        System.out.println(keyPairs.getPublicKeyStr());
    }

    @Test
    public void testToken() {
        UserInfo userInfo = new UserInfo(100L, "zhangsan");
        String token = JwtTokenUtil.generateJwtToken(userInfo, ConstantPair.CLAIM_KEY, ConstantPair.PRIVATE_TOKEN, 10);
        System.out.println(token);
        UserInfo uInfo = JwtTokenUtil.parseObjFromToken(token, ConstantPair.PUBLIC_TOKEN, ConstantPair.ALGORITHM, ConstantPair.CLAIM_KEY, UserInfo.class);
        System.out.println(JacksonUtil.toJson(uInfo));
    }

}