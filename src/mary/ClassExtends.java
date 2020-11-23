package mary;

    // 상속(확장)
    // 객체지향 3대 개념 중 하나
    // 기존 클래스에 기능을 추가하거나 재정의해서
    // 새로운 클래스를 만드는 것

    // 상속을 이용하면 기존의 정의되어 있는
    // 클래스의 모든 필드와 메서드를 물려받음
    // 기존클래스를 부모/상위/슈퍼 클래스라 하고
    // 새롭게 작성된 클래스를 자식/하위/서브 클래스라고 함

    // 상속의 장점
    // 기존 작성된 클래스 재활용
    // 클래스의 계층적 구조파악 용이
    // 소프트웨어 생산성 향상
public class ClassExtends {
    public static void main(String[] args) {
        StudentWorkers sw = new StudentWorkers();
        Researchers rs = new Researchers();

        System.out.println(sw.work());
        System.out.println(sw.eat());

        System.out.println(rs.research());
        System.out.println(rs.sleep());

    }

}

    class Persons {
        private String name;

        public Persons() { }
        public Persons(String name) { this.name = name; }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public String speak() {return "말하는 중...";}
        public String eat() {return "먹는 중...";}
        public String walk() {return "걷는 중...";}
        public String sleep() {return "자는 중...";}
    }

    // Persons 클래스를 확장해서 Students 클래스를 정의
    // class 클래스명 extends 상위클래스명 { }
    class Students extends Persons {
        public String study() { return "나는 공부 중..."; }

    }

    class StudentWorkers extends Students {
        public String work() { return "나는 일하는 중..."; }
    }

    class Researchers extends Persons {
        public String research() { return "나는 연구 중..."; }
    }

    class professors extends Researchers {
        public String teach() { return "나는 강의 중 ..."; }
    }


