package mary;

import java.util.Scanner;

public class JDBCMembers {
    // playground 데이터베이스의 BookMembers 테이블에
    // 새로운 회원정보를 입력하는 JDBC 프로그램을 작성하세요
    // 컬럼정보 : custid, name, address, phone
    // 입력은 Scanner 이용

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("회원 아이디는 ? ");
        int custid = Integer.parseInt(sc.nextLine());

    }
}

