public class Kiosk {
    public static final int KEY = 3;
    private int inventory;

    // 키오스크 생성자
    public Kiosk(){
        this.inventory = inventory;
    }

    public Order initOrder(String menu, int count){
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

        if(price == 0){
            return null;
        }

        if(isInvetory((count))){
            Order order = new Order(menu, count, price);
            return order;
        }else{
            return null;
        }

    }



    // 재고 개수 확인하여 불린 타입 반환
    public boolean isInvetory(int count){
        if(inventory > count){
            return true;
        }else{
            return false;
        }
    }

    // 재고개수를 감소시켜줌
    public void subInventory(int count){
        this.inventory = inventory - count;
    }




}
