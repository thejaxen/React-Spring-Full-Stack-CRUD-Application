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

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<EmployeeDto> getAllEmployees() {
        //Takes list of employee jpa entity
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() ->
                new ResourceNotFoundException("Employee with id " + employeeId + " not found"));

        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());

        Employee updatedEmployeeObj = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(()->
                new ResourceNotFoundException("Employee with id " + employeeId + " not found"));

        employeeRepository.deleteById(employeeId);
    }


}
