package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.StateMaster;

public interface StateMasterRepository extends JpaRepository<StateMaster, Long> {
}
