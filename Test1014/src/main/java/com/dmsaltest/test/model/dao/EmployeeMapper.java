package com.dmsaltest.test.model.dao;

import com.dmsaltest.test.model.dto.EmployeeDTO;
import com.dmsaltest.test.model.dto.SearchCriteria;

import java.util.List;

public interface EmployeeMapper {
    List<EmployeeDTO> selectBySalary(int salary);

    List<EmployeeDTO> selectByDeptCode(SearchCriteria deptCode);
}
