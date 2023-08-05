public class Kiosk {
    public static int key = 3;
    private int inventory;

    public Kiosk(int inventory) {
        this.inventory = inventory;
    }


    public Order initOder(String menu, int count) {
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
            Order order = new Order(menu, count, price);
            return order;
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
}