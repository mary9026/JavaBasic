package semiproject;

import mary.JDBCUtil;

public class EmployeeV3JDBC extends JDBCUtil {

    public static String insertEmployee =
            " insert into employees values(?,?,?,?,?,?,?,?,?,?,?) ";

    public static String selectEmployee =
            " select employee_id, last_name, email, job_id, manager_id, department_id from employees ";

    public static String selectOneEmployee =
            " select * from employees where employee_id = ? ";

    public static String updateEmployee =
            " update employees set first_name = ?, last_name = ?, email = ?, phone_number = ?, hire_date = ? where employee_id = ? ";

    public static String deleteEmployee =
            " delete from employees where employee_id = ? ";

}
