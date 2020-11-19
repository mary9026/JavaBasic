package lab;

public class EX01 {
    public static void main(String[] args) {
    // 학생 클래스를 이용해서 객체 생성
    // 학과 클래스를 이용해서 객체 생성
    // 과목 클래스를 이용해서 객체 생성
    // 교수 클래스를 이용해서 객체 생성

    // 각 객체의 변수에 값 대입
        Student kim = new Student();

        kim.stdnum = 201350050;
        kim.name = "김태희";
        kim.adress = "경기도 고양시";
        kim.birth = 1985.3.22;
        kim.major = "컴퓨터";
        kim.teach = 504;





    // 객체에 저장된 값 출력
        System.out.println(kim.stdnum);
        System.out.println(kim.name);
        System.out.println(kim.adress);
        System.out.println(kim.birth);
        System.out.println(kim.major);
        System.out.println(kim.teach);

    }
}
