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

            int userInput = 0;
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
        int userInput = 0;
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
        else if(userInput == 0){
            System.out.println("0번으로 홈으로 이동합니다.");
        }
        //장바구니를 만들고 거기다 추가를 계속해야함 다른것들도 똑같게 프린트만 만드렀음.
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
        int userInput = 0;

        userInput = scanner.nextInt();


        if(userInput != 0 &&  userInput <= s.size()){
            BugerKing pickItem = s.get(userInput - 1);
            boolean isExist = false;

            for(ShoppingBasket basketitem : item){
                if(basketitem.getName().equals(pickItem.getName())){
                basketitem.setNum(basketitem.getNum() + 1);
                isExist = true;
                basketitem.setPrice(basketitem.getPrice() + pickItem.getPrice());

                    System.out.println(basketitem.getName() + "의 수량이 추가되었습니다");
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
        Scanner scanner = new Scanner(System.in);//Syste,.in 표준 입력 장치에서 읽어 오겠다.
        int userInput = 0;

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
        int userInput = 0;
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
        else {
            System.out.println("번경할 수량을 정하세요");
            int userQuantity = scanner.nextInt();
            if (userInput <= item.size() && userInput >= 1) {
                ShoppingBasket quantity = item.get(userInput - 1);
                quantity.setNum(userQuantity);
                int unitPrice = quantity.getPrice();   // 일단 지금 price가 '단가'라고 가정
                quantity.setNum(userQuantity);
                quantity.setPrice(unitPrice * userQuantity);
            }
            else{
                System.out.println("번호가 정확하지 않습니다 홈으로 돌아갑니다.");
            }
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

        if(userInput <= 0 && index >= item.size()){
            System.out.println("번호가 이상합니다 홈으로 이동");
            return;
        }
        System.out.println("정말 삭제 하시겠습니까? (0: 취소 및 홈으로 1: 삭제):");
        int removeInput = scanner.nextInt();
        if(removeInput == 1) {
            ShoppingBasket removeItem = item.remove(index);
            System.out.println("삭제 되었습니다.");
        }
    }
}