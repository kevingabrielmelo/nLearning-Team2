package com.nlearning.repository;

import org.springframework.data.repository.CrudRepository;

import com.nlearning.models.CursoAluno;

public interface CursoAlunoRepository extends CrudRepository<CursoAluno, String>{
	//Procura Aluno por ID do CursoAluno
	Iterable<CursoAluno> findAllByIdCursoAluno(Long codigo);
	//Procura Aluno por ID do aluno
	Iterable<CursoAluno> findAllByIdAluno(Long codigo);

}