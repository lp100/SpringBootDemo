package org.com.zrhx.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.com.zrhx.utill.MD5Util;
import org.com.zrhx.utill.R;
import org.com.zrhx.utils.ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @Title: SysLoginController
 * @Description: 登录相关
 * @author: gs
 * @date: 2017/5/27 9:32
 */
@Controller
public class SysLoginController extends BaseController<SysLoginController>{


	
	/**
	 * 登录
	 */
	@ResponseBody
	@RequestMapping(value = "/sys/login")
	public R login(String username, String password, String captcha)throws IOException {
		try{
			Subject subject = ShiroUtils.getSubject();
			//md5加密
			password = MD5Util.MD5Encode(password);
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
//			token.setRememberMe(rememberMe);//设置记住我  自动登录
			subject.login(token);
		}catch (UnknownAccountException e) {
			logger.error(e.getMessage(),e);
			return R.error(e.getMessage());
		}catch (IncorrectCredentialsException e) {
			logger.error(e.getMessage(),e);
			return R.error(e.getMessage());
		}catch (LockedAccountException e) {
			logger.error(e.getMessage(),e);
			return R.error(e.getMessage());
		}catch (AuthenticationException e) {
			logger.error(e.getMessage(),e);
			return R.error("账户验证失败");
		}
		return R.ok();
	}
	
	/**
	 * 退出
	 */
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout() {
		ShiroUtils.logout();
		return "redirect:login.jsp";
	}

	/**
	 * 退出
	 */
	@RequestMapping(value = "index")
	public String index() {
		return "login.jsp";
	}
}
