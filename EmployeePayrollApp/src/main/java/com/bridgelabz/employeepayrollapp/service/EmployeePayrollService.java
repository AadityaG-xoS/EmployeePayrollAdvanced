package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class EmployeePayrollService implements IEmployeePayrollService {

    private List<EmployeePayrollData> employeeList = new ArrayList<>();
    private int idCounter = 1;

    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        log.info("Fetching all employee data");
        return employeeList;
    }
    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData newEmployee = new EmployeePayrollData(idCounter++, employeePayrollDTO.getName(), employeePayrollDTO.getSalary());
        employeeList.add(newEmployee);
        log.info("Created new employee: {}", newEmployee);
        return newEmployee;
    }
    @Override
    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        return employeeList.stream()
                .filter(emp -> emp.getId() == empId)
                .findFirst()
                .orElseThrow(() -> new EmployeePayrollException("Employee with ID " + empId + " not found"));
    }

    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData emp = this.getEmployeePayrollDataById(empId);
        emp.setName(employeePayrollDTO.getName());
        emp.setSalary(employeePayrollDTO.getSalary());
        return emp;
    }

    @Override
    public void deleteEmployeePayrollData(int empId) {
        EmployeePayrollData emp = this.getEmployeePayrollDataById(empId); // will throw if not found
        employeeList.remove(emp);
    }
}
