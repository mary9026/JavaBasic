package mary;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * SungJukV8Service
 * 성적처리 추상클래스를 상속해서 만든 클래스
 */

public class SungJukV10Service {


    public SungJukV10Service()  {
    }

    public void displayMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append("------------------------------\n")
                .append("성적 처리프로그램  V10\n")
                .append("------------------------------\n")
                .append("1. 성적 데이터 입력\n")
                .append("2. 성적 데이터 조회\n")
                .append("3. 성적 데이터 상세조회\n")
                .append("4. 성적 데이터 수정\n")
                .append("5. 성적 데이터 삭제\n")
                .append("6. 프로그램 종료\n")
                .append(" ------------------------------\n")
                .append(" 원하시는 작업은 ? [1,2,3,4,5,0] ");
        System.out.print(sb);

    }

    public void newSungJuk() {
        String name;
        int kor, eng, mat;

        Scanner sc = new Scanner(System.in);

        System.out.print("이름을 입력하세요 : ");
        name = sc.nextLine();
        System.out.print("국어 점수를 입력하세요 : ");
        kor = sc.nextInt();
        System.out.print("영어 점수를 입력하세요 : ");
        eng = sc.nextInt();
        System.out.print("수학 점수를 입력하세요 : ");
        mat = sc.nextInt();

        // 입력받은 성적데이터를 동적배열에 저장
        SungJukVO sj = new SungJukVO(name, kor, eng, mat, 0, 0, ' ');

        // 총점, 평균, 학점을 계산
        computeSungJuk(sj);

        // 최종적으로 처리한 성적데이터를 sungjuk테이블에 저장하기 위해
        // SungJukV10DAO의 insertSungJuk메서드를 호출하고
        // 매개변수로 성적데이터를 넘김김
        String result = SungJukV10DAO.insertSungJuk(sj);
        System.out.println(result);
    }


    public void computeSungJuk(SungJukVO sj) {
        sj.setSum(sj.getKor()+sj.getEng()+sj.getMat());
        sj.setMean((double)sj.getSum() / 3);

        switch((int)sj.getMean()/10) {
            case 10 : sj.setGrd('수'); break;
            case 9 : sj.setGrd('수'); break;
            case 8 : sj.setGrd('우'); break;
            case 7 : sj.setGrd( '미'); break;
            case 6 : sj.setGrd( '양'); break;
            default : sj.setGrd( '가');
        } // switch
    }

    // 조회할 성적데이터를 DAO로부터 넘겨받아 출력
    public void readSungJuk() {
        String fmt = "번호:%s, 이름:%s, 국어:%d, 영어:%d, 수학:%d, 등록일:%s\n";
        StringBuilder sb = new StringBuilder();

        // 받아오는 데이터가 한줄이 아니니 동적배열로(ArrayList/컬렉션 프레임웍)로 받아옴?
        // substring() n-1 로 카운트가 0부터 시작되므로 기재 시 표기 희망값 +1로 기재해야함
        ArrayList<SungJukVO> sjs = SungJukV10DAO.selectSungJuk(); //!!! 핵심 문장

        for(SungJukVO sj : sjs) {
            String result = String.format(fmt, sj.getSjno(), sj.getName(), sj.getKor(), sj.getEng(), sj.getMat(), sj.getRegdate().substring(0,10));
            sb.append(result);
        }
        System.out.println(sb.toString());
    }

    public void readOneSungJuk() {
        String fmt = "번호:%s, 이름:%s, 국어:%d, 영어:%d, 수학:%d\n"
                + "총점:%d, 평균:%.1f, 학점:%s, 등록일:%s\n";

        Scanner sc = new Scanner(System.in);
        System.out.print("조회할 성적번호는 ? ");
        String sjno = sc.nextLine();

        SungJukVO sj = SungJukV10DAO.selectOneSungJuk(sjno);

        String result = String.format(fmt, sj.getSjno(),
                sj.getName(), sj.getKor(), sj.getEng(), sj.getMat(), sj.getSum(), sj.getMean(), sj.getGrd(), sj.getRegdate());

        System.out.println(result);
    }

    public void modifySungJuk() {
        Scanner sc = new Scanner(System.in);
        SungJukVO sj = new SungJukVO();

        System.out.println("수정할 성적번호는 ? ");
        sj.setSjno(sc.nextInt());
        System.out.println("수정할 국어점수는 ? ");
        sj.setKor(sc.nextInt());
        System.out.println("수정할 영어점수는 ? ");
        sj.setEng(sc.nextInt());
        System.out.println("수정할 수학점수는 ? ");
        sj.setMat(sc.nextInt());

        computeSungJuk(sj);

        String result = SungJukV10DAO.updateSungJuk(sj);
        System.out.println(result);
    }

    public void removeSungJuk() {
        Scanner sc = new Scanner(System.in);

        System.out.println("삭제할 성적번호는 ? ");
        int sjno = sc.nextInt();

        String result = SungJukV10DAO.deleteSungJuk(sjno);
        System.out.println(result);
    }
}
