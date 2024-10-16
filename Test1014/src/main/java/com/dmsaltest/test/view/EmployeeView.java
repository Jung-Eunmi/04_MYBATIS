package com.dmsaltest.test.view;

import com.dmsaltest.test.controller.EmployeeController;
import com.dmsaltest.test.model.dto.SearchCriteria;

import java.util.*;

public class EmployeeView {

    public void display() {

        Scanner sc = new Scanner(System.in);
        EmployeeController employeeController = new EmployeeController();

        do{
            System.out.println("=================HiMedia 회사=================");
            System.out.println("1. 급여금액대 직원 조회");
            System.out.println("2. 부서명으로 직원 조회");
            System.out.println("3. 3명의 직원 랜덤으로 조회하기");
            System.out.println("4. 사번 혹은 부서코드로 검색, 사번과 부서코드 둘다 일치하는 경우도 검색, 검색 조건 없으면 전체 검색");
            System.out.println("5. 직원 정보 부분수정하기");
            System.out.println("9. 프로그램 종료");
            System.out.println("==============================================");
            System.out.print("실행 할 메뉴를 선택해주세요 : ");
            int no = sc.nextInt();

            switch (no){
                case 1 :
                    employeeController.selectBySalary(inputSqlary()); break;
                case 2 :
                    employeeController.selectBydeptCode(inputDeptCode()); break;
                case 3 :
                    employeeController.selectByRandom(inputRandom()); break;
                case 4 :
                    employeeController.selectBydeptCodeOrEmpIdElesAllMember(inputDeptCodeOrEmpId());break;
                case 9 :
                    return;
            }

        }while (true);


    }

    private static int inputSqlary() {
        Scanner sc = new Scanner(System.in);
        System.out.print("조회하고 싶은 직원의 급여금액을 입력해주세요 : ");
        int salary = sc.nextInt();

        return salary;
    }

    private SearchCriteria inputDeptCode() {
        Scanner sc = new Scanner(System.in);
        System.out.print("부서명을 입력해주세요 : ");
        String value = sc.nextLine();

        return new SearchCriteria("deptName", value);
    }

    private static List<Integer> inputRandom() {
        Set<Integer> set = new HashSet<>();
        while(set.size() < 3){
            int random = ((int)(Math.random()*20))+200;
            set.add(random);
        }

        List<Integer> empIdRandom = new ArrayList<>(set);
        Collections.sort(empIdRandom);

        return empIdRandom;
    }

    private static Map<String, Object> inputDeptCodeOrEmpId() {
        Scanner sc = new Scanner(System.in);
        System.out.print("검색 조건 (empId or deptCode or both or null) : ");
        String condition = sc.nextLine();

        Map<String, Object> criteria = new HashMap<>();
        if("empId".equals(condition)){

            System.out.print("검색 할 사원번호를 입력해주세요 : ");
            String empIdValue = sc.nextLine();
            criteria.put("empIdValue", empIdValue);

        } else if("deptCode".equals(condition)){

            System.out.print("검색 할 부서코드를 입력해주세요 : ");
            String deptCodeValue = sc.nextLine();

            criteria.put("deptCodeValue", deptCodeValue);

        } else if("both".equals(condition)){

            System.out.print("검색 할 사원번호를 입력해주세요 : ");
            String empIdValue = sc.nextLine();
            System.out.print("검색 할 부서코드를 입력해주세요 : ");
            String deptCodeValue = sc.nextLine();

            criteria.put("empIdValue", empIdValue);
            criteria.put("deptCodeValue", deptCodeValue);
        }

        return criteria;
    }



}
