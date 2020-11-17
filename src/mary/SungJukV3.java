package mary;

import java.util.Scanner;

/**
 * 파일명 : SungJukV1
 * 작성일 : 2020.11.17
 *
 * 프로그램설명 : 성적처리 프로그램 V3
 * 학생 3명의 성적데이터를 키보드로 입력받아
 * 총점, 평균, 학점을 계산하고 결과 출력
 * name, kor, eng, mat, sum, mean, grd
 *
 * 평균은 소수점 첫째 자리까지 출력하고
 * 학점기준은 '수우미양가'로 하되
 * switch 문으로 학점을 계산하도록 함
 *
 * 단, 성적처리 결과 출력 시 출력문을 하나만 사용
 *
 */
public class SungJukV3 {
    public static void main(String[] args) {
       // 변수선언
       String name ;
       int kor ;
       int eng ;
       int mat ;
       int sum ;
       double mean ;
       char grd ;
       String fmt =
            "이름 : %s\n 국어 : %d\n 영어 : %d\n 수학 : %d\n"
                    + "총점 : %d\n 평균 : %.1f\n 학점 : %c";





       // 처리
       // 성적 데이터를 키보드로 입력받기 위해 Scanner 클래스 초기화
       Scanner scanner = new Scanner(System.in);

       for (int i=1; i <=3; ++i) {
           System.out.println(i + "번째 학생 성적 입력 중 ... ");

           System.out.print("이름을 입력하세요 : ");
           name = scanner.nextLine();
           System.out.print("국어 점수를 입력하세요 : ");
           kor = scanner.nextInt();
           System.out.print("영어 점수를 입력하세요 : ");
           eng = scanner.nextInt();
           System.out.print("수학 점수를 입력하세요 : ");
           mat = scanner.nextInt();


           sum = kor + eng + mat;
           mean = (double) sum / 3;

           switch ((int) mean / 10) {
               case 10:
                   grd = '수';
                   break;
               case 9:
                   grd = '수';
                   break;
               case 8:
                   grd = '우';
                   break;
               case 7:
                   grd = '미';
                   break;
               case 6:
                   grd = '양';
                   break;
               default:
                   grd = '가';
           }


           // 결과출력

           System.out.printf(fmt, name, kor, eng, mat, sum, mean, grd);

       }


    }
}
