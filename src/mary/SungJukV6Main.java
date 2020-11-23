package mary;

import java.util.Scanner;

/**
 * 파일명 : SungJukV6Main
 * 작성일 : 2020.11.23
 *
 * 프로그램설명 : 성적처리 프로그램 V6
 * 중간고사와 기말고사 성적처리 프로그램을 만들려고 함
 * SungJukV1을 토대로 중간고사 성적과 기말고사 성적 클래스를
 * 상속을 이용해서 작성하세요.
 *
 * 중간고사 MidSungJuk : 국어, 영어, 수학
 * 기말고사 FinalSungJuk : 국어, 영어, 수학, 미술, 과학
 *
 * 성적처리 : computeSungJuk
 * 결과출력 : printSungJuk
 * name, kor, eng, mat, art, sci, sum, mean, grd
 *
 */

public class SungJukV6Main {
    public static void main(String[] args) {
        MidSungJuk msj = new MidSungJuk();
//        msj.readSungJuk();
//        msj.computeSungJuk();
//        msj.printSungJuk();

        //MidSungJuk fsj = new FinalSungJuk(); 이렇게 써도 됨 (묵시적 클래스 형 변환과 메서드 재정의 p.253참조)
        FinalSungJuk fsj = new FinalSungJuk();
        fsj.readSungJuk();
        fsj.computeSungJuk();
        fsj.printSungJuk();

    }
}

class MidSungJuk {
    protected String name ;
    protected int kor ;
    protected int eng ;
    protected int mat ;
    protected int sum ;
    protected double mean ;
    protected char grd ;


    public MidSungJuk() {
    }

    public MidSungJuk(String name, int kor, int eng, int mat) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.mat = mat;
//        sum = 0;
//        mean = 0.0;
//        grd = '가'; << 이 부분은 기재해도 되지만 안넣어도 무관
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

    } //readSungJuk

    protected void computeSungJuk() {
        sum = kor+eng+mat;
        mean = (double)sum / 3;
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

class FinalSungJuk extends MidSungJuk {
    protected int art;
    protected int sci;

    public FinalSungJuk() {
    }

    public FinalSungJuk(String name, int kor, int eng, int mat, int art, int sci) {
        // 부모 클래스에 정의된 멤버변수 초기화 코드를
        // super 라는 이름으로 치환해서 호출할 수 있음
        // super(생성자 매개변수 목록);
//        this.name = name;
//        this.kor = kor;
//        this.eng = eng;
//        this.mat = mat;
        super(name, kor, eng, mat);
        this.art = art;
        this.sci = sci;
    }

    public int getArt() {
        return art;
    }

    public void setArt(int art) {
        this.art = art;
    }

    public int getSci() {
        return sci;
    }

    public void setSci(int sci) {
        this.sci = sci;
    }

    @Override
    protected void readSungJuk() {
        // 부모 클래스에 정의된 성적 입력코드를
        // super라는 이름으로 치환해서 호출할 수 있음
        // super.메서드이름();

        super.readSungJuk();

        Scanner sc = new Scanner(System.in); // 부모클래스에서 지정된 스캐너는 자식클래스에서 효력이 발생되지 않으므로 재선언 필요
        System.out.print("미술 점수를 입력하세요 : ");
        art = sc.nextInt();
        System.out.print("과학 점수를 입력하세요 : ");
        sci = sc.nextInt();
    }

    @Override
    protected void computeSungJuk() {
        // 부모클래스에 정의된 총점 변수를
        // super라는 이름으로 치환해서 호출할 수 있음
        // super.멤버변수명
        // super.computeSungJuk(); // 어차피 계산이 다시되어야 하니 불필요하나 하기 super.sum 으로 계산 위해서는 기재해야함
        // sum = super.sum + sci + art; // 이것만 수정한다고 해도 mean도 5과목으로 바꿔야해서 그냥 다시 쓰는게 나음

        sum = kor + eng + mat + art + sci;
        mean = (double)sum / 5;
        grd = (mean >= 90) ? '수' :
              (mean >= 80) ? '우' :
              (mean >= 70) ? '미' :
              (mean >= 60) ? '양' : '가';
    }

    @Override
    protected void printSungJuk() {
        // super.printSungJuk();

        String fmt =
                "이름 : %s\n 국어 : %d\n 영어 : %d\n 수학 : %d\n"
                        + "과학 : %d\n 미술 : %d\n"
                        + "총점 : %d\n 평균 : %.1f\n 학점 : %s\n";

        String result = String.format(fmt, name, kor, eng, mat, sci, art, sum, mean, grd);

        System.out.println(result);
    }
}