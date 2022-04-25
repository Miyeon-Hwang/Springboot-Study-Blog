package com.hmy.blog.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.hmy.blog.dto.ResponseDto;

@ControllerAdvice // 해당 프로젝트 전역에서 발생하는 exception에대해 @ExceptionHandler를 적용하겠다. 이 어노테이션이 없으면 해당 controller 내 exception만 잡을 수 있음.
@RestController
public class GlobalExceptionHandler {

	@ExceptionHandler(value = Exception.class) // @Controller, @RestController가 적용된 Bean내에서 발생한 exception 중 value로 정해준 exception type에 대해 처리하겠다
	public ResponseDto<String> handleException(Exception e) {
		return new ResponseDto<String>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
	}
}
