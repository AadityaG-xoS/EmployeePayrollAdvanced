package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {

    private List<EmployeePayrollData> employeeList = new ArrayList<>();
    private int idCounter = 1;

    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        return employeeList;
    }

    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        return employeeList.stream()
                .filter(emp -> emp.getId() == empId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData newEmployee = new EmployeePayrollData(idCounter++, employeePayrollDTO.getName(), employeePayrollDTO.getSalary());
        employeeList.add(newEmployee);
        return newEmployee;
    }

    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData emp = this.getEmployeePayrollDataById(empId);
        if (emp != null) {
            emp.setName(employeePayrollDTO.getName());
            emp.setSalary(employeePayrollDTO.getSalary());
        }
        return emp;
    }

    @Override
    public void deleteEmployeePayrollData(int empId) {
        employeeList.removeIf(emp -> emp.getId() == empId);
    }
}
