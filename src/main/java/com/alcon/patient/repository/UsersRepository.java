package com.alcon.patient.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alcon.patient.entity.Users;

@Repository
public interface UsersRepository extends CrudRepository<Users, String>{
	
	public long countByIsSurgeonCaseFlag(Boolean isSurgeonCaseFlag);
	
}