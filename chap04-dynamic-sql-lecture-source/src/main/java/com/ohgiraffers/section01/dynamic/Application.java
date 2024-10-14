package com.ohgiraffers.section01.dynamic;

import com.ohgiraffers.common.MenuDTO;
import com.ohgiraffers.common.SearchCriteria;

import java.util.*;

public class Application {

    public static void main(String[] args) {

        /* title. MyBatis Dynamic SQL 확인하기 */
        Scanner sc = new Scanner(System.in);

        do{
            System.out.println("=======MyBatis 동적 SQL 학습 메뉴=======");
            System.out.println("1. if 확인하기");
            System.out.println("2. choose(when, otherwise) 확인하기");
            System.out.println("3. foreach 확인하기");
            System.out.println("4. trim(where, set) 확인하기");
            System.out.println("9. 종료하기");
            System.out.print("메뉴를 선택해주세요 : ");
            int no = sc.nextInt();

            switch (no){
                case 1 :
                    ifsubMenu(); break;
                case 2 :
                    chooseSubMenu(); break;
                case 3 :
                    foreachSubMenu(); break;
                case 4 :
                    trimSubMenu(); break;

                case 9 :
                    System.out.println("프로그램 종료"); return;
            }

        } while (true);

    }


// if 확인=================================================================================================
    private static void ifsubMenu() {
        Scanner sc = new Scanner(System.in);
        MenuService menuService = new MenuService();

        do{
            System.out.println("=================if 서브메뉴=================");
            System.out.println("1. 원하는 금액 대 적합한 추천 메뉴 목록 보여주기");
            System.out.println("2. 메뉴 이름 or 카테고리 명으로 검색해서 메뉴 목록 보여주기");
            System.out.println("9. 이전 메뉴로 돌아가기");
            System.out.print("원하는 메뉴를 선택해주세요 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1 :
                    menuService.selectMenuByPrice(inputPrice()); break;
                case 2 :
                    menuService.searchMenu(inputSearchCriteria()); break;
                case 9 :
                    System.out.println("if 서브메뉴 종료"); return;
            }

        } while (true);


    }

    // if 1번
    private static int inputPrice() {
        Scanner sc = new Scanner(System.in);
        System.out.print("검색하실 가격의 최대 금액을 입력해주세요 : ");
        int price = sc.nextInt();

        return price;
    }

    // if 2번
    private static SearchCriteria inputSearchCriteria() {
        Scanner sc = new Scanner(System.in);
        System.out.print("검색 기준을 선택해주세요(menuName or category) : ");
        String condition = sc.nextLine();
        System.out.print("검색어를 입력해주세요 : ");
        String value = sc.nextLine();

        return new SearchCriteria(condition, value);
    }

// choose 확인=================================================================================================
    private static void chooseSubMenu() {
        Scanner sc = new Scanner(System.in);
        MenuService menuService = new MenuService();

        do{
            System.out.println("=================choose 서브메뉴=================");
            System.out.println("1. 카테고리 상위 분류별 메뉴 보여주기(식사, 음료, 디저트)");
            System.out.println("9. 이전 메뉴로 돌아가기");
            System.out.print("메뉴 번호를 입력하세요 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1 :
                    menuService.searchMenuBySupCategory(inputSupCategory()); break;
                case 9 :
                    return;
            }

        }while (true);
    }

    private static SearchCriteria inputSupCategory() {
        Scanner sc = new Scanner(System.in);
        System.out.print("상위 분류를 입력해주세요(식사, 음료, 디저트) : ");
        String value = sc.nextLine();

        return new SearchCriteria("category", value);
    }

// foreach 확인=================================================================================================
    private static void foreachSubMenu() {
        Scanner sc = new Scanner(System.in);
        MenuService menuService = new MenuService();

        do{
            System.out.println("=================foreach 서브메뉴=================");
            System.out.println("1. 랜덤한 메뉴 5개 추출해서 조회하기");
            System.out.println("9. 이전 메뉴로 돌아가기");
            System.out.print("메뉴 번호를 입력하세요 : ");
            int no = sc.nextInt();

            switch (no){
                case 1 :
                    menuService.searchMenuByRandomCode(createRandomCodeList()); break;
                case 9 :
                    return;
            }
        }while (true);
    }

