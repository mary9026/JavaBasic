package semiproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeV3DAO {

    // 입력받은 사원정보를 employees 테이블에 저장함
    public static String insertEmployee(EmployeeVO emp) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String result = "사원데이터 처리중 ...?!?";

        conn = EmployeeV3JDBC.makeConn();
        try {
            pstmt = conn.prepareStatement(EmployeeV3JDBC.insertEmployee);
            pstmt.setInt(1, emp.getEmpno());
            pstmt.setString(2, emp.getFname());
            pstmt.setString(3, emp.getLname());
            pstmt.setString(4, emp.getEmail());
            pstmt.setString(5, emp.getPhone());
            pstmt.setString(6, emp.getHdate());
            pstmt.setString(7, emp.getJobid());
            pstmt.setInt(8, emp.getSal());
            pstmt.setDouble(9, emp.getComm());
            pstmt.setInt(10, emp.getMgrid());
            pstmt.setInt(11, emp.getDeptid());
            int cnt = pstmt.executeUpdate();
            if (cnt > 0) result = "성적데이터 저장완료!";
        } catch (SQLException se) {
            System.out.println("insertSQL에서 오류발생");
            se.printStackTrace();
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

    // 입력받은 사원번호로 employees 테이블을 조회하고
    // 그 결과를 employeeVO 로 구성한 후 EmployeeV3Service로 넘김
    public static EmployeeVO selectOneEmployee(String empid) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        EmployeeVO emp = null;

        conn = EmployeeV3JDBC.makeConn();
        try {
            pstmt = conn.prepareStatement(EmployeeV3JDBC.selectOneEmployee);
            pstmt.setString(1, empid);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                emp = new EmployeeVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8),
                        rs.getDouble(9), rs.getInt(10),rs.getInt(11));
            }
        } catch (SQLException se) {
            System.out.println("selectOneEmployee 에서 오류 발생 ! ");
            se.printStackTrace();
        }
        EmployeeV3JDBC.destoryConn(conn, pstmt, rs);

        return emp;
    }

    // 수정할 사원번호를 넘겨받아 employees 테이블을 수정함
    public static String updateEmployee(EmployeeVO em) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String result = "사원데이터 수정 처리중 ...?!?";

        conn = EmployeeV3JDBC.makeConn();
        try {
            pstmt = conn.prepareStatement(EmployeeV3JDBC.updateEmployee);
            pstmt.setString(1, em.getFname());
            pstmt.setString(2, em.getLname());
            pstmt.setString(3, em.getEmail());
            pstmt.setString(4, em.getPhone());
            pstmt.setString(5, em.getHdate());
            pstmt.setInt(6, em.getEmpno());

            int cnt = pstmt.executeUpdate();
            if (cnt > 0) result = "사원정보 수정 완료 ! ";
        } catch (SQLException se) {
            System.out.println("updateEmployee에서 오류발생 ! ");
            se.printStackTrace();
        }
        EmployeeV3JDBC.destoryConn(conn, pstmt);
        return result;

    }

    // 입력받은 사원번호를 이용해서 employees 테이블을 삭제함
    public static String deleteEmployee(Integer empid) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String result = "사원데이터 삭제 처리중...?!?";

        conn = EmployeeV3JDBC.makeConn();
        try {
            pstmt = conn.prepareStatement(EmployeeV3JDBC.deleteEmployee);
            pstmt.setInt(1, empid);

            int cnt = pstmt.executeUpdate();
            if (cnt > 0) result = "사원데이터 삭제 완료 ! ";
        } catch (SQLException se) {
            System.out.println("deleteEmployee 에서 오류 ! ");
            se.printStackTrace();
        }
        EmployeeV3JDBC.destoryConn(conn, pstmt);

        return result;
    }


}
