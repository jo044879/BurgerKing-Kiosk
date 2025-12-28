/*
    22300705 조나은 한동대학교 멋쟁이 사자처럼

    멋쟁이 사자처럼 실습 2번째 과제
    코드 구현은 README.md 통해서 확인
    구현 class - BugerKing, ShoppingBasket class로 구성
    BugerKing - name 과 price으로 구성
    ShoppingBasket은 name price num으로 구성 num은 개 수를 확인하는 변수명이다.
    모든 Scanner class의 변수명(객체)은 scanner로 통일함 각 함수별 Scanner class 동일
    모든 함수에서 scanner를 받는 객체는 userInput으로 통일함.
    ArrayList는 buger, drink side. baskets로 구성 각 정보를 담는다.
    각 함수에서 ArraList class 를 받을 때 각 객체에 첫 글자를 사용함. baskets은 item으로 통일


    main class에 구성되어 있는 함수는 8개로 구성되어 있음
    각 함수에서 ArraList class 를 받을 때 각 객체에 첫 글자를 사용함. baskets은 item으로 통일
    SetMenu 함수는 모든 메뉴들의 수정과 삭제를 용이하게 하기 위한 함수 기초 제공
    MenuPrint 함수는 단순 menu에 대한 프린트를 진행함. 반복문 돌며 항상 시작
    BugerOrder 함수 버거에 대한 주문을 하기 위한 함수 특정 userInput을 입력 시 baskets ArrayList에 저장
    이하 SideOrder DrinkOrder 함수도 동일하게 진행함
    Oredr 함수 - cnhence for 문을 통해서 동일한 메뉴를 받을 땐 수량만 증가.
                새로운 메뉴를 받을 땐 추가를 하게 로직 구성
                userInput이 0일 시 돌아감
    BasketCheck 함수 - 주문하기 수량 조절 삭제로 이루어짐
                       장바구니에 있는 메뉴와 입력을 통해 이동
                       클린 코딩을 위한 수량과 조절은 함수로 구성
                       QuantityControl 함수 - 내에 변경할 메뉴와 수량을 user에게 입력받아 setter를 통해서 직접 변경함.
                                             이후 수량 조절에 따른 price도 변경되어야 하기 때문에 단가를 구한 후 곱해 산출함.
                       DeleteOrder 함수 - 메뉴를 보여주고 이후 삭제할 메뉴를 입력받음
                                         삭제할 것인지 확인 후 remove 함수를 통해서 제거함
    QuantityControl DeleteOrder 함수는 BasketCheck에 포함되어 있어 장바구니에 아무 것도 없는 경우 실행되지 않도록 로직 구성

    모든 error 가능성을 최소화 시키며 구성하였음.
 */
package kiosk;

