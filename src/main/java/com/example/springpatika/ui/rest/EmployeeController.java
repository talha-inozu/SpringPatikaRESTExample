package com.example.springpatika.ui.rest;

import com.example.springpatika.business.dto.EmployeeDto;
import com.example.springpatika.business.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "https://localhost:3000")
public class EmployeeController {

    @Autowired
    EmployeeServices employeeServices;


    @GetMapping("/employees")
    public List<EmployeeDto> getAllEmployees(){
        List<EmployeeDto> employeeDtoList = employeeServices.getAllEmployees();
        return  employeeDtoList;
    }
    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id){
            EmployeeDto employeeDto = employeeServices.getEmployeeById(id).getBody();
            return ResponseEntity.ok(employeeDto);
    }

    @PostMapping("/employees")
    public EmployeeDto createEmployee(@RequestBody EmployeeDto employeeDto){
        employeeServices.createEmployee(employeeDto);
        return  employeeDto;
    }

    @PutMapping("/employees/{id}")
    public EmployeeDto updateEmployee(@PathVariable Long id,@RequestBody EmployeeDto employeeDto) throws Throwable {
        employeeServices.updateEmployee(id,employeeDto);
        return  employeeDto;
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable Long id) throws Throwable {

        Map<String,Boolean> response = employeeServices.deleteEmployee(id).getBody();
        return ResponseEntity.ok(response);
    }








    

}
