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

        EmployeeVO emp = new EmployeeVO(0, "", "", "", "", "", 0, 0.0, 0, 0);

        Scanner sc = new Scanner(System.in);
        //emp.setEmpno(sc.nextInt());

        System.out.print("사번을 입력하세요 : ");
        // empno = sc.nextLine();
        emp.setEmpno(Integer.parseInt(sc.nextLine()));
        System.out.print("이름을 입력하세요 : ");
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

        // 입력받은 데이터를 동적배열에 저장
        // EmployeeVO ev = new EmployeeVO(empno, lname, email, jobid, deptid);

        // 처리된 데이터를 동적배열에 저장 (멤버데이터 만들어야 함)
        // empdata.add(emp);
    }

    public void readEmployee() {
        String fmt = "%8s %8s %8s %8s %8s %8s\n";
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
    }
}
