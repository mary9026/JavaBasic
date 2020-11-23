package mary;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

// 메서드 재정의 override
    // 객체지향 중요 3대개념 중 다형성에 해당
    // 상속관계에 있는 상위클래스의 메서드를 하위클래스에서 같은 이름의 메서드로 다시 작성하는 것
    // 즉, 상속받은 메서드를 새로 정의해서 사용하는 것을 말함
public class Overriding {
    public static void main(String[] args) {
        Cat ct = new Cat();
        Dog d = new Dog();

        System.out.println(ct.cry());
        System.out.println(d.cry());
    }






}


class Animal { // 상속화의 경우 가능한 private 보다는 protected 를 사용
    protected String cry() { return "동물이 웁니다."; }
}

class Cat extends Animal {
    @Override // 부모클래스로부터 상속받은 메서드인데 부족함이 있어서 자식클래스에서 추가사용 하는구나 라는 의미로 알아볼 수 있도록 나옴
    protected String cry() { return "야옹~ 야옹~"; }
}

class Dog extends Animal {
    @Override
    protected String cry() { return "멍! 멍!"; }
}