package aaa.lib.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.captcha.Captcha;
import nl.captcha.backgrounds.GradiatedBackgroundProducer;
import nl.captcha.servlet.CaptchaServletUtil;
import nl.captcha.text.producer.DefaultTextProducer;

public class CaptchaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Captcha captcha = new Captcha.Builder(150, 50)
                .addText(new DefaultTextProducer(7,RandomUtil.generateEngNum(7).toCharArray()))
                .addNoise().addNoise().addNoise().addNoise()
                .addBackground(new GradiatedBackgroundProducer())
                .build();

        response.setContentType("image/png");
        response.setDateHeader("Max-Age", 0);
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        CaptchaServletUtil.writeImage(response, captcha.getImage());
        request.getSession().setAttribute("simplecaptcha", captcha.getAnswer());
    }
 
}