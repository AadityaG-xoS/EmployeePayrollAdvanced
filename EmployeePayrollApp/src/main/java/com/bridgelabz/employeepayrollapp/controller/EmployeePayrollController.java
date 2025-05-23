package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.service.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @Autowired
    private IEmployeePayrollService employeePayrollService;

    @GetMapping("/")
    public List<EmployeePayrollData> getAllEmployees() {
        return employeePayrollService.getEmployeePayrollData();
    }

    @GetMapping("/get/{id}")
    public EmployeePayrollData getEmployeeById(@PathVariable int id) {
        return employeePayrollService.getEmployeePayrollDataById(id);
    }

    @PostMapping("/create")
    public EmployeePayrollData createEmployee(@RequestBody EmployeePayrollDTO dto) {
        return employeePayrollService.createEmployeePayrollData(dto);
    }

    @PutMapping("/update/{id}")
    public EmployeePayrollData updateEmployee(@PathVariable int id, @RequestBody EmployeePayrollDTO dto) {
        return employeePayrollService.updateEmployeePayrollData(id, dto);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id) {
        employeePayrollService.deleteEmployeePayrollData(id);
        return "Deleted employee with id: " + id;
    }
}
