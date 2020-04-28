package com.example.demo.Controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.client.HttpClient;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.demo.Service.IGoodService;
import com.example.demo.Service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController{
	
	static List<Integer> ran = new ArrayList<>();
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IGoodService goodService;
	@GetMapping("test")
	public String test() {
		
		return userService.findAll();
	}
	
	
	@GetMapping("download")
	public ResponseEntity<UrlResource> download() throws IOException {
		//ApplicationContext context = new ClassPathXmlApplicationContext("classpath:services.xml", "classpath:daos.xml");

		UrlResource urlResource = new UrlResource("file:F:\\新用户添加.xlsx");
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment;filename=abc.txt");
		HttpStatus statusCode = HttpStatus.OK;	
		return new ResponseEntity<UrlResource>(urlResource, headers, statusCode);
	}
	
	@PostMapping("test")
	public String test(HttpServletRequest request) throws IllegalStateException, IOException {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)request;
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		System.out.println(request.getHeader(HttpHeaders.CONTENT_DISPOSITION));
		for(Entry<String, MultipartFile> entry : fileMap.entrySet()) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue().getContentType());
			System.out.println(new String(entry.getValue().getOriginalFilename().getBytes(),"us-ascii"));
			System.out.println(entry.getValue().getName());
			System.out.println(entry.getValue().getSize());
		}
		return "执行成功";
	}
}
