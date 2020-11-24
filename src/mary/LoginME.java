package mary;

import java.util.Scanner;

/**
 * 로그인 확인 프로그램
 * 1. 아이디, 비밀번호를 입력받음
 * => ID : abc123, PW : 987xyz
 *  1. Scanner로 아이디, 비밀번호를 입력받음
 *  2a. 아이디와 비밀먼호 틀리면 "가입되지 않은 아이디!"
 *  2b. 아이디만 맞으면 "비밀번호가 틀렸음!"
 *  2c. 아이디와 비밀번호가 맞으면 "로그인 성공 ! " // 문자열값 비교하는 것으로 작성
 */
public class LoginME {
    public static void main(String[] args) {
        String uid = "abc123";
        String pwd = "987xyz";
        String myuid = "";
        String mypwd = "";

        while(true) {
            Scanner sc = new Scanner(System.in);
            System.out.print("아이디를 입력하세요 : ");
            myuid = sc.nextLine();
            System.out.print("비밀번호를 입력하세요 : ");
            mypwd = sc.nextLine();


            if (!uid.equals(myuid)
                    && !pwd.equals(mypwd)) {
                System.out.println("가입되지 않은 아이디!");
            } else if (uid.equals(myuid)
                    && !pwd.equals(mypwd)) {
                System.out.println("비밀번호가 틀렸음!");
            } else if (uid.equals(myuid)
                    && pwd.equals(mypwd)) {
                System.out.println("로그인 성공 ! ");
                break;
            }
        }




    } //main
} //class
