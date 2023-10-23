package com.cos.photogramstart.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ImageController {
	
	@GetMapping({"/","/image/story"})
	public String story() {
		return "image/story";
	}

	@GetMapping("/image/popular")
	public String popular() {
		return "image/popular";
	}

	@GetMapping("/image/upload")
	public String upload() {
		return "image/upload";
	}
	
	@PostMapping("/image")
	public String imageUpload() {
		
		
		return null;
	}
}
