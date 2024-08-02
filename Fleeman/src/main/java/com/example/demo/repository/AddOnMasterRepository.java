package com.example.demo.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.AddOnMaster;

@Repository
public interface AddOnMasterRepository extends JpaRepository<AddOnMaster, Long> {
}

