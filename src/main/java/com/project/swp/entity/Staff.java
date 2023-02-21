package com.project.swp.entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;
@Entity
@Table(name = "Staff")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EmpID")
    private int empId;

    @Column(name = "UserName")
    private String userName;

    @Column(name = "Password")
    private String password;

    @Column(name = "EmpName")
    private String empName;

    @Column(name = "PhoneNumber")
    private String phoneNumber;

    @Column(name = "Email")
    private String email;

    @Column(name = "Picture")
    private String picture;

    @Column(name = "Status")
    private String status;

    @Column(name = "Salary")
    private Double salary;

    @Column(name = "TimeWork")
    private String timeWork;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "RoleID", referencedColumnName="RoleID"),
            @JoinColumn(name = "ResID", referencedColumnName="ResID")
    })
   private Role role;

    public Staff() {
    }

    public Staff(int empId, String userName, String password, String empName, String phoneNumber, String email, String picture, String status, Double salary, String timeWork, Role role) {
        this.empId = empId;
        this.userName = userName;
        this.password = password;
        this.empName = empName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.picture = picture;
        this.status = status;
        this.salary = salary;
        this.timeWork = timeWork;
        this.role = role;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getTimeWork() {
        return timeWork;
    }

    public void setTimeWork(String timeWork) {
        this.timeWork = timeWork;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
