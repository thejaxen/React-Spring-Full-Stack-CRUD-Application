package com.CRUD.ems.service.impl;

import com.CRUD.ems.Mapper.EmployeeMapper;
import com.CRUD.ems.dto.EmployeeDto;
import com.CRUD.ems.entity.Employee;
import com.CRUD.ems.repository.EmployeeRepository;
import com.CRUD.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {


    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        return null;
    }
}
