package com.ait.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ait.relation_mapping.HR;

@Repository
public interface HRRepository extends JpaRepository<HR, Integer> {

}
