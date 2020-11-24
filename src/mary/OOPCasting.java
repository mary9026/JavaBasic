package mary;

// 클래스/인터페이스 형변환
// 특정 객체가 자식클래스/인터페이스 타입에서
// 부모클래스/인터페이스 타입 또는 반대로 형변환하는 것을 의미
public class OOPCasting {
    public static void main(String[] args) {
        Unit u1 = new Unit();
        Marine m1 = new Marine();
        Firebat f1 = new Firebat();

        u1.attack();
        m1.attack();
        f1.attack();

        Unit unit = new Marine();
        // Marine 객체는 자동으로 Unit 객체로 형변환 // 타입은 Unit 이지만, Marine 객체를 씀 ?
        // 이처럼 상속관계에 있는 클래스간의 객체 생성 시 자식클래스 타입의 객체를 부모클래스타입의 객체로
        // 선언하는 경우 업캐스팅 upcasting 이라 함
        unit.attack();

        // Marine m3 = (Marine) new Unit();
        // Unit 객체를 Firdbat  객체로 형변환 하려면
        // 명시적 형변환 필요
        // 이처럼 상속관계에 있는 클래스간의 객체 생성 시 부모클래스 타입의 객체를 자식클래스타입의 객체로
        // 선언하는 경우 다운캐스팅 downcasting 이라 함
        // 단, 컴파일시에는 오류가 나지 않지만 실행 시 오류 발생 ! (=서로다른 데이터 타입으로 형변환은 원칙적으로 불가)
        //m3.attack();

        Marine m2 = (Marine) unit;
        //  Unit 객체변수를 Marine 객체로 다운캐스팅
        // 실행에는 아무런 문제 없음
        // => unit 변수는 Marine 객체를 Unit 객체로 만든 것
        // 따라서 Marine 객체로의 형변환이 가능
        m2.attack();
    }
}

class Unit {
    protected int hp;
    protected int ap;

    public void attack() {
        System.out.println("공격 중입니다...");
    }
}

class Marine extends Unit {
    @Override
    public void attack() {
        System.out.println("해병대가 공격중...");
    }
}
class Firebat extends Unit {
    @Override
    public void attack() {
        System.out.println("불곰이 공격중...");
    }
}
