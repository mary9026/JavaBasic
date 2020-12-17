package semiproject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * EmployeeV1Service
 * 인사정보 처리 인터페이스를 구현한 클래스
 * 인사정보 처리에 대한 CRUD 코드를 작성해 둠
 */

public class EmployeeV1Service extends EmployeeV1GenericService {
    List<EmployeeVO> empdata = new ArrayList<>();

    @Override
    /**
     * 인사정보 입력받기
     */
    public void newEmployee() {
        //String lname, email, jobid, phone, hdate;
        //int empno, sal, mgrid, deptid;
        //double comm;

        EmployeeVO emp = new EmployeeVO(0, "", "", "", "", "","", 0, 0.0, 0, 0 );

        Scanner sc = new Scanner(System.in);
        //emp.setEmpno(sc.nextInt());

        // 모든 인사정보는 일단 문자형으로 받되
        // 필요에 따라 적절한 형변환을 해서 변수 저장

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
        empdata.add(emp);

    }

    @Override
    public void readEmployee() {
        // 데이터 출력시 간격유지를 위해 형식지정자 앞에 숫자 사용 (\t도 있으나 칸이 맞지 않았음)
        // String hdr = "사번\t 성\t 이메일\t 직책\t 상사번호\t 부서번호";
        String fmt = "%8s %8s %8s %8s %8s %8s\n";

        System.out.printf(fmt, "empno", "lname", "email", "jobid", "mgrid", "deptid");
        Iterator<EmployeeVO> iter = empdata.iterator();
        while (iter.hasNext()) {
            EmployeeVO em = iter.next();

            System.out.printf(fmt, em.getEmpno(), em.getLname(), em.getEmail(), em.getJobid(), em.getMgrid(), em.getDeptid());

        }
    }


    @Override
    public void readOneEmployee() {
        /**
         * 상세 인사정보 출력
         * 사원번호를 입력받아 출력함
         */
        String fmt = "%8s %8s %8s %8s %8s %8s %8s %8s %8s %8s %8s \n";
        EmployeeVO emp = new EmployeeVO();
        Scanner sc = new Scanner(System.in);
        System.out.print("조회할 직원의 사번을 입력하시오. ");
        emp.setEmpno(Integer.parseInt(sc.nextLine()));

        for(EmployeeVO ev : empdata) {
            // 입력한 사원번호와
            // 순회해서 읽어온 사원정보와 사원번호의 비교
            if(emp.getEmpno() == emp.getEmpno()) {
                emp = ev;

            }
        }
        System.out.printf(fmt, emp.getEmpno(), emp.getLname(), emp.getEmail(), emp.getPhone(), emp.getHdate(), emp.getJobid(), emp.getSal(), emp.getComm(), emp.getMgrid(), emp.getDeptid());
    }


    @Override
    public void modifyEmployee() {
        super.modifyEmployee();
    }

    @Override
    public void removeEmployee() {
        super.removeEmployee();
    }

    /**
     * 인사정보 처리 UI 출력
      */
    public void displayMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append("------------------------------\n")
                .append("인사관리 프로그램  V1\n")
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

}
