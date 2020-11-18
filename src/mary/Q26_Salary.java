package mary;

import java.util.Scanner;

public class Q26_Salary {
    public static void main(String[] args) {

        int tax = 0;
        int marry = 0;
        int salary = 0;

        Scanner sc = new Scanner(System.in);
        System.out.println("기혼/미혼 여부를 숫자로 입력하시오 (미혼 : 0 / 기혼 : 1) : " );
        marry = sc.nextInt();

        System.out.println("연봉을 천단위로 입력하시오 : ");
        salary = sc.nextInt();


        if(marry<=0) {
            if(salary<3000) {
            tax = (salary*10)/100;}
        }else if (marry<=0 ) {
            if(salary>3000) {
            tax = (salary*25)/100;}
        }else if (marry>=1) {
            if(salary<6000) {
            tax = (salary*15)/100;}
        }else if(marry>=1) {
            if(salary<6000) {
            tax = (salary*35)/100;}
        }

        System.out.printf("연봉은 %d 이며 납부하셔야 할 세금은 %d 입니다.", salary, tax);

    }
}
