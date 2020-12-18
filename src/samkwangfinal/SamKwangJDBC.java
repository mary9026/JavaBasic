package samkwangfinal;

import mary.JDBCUtil;

public class SamKwangJDBC extends JDBCUtil {

//    public static String readCODP =
//        " select * from 주문 " +
//                " inner join 운송 on 주문.주문번호 = 운송.주문번호 " +
//                " inner join 직원 on 직원.인사번호 = 주문.인사번호 ";
//
//    public static String readSOE =
//           " select * from 고객 inner join 주문 on 고객.고객번호 = 주문.고객번호 " +
//                   " inner join 주문항목 on 주문.주문번호 = 주문항목.주문번호 " +
//                   " inner join 제품 on 주문항목.제품번호 = 제품.제품번호 ";


    public static String selectCODP =
            " select 고객번호, 고객이름, 주문번호, 주문일, 제품번호, 수량, 제품이름, 단가 from CODP order by 주문번호 desc ";
    public static String selectOneCODP = " select * from CODP where 주문번호 = ? ";

    public static String selectSOE = " select 인사번호, 주문번호, 운송ID, 운송이름, 주문일, 직책 " +
            " from SOE order by 운송ID desc ";

    public static String selectOneSOE =
            " select * from SOE where 운송ID = ? ";
}
