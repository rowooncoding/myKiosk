public class HereOrder extends Order{
    protected int orderNum;
    OnHere onHere;

    interface OnHere{
        void successHere(String menu, int orderNum, int change);
    }

    public void setOnHere(OnHere onHere){
        this.onHere = onHere;
    }


    public HereOrder(String menu, int count, int price) {
        super(menu, count, price);
    }

    public void setOrderNum(int orderNum) {
        orderNum = orderNum;
    }

    @Override
    public boolean runOrder(int deposit) {
        int change = deposit - orderPrice;
        onHere.successHere(menu, change, orderNum);
        return false;
    }

    private void setOrderPrice(int price) {
        orderPrice = price * count;
        System.out.println(orderPrice + "원 입니다.");
    }
}
