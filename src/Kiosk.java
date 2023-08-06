public class Kiosk implements DeliveryOrder.OnDelivery, HereOrder.OnHere, TakeoutOrder.OnTakeout {
    public static int key = 3;
    private int inventory;

    public Kiosk(int inventory) {
        this.inventory = inventory;
    }

    public Order initOder(Menu[] menus, int orderType) throws KisokException {


        if (isInventory(menus.length)) {
            if (orderType == 1) {
                DeliveryOrder order = new DeliveryOrder(menus);
                order.setOnDelivery(this);
                return order;
            } else if (orderType == 2){
                TakeoutOrder order = new TakeoutOrder(menus);
                order.setOnTakeout(this);
                return order;
            } else {
                HereOrder order = new HereOrder(menus);
                order.setOnHere(this);
                return order;
            }
        } else {
            System.out.println("재고가 부족합니다.");
            throw new KisokException(102);
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
    public void successDelivery(String locate, Menu[] menus) {
        System.out.println(locate + " 주소로 배달 주문이 완료 되었습니다.");
        System.out.print("주문 내역 : ");
        for (Menu m : menus) {
            if (m == null) {
                break;
            }
            System.out.print(m.name + " ");
        }
        System.out.println("");
        subInventory(menus.length);
    }
    @Override
    public void successHere(int change, int orderNum, Menu[] menus) {
        System.out.println("잔돈 "+change+"입니다. ");
        System.out.println(orderNum+ " 주문번호로 주문 완료되었습니다.");
        System.out.print("주문 내역 : ");
        for (Menu m : menus) {
            if (m == null) {
                break;
            }
            System.out.print(m.name + " ");
        }
        System.out.println("");
        subInventory(menus.length);
    }
    @Override
    public void successTakeout(int change, int time, Menu[] menus) {
        System.out.println("잔돈 "+change+"입니다. ");
        System.out.print(time+ " 분후 포장주문 완료되었습니다.");
        System.out.print("주문 내역 : ");
        for (Menu m : menus) {
            if (m == null) {
                break;
            }
            System.out.print(m.name + " ");
        }
        System.out.println("");
        subInventory(menus.length);
    }

}

class KisokException extends Exception {
    public int code;

    public KisokException(int code) {
        this.code = code;
    }
}