package lab;

import java.util.Scanner;

public class Q28_Gugudan {
    public static void main(String[] args) {
        int dan=0, value=0;
        int i;
        Scanner sc = new Scanner(System.in);
        System.out.print("구구단 : ");
        dan = sc.nextInt();



        for(i=1; i<=9; ++i) {
            if(dan > 0 && dan <= 9) {
                value = dan * i;
                System.out.println(dan + "x" + i + "=" + value);
            }else {
                System.out.println("잘못 입력하셨습니다!!");
                break;
            }

        }



    }
}
