package com.orangetalents.pessoaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orangetalents.pessoaapi.entity.Pessoa;


@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
