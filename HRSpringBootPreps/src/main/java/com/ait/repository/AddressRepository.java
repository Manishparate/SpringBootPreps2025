package com.ait.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ait.relation_mapping.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
