package com.orangetalents.pessoaapi.controller;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.orangetalents.pessoaapi.entity.Pessoa;
import com.orangetalents.pessoaapi.repository.PessoaRepository;

@RestController
@RequestMapping(value="/pessoas")
public class PessoaController {
	
	@Autowired
	private PessoaRepository repository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Pessoa save(@RequestBody Pessoa pessoa) {
		return repository.save(pessoa);

	}
	
	@GetMapping
	public ResponseEntity<List<Pessoa>> findAll(){
		List<Pessoa> list = new ArrayList<>();
		list.add(new Pessoa(1L, "Maria Silva", "mariasilva@gmail.com","12345678901", LocalDate.now()));
		list.add(new Pessoa(2L, "João Gomes", "joaogomes@gmail.com", "12345678901", LocalDate .now()));
		list.add(new Pessoa(3L, "Tereza Cristina","terezacristina@gmail.com", "12345678901", LocalDate .now()));

		return ResponseEntity.ok().body(list);
	}
	
	
	
}
