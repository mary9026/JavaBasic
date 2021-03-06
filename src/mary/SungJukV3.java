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
        //  자료형 변수명[] = new 자료형[크기];
       String name[] = new String[3];
       int kor[] = new int[3] ;
       int eng[] = new int[3] ;
       int mat[] = new int[3] ;
       int sum[] = new int[3] ;
       double mean[] = new double[3] ;
       char grd[] = new char[3];
       String fmt =
            "이름 : %s\n 국어 : %d\n 영어 : %d\n 수학 : %d\n"
                    + "총점 : %d\n 평균 : %.1f\n 학점 : %c\n";





       // 처리
       // 성적 데이터를 키보드로 입력받기 위해 Scanner 클래스 초기화
       Scanner sc = new Scanner(System.in);

       for (int i=0; i <3; ++i) {
               System.out.println((i+1) + "번째 학생 성적 입력 중 ... ");

               System.out.print("이름을 입력하세요 : ");
               name[i] = sc.nextLine();
               System.out.print("국어 점수를 입력하세요 : ");
               kor[i] = Integer.parseInt(sc.nextLine());
               System.out.print("영어 점수를 입력하세요 : ");
               eng[i] = Integer.parseInt(sc.nextLine());
               System.out.print("수학 점수를 입력하세요 : ");
               mat[i] = Integer.parseInt(sc.nextLine());

               //sc.skip("\r\n|[\n\r]");
                // 이 변수 사용하지 않기 위해서 nextInt -> nextLine 으로 변경해서 값 설정 : Integer.parseInt(sc.nextLine());

               // 수학성적 입력시 같이 입력된 enter키가
               // 다음 데이터(이름) 입력 시 입력값으로
              // 자동으로 전달됨
              // 그러한 상황을 해결하기 위해
             // 미리 엔터키를 제거하는 코드 삽입 (scanner명.skip("\r\n|[\n\r]");)

           }

           for (int i=0; i<3; ++i) {
               sum[i] = kor[i] + eng[i] + mat[i];
               mean[i] = (double) sum[i] / 3;

               switch ((int) mean[i] / 10) {
                   case 10:
                   case 9:
                       grd[i] = '수';
                       break;
                   case 8:
                       grd[i] = '우';
                       break;
                   case 7:
                       grd[i] = '미';
                       break;
                   case 6:
                       grd[i] = '양';
                       break;
                   default:
                       grd[i] = '가';
               }
           }


           // 결과출력

           for(int i=0; i<3; ++i) {
               System.out.printf(fmt, name[i], kor[i], eng[i], mat[i], sum[i], mean[i], grd[i]);
           }

       }


    }
