package samkwangfinal;

import mary.JDBCUtil;

public class SamKwangJDBC extends JDBCUtil {

    public static String readCODP =
        " select * from 주문 " +
                " inner join 운송 on 주문.주문번호 = 운송.주문번호 " +
                " inner join 직원 on 직원.인사번호 = 주문.인사번호 ";

    public static String readSOE =
           " select * from 고객 inner join 주문 on 고객.고객번호 = 주문.고객번호 " +
                   " inner join 주문항목 on 주문.주문번호 = 주문항목.주문번호 " +
                   " inner join 제품 on 주문항목.제품번호 = 제품.제품번호 ";


}