import java.util.ArrayList;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        //TODO: 구현
        ArrayList<BugerKing> buger = new ArrayList<>();
        ArrayList<BugerKing> drink = new ArrayList<>();
        ArrayList<BugerKing> side = new ArrayList<>();
        ArrayList<ShoppingBasket> baskets  = new ArrayList<>();


        SetMenu(buger, drink, side);

        Scanner scanner = new Scanner(System.in);//Syste,.in 표준 입력 장치에서 읽어 오겠다.

        while(true){
            MenuPrint();

            int userInput;
            userInput = scanner.nextInt();


            if(userInput == 1) BugerOrder(buger, baskets);
            else if (userInput == 2) SideOrder(side, baskets);
            else if (userInput == 3) DrinkOrder(drink, baskets);
            else if (userInput == 4) BasketCheck(baskets);
            else if (userInput == 5) break;
        }


    }


    static void SetMenu(ArrayList<BugerKing> b, ArrayList<BugerKing> d, ArrayList<BugerKing> s){

        b.add(new BugerKing("와퍼", 6900));
        b.add(new BugerKing("큐브 스테이크 와퍼", 8900));
        b.add(new BugerKing("콰트로 치즈 와퍼", 7900));
        b.add(new BugerKing("몬스터 와퍼", 9300));
        b.add(new BugerKing("통새우 와퍼", 7900));
        b.add(new BugerKing("블랙 바베큐 와퍼", 9300));

        s.add(new BugerKing("너겟킹", 2500));
        s.add(new BugerKing("해쉬 브라운", 1800));
        s.add(new BugerKing("치즈스틱", 1200));
        s.add(new BugerKing("어니언링", 2400));
        s.add(new BugerKing("바삭킹", 3000));
        s.add(new BugerKing("감자튀김", 2000));

        d.add(new BugerKing("코카콜라", 2000));
        d.add(new BugerKing("코카콜라 제로", 2000));
        d.add(new BugerKing("펩시", 2000));
        d.add(new BugerKing("펩시 제로", 2000));
        d.add(new BugerKing("사이다", 2000));
        d.add(new BugerKing("사이다 제로", 2000));

    }

    static void MenuPrint(){
        System.out.println("=====홈=====");
        System.out.println("1. 햄버거");
        System.out.println("2. 사이드");
        System.out.println("3. 음료수");
        System.out.println("4. 장바구니");
        System.out.println("5. 종료");
        System.out.print("메뉴 선택:");

    }

    static void BugerOrder(ArrayList<BugerKing> b, ArrayList<ShoppingBasket> item){

        System.out.println("=====햄버거 메뉴=====");
        int i = 0;
        for(BugerKing bugers : b){
            System.out.println(i + 1+". " + bugers.getName() +" "+"("+bugers.getPrice()+")");
            i++;
        }
        System.out.println("메뉴선택 (0을 선택 시 홈으로): ");
        Scanner scanner = new Scanner(System.in);//Syste,.in 표준 입력 장치에서 읽어 오겠다.
        int userInput;
        userInput = scanner.nextInt();

        if (userInput > 0 && userInput <= b.size()) {
            BugerKing selectedBurger = b.get(userInput - 1);
            boolean isExist = false;

            for (ShoppingBasket basketItem : item) {
                if (basketItem.getName().equals(selectedBurger.getName())) {
                    basketItem.setNum(basketItem.getNum() + 1);
                    basketItem.setPrice(basketItem.getPrice() + selectedBurger.getPrice());
                    isExist = true;
                    System.out.println(basketItem.getName() + "의 수량이 추가되었습니다");
                    break;
                }
            }
            if (!isExist) {
                item.add(new ShoppingBasket(selectedBurger.getName(), selectedBurger.getPrice(), 1));
                System.out.println(selectedBurger.getName() + "이(가) 장바구니에 담겼습니다.");
            }
        }
        else if(userInput == 0){
            System.out.println("0번으로 홈으로 이동합니다.");
        }

    }

    static void SideOrder(ArrayList<BugerKing> s, ArrayList<ShoppingBasket> item){

        System.out.println("=====사이드 메뉴=====");
        int i = 0;
        for(BugerKing sides : s){
            System.out.println(i + 1+". " + sides.getName() +" "+"("+sides.getPrice()+")");
            i++;
        }
        System.out.println("메뉴선택 (0을 선택 시 홈으로): ");


        Scanner scanner = new Scanner(System.in);//Syste,.in 표준 입력 장치에서 읽어 오겠다.
        int userInput;

        userInput = scanner.nextInt();


        if(userInput != 0 &&  userInput <= s.size()){
            BugerKing pickItem = s.get(userInput - 1);
            boolean isExist = false;

            for(ShoppingBasket basket : item){
                if(basket.getName().equals(pickItem.getName())){
                    basket.setNum(basket.getNum() + 1);
                    isExist = true;
                    basket.setPrice(basket.getPrice() + pickItem.getPrice());
                    System.out.println(basket.getName() + "의 수량이 추가되었습니다");
                break;
                }

            }
            if(!isExist){
                item.add(new ShoppingBasket(pickItem.getName(), pickItem.getPrice(), 1));
                System.out.println(pickItem.getName() + "이(가) 장바구니에 담겼습니다.");
            }

            System.out.println(userInput - 1 +" 에 있는 메뉴가 담겼습니다.");
        }
        else if(userInput == 0){
            System.out.println("0번으로 홈으로 이동합니다.");
        }
    }

    static void DrinkOrder(ArrayList<BugerKing> d, ArrayList<ShoppingBasket> item){
        System.out.println("=====음료 메뉴=====");
        int i = 0;
        for(BugerKing drinks : d){
            System.out.println(i + 1+". " + drinks.getName() +" "+"("+drinks.getPrice()+")");
            i++;
        }
        System.out.println("메뉴선택 (0을 선택 시 홈으로): ");
        Scanner scanner = new Scanner(System.in);
        int userInput;

        userInput = scanner.nextInt();


        if(userInput != 0 &&  userInput <= d.size()){
            BugerKing pickItem = d.get(userInput - 1);
            boolean isExist = false;

            for(ShoppingBasket basket : item){
                if (basket.getName().equals(pickItem.getName())){
                    isExist = true;
                    basket.setNum(basket.getNum() + 1);
                    basket.setPrice(basket.getPrice() + pickItem.getPrice());
                    System.out.println(basket.getName() + "의 수량이 추가되었습니다");
                    break;
                }
            }
            if(!isExist){
                item.add(new ShoppingBasket(pickItem.getName(), pickItem.getPrice(), 1));
                System.out.println(pickItem.getName() + "이(가) 장바구니에 담겼습니다.");
            }

        }
        else if(userInput == 0) {
            System.out.println("0번으로 홈으로 이동합니다.");
        }
    }


    static void BasketCheck(ArrayList<ShoppingBasket> item){
        if(item.isEmpty()){//item.size() == 0 이렇게 작성했고 intelliJ를 통해서 간략화 시킴
            System.out.println("아무것도 들어가 있지 않습니다. 홈으로 돌아갑니다.");
            return;
        }
        System.out.println("===== 장바구니 =====");
        int totalCost = 0;
        for(ShoppingBasket i : item){
            System.out.println("- "+ i.getName()+" "+i.getNum());
            totalCost += i.getPrice();
        }
        System.out.println("====================");
        System.out.println("1. 주문하기");
        System.out.println("2. 수량 조절하기");
        System.out.println("3. 삭제하기");
        System.out.println("총 가격 "+totalCost);
        //바로 수량 주문하기 함수 가져와서 지우고 수량 조절 ㄱㄱ
        Scanner scanner = new Scanner(System.in);
        int userInput;
        userInput = scanner.nextInt();

        if(userInput == 1) {
            System.out.println("주문 되었습니다.");
        }
        else if (userInput == 2) QuantityControl(item);
        else if(userInput == 3) DeleteOrder(item);
            //1. 주문 2 수량 3 삭제
    }

    static void QuantityControl(ArrayList<ShoppingBasket> item){
        int totalCost = 1;

        System.out.println("===== 수량 조절하기 =====");
        System.out.println("현재 장바구니");
        for(ShoppingBasket i : item){
            System.out.println("["+totalCost+"]"+" "+ i.getName()+" "+i.getNum());
            totalCost ++;
        }


        System.out.println("수량을 조절할 메뉴 번호를 선택하세요 (0을 선택 시 홈으로): ");

        Scanner scanner = new Scanner(System.in);//Syste,.in 표준 입력 장치에서 읽어 오겠다.

        int userInput = scanner.nextInt();

        if(userInput == 0){
            System.out.println("홈으로 돌아갑니다");
        }
        else if(userInput <= item.size() ) {
            System.out.println("번경할 수량을 정하세요");
            int userQuantity = scanner.nextInt();
            if (userInput <= item.size() && userInput >= 1) {
                ShoppingBasket quantity = item.get(userInput - 1);
                int unitPrice = quantity.getPrice() / quantity.getNum();
                quantity.setNum(userQuantity);
                quantity.setPrice(unitPrice * userQuantity);
            }
            else{
                System.out.println("번호가 정확하지 않습니다 홈으로 돌아갑니다.");
            }
        }
        else{
            System.out.println("주문번호가 옳지 않습니다.");
        }


    }


    static void DeleteOrder(ArrayList<ShoppingBasket> item){
        int totalCost = 1;
        System.out.println("===== 삭제하기 =====");
        System.out.println("현재 장바구니");
        for(ShoppingBasket i : item){
            System.out.println("["+totalCost+"]"+" "+ i.getName()+" "+i.getNum());
            totalCost ++;
        }
        System.out.println(" ");

        Scanner scanner = new Scanner(System.in);//Syste,.in 표준 입력 장치에서 읽어 오겠다.
        System.out.println("삭제할 메뉴 번호를 선택하세요 (0을 선택 시 홈으로): ");
        int userInput = scanner.nextInt();
        int index = userInput - 1;

        if(userInput <= 0 || index >= item.size()){
            System.out.println("번호가 이상합니다 홈으로 이동");
            return;
        }
        System.out.println("정말 삭제 하시겠습니까? (0: 취소 및 홈으로 1: 삭제):");
        int removeInput = scanner.nextInt();
        if(removeInput == 1) {
            item.remove(index);
            System.out.println("삭제 되었습니다.");
        }
    }
}