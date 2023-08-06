import java.sql.SQLOutput;

public class Kiosk implements DeliveryOrder.OnDelivery, HereOrder.OnHere, TakeoutOrder.OnTakeout {
    public final static int key = 3;
    private int inventory;

    public Kiosk(int inventory) {
        this.inventory = inventory;
    }


    public Order initOder(String menu, int count, int orderType) {
        int price = 0;

        if (menu.equals("딸기요거트")){
            price = 4500;
        } else if (menu.equals("카페라떼") || menu.equals("밀크티")){
            price = 3500;
        } else if (menu.equals("아메리카노")){
            price = 2000;
        } else {
            price = 0;
        }

        if (price == 0) {
            System.out.println("메뉴가 없습니다.");
            return null;
        }

        if (isInventory(count)) {
            if (orderType == 1) {
                DeliveryOrder order = new DeliveryOrder(menu, count, price);
                order.setOnDelivery(this);
                return order;
            } else if (orderType == 2){
                HereOrder hereOrder = new HereOrder(menu, count, price);
                hereOrder.setOnHere(this);
                return hereOrder;
            } else {
               TakeoutOrder takeoutOrder = new TakeoutOrder(menu, count, price);
               takeoutOrder.setOnTakeout(this);
               return takeoutOrder;
            }
        } else {
            System.out.println("재고가 부족합니다.");
            return null;
        }
    }


    private boolean isInventory(int count) {
        if (inventory >= count) {
            return true;
        } else {
            return false;
        }
    }


    public void subInventory(int count) {
        inventory -= count;
    }

    @Override
    public void successDelivery(String locate, String menu, int count) {
        System.out.print(locate + " 주소로 ");
        System.out.println(menu + " 배달 주문이 완료 되었습니다.");
        subInventory(count);
    }

    @Override
    public void successHere(String menu, int orderNum, int change) {
        System.out.println("잔돈 " + change + " 입니다");
        System.out.println(orderNum + "주문번호로 " + menu + " 주문 완료되었습니다.");
    }

    @Override
    public void successTakeout(String menu, int change, int time) {
        System.out.println("잔돈" + change + " 입니다.");
        System.out.println(time + " 뒤 " + menu + " 포장주문 완료하였습니다.");
    }
}