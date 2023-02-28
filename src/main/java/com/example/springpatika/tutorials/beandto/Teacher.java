package com.example.springpatika.tutorials.beandto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Teacher {

    private Long teacherId;
    private String teacherNameSurname;
    private String teacherEmail;
    private String teacherPassword;

    public Teacher(Long teacherId, String teacherNameSurname, String teacherEmail, String teacherPassword) {
        this.teacherId = teacherId;
        this.teacherNameSurname = teacherNameSurname;
        this.teacherEmail = teacherEmail;
        this.teacherPassword = teacherPassword;
    }
    public Long getTeacherId() {
        return teacherId;
    }
    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }
    public String getTeacherNameSurname() {
        return teacherNameSurname;
    }
    public void setTeacherNameSurname(String teacherNameSurname) {
        this.teacherNameSurname = teacherNameSurname;
    }
    public String getTeacherEmail() {
        return teacherEmail;
    }
    public void setTeacherEmail(String teacherEmail) {
        this.teacherEmail = teacherEmail;
    }
    public String getTeacherPassword() {
        return teacherPassword;
    }
    public void setTeacherPassword(String teacherPassword) {
        this.teacherPassword = teacherPassword;
    }
}
