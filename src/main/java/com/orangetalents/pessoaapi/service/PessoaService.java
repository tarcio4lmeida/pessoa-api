package com.orangetalents.pessoaapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orangetalents.pessoaapi.dto.PessoaDTO;
import com.orangetalents.pessoaapi.entity.Pessoa;
import com.orangetalents.pessoaapi.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	PessoaRepository pessoaRepository;

	public List<Pessoa> findAll(){
		return pessoaRepository.findAll();
	}
	
	public PessoaDTO save(PessoaDTO dto){
		Pessoa entity = new Pessoa();
		
		copyDtoToEntity(dto, entity);
		
		entity = pessoaRepository.save(entity);
		
		return new PessoaDTO(entity);
	}
	
	private void copyDtoToEntity(PessoaDTO dto, Pessoa entity) {
		entity.setNome(dto.getNome());
		entity.setCpf(dto.getCpf());		
		entity.setEmail(dto.getEmail());
		entity.setDataNascimento(dto.getDataNascimento());
	}
}
