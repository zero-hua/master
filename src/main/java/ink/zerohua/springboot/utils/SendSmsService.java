package ink.zerohua.springboot.utils;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

import java.util.UUID;

public class SendSmsService {

    public static String sendSms(String phoneNumber){


        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);

        //此处不能动！
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");

        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phoneNumber);
        request.putQueryParameter("SignName", "Jere博客");
        request.putQueryParameter("TemplateCode", "SMS_189610921");

        String code = UUID.randomUUID().toString().substring(0,4);
        System.out.println(code);

//        "{\"code\":\"1221\"}"
        request.putQueryParameter("TemplateParam", "{\"code\":\""+code+"\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return code;
    }
}
