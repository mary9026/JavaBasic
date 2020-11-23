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
//        msj2.readSungJuk();
//        msj2.computeSungJuk();
//        msj2.printSungJuk();

        FinalSungJuk2 fsj2 = new FinalSungJuk2();
            fsj2.readSungJuk();
            fsj2.computeSungJuk();
            fsj2.printSungJuk();
    }
}

abstract class SungJukV7 {
    protected String name ;
    protected int kor ;
    protected int eng ;
    protected int mat ;
    protected int sum ;
    protected double mean ;
    protected char grd ;

    public SungJukV7() {
    }

    public SungJukV7(String name, int kor, int eng, int mat) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.mat = mat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKor() {
        return kor;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public int getEng() {
        return eng;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    public int getMat() {
        return mat;
    }

    public void setMat(int mat) {
        this.mat = mat;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public double getMean() {
        return mean;
    }

    public void setMean(double mean) {
        this.mean = mean;
    }

    public char getGrd() {
        return grd;
    }

    public void setGrd(char grd) {
        this.grd = grd;
    }
}

interface ISungJukV7 {
    void readSungJuk();
    void computeSungJuk();
    void printSungJuk();

}

class MidSungJuk2 extends SungJukV7 implements ISungJukV7{

    @Override
    public void readSungJuk() {
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

    @Override
    public void computeSungJuk() {
        sum = kor+eng+mat;
        mean = (double)sum / 3;
        grd = (mean >= 90) ? '수' :
              (mean >= 80) ? '우' :
              (mean >= 70) ? '미' :
              (mean >= 60) ? '양' : '가';
    }

    @Override
    public void printSungJuk() {
        String fmt =
                "이름 : %s\n 국어 : %d\n 영어 : %d\n 수학 : %d\n"
                        + "총점 : %d\n 평균 : %.1f\n 학점 : %s\n";

        String result = String.format(fmt, name, kor, eng, mat, sum, mean, grd);

        System.out.println(result);
    }
}

class FinalSungJuk2 extends SungJukV7 implements ISungJukV7 {
    protected int sci;
    protected int art;

    public FinalSungJuk2() {
    }

    public FinalSungJuk2(String name, int kor, int eng, int mat, int sci, int art) {
        super(name, kor, eng, mat);
        this.sci = sci;
        this.art = art;
    }

    @Override
    public void readSungJuk() {
        Scanner sc = new Scanner(System.in);

        System.out.print("이름을 입력하세요 : ");
        name = sc.nextLine();
        System.out.print("국어 점수를 입력하세요 : ");
        kor = sc.nextInt();
        System.out.print("영어 점수를 입력하세요 : ");
        eng = sc.nextInt();
        System.out.print("수학 점수를 입력하세요 : ");
        mat = sc.nextInt();
        System.out.print("미술 점수를 입력하세요 : ");
        art = sc.nextInt();
        System.out.print("과학 점수를 입력하세요 : ");
        sci = sc.nextInt();
    }

    @Override
    public void computeSungJuk() {
        sum = kor + eng + mat + art + sci;
        mean = (double)sum / 5;
        grd = (mean >= 90) ? '수' :
              (mean >= 80) ? '우' :
              (mean >= 70) ? '미' :
              (mean >= 60) ? '양' : '가';
    }

    @Override
    public void printSungJuk() {
        String fmt =
                "이름 : %s\n 국어 : %d\n 영어 : %d\n 수학 : %d\n"
                        + "과학 : %d\n 미술 : %d\n"
                        + "총점 : %d\n 평균 : %.1f\n 학점 : %s\n";

        String result = String.format(fmt, name, kor, eng, mat, sci, art, sum, mean, grd);

        System.out.println(result);
    }
}