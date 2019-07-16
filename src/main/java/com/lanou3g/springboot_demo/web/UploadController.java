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
			ApplicationHome home = new ApplicationHome(getClass());

			// homeSource获取的路径是jar包的绝对路径(包括jar包名称)
			// homeDir获取的路径是jar包所在目录的绝对路径(不包含jar包名称)
			File homeSource = home.getSource();
			File homeDir = home.getDir();
			log.info("homeSource: " + homeSource);
			log.info("homeDir: " + homeDir);

			//在SpringBoot工程中不适合通过ServletContext.getRealPath("/upload");:
			//uploadPath: C:\\Users\\John\\AppData\\Local\\Temp\\tomcat-docbase.11168215243077803.8081\\upload
			//C:\\Users\\John\\AppData\\Local\\Temp\\tomcat-docbase.1305638418179073926.8081\\upload
			/*File uploadPath = new File(req.getServletContext().getRealPath("/upload"));
			*/
			File uploadPath = new File(homeDir, "upload");
			if(!uploadPath.exists()) {
				uploadPath.mkdirs();
			}
			log.info("uploadPath: " + uploadPath);
			file.transferTo(new File(uploadPath, file.getOriginalFilename()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("message", "上传成功");
		return "index";
	}
}
