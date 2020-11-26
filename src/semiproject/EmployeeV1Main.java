package semiproject;

import java.util.Scanner;

/**
 * EmployeeV1Main
 * 인사정보 관리 프로그램 진입점
 */

public class EmployeeV1Main {
    public static void main(String[] args) {
        EmployeeV1Service empsrv = new EmployeeV1Service();

        Scanner sc = new Scanner(System.in);
        String menu; // int menu=0; 으로 해서 숫자만 받아도 됨 대신 알파벳 입력 시 오류

        while(true) { // 메뉴 띄우고 작업번호 입력을 반복
            empsrv.displayMenu();
            menu = sc.nextLine();

            switch (menu) {
                case "1" : empsrv.newEmployee(); break;
                case "2" : empsrv.readEmployee(); break;
                case "3" : empsrv.readOneEmployee(); break;
                case "4" : break;
                case "5" : break;
                case "0" : System.exit(0); break; // System.exit(0); 정상적으로 종료한다 라는 명령어
                default:
                    System.out.println("잘못 입력 하셨습니다. ㅠㅠ");
            }
        }

    }
}
