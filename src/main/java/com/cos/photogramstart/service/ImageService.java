package com.cos.photogramstart.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cos.photogramstart.config.auth.PrincipalDetails;
import com.cos.photogramstart.domain.image.Image;
import com.cos.photogramstart.domain.image.ImageRepository;
import com.cos.photogramstart.web.dto.Image.ImageUploadDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ImageService {
	
	private final ImageRepository imageRepository;
	
	@Value("${file.path}") // application.yml 
	private String uploadFolder; 
	
	// 사진업로드
	public void uploadPhoto(ImageUploadDto imageUploadDto, PrincipalDetails principalDetails) { 
		UUID uuid = UUID.randomUUID(); // uuid
		String imageFileName = uuid+"_"+imageUploadDto.getFile().getOriginalFilename(); // 1.jpg 
		System.out.println("이미지 파일이름 :  "+imageFileName);
		
		Path imageFilePath = Paths.get(uploadFolder+imageFileName);
		
		// 통신, I/O -> 예외가 발생할 수 있다. 
		try {
			Files.write(imageFilePath, imageUploadDto.getFile().getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// image 테이블에 저장
		Image image = imageUploadDto.toEntity(imageFileName, principalDetails.getUser()); // 3ee1a3d3-2145-4922-a519-e746d0b5840e_test.jpeg
		imageRepository.save(image);

		// 오브젝트를 콘솔에 출력할 때 문제가 발생되어 주석처리. Image.java  참고 
		//Image imageEntity = imageRepository.save(image);		
		//System.out.println(">>>>>> imageEntity : " + imageEntity.toString());
	}
}
