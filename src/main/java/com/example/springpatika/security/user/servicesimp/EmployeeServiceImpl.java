package com.example.springpatika.security.user.servicesimp;

import com.example.springpatika.business.dto.EmployeeDto;
import com.example.springpatika.business.services.EmployeeServices;
import com.example.springpatika.data.entity.EmployeeEntity;
import com.example.springpatika.data.repository.EmployeeRepository;
import com.example.springpatika.exceptions.ResourceNotFoundException;
import io.swagger.v3.oas.annotations.servers.Server;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeServices {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ModelMapper  modelMapper;

    @GetMapping("/employees")
    @Override
    public List<EmployeeDto> getAllEmployees() {

        List<EmployeeDto> employeeDtoList = new ArrayList<>();
        Iterable<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        for(EmployeeEntity entity:employeeEntities){

            EmployeeDto  employeeDto = entityToDto(entity);
            employeeDtoList.add(employeeDto);
        }

        return employeeDtoList;
    }

    @PostMapping("/employees")
    @Override
    public EmployeeDto createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = dtoToEntity(employeeDto);
        employeeRepository.save(employeeEntity);
        return employeeDto;
    }

    @GetMapping("/employees/{id}")
    @Override
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id) {
        EmployeeEntity employeeEntity = null;
        try {
            employeeEntity = (EmployeeEntity) employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee can not found"));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        EmployeeDto employeeDto = entityToDto(employeeEntity);

        return ResponseEntity.ok(employeeDto);
    }

    @PutMapping("/employees/{id}")
    @Override
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id,@RequestBody EmployeeDto employeeDetails) throws Throwable {

         EmployeeEntity employeeEntity = dtoToEntity(employeeDetails);
        EmployeeEntity employee = (EmployeeEntity) employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not exist !"));
        employee.setFirstName(employeeEntity.getFirstName());
        employee.setEmailId(employeeEntity.getEmailId());
        employee.setLastname(employeeEntity.getLastname());
        EmployeeEntity updatedEmployee = (EmployeeEntity) employeeRepository.save(employee);
        EmployeeDto employeeDto = entityToDto(updatedEmployee);



        return ResponseEntity.ok(employeeDto);
    }

    @DeleteMapping("/employees/{id}")
    @Override
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id) throws Throwable {
        EmployeeEntity employeeEntity = (EmployeeEntity) employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee not exist !"));
        employeeRepository.delete(employeeEntity);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }



    @Override
    public EmployeeDto entityToDto(EmployeeEntity employeeEntity) {

        EmployeeDto employeeDto = modelMapper.map(employeeEntity,EmployeeDto.class);

        return employeeDto;
    }

    @Override
    public EmployeeEntity dtoToEntity(EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = modelMapper.map(employeeDto, EmployeeEntity.class);

        return employeeEntity;
    }
}
