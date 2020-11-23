package mary;

// 인터페이스
// 추상메서드와 상수만으로 구서된 특수한 클래스
// 어떤 클래스를 만들때 추상메서드를 통해
// 기본이 되는 틀을 제공하여 규칙에 맞춰 코드를 짤 수 있게 해줌 => 접근제한자는 언제나 public 으로 고정
// 클래스와는 달리 다중상속을 지원함

// 인터페이스 작성시 interface 를 사용
// 인터페이스를 구현할때는 implements 를 사용
public class Interface {
    public static void main(String[] args) {
        Cat3 c3 = new Cat3();
        System.out.println(c3.cry());

        Dog3 d3 = new Dog3();
        System.out.println(d3.cry());

        Murloc m = new Murloc();
        System.out.println(m.cry());
    }
}

class Animal3 {
    protected int weight;
    protected int height;
}

interface Animal3Action {
    // public static String COLOR = "brown";
    // static String COLOR = "brown"; 이것도 생략해도 되고 다 써도 됨
    String COLOR = "brown";

    // public abstract String cry();
    // abstract String cry(); // 두줄 다 사용가능하나 생략해도 됨 하기로 간편하게 써도 무관함 !
    String cry(); // 앞에 protected 사용할 수 없음 interface는 누구나 접근할 수 있으므로 메서드의 접근제한자가 public이다
}

class Cat3 extends Animal3
        implements Animal3Action {

    @Override
    public String cry() { return "야옹 ~ 야옹 ~"; }
}

class Dog3 extends Animal3 implements Animal3Action {

    @Override
    public String cry() { return "멍 ! 멍 ! "; }
}

class Murloc extends Animal3 implements Animal3Action {

    @Override
    public String cry() { return "아훓훓훓~"; }
}
