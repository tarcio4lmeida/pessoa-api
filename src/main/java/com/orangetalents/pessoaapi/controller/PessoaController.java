package com.orangetalents.pessoaapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orangetalents.pessoaapi.dto.PessoaDTO;
import com.orangetalents.pessoaapi.entity.Pessoa;
import com.orangetalents.pessoaapi.service.PessoaService;

@RestController
@RequestMapping(value="/pessoas")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	
	@PostMapping
	public  ResponseEntity<PessoaDTO> save(@RequestBody @Valid PessoaDTO dto) {
		dto = pessoaService.save(dto);
		return ResponseEntity.ok().body(dto);
	}
	
	@GetMapping
	public ResponseEntity<List<Pessoa>> findAll(){
		List<Pessoa>list = pessoaService.findAll();

		return ResponseEntity.ok().body(list);
	}
	
	
	
}
