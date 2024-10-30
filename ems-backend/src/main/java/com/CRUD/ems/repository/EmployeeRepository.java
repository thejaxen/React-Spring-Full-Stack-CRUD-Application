package com.CRUD.ems.repository;

import com.CRUD.ems.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

//First parameter is entity and the second parameter must be primary key
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
