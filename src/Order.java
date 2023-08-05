public abstract class Order {
    public String menu;
    public int count;
    protected int orderPrice;

    public Order(String menu, int count, int price) {
        this.menu = menu;
        this.count = count;
        setOrderPrice(price);
    }

    public abstract boolean runOrder(int deposit);


    private void setOrderPrice(int price) {
        orderPrice = price * count;
        System.out.println(orderPrice + "원 입니다.");
    }

    public int getOrderPrice() {
        return this.orderPrice;
    }

}





