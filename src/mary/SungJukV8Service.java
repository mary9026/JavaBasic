package mary;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * SungJukV8Service
 * 성적처리 추상클래스를 상속해서 만든 클래스
 */

public class SungJukV8Service extends SungJukV8GenericService {
    // 멤버변수 선언
    // 입력받은 모든 성적데이터를 저장하는 동적배열 변수 선언
    List<SungJukVO> sjdata = new ArrayList<>();

    // 입력받은 성적데이터를 저장하는 변수
    SungJukVO sj = null;

    @Override
    /**
     * 이름과 국/영/수 성적 데이터를 입력받아
     * 총점, 평균, 학점을 계산한 뒤
     * 동적배열에 추가함
     */
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
        sj = new SungJukVO(name, kor, eng, mat, 0, 0, ' ');

        // 총점, 평균, 학점을 계산
        computeSungJuk(sj);

        // 처리된 성적데이터를 동적배열에 저장 (멤버데이터 만들어야 함)
        sjdata.add(sj);
    }

    @Override
    /**
     * 저장된 성적 데이터들 중에서
     * 번호, 이름, 국어, 영어, 수학만 뽑아서 리스트형태로 출력
     */
    public void readSungJuk() {
        String fmt = "이름:%s, 국어:%d, 영어:%d, 수학:%d\n";
        // 동적배열에 저장된 데이터들을 출력하기 위해
        // 각 요소를 순회할 수 있도록 Iterator 객체 선언
        Iterator<SungJukVO> iter = sjdata.iterator();
        while (iter.hasNext()) {
            SungJukVO sj = iter.next();

            System.out.printf(fmt, sj.getName(), sj.getKor(), sj.getEng(), sj.getMat()); // StringBuilder 로도 구현 가능(추천)
        }
    }

    @Override
    /**
     * 상세조회할 학생이름을 입력받아
     * 이름, 국어, 영어, 수학, 총점, 평균, 학점을 출력
     */
    public void readOneSungJuk() {
        String fmt = "이름:%s, 국어:%d, 영어:%d, 수학:%d\n"
                + "총점:%d, 평균:%.1f, 학점:%s\n";

        // 상세조회할 학생이름 입력 받음
        Scanner sc = new Scanner(System.in);
        System.out.print("조회할 학생이름은 ? ");
        String name = sc.nextLine();

        // 입력받은 이름으로 데이터 검색 후 결과출력 / iterator 보다는 향상된 for 문으로 쓰는게 효율적
        for(SungJukVO sj : sjdata) {
            if (sj.getName().equals(name)) {
                System.out.printf(fmt, sj.getName(), sj.getKor(), sj.getEng(), sj.getMat(), sj.getSum(), sj.getMean(), sj.getGrd());
                break;
            }
        }
    }

    /**
     *  성적 처리 프로그램의 메뉴 출력 기능
     */
    public void displayMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append("------------------------------\n")
                .append("성적 처리프로그램  V8\n")
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

}
