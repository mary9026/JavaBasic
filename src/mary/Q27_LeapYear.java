package mary;

import java.util.Scanner;

public class Q27_LeapYear {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("년도를 입력하시오. : ");
        int year = sc.nextInt();

        boolean leapY = false;

        leapY = (year%4==0 && year%100!=0 || year%400==0);

        if (leapY) {
            System.out.println(year + "년은 윤년 입니다.");

        }else {
            System.out.println(year + "년은 평년 입니다.");
        }


    }
}
