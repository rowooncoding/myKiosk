public class TakeoutOrder extends Order{
    private OnTakeout onTakeout;
    private int time;

    interface OnTakeout{
        void successTakeout(int change, int time, Menu[] menus);
    }

    public void setOnTakeout(OnTakeout onTakeout) {
        this.onTakeout = onTakeout;
    }

    public TakeoutOrder(Menu[] menus) {
        super(menus);
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public void runOrder(int deposit) {
        int change = deposit - orderPrice;
        if (change >= 0) {
            onTakeout.successTakeout(change, time, menus);
        } else {
            System.out.println("금액이 부족합니다.");
        }
    }

    @Override
    public void setOrderPrice() {
        // TODO Auto-generated method stub
        super.setOrderPrice();
        this.orderPrice -= 500;
        System.out.print("테이크 아웃은 500원 할인되어 ");
        System.out.println(orderPrice + "원 입니다.");
    }
}