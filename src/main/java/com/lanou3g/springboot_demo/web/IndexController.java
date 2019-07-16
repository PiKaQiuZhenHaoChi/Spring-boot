package com.lanou3g.springboot_demo.web;

import com.lanou3g.springboot_demo.bean.Man;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class IndexController {

	@RequestMapping("/")
	public String index(ModelMap map, HttpSession session) {
		map.addAttribute("message", "http://www.ityouknow.com");
		session.setAttribute("sessionKey", "我是Session里的值");
		log.info("index");
		return "index";
	}

	@RequestMapping("/test_rest")
	@ResponseBody
	public Man testRest() {
		return new Man("古韵姐", 99);
	}

}
