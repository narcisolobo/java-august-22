package com.nlobo.lakersroster.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nlobo.lakersroster.models.Laker;

@Repository
public interface LakerRepository extends CrudRepository<Laker, Long> {
	
	List<Laker> findAll();

}
