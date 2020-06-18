package ink.zerohua.springboot.utils;

import org.apache.commons.codec.binary.Hex;
import org.apache.shiro.crypto.hash.SimpleHash;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EnCode {

    public static String getEnCodeStr(String source,String salt){
        String s = new SimpleHash("SHA-256",source,salt,2).toString();
        return s;
    }
}
