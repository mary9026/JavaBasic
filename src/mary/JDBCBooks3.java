package mary;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCBooks3 {
    public static void main(String[] args) {
        // Books 테이블의 저장된 모든 내용을 출력함
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "select * from books";
        String fmt = "%s %s %s %s\n"; // 출력하기 편하기 위해 만든 포멧 형식
        StringBuilder sb = new StringBuilder();

        conn = JDBCUtil.makeConn();
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery(); // excuteQuery의 결과를 rs로 받아옴
            while(rs.next()) { // rs.next() 쓰면 한 행을 가져옴
                String bookid = rs.getString(1); // get 으로 가져오고 1번째 컬럼을 가져온다는 의미 보통 가져올땐 문자형으로 !
                String bookname = rs.getString(2);
                String publisher = rs.getString(3);
                String price = rs.getString(4);
                String result = String.format(fmt, bookid, bookname, publisher, price);
                sb.append(result);

            }
        } catch (SQLException ex) {
            System.out.println("JDBC 질의문 생성 오류");
        }
        JDBCUtil.destoryConn(conn, pstmt, rs);

        // 결과 출력
        System.out.println(sb.toString()); // println은 자동 형변환이 일어나지만 보통은 직접 써줘야하므로 문자형으로 나타낼 수 있도록 sb.toString() 으로 기재
    }
}
