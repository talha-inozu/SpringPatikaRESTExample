package com.example.springpatika.tutorials.controller;

import com.example.springpatika.tutorials.beandto.TeacherDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@Log4j2
public class FormController {

    @GetMapping("/form")
    public String getForm(Model model){
        model.addAttribute("cv_teacher", TeacherDto.builder().teacherId(0L).build());
        return  "form_post/formvalidation";
    }


    @PostMapping("/form/{id}")
//    public String postForm(@Valid @ModelAttribute(value = "cv_teacher") TeacherDto teacherDto, BindingResult bindingResult){
    public String postForm(@Valid @ModelAttribute(value = "cv_teacher") TeacherDto teacherDto, BindingResult bindingResult, @PathVariable(name = "id") long id){
        if(bindingResult.hasErrors()) {
            log.error(bindingResult.toString());
            return  "form_post/formvalidation";
        }
        teacherDto.setTeacherId(id);
        log.info("Succes"+teacherDto);
        //Database yazma alani

        return  "form_post/success";
    }



}
