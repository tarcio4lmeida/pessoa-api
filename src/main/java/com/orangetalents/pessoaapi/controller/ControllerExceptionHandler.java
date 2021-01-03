package com.orangetalents.pessoaapi.controller;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.orangetalents.pessoaapi.controller.exceptions.ErroPadrao;
import com.orangetalents.pessoaapi.controller.exceptions.ErroValidacao;
import com.orangetalents.pessoaapi.service.exceptions.CadastradoException;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErroValidacao> validation(MethodArgumentNotValidException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY; 
		ErroValidacao erro = new ErroValidacao();
		erro.setTimestamp(Instant.now());
		erro.setStatus(status.value());
		erro.setErro("Erro de validação de campos");
		erro.setMensagem(e.getMessage());
		erro.setPath(request.getRequestURI());
		
		for(FieldError f : e.getBindingResult().getFieldErrors()) {
			erro.addErro(f.getField(), f.getDefaultMessage());
		}
		
		return ResponseEntity.status(status).body(erro);
	}
	
	@ExceptionHandler(CadastradoException.class)
	public ResponseEntity<ErroPadrao> usuarioCadastradoException(CadastradoException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.BAD_REQUEST;
		ErroPadrao erro = new ErroPadrao();
		
		erro.setTimestamp(Instant.now());
		erro.setStatus(status.value());
		erro.setErro("Erro de cadastrado!");
		erro.setMensagem(e.getMessage());
		erro.setPath(request.getRequestURI());
		
		return ResponseEntity.status(status).body(erro);
	}
}
