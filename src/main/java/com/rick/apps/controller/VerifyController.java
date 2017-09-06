package com.rick.apps.controller;

import com.rick.common.Constant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

/**
 * Desc :  图片验证码生成类
 * User : RICK
 * Time : 2017/8/31 17:14
  */
@Controller
public class VerifyController {
    /**
     * Desc :  获取验证码
     * User : RICK
     * Time : 2017/8/31 17:16
      */
    @RequestMapping("/getVcode")
    public void generate(HttpServletRequest request, HttpServletResponse response) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        String code = drawImg(output);
        request.getSession().setAttribute(Constant.VERIFY_CODE, code);
        try {
            ServletOutputStream out = response.getOutputStream();
            output.writeTo(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String drawImg(ByteArrayOutputStream output) {
        String code = "";
        for (int i = 0; i < 4; i++) {
            code += randomChar();
        }
        int width = 70;
        int height = 25;
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
        Font font = new Font("Times New Roman", Font.PLAIN, 20);
        Graphics2D g = bi.createGraphics();
        g.setFont(font);
        Color color = new Color(66, 2, 82);
        g.setColor(color);
        g.setBackground(new Color(226, 226, 240));
        g.clearRect(0, 0, width, height);
        FontRenderContext context = g.getFontRenderContext();
        Rectangle2D bounds = font.getStringBounds(code, context);
        double x = (width - bounds.getWidth()) / 2;
        double y = (height - bounds.getHeight()) / 2;
        double ascent = bounds.getY();
        double baseY = y - ascent;
        g.drawString(code, (int) x, (int) baseY);
        g.dispose();
        try {
            ImageIO.write(bi, "jpg", output);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return code;
    }

    private char randomChar() {
        Random r = new Random();
        String s = "ABCDEFGHJKLMNPRSTUVWXYZ0123456789";
        return s.charAt(r.nextInt(s.length()));
    }
}
