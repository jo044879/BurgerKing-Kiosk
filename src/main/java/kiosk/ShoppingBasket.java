package kiosk;

public class ShoppingBasket {

    String name;
    int price;
    int num;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public ShoppingBasket(String name, int price, int num){
        this.name = name;
        this.num = num;
        this.price = price;
    }
}
