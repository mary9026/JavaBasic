package samkwangfinal;

import java.util.Scanner;

public class SamKwangService {

    public void displayMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append("------------------------------\n")
                .append("주문조회 프로그램  \n")
                .append("------------------------------\n")
                .append("1. CODP 주문 정보 조회\n")
                .append("2. SOE 주문 정보 조회\n")
                .append("3. 프로그램 종료\n")
                .append(" ------------------------------\n")
                .append(" 원하시는 작업은 ? ");
        System.out.print(sb);

    }

    public void readOrders() {
        Scanner sc = new Scanner(System.in);

        String fmt = "%10 ";
    }

    public void readOneOrders() {

    }
}
