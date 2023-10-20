package com.cos.photogramstart.web.dto.user;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.service.UserService;
import com.cos.photogramstart.web.dto.CMRespDto;
import com.cos.photogramstart.web.dto.user.UserUpdateDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController // data 응답
public class UserApiController {
	
	private final UserService userService;
	
	@PutMapping("/api/user/{id}")
	public CMRespDto<?> update(@PathVariable int id, UserUpdateDto userUpdateDto) {
		// System.out.println(userUpdateDto); // 다 null로 들어오는데???
		User userEntity = userService.ModifyMember(id, userUpdateDto.toEntity());
		return new CMRespDto<>(1, "회원수정완료", userEntity);
	}
}
