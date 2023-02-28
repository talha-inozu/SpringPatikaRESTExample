package com.example.springpatika.tutorials.beandto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Log4j2
public class TeacherDto {

    private Long teacherId;
    @NotEmpty(message = "It cant be empty!")
    @Size(max = 256, min = 1)
    private String teacherNameSurname;
    @Email(message = "Not valid format")
    private String teacherEmail;

    @Size(max = 256, min = 1)
    private String teacherPassword;


}
