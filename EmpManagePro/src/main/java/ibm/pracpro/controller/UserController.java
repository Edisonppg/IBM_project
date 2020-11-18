package ibm.pracpro.controller;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ibm.pracpro.model.User;
import ibm.pracpro.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
	
	@Autowired
	private UserService service;
	
	@RequestMapping("regist")
	public String saveUser(HttpServletRequest req,User u,String key) {
		String checknum = (String)req.getSession().getAttribute("checknum");
		if(!checknum.equals(key)) {
			return "验证码错误";
		}
		int result = 0;
		try {
			result = service.save(u);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if (result==1) {
			return "success";
		}else {
			return "fail";
		}
	}
	
	@RequestMapping("update")
	public String updateUser(User u) {
		int result = 0;
		try {
			result = service.update(u);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if (result==1) {
			return "success";
		}else {
			return "fail";
		}
	}
	
	@RequestMapping("login")
	public String userLogin(String userName,String password) {
		User u = service.getUserByName(userName);
		if(u==null) {
			return "用户名不存在";
		}
		if(u.getPassword().equals(password)) {
			return JSONObject.valueToString(u);
		}else {
			return "密码错误";
		}
	}
	
}
