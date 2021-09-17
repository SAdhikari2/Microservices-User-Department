package com.saikat.departmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saikat.departmentservice.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {



}
