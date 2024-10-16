package com.ohgiraffers.section01.xmlmapper;

import com.ohgiraffers.common.CategoryAndMenuDTO;
import com.ohgiraffers.common.MenuAndCategoryDTO;
import com.ohgiraffers.common.MenuDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.common.Template.getSqlSession;

public class ElementService {

    private ElementMapper mapper;

//Cache=============================================================================================
    public void selectCacheTest() {
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(ElementMapper.class);

        // 동일한 쿼리문을 여러 번 실행 테스트 (반복문)
        for(int i = 0; i<10; i++){
            // 조회 시간 확인 용 시작 시간 체크
            // 캐시태그를 사용하면 한번 호출할 때는 DB를 갔다오고 그 이후는 캐시에 저장 된 것을 이용함(시간 절약)
            Long startTime = System.currentTimeMillis();

            List<String> menuNameList = mapper.selectCacheTest();
            System.out.println(menuNameList);

            // 조회 시간 확인 용 끝나는 시간 체크
            Long endTime = System.currentTimeMillis();

            // 총 걸린 시간 체크
            Long interval = endTime - startTime;
            System.out.println("수행 시간 : " + interval + "(ms)");
        }

        sqlSession.close();

    }

//ResultMap 1번 resultMap=================================================================
    public void selectResultMapTest() {
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(ElementMapper.class);

        List<MenuDTO> menuList = mapper.selectResultMapTest();

        for(MenuDTO menu : menuList){
            System.out.println(menu);
        }

        sqlSession.close();
    }
//ResultMap 2번 constructor=================================================================
    public void selectResultMapConstructor() {
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(ElementMapper.class);

        List<MenuDTO> menuList = mapper.selectResultMapConstructor();

        for(MenuDTO menu : menuList){
            System.out.println(menu);
        }

        sqlSession.close();
    }
//ResultMap 3번 association=================================================================
    public void selectResultMapAssociation() {
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(ElementMapper.class);

        List<MenuAndCategoryDTO> menuList = mapper.selectResultMapAssociationTest();

        for(MenuAndCategoryDTO menu : menuList){
            System.out.println(menu);
        }

        sqlSession.close();
    }
//ResultMap 4번 collection=================================================================
    public void selectResultMapCollection() {
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(ElementMapper.class);

        List<CategoryAndMenuDTO> menuList = mapper.selectResultMapCollection();

        for(CategoryAndMenuDTO menu : menuList){
            System.out.println(menu);
        }

        sqlSession.close();
    }
//Sql==============================================================================================
    public void sqlTest() {
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(ElementMapper.class);

        List<MenuDTO> menuList = mapper.selectSqlTest();

        for(MenuDTO menu : menuList){
            System.out.println(menu);
        }

        sqlSession.close();
    }
}
