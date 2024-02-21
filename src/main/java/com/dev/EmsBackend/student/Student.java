package com.dev.EmsBackend.student;

import com.dev.EmsBackend.emsuser.EmsUser;
import com.dev.EmsBackend.teacher.Teacher;
import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student extends EmsUser {

    @Column(name = "department_name")
    private String departmentName;

    @ManyToOne
    @JoinColumn(name = "advisor_id")
    private Teacher advisor;

    @Column(name = "student_id")
    private String studentId;

    @Column(name = "batch_no")
    private String batchNo;

    public Student(String email, String password, String departmentName, Teacher advisor, String studentId, String batchNo) {
        super(email, password);
        this.departmentName = departmentName;
        this.advisor = advisor;
        this.studentId = studentId;
        this.batchNo = batchNo;
    }

    public Student(String email, String phone, String name, String password, String departmentName, Teacher advisor, String studentId, String batchNo) {
        super(email, phone, name, password);
        this.departmentName = departmentName;
        this.advisor = advisor;
        this.studentId = studentId;
        this.batchNo = batchNo;
    }

    public Student() {
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Teacher getAdvisor() {
        return advisor;
    }

    public void setAdvisor(Teacher advisor) {
        this.advisor = advisor;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }
}
