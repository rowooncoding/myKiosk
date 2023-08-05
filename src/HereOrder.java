public class HereOrder extends Order{
    protected int orderNum;

    public HereOrder(String menu, int count, int price) {
        super(menu, count, price);
    }

    public void setOrderNum(int orderNum) {
        orderNum = orderNum;
    }

    @Override
    public boolean runOrder(int deposit) {
        int change = deposit - orderPrice;
        System.out.println("잔돈 " + change + " 입니다");
        System.out.println(orderNum + "주문번호로 " + menu + " 주문 완료되었습니다.");
        return false;
    }

    private void setOrderPrice(int price) {
        orderPrice = price * count;
        System.out.println(orderPrice + "원 입니다.");
    }
}
