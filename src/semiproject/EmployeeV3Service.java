package semiproject;

import mary.SungJukV10DAO;
import mary.SungJukVO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class EmployeeV3Service {

    public void displayMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append("------------------------------\n")
                .append("인사관리 프로그램  V3\n")
                .append("------------------------------\n")
                .append("1. 인사 정보 입력\n")
                .append("2. 인사 정보 조회\n")
                .append("3. 인사 정보 상세조회\n")
                .append("4. 인사 정보 수정\n")
                .append("5. 인사 정보 삭제\n")
                .append("6. 프로그램 종료\n")
                .append(" ------------------------------\n")
                .append(" 원하시는 작업은 ? ");
        System.out.print(sb);

    }

    public void newEmployee() {
        //String lname, email, jobid, phone, hdate;
        //int empno, sal, mgrid, deptid;
        //double comm;

        EmployeeVO emp = new EmployeeVO(0, "", "", "", "", "", "", 0, 0.0, 0, 0);

        Scanner sc = new Scanner(System.in);
        //emp.setEmpno(sc.nextInt());

        System.out.print("사번을 입력하세요 : ");
        // empno = sc.nextLine();
        emp.setEmpno(Integer.parseInt(sc.nextLine()));
        System.out.print("이름을 입력하세요 : ");
        emp.setFname(sc.nextLine());
        System.out.print("성을 입력하세요 : ");
        emp.setLname(sc.nextLine());
        System.out.print("이메일 주소를 입력하세요 : ");
        emp.setEmail(sc.nextLine());
        System.out.print("전화번호를 입력하세요 : ");
        emp.setPhone(sc.nextLine());
        System.out.print("입사일을 입력하세요 : ");
        emp.setHdate(sc.nextLine());
        System.out.print("직책을 입력하세요 : ");
        emp.setJobid(sc.nextLine());
        System.out.print("급여를 입력하세요 : ");
        emp.setSal(Integer.parseInt(sc.nextLine()));
        System.out.print("수당을 입력하세요 : ");
        emp.setComm(Double.parseDouble(sc.nextLine()));
        System.out.print("상사번호를 입력하세요 : ");
        emp.setMgrid(Integer.parseInt(sc.nextLine()));
        System.out.print("부서번호를 입력하세요 : ");
        emp.setDeptid(Integer.parseInt(sc.nextLine()));

        String result = EmployeeV3DAO.insertEmployee(emp);
        System.out.println(result);


    }

    public void readEmployee() {
        String fmt = "%10s %10s %10s %10s %10s %10s\n";
        StringBuilder sb = new StringBuilder();

        String result = String.format(fmt, "empno", "lname", "email", "jobid", "mgrid", "deptid"); // 제목출력

        ArrayList<EmployeeVO> empVO = EmployeeV3DAO.selectEmployee();

        for (EmployeeVO em:empVO) {
            result = String.format(fmt, em.getEmpno(), em.getLname(), em.getEmail(),
                    em.getJobid(), em.getMgrid(), em.getDeptid());
            sb.append(result);

        }
        System.out.println(sb.toString());
    }

    public void readOneEmployee() {
        String fmt = "%10s %10s %10s %10s %10s %10s %10s %10s %10s %10s %10s \n";

        Scanner sc = new Scanner(System.in);
        System.out.print("조회할 직원의 사번을 입력하시오. ");
        String empid = sc.nextLine();

        EmployeeVO emp = EmployeeV3DAO.selectOneEmployee(empid);

        String result = String.format(fmt, emp.getEmpno(),emp.getFname(), emp.getLname(), emp.getEmail(),
                emp.getPhone(), emp.getHdate(), emp.getJobid(), emp.getSal(), emp.getComm(),
                emp.getMgrid(), emp.getDeptid());

        System.out.println(result);
    }

    // 매개변수 2개 넘기는거 연구해보기
    public void modifyEmployee() {
        Scanner sc = new Scanner(System.in);
        EmployeeVO em = new EmployeeVO();

        System.out.print("수정할 사번을 입력하세요 : ");
        em.setEmpno(Integer.parseInt(sc.nextLine()));
        System.out.print("수정할 이름을 입력하세요 : ");
        em.setFname(sc.nextLine());
        System.out.print("수정할 성을 입력하세요 : ");
        em.setLname(sc.nextLine());
        System.out.print("수정할 이메일을 입력하세요 : ");
        em.setEmail(sc.nextLine());
        System.out.print("수정할 전화번호를 입력하세요 : ");
        em.setPhone(sc.nextLine());
        System.out.print("수정할 입사일을 입력하세요 : ");
        em.setHdate(sc.nextLine());

        String result = EmployeeV3DAO.updateEmployee(em);
        System.out.println(result);


    }

    public void removeEmployee() {
        Scanner sc = new Scanner(System.in);

        System.out.println("삭제할 사원번호는 ? ");
        Integer empid = sc.nextInt();

        String result = EmployeeV3DAO.deleteEmployee(empid);
        System.out.println(result);
    }
}
