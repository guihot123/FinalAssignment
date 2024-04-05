package com.example.jbe092023.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.jbe092023.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{
	@Query(nativeQuery = true, value ="SELECT * FROM jbe092023.table_address where user_id like %?1%")
	List<Address> findAllByProductId(Integer id);

}
