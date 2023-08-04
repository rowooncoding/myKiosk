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
        System.out.println(orderPrice + " 원 입니다.");
    }

    public boolean runOrder(int deposit){
        int change = deposit - orderPrice;
        if(change >= 0){
            System.out.println("잔돈 " + change + " 와 " + menu + "나왔습니다.");
            return true;
        }else{
            System.out.println("금액이 부족합니다.");
            return false;
        }
    }







}
