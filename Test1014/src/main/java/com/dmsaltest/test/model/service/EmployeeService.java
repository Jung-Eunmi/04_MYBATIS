package com.dmsaltest.test.model.service;

import com.dmsaltest.test.model.dao.EmployeeMapper;
import com.dmsaltest.test.model.dto.EmployeeDTO;
import com.dmsaltest.test.model.dto.SearchCriteria;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.dmsaltest.test.common.Template.getSqlSession;

public class EmployeeService {

    private EmployeeMapper mapper;

    public List<EmployeeDTO> selectBySalary(int salary) {
        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(EmployeeMapper.class);

        List<EmployeeDTO> employeeList = mapper.selectBySalary(salary);

        sqlSession.close();

        return employeeList;
    }

    public List<EmployeeDTO> selectBydeptCode(SearchCriteria deptCode) {
        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(EmployeeMapper.class);

        List<EmployeeDTO> employeeList = mapper.selectByDeptCode(deptCode);

        sqlSession.close();

        return employeeList;
    }

    public List<EmployeeDTO> selectByRandom(List<Integer> empIdRandom) {
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(EmployeeMapper.class);

        Map<String, List<Integer>> criteria = new HashMap<>();
        criteria.put("empIdRandom", empIdRandom);

        List<EmployeeDTO> employeeList = mapper.selectByRandom(criteria);

        sqlSession.close();

        return employeeList;
    }

    public List<EmployeeDTO> selectBydeptCodeOrEmpIdElesAllMember(Map<String, Object> criteria) {
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(EmployeeMapper.class);

        List<EmployeeDTO> employeeList = mapper.selectBydeptCodeOrEmpIdElesAllMember(criteria);

        sqlSession.close();

        return employeeList;
    }
}
