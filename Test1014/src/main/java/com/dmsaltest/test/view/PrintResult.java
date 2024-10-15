package com.dmsaltest.test.view;

import com.dmsaltest.test.model.dto.EmployeeDTO;

import java.util.List;

public class PrintResult {
    public void printEmployeeBySalary(List<EmployeeDTO> employeeList) {
        for(EmployeeDTO employee : employeeList ){
            System.out.println(employee);
        }
    }

    public void printErrorMessage(String errorCode) {
        String errorMessage = "";
        switch (errorCode){
            case "selectSalaryList" :
                errorMessage = "급여금액 별 직원 조회를 실패하셨습니다"; break;
            case "selectDeptCodeList" :
                errorMessage = "부서코드로 직원 조회를 실패하셨습니다."; break;
            case "selectRandom" :
                errorMessage = "랜덤으로 직원 조회를 실패하셨습니다."; break;
        }

        System.out.println(errorMessage);
    }

    public void printEmployeeByDeptCode(List<EmployeeDTO> employeeList) {
        for(EmployeeDTO employee : employeeList ){
            System.out.println(employee);
        }
    }


    public void printEmployeeByRandom(List<EmployeeDTO> employeeList) {
        for(EmployeeDTO employee : employeeList){
            System.out.println(employee);
        }
    }
}
