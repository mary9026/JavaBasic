package samkwangfinal;

import semiproject.EmployeeV3Service;

import java.util.Scanner;

public class SamKwangMain {
    public static void main(String[] args) {
        SamKwangService sksv = new SamKwangService();

        Scanner sc = new Scanner(System.in);
        String menu; // int menu=0; 으로 해서 숫자만 받아도 됨 대신 알파벳 입력 시 오류

        while(true) { // 메뉴 띄우고 작업번호 입력을 반복
            sksv.displayMenu();
            menu = sc.nextLine();

            switch (menu) { //DAO 클래스 이름과 동일하게 대상에 맞는 명사형태로 쓰면 됨
                case "1" : sksv.readOrders(); break;
                case "2" : sksv.readOneOrders(); break;
                case "0" : System.exit(0); break; // System.exit(0); 정상적으로 종료한다 라는 명령어
                default:
                    System.out.println("잘못 입력 하셨습니다. ㅠㅠ");
            }
        }
    }

}
