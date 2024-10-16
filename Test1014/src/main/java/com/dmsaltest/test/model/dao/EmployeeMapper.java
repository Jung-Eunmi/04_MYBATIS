package com.dmsaltest.test.model.dao;

import com.dmsaltest.test.model.dto.EmployeeDTO;
import com.dmsaltest.test.model.dto.SearchCriteria;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {
    List<EmployeeDTO> selectBySalary(int salary);

    List<EmployeeDTO> selectByDeptCode(SearchCriteria deptCode);


    List<EmployeeDTO> selectByRandom(Map<String, List<Integer>> criteria);

    List<EmployeeDTO> selectBydeptCodeOrEmpIdElesAllMember(Map<String, Object> criteria);
}
