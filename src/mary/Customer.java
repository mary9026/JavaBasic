package mary;

public class Customer implements Buy, Sell {
    @Override
    public void sell() {
        System.out.println("구매하기");
    }

    @Override
    public void buy() {
        System.out.println("판매하기");
    }

    @Override
    public static void order() {
        System.out.println("고객 판매 주문");
    }

}

public interface Buy {
    void buy();

    default void order() {
        System.out.println("구매주문");
    }
}

public interface Sell {
    void sell();

    default void order() {
        System.out.println("판매주문");
    }
}