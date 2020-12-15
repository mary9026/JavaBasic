package mary;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCMembers2 {

    public static void main(String[] args) {
        // JDBC 관련 변수
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "insert into book_members values (?,?,?,?)";

        // 회원 정보 입력 받음
        Scanner sc = new Scanner(System.in);

        System.out.print("회원 번호는 ? ");
        int custid = Integer.parseInt(sc.nextLine());
        System.out.print("회원 이름은 ? ");
        String name = sc.nextLine();
        System.out.print("회원 주소는 ? ");
        String address = sc.nextLine();
        System.out.print("회원 전화번호는 ? ");
        String phone = sc.nextLine();

        // 입력받은 회원정보를 테이블에 저장
        // static 으로 선언된 글자들은 좀 누워있는 글씨체로 표기됨
        conn = JDBCUtil.makeConn();
        try {
            pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, custid);
                pstmt.setString(2, name);
                pstmt.setString(3, address);
                pstmt.setString(4, phone);

        int cnt = pstmt.executeUpdate();
        if (cnt > 0) System.out.println("회원정보 추가완료!");
        } catch (SQLException se) {
            System.out.println("JDBC 질의문 생성 오류");
        }
        JDBCUtil.destoryConn(conn, pstmt);

    }
}
