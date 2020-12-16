package mary;

import java.util.Scanner;

/**
 * 파일명 : SungJukV9Main
 * 작성일 : 2020.12.16
 *
 * 프로그램설명 : 성적처리 프로그램 V10
 * 성적처리 프로그램에 저장기능을 추가함
 * 즉, mariadb 데이터베이스에 sungjuk 테이블을 생성해서
 * 입력한 성적데이터를 저장해 둠
 *
 */

public class SungJukV10Main {
    public static void main(String[] args) {
        SungJukV10Service sjsrv = new SungJukV10Service();

        Scanner sc = new Scanner(System.in);
        String menu; // int menu=0; 으로 해서 숫자만 받아도 됨 대신 알파벳 입력 시 오류

        while(true) { // 메뉴 띄우고 작업번호 입력을 반복
            sjsrv.displayMenu();
            menu = sc.nextLine();

            switch (menu) {
                case "1" : sjsrv.newSungJuk(); break;
                case "2" : sjsrv.readSungJuk(); break;
                case "3" : sjsrv.readOneSungJuk(); break;
                case "4" : break;
                case "5" : break;
                case "0" : System.exit(0); break; // System.exit(0); 정상적으로 종료한다 라는 명령어
                default:
                    System.out.println("잘못 입력 하셨습니다. ㅠㅠ");
            }
        }
    }
}
