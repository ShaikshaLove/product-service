package io.s3soft.productservice.exception.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.s3soft.productservice.dto.ErrorResponse;
import io.s3soft.productservice.exception.ProductNotFoundException;

@RestControllerAdvice
public class ProductNotFoundExceptionAdvice {
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleProductNotFoundExeption(ProductNotFoundException ex){
		ErrorResponse errorResponse=new ErrorResponse(ex.getMessage(),HttpStatus.NOT_FOUND.value(),ex.getClass().getName());
		return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.NOT_FOUND);
	}

}
