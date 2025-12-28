package kiosk;

public class BugerKing {

    String name;
    int price;

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

    public BugerKing(String name, int price){
        this.name = name;
        this.price = price;
    }

    public boolean equals(BugerKing nameCk) {
        return name.equals(nameCk.getName());
    }
}
