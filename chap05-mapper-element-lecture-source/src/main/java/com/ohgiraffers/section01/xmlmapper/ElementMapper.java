package com.ohgiraffers.section01.xmlmapper;

import com.ohgiraffers.common.MenuDTO;

import java.util.List;

public interface ElementMapper {

    List<String> selectCacheTest();

    List<MenuDTO> selectResultMapTest();

    List<MenuDTO> selectResultMapConstructor();
}
