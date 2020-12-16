package semiproject;

import mary.JDBCUtil;

public class EmployeeV3JDBC extends JDBCUtil {

    public static String insertEmployee =
            " insert into employees (employee_id, last_name, email, phone_number, hire_date, job_id, salary, " +
                    "commission_pct, manager_id, department_id) " +
                    "+ values(?,?,?,?,?,?,?,?,?,?) ";

    public static String selectEmployee =
            " select employee_id, last_name, email, job_id, manager_id, department_id from employees ";

    public static String selectOneEmployee =
            " select * from employees where employee_id = ? ";

}
