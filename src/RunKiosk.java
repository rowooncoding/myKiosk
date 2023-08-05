import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.Scanner;

import java.util.Scanner;


public class RunKiosk {


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        System.out.println("키오스크 키를 입력해주세요");
        int key = scanner.nextInt();

        if (Kiosk.key == key) {
            System.out.println("매장 재고개수를 입력해주세요");
            int inventory = scanner.nextInt();

            Kiosk kiosk = new Kiosk(inventory);
            while (true) {
                System.out.println("메뉴와 개수를 입력해주세요");
                String menu = scanner.next();
                if (menu.equals("종료")) {
                    System.out.println("프로그램을 종료 합니다.");
                    break;
                }

                int count = scanner.nextInt();
                Order order = kiosk.initOder(menu, count);
                if (order == null) {
                    continue;
                }

                int deposit = scanner.nextInt();
                if (order.runOrder(deposit)) {
                    kiosk.subInventory(count);
                }

            }

        } else {
            System.out.println("키오스크 키가 맞지 않습니다.");
        }

        scanner.close();
    }

}