package mary;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCOrders3b {
    public static void main(String[] args) {
        // 고객번호로 주문정보 조회
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "select * from book_orders where custid = ?";
        String fmt = "%s %s %s %s %s\n";
        StringBuilder sb = new StringBuilder();

        Scanner sc = new Scanner(System.in);
        System.out.print("고객번호를 입력하세요 ");
        Integer num = sc.nextInt();

        conn = JDBCUtil.makeConn();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, num);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                String orderid = rs.getString(1);
                String custid = rs.getString(2);
                String bookid = rs.getString(3);
                String saleprice = rs.getString(4);
                String orderdate = rs.getString(5);
                String result = String.format(fmt, orderid, custid, bookid, saleprice, orderdate);
                sb.append(result);
            }
        } catch (SQLException ex) {
            System.out.println("JDBC 질의문 생성 오류");
        }
        JDBCUtil.destoryConn(conn, pstmt, rs);

        System.out.println(sb.toString());
    }
}
