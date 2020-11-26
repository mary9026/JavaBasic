package semiproject;

import mary.SungJukVO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class EmployeeV1Service extends EmployeeV1GenericService {
    List<EmployeeVO> empdata = new ArrayList<>();

    @Override
    public void newEmployee() {
        String lname, email, jobid, empno, deptid;

        Scanner sc = new Scanner(System.in);

        System.out.print("사번을 입력하세요 : ");
        empno = sc.nextLine();
        System.out.print("이름(성/last name)을 입력하세요 : ");
        lname = sc.nextLine();
        System.out.print("이메일 주소를 입력하세요 : ");
        email = sc.nextLine();
        System.out.print("직책을 입력하세요 : ");
        jobid = sc.nextLine();
        System.out.print("부서번호를 입력하세요 : ");
        deptid = sc.nextLine();

        // 입력받은 데이터를 동적배열에 저장
        EmployeeVO ev = new EmployeeVO(empno, lname, email, jobid, deptid);

        // 처리된 데이터를 동적배열에 저장 (멤버데이터 만들어야 함)
        empdata.add(ev);

    }

    @Override
    public void readEmployee() {
        String fmt = "사번:%s, 이름(성):%s, 이메일:%s, 직책:%s, 부서번호:%s\n";

        Iterator<EmployeeVO> iter = empdata.iterator();
        while (iter.hasNext()) {
            EmployeeVO em = iter.next();

            System.out.printf(fmt, em.getEmpno(), em.getLname(), em.getEmail(), em.getJobid(), em.getDeptid());

        }
    }


    @Override
    public void readOneEmployee() {
        String fmt = "사번:%s, 이름(성):%s, 이메일:%s, 직책:%s, 부서번호:%s\n";

        Scanner sc = new Scanner(System.in);
        System.out.print("조회할 직원의 사번을 입력하시오. ");
        String name = sc.nextLine();

        for(EmployeeVO ev : empdata) {
            if(ev.getEmpno().equals(name)) {
                System.out.printf(fmt, ev.getEmpno(), ev.getLname(), ev.getEmail(), ev.getJobid(), ev.getDeptid());
            }
        }
    }

    @Override
    public void modifyEmployee() {
        super.modifyEmployee();
    }

    @Override
    public void removeEmployee() {
        super.removeEmployee();
    }

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
