package ink.zerohua.springboot;

import ink.zerohua.springboot.utils.CodeSHA256;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootThymeleafApplicationTests {

    @Test
    void contextLoads() {
        String s = "zxcvbn";
        System.out.println(CodeSHA256.getSHA256Str(s));
    }

}
