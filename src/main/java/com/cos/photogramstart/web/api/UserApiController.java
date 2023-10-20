package com.cos.photogramstart.web.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.photogramstart.service.UserService;
import com.cos.photogramstart.web.dto.user.UserUpdateDto;

import lombok.RequiredArgsConstructor;

@RestController // data 응답
public class UserApiController {
	
	@PutMapping("/api/user/{id}")
	public String update(UserUpdateDto userUpdateDto) {
		System.out.println(userUpdateDto);
		return "ok";
	}
}
