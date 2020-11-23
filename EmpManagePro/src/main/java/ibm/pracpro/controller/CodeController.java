package ibm.pracpro.controller;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.code.kaptcha.Producer;

import ibm.pracpro.utils.RedisUtil;

@Controller
@CrossOrigin
public class CodeController {
	@Autowired
	private RedisUtil redisUtil;
	
	@Autowired
	private Producer captchaProducer = null;

	@RequestMapping("/kaptcha")
	public void getKaptchaImage(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("uuid") String uuid) throws Exception {
		System.out.println(uuid);
		response.setDateHeader("Expires", 0);
		response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");
		response.setHeader("Pragma", "no-cache");
		response.setContentType("image/jpeg");
		// 生成验证码
		String capText = captchaProducer.createText();
		System.out.println("当前验证码是：" + capText);
		redisUtil.set(uuid + "key", capText);// 向redis中存入验证码
//		System.out.println(redisUtil.get(uuid + "key"));
//        request.getSession().setAttribute("checknum", capText);//前后端分离后session无法保存
		// 向客户端写出
		BufferedImage bi = captchaProducer.createImage(capText);
		ServletOutputStream out = response.getOutputStream();
//        ByteArrayOutputStream out = new ByteArrayOutputStream();//创建流
		ImageIO.write(bi, "jpg", out);// 将图片输入流中
//        byte b[]= out.toByteArray();//格式化流数据
		try {
			out.flush();
		} finally {
			out.close();
		}
	}
}