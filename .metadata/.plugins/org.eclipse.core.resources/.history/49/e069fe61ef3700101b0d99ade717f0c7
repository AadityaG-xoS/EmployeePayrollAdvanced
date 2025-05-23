package com.bridgelabz.employeepayrollapp.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @GetMapping("/")
    public String getWelcomeMessage() {
        return "Welcome to Employee Payroll App!";
    }

    @GetMapping("/get")
    public String getEmployeeData() {
        return "Get Call Success";
    }

    @GetMapping("/get/{id}")
    public String getEmployeeById(@PathVariable int id) {
        return "Get Call Success for id: " + id;
    }

    @PostMapping("/create")
    public String createEmployee(@RequestBody String employeeData) {
        return "Post Call Success: " + employeeData;
    }

    @PutMapping("/update")
    public String updateEmployee(@RequestBody String employeeData) {
        return "Put Call Success: " + employeeData;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id) {
        return "Delete Call Success for id: " + id;
    }
}
