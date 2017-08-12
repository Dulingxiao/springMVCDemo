package cn.dlx.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.dlx.pojo.User;
import cn.dlx.pojo.UserVO;

@Controller
@RequestMapping("hello")
public class DemoController {

	@RequestMapping(value = "**show")
	public ModelAndView test() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg", "第一个sadly");
		mv.setViewName("hello");
		return mv;
	}

	@RequestMapping(value = "show2")
	public ModelAndView test2(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		StringBuffer sb = new StringBuffer();
		sb.append(request + "<br/>");
		sb.append(response + "<br/>");
		sb.append(session + "");
		mv.addObject("msg", "内置对象：" + sb.toString());
		mv.setViewName("hello");
		return mv;
	}

	@RequestMapping(value = "show3")
	public String test3(Model model, ModelMap map) {
		model.addAttribute("msg", "model+++");
		return "hello";
	}

	@RequestMapping(value = "show4/{name}")
	public String test4(Model model, @PathVariable("name") String name) {
		model.addAttribute("msg", "model+++" + name);
		return "hello";
	}

	@RequestMapping(value = "show5")
	public String test5(Model model, @RequestParam(value = "name", defaultValue = "zhangsan") String name) {
		model.addAttribute("msg", "name=" + name);
		return "hello";
	}

	@RequestMapping(value = "show6")
	public String test6(Model model, @CookieValue(value = "JSESSIONID") String value) {
		model.addAttribute("msg", "JSESSIONID=" + value);
		return "hello";
	}

	@RequestMapping(value = "show7")
	@ResponseStatus(value = HttpStatus.OK)
	public void test7(@RequestParam(value = "name", defaultValue = "zhangsan") String name,
			@RequestParam(value = "age", defaultValue = "15") Integer age, Model model) {
		System.out.println(name);
		System.out.println(age);
	}

	@RequestMapping(value = "show8")
	@ResponseStatus(value = HttpStatus.OK)
	public void test8(Model model, User user) {
		System.out.println(user);

	}

	@RequestMapping(value = "show9")
	@ResponseStatus(value = HttpStatus.OK)
	public void test9(Model model, UserVO list) {
		System.out.println(list);
	}

	@RequestMapping(value = "show10")
	public String test10(Model model, UserVO list) {
		ArrayList<User> arrayList = new ArrayList<User>();
		for (int i = 0; i < 10; i++) {
			User user = new User();
			user.setAge(10 + i);
			user.setIncome(100d + i);
			user.setName("zhang" + i);
			arrayList.add(user);
		}
		model.addAttribute("userList", arrayList);
		return "user";
	}

	@RequestMapping(value = "show11")
	@ResponseBody
	public List<User> test11(Model model, UserVO list) {
		ArrayList<User> arrayList = new ArrayList<User>();
		for (int i = 0; i < 10; i++) {
			User user = new User();
			user.setAge(10 + i);
			user.setIncome(100d + i);
			user.setName("zhang" + i);
			arrayList.add(user);
		}
		model.addAttribute("userList", arrayList);
		return arrayList;
	}

	@RequestMapping(value = "show12")
	public String test12(@RequestBody User user, Model model) {
		model.addAttribute("msg", user.toString());
		System.out.println(user);
		return "hello";
	}

	@RequestMapping(value = "show13")
	public String test13(Model model, @RequestParam("file") MultipartFile file) throws IllegalStateException,
			IOException {
		if (file != null) {
			file.transferTo(new File("d:\\test\\" + file.getOriginalFilename()));
		}
		model.addAttribute("msg", "success");
		return "hello";
	}

	@RequestMapping(value = "show14")
	public String test14() {
		return "redirect:show16.do?id=100&name=zhang&type=redirect";
	}

	@RequestMapping(value = "show15")
	public String test15() {
		return "forward:show16.do?id=100&name=zhang&type=forward";
	}

	@RequestMapping(value = "show16")
	public String test16(Model model, @RequestParam("id") String id, @RequestParam("name") String name,
			@RequestParam("type") String type) {
		model.addAttribute("msg", "id=" + id + ",name=" + name + "type=" + type);
		return "hello";
	}
}
