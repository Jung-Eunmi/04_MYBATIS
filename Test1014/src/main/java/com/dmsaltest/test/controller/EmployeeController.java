package com.dmsaltest.test.controller;

import com.dmsaltest.test.model.dto.EmployeeDTO;
import com.dmsaltest.test.model.dto.SearchCriteria;
import com.dmsaltest.test.model.service.EmployeeService;
import com.dmsaltest.test.view.PrintResult;

import java.util.List;

public class EmployeeController {

    private final EmployeeService employeeService;
    private final PrintResult printResult;

    public EmployeeController() {
        this.employeeService = new EmployeeService();
        this.printResult = new PrintResult();
    }

    public void selectBySalary(int salary) {

        List<EmployeeDTO> employeeDTOList = employeeService.selectBySalary(salary);

        if(employeeDTOList != null){
            printResult.printEmployeeBySalary(employeeDTOList);
        }else {
            printResult.printErrorMessage("selectSalaryList");
        }

    }

    public void selectBydeptCode(SearchCriteria deptCode) {

        List<EmployeeDTO> employeeList = employeeService.selectBydeptCode(deptCode);

        if(employeeList != null){
            printResult.printEmployeeByDeptCode(employeeList);
        }else {
            printResult.printErrorMessage("selectDeptCodeList");
        }
    }
}
