package com.cos.photogramstart.web.api;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.photogramstart.config.auth.PrincipalDetails;
import com.cos.photogramstart.domain.image.Image;
import com.cos.photogramstart.service.ImageService;
import com.cos.photogramstart.web.dto.CMRespDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ImageApiController {
	
	private final ImageService imageService;

	@GetMapping("/api/image")
	public ResponseEntity<?> imageStory(
								@AuthenticationPrincipal PrincipalDetails principalDetails, 
								@PageableDefault(size=3) Pageable pageable) { // Native Query에 order by 구문 넣음.
							// direction=Sort.Direction.DESC 옵션 삭제, (=order by id desc)
							// 에러 발생됨, Native Query를 쓰지 않으면 활용 가능.
		Page<Image> images = imageService.imageStory(principalDetails.getUser().getId(), pageable);
		return new ResponseEntity<>(new CMRespDto<>(1, "성공", images), HttpStatus.OK);
	}
}
