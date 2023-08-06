public class TakeoutOrder extends Order{
    protected int time;
    OnTakeout onTakeout;

    interface OnTakeout{
        void successTakeout(String menu, int change, int time);
    }

    public void setOnTakeout(OnTakeout onTakeout){
        this.onTakeout = onTakeout;
    }

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
            onTakeout.successTakeout(menu, change, time);
        }
        return false;
    }

    private void setOrderPrice(int price) {
        orderPrice = price * count -500;
        System.out.println("테이크 아웃은 500원 할인되어" + orderPrice + "원 입니다.");
    }
}
