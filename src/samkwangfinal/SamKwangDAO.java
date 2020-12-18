package samkwangfinal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SamKwangDAO {

    // CODP 테이블에서 기본정보만 조회한 후 넘김
    public static ArrayList<SamKwangCODPVO> selectCODP() {
        ArrayList<SamKwangCODPVO> codps = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        conn = SamKwangJDBC.makeConn();
        try {
            pstmt = conn.prepareStatement(SamKwangJDBC.selectCODP);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                SamKwangCODPVO codp = new SamKwangCODPVO(
                  rs.getInt(1),
                  rs.getString(2),
                  rs.getInt(3),
                  rs.getString(4),
                  rs.getInt(5),
                  rs.getInt(6),
                  rs.getString(7),
                  rs.getInt(8)
                );
                codps.add(codp);
            }
        } catch (SQLException se) {
            System.out.println("selectCODP에서 오류발생 ! ");
            se.printStackTrace();
        }


        SamKwangJDBC.destoryConn(conn,pstmt,rs);
        return codps;
    }

    // 넘겨준 주문번호를 이용해서 CODP에서 주문정보를 조회하고 결과를 넘겨줌
    public static ArrayList<SamKwangCODPVO> selectOneCODP(int 주문번호) {
        ArrayList<SamKwangCODPVO> codps = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        conn = SamKwangJDBC.makeConn();
        try {
            pstmt = conn.prepareStatement(SamKwangJDBC.selectOneCODP);
            pstmt.setInt(1, 주문번호);
            rs = pstmt.executeQuery();

            while(rs.next()) {
                SamKwangCODPVO codp = new SamKwangCODPVO(
                    rs.getInt(1), rs.getInt(2),
                    rs.getInt(3), rs.getString(4),
                    rs.getString(5), rs.getString(6),
                    rs.getString(7), rs.getString(8),
                    rs.getString(9), rs.getString(10),
                    rs.getInt(11), rs.getInt(12),
                    rs.getString(13), rs.getString(14),
                    rs.getInt(15), rs.getInt(16) );
                codps.add(codp);
            }
        } catch (SQLException se) {
            System.out.println("selectOneCODP에서 오류 발생 ! ");
            se.printStackTrace();
        }
        SamKwangJDBC.destoryConn(conn,pstmt,rs);

        return codps;
    }

    // SOE 테이블에서 기본정보만 조회한 후 넘김
    public static ArrayList<SamKwangSOEVO> selectSOE() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<SamKwangSOEVO> soes = new ArrayList<>();

        conn = SamKwangJDBC.makeConn();
        try {
            pstmt = conn.prepareStatement(SamKwangJDBC.selectSOE);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                SamKwangSOEVO soe = new SamKwangSOEVO(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)
                );
                soes.add(soe);
            }
        } catch (SQLException se) {
            System.out.println("selectSOE에 오류발생 ! ");
            se.printStackTrace();
        }
        SamKwangJDBC.destoryConn(conn, pstmt, rs);

        return soes;
    }

    // 넘겨준 운송ID를 이용해서 SOE에서 배송정보를 조회하고 결과를 넘겨줌 / 단일값이니 ArrayList 안쓰고 VO객체로 넘김
    public static SamKwangSOEVO selectOneSOE(int 운송ID) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        SamKwangSOEVO soe = null;

        conn = SamKwangJDBC.makeConn(); // Connection 생성
        try {
            pstmt = conn.prepareStatement(SamKwangJDBC.selectOneSOE); // SQL문 받아옴
            pstmt.setInt(1, 운송ID);
            rs = pstmt.executeQuery(); // 결과 받음
            if(rs.next()) {
                soe = new SamKwangSOEVO(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13));
            }
        } catch (SQLException se) {
            System.out.println("selectOneSOE에서 오류발생 ! ");
            se.printStackTrace();
        }



        SamKwangJDBC.destoryConn(conn,pstmt,rs);
        return soe;

    }
}
