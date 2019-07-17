package com.lanou3g.springboot_demo.web;

import com.lanou3g.springboot_demo.bean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 此类用于展示从配置中读取到的参数
 * 配合profile测试
 */
@Controller
public class ConfTestController {

	@Autowired
	private Student student;

	@RequestMapping("/conf")
	public String readConf(Model model) {

		StringBuilder sb = new StringBuilder();
		sb.append("古韵姐：" + student.getYunJieAge());
		sb.append("<br />");
		sb.append("赛赛：" + student.getSaisaiAge());

		model.addAttribute("message", sb.toString());
		return "index";
	}
}
