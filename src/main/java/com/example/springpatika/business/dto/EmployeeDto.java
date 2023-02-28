package com.example.springpatika.business.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Log4j2
public class EmployeeDto {
    private Long id;
    private String firstName;
    private String lastname;
    private String emailId;

}
