package com.nlearning.repository;

import org.springframework.data.repository.CrudRepository;

import com.nlearning.models.CursoAluno;

public interface CursoAlunoRepository extends CrudRepository<CursoAluno, String>{
	//Procura Aluno por ID
	CursoAluno findByIdCursoAluno(Long codigo);

}