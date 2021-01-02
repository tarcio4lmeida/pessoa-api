package com.orangetalents.pessoaapi.controller;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orangetalents.pessoaapi.entity.Pessoa;

@RestController
@RequestMapping(value="/pessoas")
public class PessoaController {
	
	@GetMapping
	public ResponseEntity<List<Pessoa>> findAll(){
		List<Pessoa> list = new ArrayList<>();
		list.add(new Pessoa(1L, "Maria Silva", "mariasilva@gmail.com","12345678901", Instant.now()));
		list.add(new Pessoa(2L, "João Gomes", "joaogomes@gmail.com", "12345678901", Instant.now()));
		list.add(new Pessoa(3L, "Tereza Cristina","terezacristina@gmail.com", "12345678901", Instant.now()));

		return ResponseEntity.ok().body(list);
	}
}
