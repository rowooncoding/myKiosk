public class Kiosk {
    public static final int KEY = 3;
    private int inventory;

    // 키오스크 생성자
    public Kiosk(){
        this.inventory = inventory;
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
