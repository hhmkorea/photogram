package com.cos.photogramstart.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController // 데이터 리턴 
@ControllerAdvice // 모든 Excepiton을 낚아챔
public class ControllerExceptionHandler {

	@ExceptionHandler(RuntimeException.class)
	public String validationException(RuntimeException e) {
		return e.getMessage();
	}
}
