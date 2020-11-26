package semiproject;

public class EmployeeVO {
    private String empno;
    private String lname;
    private String email;
    private String jobid;
    private String deptid;

    public EmployeeVO() {
    }

    public EmployeeVO(String empno, String lname, String email, String jobid, String deptid) {
        this.empno = empno;
        this.lname = lname;
        this.email = email;
        this.jobid = jobid;
        this.deptid = deptid;
    }

    public String getEmpno() {
        return empno;
    }

    public void setEmpno(String empno) {
        this.empno = empno;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJobid() {
        return jobid;
    }

    public void setJobid(String jobid) {
        this.jobid = jobid;
    }

    public String getDeptid() {
        return deptid;
    }

    public void setDeptid(String deptid) {
        this.deptid = deptid;
    }
}
