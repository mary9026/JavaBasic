package mary;

/**
 * 파일명 : SungJukV1
 * 작성일 : 2020.11.17
 *
 * 프로그램설명 : 성적처리 프로그램 V1
 * 이름, 국어, 영어, 수학 점수를 설정하면
 * 총점, 평균, 학점을 계산하고 결과 출력
 * name, kor, eng, mat, sum, mean, grd
 * 단, 학점 기준은 '수우미양가'로 함
 */
public class SungJukV1 {
    public static void main(String[] args) {
       String name="혜교";
       int kor=99, eng=98, mat=99;
       int grd=0;
       double sum=0, mean=0;

       sum=kor+eng+mat;
       mean=sum/3;

       System.out.println("이름 : " + name);
       System.out.println("국어 : " + kor);
       System.out.println("영어 : " + eng);
       System.out.println("수학 : " + mat);
       System.out.println("-------------------");
       System.out.println("총점 : " + sum);
       System.out.println("평균 : " + mean);




    }
}
