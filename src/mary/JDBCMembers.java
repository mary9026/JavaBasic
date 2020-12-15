package mary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCMembers {
    // playground 데이터베이스의 BookMembers 테이블에
    // 새로운 회원정보를 입력하는 JDBC 프로그램을 작성하세요
    // 컬럼정보 : custid, name, address, phone
    // 입력은 Scanner 이용

    public static void main(String[] args) {

        // 데이터베이스 연결정보
        String DRV = "org.mariadb.jdbc.Driver";
        String URL = "jdbc:mariadb://mariadb.ct2u6pxalfjg.ap-northeast-2.rds.amazonaws.com:3306/playground";
        String USR = "playground";
        String PWD = "playground2020";

        // 1. 회원정보 입력
        Scanner sc = new Scanner(System.in);
        System.out.print("회원 번호는 ? ");
        int custid = Integer.parseInt(sc.nextLine());
        System.out.print("회원 이름은 ? ");
        String name = sc.nextLine();
        System.out.print("회원 주소는 ? ");
        String address = sc.nextLine();
        System.out.print("회원 전화번호는 ? ");
        String phone = sc.nextLine();

        // 2. SQL문 작성 (=질의문 작성)
        String sql = " insert into book_members "
                + " values (" + custid + ", '" + name + "', '" + address + "', '" + phone + "') ";
        System.out.println(sql);



        // a) JDBC 드라이버 초기화
        // JDBC Connection 객체 생성 (풀이 중에 a-b-c- 한 문장으로 모두 통합 풀이 )
        // JDBC Statement 객체 생성
        // SQL문 실행 및 결과 확인
        // JDBC 관련 객체 제거
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName(DRV);
            conn = DriverManager.getConnection(URL, USR, PWD);
            stmt = conn.createStatement();
            int cnt = stmt.executeUpdate(sql);
            if (cnt > 0)
                System.out.println("데이터 추가 완료!");
        } catch (ClassNotFoundException cnf) {
            System.out.println("JDBC 드라이버가 없어요 ");
        } catch (SQLException se) {
            System.out.println("JDBC 연결 실패 ! ");
        } finally {
            if (stmt != null)
                try {
                    stmt.close();
                } catch (SQLException ex) { }
            if (conn != null)
                try {
                    conn.close();
                } catch (SQLException ex) { }

        }

        // b) 데이터베이스 서버 접속

        // c) SQL문 객체를 생성하고 서버로 전송해서 실행함



        // d) JDBC 관련 객체는 메모리에서 제거



    }
}

