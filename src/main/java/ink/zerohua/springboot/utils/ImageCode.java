package ink.zerohua.springboot.utils;

import org.apache.shiro.web.session.HttpServletSession;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

public class ImageCode {

    //图片宽
    private static final int W = 100;
    //图片高
    private static final int H = 40;
    //验证码库,ctrl+shift+x,大小写转换
    private static final String CODE = "ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnpqrstuvwxyz23456789";
    //字符数量
    private static final int CODE_COUNT = 4;
    //干扰线条
    private static final int LINE_COUNT = 8;
    //验证码在session中的key
    private static final String RANDOMCODEKEY = "randomCode";

    Random random = new Random();

    //绘制图片的方法
    public void getCode(HttpServletRequest request, HttpServletResponse response){
        //生成图片
        BufferedImage image = new BufferedImage(W,H,BufferedImage.TYPE_INT_BGR);
        //获取画笔
        Graphics g = image.getGraphics();
        //设置画笔颜色,背景色
        g.setColor(Color.WHITE);
        //填充可绘制区域
        g.fillRect(0,0,W,H);
        //创建字体对象
        Font font = new Font("黑体",Font.BOLD,25);
        //字笔合一
        g.setFont(font);
        //存放code
        String codeStr = "";
        //循环结构,绘制验证码
        for(int i=0;i<CODE_COUNT;i++){
            //设置画笔颜色
            g.setColor(getColor());
            //get str from whrase
            char c = getChar();
            codeStr += c;
            //画到图像中
            g.drawString(c+"",i*20+5,25);
        }
        //将验证码放入request中以便核验
        HttpSession session = request.getSession();
        session.removeAttribute(RANDOMCODEKEY);
        session.setAttribute(RANDOMCODEKEY, codeStr);
        //绘制干扰线
        for(int i=0;i<LINE_COUNT;i++){
            //设置画笔颜色
            g.setColor(getColor());
            //确定一条线(两点)
            int xStart = random.nextInt(W+1);
            int yStart = random.nextInt(H+1);
            int xEnd = random.nextInt(W+1);
            int yEnd = random.nextInt(H+1);
            //绘制线条
            g.drawLine(xStart,yStart,xEnd,yEnd);
        }
        //画噪点
        int total = (int)(W*H*0.02);
        for(int i=0;i<total;i++){
            g.setColor(getColor());
            int x = random.nextInt(W);
            int y = random.nextInt(H);
            image.setRGB(x,y,getColor().getRGB());
        }
        //通过IO流输出到浏览器
        OutputStream out = null;
        try {
            out = response.getOutputStream();
            ImageIO.write(image,"jpg",out);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //获取随机颜色
    public Color getColor(){
        return new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256));
    }

    //获取随机字符
    public char getChar(){
        return CODE.charAt(random.nextInt(56));
    }
}