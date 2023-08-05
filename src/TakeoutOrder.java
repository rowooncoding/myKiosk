public class TakeoutOrder extends Order{
    protected int time;
    public TakeoutOrder(String menu, int count, int price) {
        super(menu, count, price);
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public boolean runOrder(int deposit) {
        int change = deposit - orderPrice;
        if(change >= 0){
            System.out.println("잔돈" + change + " 입니다.");
            System.out.println(time + " 뒤 " + menu + " 포장주문 완료하였습니다.");
        }
        return false;
    }

    private void setOrderPrice(int price) {
        orderPrice = price * count -500;
        System.out.println("테이크 아웃은 500원 할인되어" + orderPrice + "원 입니다.");
    }
}
