package com.CRUD.ems.service.impl;

import com.CRUD.ems.Mapper.EmployeeMapper;
import com.CRUD.ems.dto.EmployeeDto;
import com.CRUD.ems.entity.Employee;
import com.CRUD.ems.exception.ResourceNotFoundException;
import com.CRUD.ems.repository.EmployeeRepository;
import com.CRUD.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class EmployeeServiceImpl implements EmployeeService {


    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        //Mapping employee dto to employee jpa entity
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        //Passing employee jpa entity to database
        Employee savedEmployee = employeeRepository.save(employee);
        //Turning employee jpa entity back to client as dto
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee with id " + employeeId + " not found"));

        return EmployeeMapper.mapToEmployeeDto(employee);
    }
}
