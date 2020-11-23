package mary;

import java.util.Scanner;

/**
 * 파일명 : SungJukV7Main
 * 작성일 : 2020.11.23
 *
 * 프로그램설명 : 성적처리 프로그램 V7
 * 중간고사와 기말고사 성적처리 프로그램을 만들려고 함
 * SungJukV6Main을 토대로 중간고사 성적과 기말고사 성적 클래스를
 * 인터페이스를  이용해서 작성하세요.
 *
 * 부모클래스 SungJukV6
 * 인터페이스 ISungJukV6
 * 중간고사 MidSungJuk2 : 국어, 영어, 수학
 * 기말고사 FinalSungJuk2 : 국어, 영어, 수학, 미술, 과학
 * 성적입력 : readSungJuk
 * 성적처리 : computeSungJuk
 * 결과출력 : printSungJuk
 * name, kor, eng, mat, art, sci, sum, mean, grd
 *
 */

public class SungJukV7Main {
    public static void main(String[] args) {
//        MidSungJuk2 msj2 = new MidSungJuk2();
//
//        msj2.readSungJuk();
//        msj2.computeSungJuk();
//        msj2.printSungJuk();

        FinalSungJuk2 fsj2 = new FinalSungJuk2();

        fsj2.readSungJuk();
        fsj2.computeSungJuk();
        fsj2.printSungJuk();

    }
}

class MidSungJuk2 {
    protected String name ;
    protected int kor ;
    protected int eng ;
    protected int mat ;
    protected int sum ;
    protected double mean ;
    protected char grd ;

    interface ISungJukV6 {
        String name() ;
        int kor() ;
        int eng() ;
        int mat() ;
    }

    protected void readSungJuk() {
        Scanner sc = new Scanner(System.in);

        System.out.print("이름을 입력하세요 : ");
        name = sc.nextLine();
        System.out.print("국어 점수를 입력하세요 : ");
        kor = sc.nextInt();
        System.out.print("영어 점수를 입력하세요 : ");
        eng = sc.nextInt();
        System.out.print("수학 점수를 입력하세요 : ");
        mat = sc.nextInt();
    }
    protected void computeSungJuk() {
        sum = kor + eng + mat;
        mean = (double) sum / 3;
        grd = (mean >= 90) ? '수' :
              (mean >= 80) ? '우' :
              (mean >= 70) ? '미' :
              (mean >= 60) ? '양' : '가';
    }

    protected void printSungJuk() {
        String fmt =
                "이름 : %s\n 국어 : %d\n 영어 : %d\n 수학 : %d\n"
                        + "총점 : %d\n 평균 : %.1f\n 학점 : %s\n";

        String result = String.format(fmt, name, kor, eng, mat, sum, mean, grd);

        System.out.println(result);
    }

}

class FinalSungJuk2 extends MidSungJuk2 implements MidSungJuk2.ISungJukV6 {
    protected int art;
    protected int sci;


    @Override
    public String name() {
        return null;
    }

    @Override
    public int kor() {
        return 0;
    }

    @Override
    public int eng() {
        return 0;
    }

    @Override
    public int mat() {
        return 0;
    }

    @Override
    protected void readSungJuk() {
        super.readSungJuk();

        Scanner sc = new Scanner(System.in); // 부모클래스에서 지정된 스캐너는 자식클래스에서 효력이 발생되지 않으므로 재선언 필요
        System.out.print("미술 점수를 입력하세요 : ");
        art = sc.nextInt();
        System.out.print("과학 점수를 입력하세요 : ");
        sci = sc.nextInt();
    }

    @Override
    protected void computeSungJuk() {
//        super.computeSungJuk();

        sum = kor + eng + mat + art + sci;
        mean = (double)sum / 5;
        grd = (mean >= 90) ? '수' :
              (mean >= 80) ? '우' :
              (mean >= 70) ? '미' :
              (mean >= 60) ? '양' : '가';


    }

    @Override
    protected void printSungJuk() {
//        super.printSungJuk();

        String fmt =
                "이름 : %s\n 국어 : %d\n 영어 : %d\n 수학 : %d\n"
                        + "과학 : %d\n 미술 : %d\n"
                        + "총점 : %d\n 평균 : %.1f\n 학점 : %s\n";

        String result = String.format(fmt, name, kor, eng, mat, sci, art, sum, mean, grd);

        System.out.println(result);
    }
}
