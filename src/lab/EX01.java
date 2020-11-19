package lab;

public class EX01 {
    public static void main(String[] args) {
    // 학생 클래스를 이용해서 객체 생성
        Student kim = new Student();

        kim.stdnum = 201350050;
        kim.name = "김태희";
        kim.adress = "경기도 고양시";
        kim.birth = "1985.3.22";
        kim.major = "컴퓨터";
        kim.prof = "504";

    // 학과 클래스를 이용해서 객체 생성
        Major compute = new Major();

        compute.major = "컴퓨터공학";
        compute.phone = "123-4567-8901";
        compute.office = "E동 2층";
        compute.chief = "504";

    // 과목 클래스를 이용해서 객체 생성
        Subject subj = new Subject();

        subj.no = "0205";
        subj.subname = "프로그래밍";
        subj.subdesc = "자바 프로그래밍";
        subj.prof = "301";

    // 교수 클래스를 이용해서 객체 생성
        Professor prof = new Professor();

        prof.no = "301";
        prof.name = "이순신";
        prof.mjfield = "프로그래밍";


    // 각 객체의 변수에 값 대입












    // 객체에 저장된 값 출력
        System.out.println(kim.stdnum);
        System.out.println(kim.name);
        System.out.println(kim.adress);
        System.out.println(kim.birth);
        System.out.println(kim.major);
        System.out.println(kim.prof);

        System.out.println(compute.major);
        System.out.println(compute.phone);
        System.out.println(compute.office);
        System.out.println(compute.chief);

        System.out.println(subj.no);
        System.out.println(subj.subname);
        System.out.println(subj.subdesc);
        System.out.println(subj.prof);

        System.out.println(prof.no);
        System.out.println(prof.name);
        System.out.println(prof.mjfield);

    }
}
