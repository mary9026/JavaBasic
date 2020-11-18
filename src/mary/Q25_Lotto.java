package mary;

import java.util.Scanner;

public class Q25_Lotto {
    public static void main(String[] args) {
        int num[] = new int[3];
        int lotto[] = new int[3];
        int i, j;

        for(i=0; i<3; i++) {
            System.out.printf("%d 번째 번호를 입력하세요.(_1~45_) :", i+1);
            Scanner sc = new Scanner(System.in);
            num[i] = sc.nextInt();

            }

        System.out.printf("\n ---- 응모하신 번호 출력 ---- \n");
        for (i=0; i<3; i++) {
            System.out.printf("%3d", num[i]);

        }

        for(i=0; i<3; i++) {
            lotto[i] = (int)(Math.random()*45)+1;
        }
        System.out.printf("\n ---- 당첨 번호 출력 ---- \n");
        for (i=0; i<3; i++) {
            System.out.printf("%3d", lotto[i]);
        }

        int count = 0;
        for(i=0; i<3; i++) {
            if(num[i] == lotto[i]) {
                count++;
            }
        }

        if(count==3) {
            System.out.printf("\n상금 1백만 지급\n");
        }else {
            System.out.printf("\n아쉽지만, 다음 기회를! \n");
        }




    }
}
