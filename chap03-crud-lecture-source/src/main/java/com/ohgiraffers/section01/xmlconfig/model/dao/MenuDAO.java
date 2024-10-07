package com.ohgiraffers.section01.xmlconfig.model.dao;

import com.ohgiraffers.section01.xmlconfig.model.dto.MenuDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Properties;

public class MenuDAO {

    /* comment.
    *   DAO(Data Access Object)
    *    - 데이터베이스에 접근하는 계층
    *    - 쿼리문을 전달하고 수행 한 쿼리문에 대한 결과를 받는 역할을 한다.
    * */

    public List<MenuDTO> selectAllMenu(SqlSession sqlSession) {

        // menu mapper 에서 작성한 쿼리문 가져오기
        return sqlSession.selectList("MenuMapper.selectAllMenu");

    }
}
