public class Menu {
    public String name;
    public int price;

    public Menu(String name) throws KisokException {
        this.name = name;
        if (name.equals("딸기요거트")){
            price = 4500;
        } else if (name.equals("카페라떼") || name.equals("밀크티")){
            price = 3500;
        } else if (name.equals("아메리카노")){
            price = 2000;
        } else {
            price = 0;
            throw new KisokException(101);
        }
    }
}