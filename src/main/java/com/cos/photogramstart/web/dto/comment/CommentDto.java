package com.cos.photogramstart.web.dto.comment;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class CommentDto {
	@NotBlank
	private String content;
	@NotNull
	private int imageId;

	// toEntity 가 필요없다.
}
