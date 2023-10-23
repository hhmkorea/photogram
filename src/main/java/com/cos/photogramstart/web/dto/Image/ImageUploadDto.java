package com.cos.photogramstart.web.dto.Image;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data //Getter, Setter
public class ImageUploadDto {
	private MultipartFile file;
	private String caption;
}