                    // 컬렉션에는 기본자료형이 들어갈 수 없다. 그러므로 <Integer> 를 씀
    private static List<Integer> createRandomCodeList() {

        // 5개의 중복되지 않는 메뉴코드 생성
        Set<Integer> set = new HashSet<>();
        while (set.size() < 5){
            int temp = ((int)(Math.random()*20))+1;
            set.add(temp);
        }
        List<Integer> menuCodeList = new ArrayList<>(set);
        Collections.sort(menuCodeList);

        return menuCodeList;
    }

// trim 확인=================================================================================================
    private static void trimSubMenu() {
        Scanner sc = new Scanner(System.in);
        MenuService menuService = new MenuService();

        do{
            System.out.println("=================trim 서브메뉴=================");
            System.out.println("1. 검색 조건이 있는 경우 메뉴코드로 조회, 단 없으면 전체 조회");
            System.out.println("2. 메뉴 혹은 카테고리코드로 검색, 메뉴와 카테고리 둘다 일치하는 경우도 검색, 검색 조건 없으면 전체 검색");
            System.out.println("3. 원하는 메뉴 정보만 수정하기");
            System.out.println("9. 이전 메뉴로 돌아가기");
            System.out.print("메뉴 번호를 입력하세요 : ");
            int no = sc.nextInt();

            switch (no){
                case 1 :
                    menuService.searchMenuByCodeOrSearchAll(inputAllOrOne()); break;
                case 2 :
                    menuService.searchMenuByNameOrCategory(inputSearchCriteriaMap()); break;
                case 3 :
                    menuService.modifyMenu(inputChange()); break;
                case 9 :
                    return;
            }
        }while (true);

    }

    // trim 1번
    private static SearchCriteria inputAllOrOne() {
        // condition -> 검색 조건 // value -> 값
        Scanner sc = new Scanner(System.in);
        System.out.print("검색 조건을 입력하시겠습니까?(예 or 아니오) : ");
        boolean hasSearchValue = "예".equals(sc.nextLine())? true : false;

        SearchCriteria searchCriteria = new SearchCriteria();
        // 우리가 "예" 를 입력 했을 때 삼항연산자로 true 를 반환하게 만들었음
        if(hasSearchValue){
            System.out.print("검색 할 메뉴 코드를 입력해주세요 : ");
            String code = sc.nextLine();
            searchCriteria.setCondition("menuCode");
            searchCriteria.setValue(code);
        }

        return searchCriteria;
    }

    // trim 2번
    private static Map<String, Object> inputSearchCriteriaMap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("검색 조건(category or name or both or null) : ");
        String condition = sc.nextLine();

        Map<String, Object> criteria = new HashMap<>();
        if("category".equals(condition)){

            System.out.print("검색 할 카테고리 코드를 입력해주세요 : ");
            int categoryValue = sc.nextInt();
            criteria.put("categoryValue", categoryValue);

        } else if("name".equals(condition)){

            System.out.print("검색 할 메뉴 이름을 입력해주세요 : ");
            String nameValue = sc.nextLine();
            criteria.put("nameValue", nameValue);

        } else if("both".equals(condition)){

            System.out.print("검색할 메뉴 이름을 입력해주세요 : ");
            String nameValue = sc.nextLine();
            System.out.print("검색할 메뉴 이름을 입력해주세요 : ");
            int categoryValue = sc.nextInt();
            criteria.put("nameValue", nameValue);
            criteria.put("categoryValue", categoryValue);
        }

        return criteria;
    }

    // trim 3번
    private static Map<String, Object> inputChange() {
        Scanner sc = new Scanner(System.in);
        System.out.print("변경 할 메뉴 코드를 입력해주세요 : ");
        int code = sc.nextInt();
        System.out.print("변경 할 메뉴 이름을 입력해주세요 : ");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.print("변경 할 카테고리 코드를 입력해주세요 : ");
        int categoryCode = sc.nextInt();
        System.out.print("판매여부를 결정해주세요(Y/N) : ");
        sc.nextLine();
        String orderableStatus = sc.nextLine();

        Map<String, Object> criteria = new HashMap<>();
        criteria.put("code", code);
        criteria.put("name", name);
        criteria.put("categoryCode", categoryCode);
        criteria.put("orderableStatus", orderableStatus);

        return criteria;
    }

}
