package com.edureka.orderms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.edureka.orderms.model.Journey;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value ="journey resource")
@Repository
@RepositoryRestResource(path = "addresses")
public interface JournyRepository extends JpaRepository<Journey, Long> {
	
	@ApiOperation("find all Addresses associated hoteles!")
	@Override
	List<Journey> findAll();
}
