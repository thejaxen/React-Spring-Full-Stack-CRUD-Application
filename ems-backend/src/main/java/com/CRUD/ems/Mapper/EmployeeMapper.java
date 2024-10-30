package com.CRUD.ems.Mapper;

import com.CRUD.ems.dto.EmployeeDto;
import com.CRUD.ems.entity.Employee;

public class EmployeeMapper {

    //Maps the entity to a dto.
    public static EmployeeDto mapToEmployeeDto(Employee employee) {
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }

    //Converts dto into jpa entity
    public static Employee mapToEmployee(EmployeeDto employeeDto) {
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }
}
