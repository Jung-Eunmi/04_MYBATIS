package com.ohgiraffers.section01.dynamic;

import com.ohgiraffers.common.MenuDTO;
import com.ohgiraffers.common.SearchCriteria;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ohgiraffers.common.Template.getSqlSession;

public class MenuService {

    private  DynamicSqlMapper mapper;

    public void selectMenuByPrice(int price) {

        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        /* comment.
        *   우리가 지금 하려고 하는 것이 price 를 query 문에 전달해서
        *   금액에 따라 적합한 메뉴를 추천을 해 줄 것이다.
        *   기본 자료형으로는 조건문의 값을 비교할 수 없어 인스턴스화를 진행해야한다.
        *   hashmap 을 사용하여 key 값으로 접근, dto 를 사용해서 getter 메소드로 접근 */

        // int 의 wrapper 클래스
        // Map 을 자료형으로 쓰고 인스턴스는 HashMap 으로 사용하는 다형성
        Map<String, Integer> map = new HashMap<>();
        map.put("price", price); // int 자료형인 price 가 Integer 로 오토박싱(자동형변환)

        // 우리가 전달한 값에 해당하는 메뉴들이 조회
        List<MenuDTO> menuList =  mapper.selectMenuByPrice(map);

        // 메뉴가 존재한다면
        if(menuList != null && menuList.size() > 0) {
            for(MenuDTO menu : menuList){
                System.out.println(menu);
            }
        } else {
            System.out.print("검색 결과 없습니다.");
        }

        sqlSession.close();

    }

    public void searchMenu(SearchCriteria searchCriteria) {

        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        List<MenuDTO> menuList = mapper.searchMenu(searchCriteria);

        if(menuList != null && menuList.size() > 0) {
            for(MenuDTO menu : menuList){
                System.out.println(menu);
            }
        } else {
            System.out.print("검색 결과 없습니다.");
        }

        sqlSession.close();
    }

    public void searchMenuBySupCategory(SearchCriteria searchCriteria) {

        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        List<MenuDTO> menuList = mapper.searchMenuBySupCategory(searchCriteria);

        if(menuList != null && menuList.size() > 0) {
            for(MenuDTO menu : menuList){
                System.out.println(menu);
            }
        } else {
            System.out.print("검색 결과 없습니다.");
        }

        sqlSession.close();
    }

    public void searchMenuByRandomCode(List<Integer> randomCodeList) {

        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        Map<String, List<Integer>> criteria = new HashMap<>();
        // Map 형식으로 우리가 만든 5개의 랜덤코드 리스트 집어넣기
        criteria.put("randomCodeList", randomCodeList);

        List<MenuDTO> menuList = mapper.searchMenuByRandomCode(criteria);

        if(menuList != null && menuList.size() > 0) {
            for(MenuDTO menu : menuList){
                System.out.println(menu);
            }
        } else {
            System.out.print("검색 결과 없습니다.");
        }

        sqlSession.close();

    }

    public void searchMenuByCodeOrSearchAll(SearchCriteria searchCriteria) {
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        List<MenuDTO> menuList = mapper.searchMenuByCodeOrSearchAll(searchCriteria);

        if(menuList != null && menuList.size() > 0) {
            for(MenuDTO menu : menuList){
                System.out.println(menu);
            }
        } else {
            System.out.print("검색 결과 없습니다.");
        }

        sqlSession.close();
    }

    public void searchMenuByNameOrCategory(Map<String, Object> criteria) {

        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        List<MenuDTO> menuList = mapper.searchMenuByNameOrCategory(criteria);

        if(menuList != null && menuList.size() > 0) {
            for(MenuDTO menu : menuList){
                System.out.println(menu);
            }
        } else {
            System.out.print("검색 결과 없습니다.");
        }

        sqlSession.close();
    }

    public void modifyMenu(Map<String, Object> criteria) {
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        int result = mapper.modifyMenu(criteria);

        if (result > 0) {
            System.out.println("메뉴 정보 변경 성공!!");
            sqlSession.commit();
        } else {
            System.out.println("메뉴 변경 실패...");
            sqlSession.rollback();
        }

        sqlSession.close();
    }
}
