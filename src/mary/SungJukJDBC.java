package mary;

// JDBCUtil 클래스 상속해서 사용
public class SungJukJDBC extends JDBCUtil {

    public static String insertSUNGJuk =
            " insert into sungjuk (name, kor, eng, mat, tot, mean, grd) " +
                    " values(?,?,?,?,?,?,?) ";
    public static String selectSungJuk =
            " select sjno, name, kor, eng, mat, regdate from sungjuk order by sjno desc ";
    public static String selectOneSungJUk =
            " select * from sungjuk where sjno = ? ";
    public static String updateSungJuk =
            " update sungjuk set kor=?, eng=?, mat=?, tot=?, mean=?, grd=? where sjno = ? ";
    public static String deleteSungJuk =
            " delete sungjuk where sjno = ? ";
}
