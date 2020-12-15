package mary;

import java.sql.*;

public class JDBCUtil {
    // 공유의 목적이 있을 경우 static 으로 선언해서 사용
    // 개인의 목적이라면 new 연산자로 선언해서 사용

    // JDBC 드라이버 초기화 및 Connection 객체 생성
    public static Connection makeConn() {
        // 데이터베이스 연결 정보
        String DRV = "org.mariadb.jdbc.Driver";
        String URL = "jdbc:mariadb://mariadb.ct2u6pxalfjg.ap-northeast-2.rds.amazonaws.com:3306/playground";
        String USR = "playground";
        String PWD = "playground2020";

        Connection conn = null;

        try {
            Class.forName(DRV);
            conn = DriverManager.getConnection(URL, USR, PWD);
        } catch (ClassNotFoundException cnf) {
            System.out.println("JDBC 드라이버가 없어요 ");
        } catch (SQLException se) {
            System.out.println("JDBC 연결 실패 ! ");
        }
        return conn;

    }

    //  JDBC 객체 관련
    public static void destoryConn(Connection conn, PreparedStatement pstmt) {
        if (pstmt != null)
            try { pstmt.close(); } catch (SQLException se) { }

        if (conn != null)
            try { conn.close(); } catch (SQLException se) { }

    }

    public static void destoryConn(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        if (rs != null)
            try { rs.close(); } catch (SQLException se) { }

        destoryConn(conn, pstmt);

    }
}
