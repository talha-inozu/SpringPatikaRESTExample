package com.example.springpatika.business.services;

import com.example.springpatika.business.dto.EmployeeDto;
import com.example.springpatika.data.entity.EmployeeEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface EmployeeServices {

    //CRUD
    public List<EmployeeDto> getAllEmployees();
    public EmployeeDto createEmployee(EmployeeDto employeeDto);
    public ResponseEntity<EmployeeDto> getEmployeeById(Long id);
    public ResponseEntity<EmployeeDto> updateEmployee(Long id, EmployeeDto employeeDto) throws Throwable;
    public  ResponseEntity<Map<String,Boolean>> deleteEmployee(Long id) throws Throwable;

    //Model Wrapper
    public  EmployeeDto entityToDto(EmployeeEntity employeeEntity);
    public  EmployeeEntity dtoToEntity(EmployeeDto employeeDto);
}
