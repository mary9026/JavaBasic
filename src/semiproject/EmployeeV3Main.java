package semiproject;

import java.util.Scanner;

public class EmployeeV3Main {
    public static void main(String[] args) {
        EmployeeV3Service empsv = new EmployeeV3Service();

        Scanner sc = new Scanner(System.in);
        String menu; // int menu=0; 으로 해서 숫자만 받아도 됨 대신 알파벳 입력 시 오류

        while(true) { // 메뉴 띄우고 작업번호 입력을 반복
            empsv.displayMenu();
            menu = sc.nextLine();

            switch (menu) { //DAO 클래스 이름과 동일하게 대상에 맞는 명사형태로 쓰면 됨
                case "1" : empsv.newEmployee(); break;
                case "2" : empsv.readEmployee(); break;
                case "3" : empsv.readOneEmployee(); break;
                case "4" : empsv.modifyEmployee(); break;
                case "5" : empsv.removeEmployee(); break;
                case "0" : System.exit(0); break; // System.exit(0); 정상적으로 종료한다 라는 명령어
                default:
                    System.out.println("잘못 입력 하셨습니다. ㅠㅠ");
            }
        }
    }
}
