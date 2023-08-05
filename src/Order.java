public class Order {
    public String menu;
    public int count;
    private int orderPrice;

    public Order(String menu, int count, int price) {
        this.menu = menu;
        this.count = count;
        setOrderPrice(price);
    }

    public boolean runOrder(int deposit) {

        int change = deposit - orderPrice;
        if (change >= 0) {
            System.out.print("잔돈 "+change+"와 ");
            System.out.println(menu + " 나왔습니다.");
            return true;
        } else {
            System.out.println("금액이 부족합니다.");
            return false;
        }
    }


    private void setOrderPrice(int price) {
        orderPrice = price * count;
        System.out.println(orderPrice + "원 입니다.");
    }

    public int getOrderPrice() {
        return this.orderPrice;
    }

}





