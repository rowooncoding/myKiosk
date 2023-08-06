public abstract class Order {
    protected Menu[] menus;
    protected int orderPrice;

    public Order(Menu[] menus) {
        this.menus = menus;
        setOrderPrice();
    }

    public abstract void runOrder(int deposit);


    public void setOrderPrice() {
        for (Menu m : menus) {
            if (m == null) {
                break;
            }
            this.orderPrice += m.price;
        }
    }

    public int getOrderPrice() {
        return this.orderPrice;
    }

}