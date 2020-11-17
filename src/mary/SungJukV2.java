package mary;

import java.util.Scanner;

/**
 * 파일명 : SungJukV1
 * 작성일 : 2020.11.17
 *
 * 프로그램설명 : 성적처리 프로그램 V2
 * 이름, 국어, 영어, 수학 점수를 입력받아
 * 총점, 평균, 학점을 계산하고 결과 출력
 * name, kor, eng, mat, sum, mean, grd
 *
 * 단, 평균은 소수점 첫째 자리까지 출력하고
 * 학점기준은 '수우미양가'로 하되
 * switch 문으로 학점을 게산하도록 함
 *
 */
public class SungJukV2 {
    public static void main(String[] args) {
       // 변수선언



       Scanner scanner = new Scanner(System.in);
       System.out.println("이름을 입력하세요 : ");
       String name = scanner.nextLine();
       System.out.println("국어 점수를 입력하세요 : ");
       int kor = scanner.nextInt();
       System.out.println("영어 점수를 입력하세요 : ");
       int eng = scanner.nextInt();
       System.out.println("수학 점수를 입력하세요 : ");
       int mat = scanner.nextInt();
       System.out.println("총점은" + (kor+eng+mat) + "입니다.");
       int grd = scanner.nextInt();


       // 처리
      switch(grd/10) {
         case 10 :
         case 9 :
            System.out.println("학점은 수 입니다.");
            break;
         case 8 :
            System.out.println("학점은 우 입니다.");
            break;
         case 7 :
            System.out.println("학점은 미 입니다.");
            break;
         case 6 :
            System.out.println("학점은 양 입니다.");
            break;
         case 5 : case 4 : case 3 : case 2 : case 1 : case 0 :
            System.out.println("학점은 가 입니다.");
            break;

      }



       // 결과출력




    }
}
