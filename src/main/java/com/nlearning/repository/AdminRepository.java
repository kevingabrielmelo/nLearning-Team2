package com.nlearning.repository;

import org.springframework.data.repository.CrudRepository;

import com.nlearning.models.Admin;

public interface AdminRepository extends CrudRepository<Admin, String>{

}