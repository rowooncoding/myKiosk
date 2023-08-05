public class DeliveryOrder extends Order{
    protected String locate;

    public DeliveryOrder(String menu, int count, int price) {
        super(menu, count, price);
    }

    public void setLocate(String locate) {
        this.locate = locate;
    }

    @Override
    public boolean runOrder(int deposit) {
        int change = deposit - orderPrice;
        if(change == 0){
            System.out.println(locate + " 주소로 " + menu + " 배달 주문 완료하였습니다.");
            return true;
        }
        return false;
    }

    private void setOrderPrice(int price) {
        orderPrice = price * count +3000;
        System.out.println("배달비 300원 추가되어" + orderPrice + "원 입니다.");
        System.out.println("배달 주문은 정확한 금액을 입력해주세요");
    }
}
