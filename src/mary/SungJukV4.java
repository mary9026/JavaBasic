package mary;

import java.util.Scanner;

/**
 * 파일명 : SungJukV4
 * 작성일 : 2020.11.18
 *
 * 프로그램설명 : 성적처리 프로그램 V4
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
 * 코드의 가독성과 유지보수를 용이하게 하기 위해
 * 메서드기반 코드로 재작성
 *
 */
public class SungJukV4 {
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
        readSungJuk(name, kor, eng, mat);
        computeSungJuk(kor, eng, mat, sum, mean, grd);


           // 결과출력
        printSungJuk(name, kor, eng, mat, sum, mean, grd);


       } // main

    // 성적 데이터 입력받기 : readSungJuk
        public static void readSungJuk(String[] name, int[] kor, int[] eng, int[] mat) {
            Scanner sc = new Scanner(System.in);

            for (int i = 0; i < 3; ++i) {
                System.out.println((i + 1) + "번째 학생 성적 입력 중 ... ");

                System.out.print("이름을 입력하세요 : ");
                name[i] = sc.nextLine();
                System.out.print("국어 점수를 입력하세요 : ");
                kor[i] = sc.nextInt();
                System.out.print("영어 점수를 입력하세요 : ");
                eng[i] = sc.nextInt();
                System.out.print("수학 점수를 입력하세요 : ");
                mat[i] = sc.nextInt();
            }

        } //readSungJuk

        // 성적 데이터 총점, 평균, 학점 처리 : computeSungJuk
        public static void computeSungJuk(
                int[] kor, int[] eng, int[] mat, int[] sum, double[] mean, char[] grd) {
                for (int i=0; i<3; ++i) {
                    sum[i] = kor[i] + eng[i] + mat[i];
                    mean[i] = (double) sum[i] / 3;

                    switch ((int) mean[i] / 10) {
                        case 10:
                        case 9:
                            grd[i] = '수'; break;
                        case 8:
                            grd[i] = '우'; break;
                        case 7:
                            grd[i] = '미'; break;
                        case 6:
                            grd[i] = '양'; break;
                        default:
                            grd[i] = '가';
                    }
                }
        } //computeSungJuk

        // 처리 결과 출력 : printSungJuk
        public static void printSungJuk(
                String[] name, int[] kor, int[] eng, int[] mat, int[] sum, double[] mean, char[] grd) {

                String fmt =
                        "이름 : %s\n 국어 : %d\n 영어 : %d\n 수학 : %d\n"
                        + "총점 : %d\n 평균 : %.1f\n 학점 : %c\n";

                for(int i=0; i<3; ++i) {
                    System.out.printf(fmt, name[i], kor[i], eng[i], mat[i], sum[i], mean[i], grd[i]);
                }
        } //printSungJuk

    } // class
