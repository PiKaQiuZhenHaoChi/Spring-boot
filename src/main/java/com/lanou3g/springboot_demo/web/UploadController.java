package com.lanou3g.springboot_demo.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationHome;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@Slf4j
@Controller
public class UploadController {
	@RequestMapping("/upload")
	public String upload(@RequestParam("myFile") MultipartFile file, HttpServletRequest req, Model model) {
		try {
			file.transferTo(new File("E:/" + file.getOriginalFilename()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("message", "上传成功");
		return "index";
	}
}
