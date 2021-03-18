package com.nlearning.repository;

import org.springframework.data.repository.CrudRepository;

import com.nlearning.models.Aluno;

public interface AlunoRepository extends CrudRepository<Aluno, String>{
	//Aluno findByid(long codigo);
}