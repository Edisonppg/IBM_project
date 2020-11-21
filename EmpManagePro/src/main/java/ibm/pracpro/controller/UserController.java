package ibm.pracpro.controller;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import ibm.pracpro.model.User;
import ibm.pracpro.service.UserService;
import ibm.pracpro.utils.RedisUtil;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

	@Autowired
	private UserService service;

	@RequestMapping("regist")
	public String saveUser(@RequestBody User u, @RequestParam("key") String key, @RequestParam("uuid") String uuid) {
		String checknum = RedisUtil.get(uuid + "key");
		System.out.println(checknum);
		System.out.println(checknum);
		System.out.println(u);
		System.out.println(key);
		if (checknum != null && !checknum.equals(key)) {
			return "0";// 验证码错误
		}
		if (service.getUserByName(u.getUserName()) != null) {
			return "1";// 用户名已存在
		}
		int result = 0;
		try {
			result = service.save(u);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if (result == 1) {
			return "success";
		} else {
			return "fail";
		}
	}

	@RequestMapping("update")
	public String updateUser(String userName, String oldpsw, String newpsw) {
		int result = 0;
		try {
			User u = service.getUserByName(userName);
			if (u.getPassword().equals(DigestUtils.md5Hex(oldpsw))) {
				if (u.getPassword().equals(DigestUtils.md5Hex(newpsw))) {
					return "1";// 返回值1为新旧密码相同
				} else {
					u.setPassword(newpsw);
					result = service.update(u);
				}
			} else {
				return "0";// 返回值0为旧密码错误
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if (result == 1) {
			return JSON.toJSONString(service.getUserByName(userName));
		} else {
			return "fail";// 数据库写入出错
		}
	}

	@PostMapping("login")
	public String userLogin(String userName, String password) {
		System.out.println(userName);
		System.out.println(password);
		User u = service.getUserByName(userName);
		if (u == null) {
			return "0";// 用户名不存在
		}
//		DigestUtils.md5Hex(password)
		if (u.getPassword().equals(password)) {
			return JSON.toJSONString(u);// 登录成功返回对象json字符串
		} else {
			return "1";// 密码错误
		}
	}

}
