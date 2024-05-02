package com.CurdApi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CurdApi.Entity.Employees;

public interface Employee_repo extends  JpaRepository<Employees, Long>{

}
