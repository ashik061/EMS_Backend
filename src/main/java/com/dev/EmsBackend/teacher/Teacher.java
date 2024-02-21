package com.dev.EmsBackend.teacher;

import com.dev.EmsBackend.emsuser.EmsUser;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "teacher")
public class Teacher extends EmsUser {
    @Column(name = "faculty_name")
    private String facultyName;

    @Column(name = "designation")
    private String designation;

    public Teacher(String email, String password, String facultyName, String designation) {
        super(email, password);
        this.facultyName = facultyName;
        this.designation = designation;
    }

    public Teacher(String email, String phone, String name, String password, String facultyName, String designation) {
        super(email, phone, name, password);
        this.facultyName = facultyName;
        this.designation = designation;
    }

    public Teacher() {
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "facultyName='" + facultyName + '\'' +
                ", designation='" + designation + '\'' +
                '}';
    }
}
