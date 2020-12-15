package mary;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCBooks3c {
    public static void main(String[] args) {
        // 도서제목을 포함하는 도서정보 조회
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "select * from books where bookname like ?";
        String fmt = "%s %s %s %s\n";
        StringBuilder sb = new StringBuilder();

        // 조회할 도서제목을 입력받음
        Scanner sc = new Scanner(System.in);
        System.out.print("도서제목은 ? ");
        String name = sc.nextLine();

        //
        conn = JDBCUtil.makeConn();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, '%'+name+'%'); // 일부 정보 값 입력 후 출력 시 이부분이 다름
            rs = pstmt.executeQuery();
            while(rs.next()) {
                String bookid = rs.getString(1);
                String bookname = rs.getString(2);
                String publisher = rs.getString(3);
                String price = rs.getString(4);

                String result = String.format(fmt, bookid, bookname, publisher, price);
                sb.append(result); //String 필드에 저장 ?
            }

        } catch (SQLException ex) {
            System.out.println("JDBC 질의문 생성 오류");
        }
        JDBCUtil.destoryConn(conn, pstmt, rs);

        System.out.println(sb.toString());

    }
}
