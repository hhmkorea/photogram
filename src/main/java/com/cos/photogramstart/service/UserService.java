package com.cos.photogramstart.service;

import java.util.function.Supplier;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.domain.user.UserRepository;
import com.cos.photogramstart.handler.ex.CustomException;
import com.cos.photogramstart.handler.ex.CustomValidationApiException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public User memberProfile(int userId) { // 회원 프로필
		// SELECT * FROM image WHERE userId = :userId;
		// JPA 방식
		User userEntity = userRepository.findById(userId).orElseThrow(() -> { // Image는 안가져옴. from User만 진행.
			throw new CustomException("해당 프로필 페이지는 없는 페이지 입니다.");
		});
		System.out.println("=======================================");
		userEntity.getImages().get(0);
		
		return userEntity;
	}
	
	@Transactional
	public User modifyMember(int id, User user) { // 회원수정
		// 1. 영속화
		// Optional Wrapping 1. 무조건 찾았다 get() 2. 못찾았어 Exception 발동 시킬께 orElseThrow() 
		User userEntity = userRepository.findById(id).orElseThrow(() -> {	return new CustomValidationApiException("찾을 수 없는 id입니다.");});
		
		// 2. 영속화된 오브젝트를 수정 - 더티 체킹(업데이트 완료)
		userEntity.setName(user.getName());
		
		String rawPassword = user.getPassword();
		String encPassword = bCryptPasswordEncoder.encode(rawPassword);
				 
		userEntity.setPassword(encPassword);
		userEntity.setBio(user.getBio());
		userEntity.setWebsite(user.getWebsite());
		userEntity.setPhone(user.getPhone());
		userEntity.setGender(user.getGender());
		
		return userEntity;
	} // 더티 체킹이 일어나서 업데이트가 완료됨.
}
