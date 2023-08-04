public class Order {
    private String menu;
    private int count;
    private int orderPrice;

    // 생성자
    public Order(String menu, int count, int price){
        this.menu = menu;
        this.count = count;
        setOrderPrice(price);
    }

    public void setOrderPrice(int price){
        this.orderPrice = price * count;
    }






}
