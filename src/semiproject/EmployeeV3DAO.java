package semiproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeV3DAO {

    public static String insertEmployee(EmployeeVO emp) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String result = "사원데이터 처리중 ...?!?";

        conn = EmployeeV3JDBC.makeConn();
        try {
            pstmt = conn.prepareStatement(EmployeeV3JDBC.insertEmployee);
            pstmt.setInt(1, emp.getEmpno());
            pstmt.setString(2, emp.getLname());
            pstmt.setString(3, emp.getEmail());
            pstmt.setString(4, emp.getPhone());
            pstmt.setString(5, emp.getHdate());
            pstmt.setString(6, emp.getJobid());
            pstmt.setInt(7, emp.getSal());
            pstmt.setDouble(8, emp.getComm());
            pstmt.setInt(9, emp.getMgrid());
            pstmt.setInt(10, emp.getDeptid());
            int cnt = pstmt.executeUpdate();
            if (cnt > 0) result = "성적데이터 저장완료!";
        } catch (SQLException se) {
            System.out.println("insertSQL에서 오류발생");
        }
        EmployeeV3JDBC.destoryConn(conn,pstmt);
        return result;
    }

    // employees 테이블에서 사원번호, 성, 이메일, 직책, 상사, 부서번호들을
    // 조회해서 ArryList로 구성한 후 EmployeeV3service로 넘김
    public static ArrayList<EmployeeVO> selectEmployee() {
        ArrayList<EmployeeVO> empVO = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        conn = EmployeeV3JDBC.makeConn();
        try {
            pstmt = conn.prepareStatement(EmployeeV3JDBC.selectEmployee);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                EmployeeVO em = new EmployeeVO(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6));
                empVO.add(em);
            }
        } catch (SQLException se) {
            System.out.println("selectEmployee에서 오류발생!");
            se.printStackTrace();
        }
        EmployeeV3JDBC.destoryConn(conn, pstmt, rs);
        return empVO;
    }


}
