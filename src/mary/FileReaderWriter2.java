package mary;

import java.io.*;

// 2차원 표 형태의 데이터를 파일에 저장하기
public class FileReaderWriter2 {
    public static void main(String[] args) throws IOException {
        // 학번, 이름, 주소, 생년월일, 학과명, 교수등으로 구성된 2차원 표 형태의 데이터를
        // Student.dat에 저장

        // 어떤 학생의 기본정보
        int hakbun = 201350050;
        String name = "김태희";
        String addr = "경기도 고양시";
        String birth = "1985.3.22";
        String dname = "컴퓨터";
        int prof = 504;

        // 학생 기본정보 저장할 파일 지정 (student.dat에 저장함)
        String fpath = "c:/Java/Student.dat";
        FileWriter fr = new FileWriter(fpath);

        // 기본정보를 저장할 형식 정의
        // 각 학몽들은 ,로 구분함
        String fmt = "%s, %s, %s, %s, %s, %s"; // 숫자든 문자든 파일에 문자형으로 저장되므로 String 으로 모두 선언
        String data = String.format(fmt, hakbun, name, addr, birth, dname, prof);

        // 버퍼기능을 지원하는 Writer 사용하기
        BufferedWriter bw = new BufferedWriter(fr);

        bw.write(data);

        bw.close();
        fr.close();

        // 과목번호, 과목명, 과목개요, 담당교수 등으로
        // 구성된 2차원 표형태의 데이터를 subject.dat에 저장

        String dnum = "0205";
        String dname2 = "프로그래밍";
        String dname3 = "자바 프로그래밍";
        int prof2 = 301;

        fpath = "c:/Java/subject.dat"; // "c:\\Java\\subject.dat" 이렇게 써도됨 (리눅스는 / 만 허용)
        FileWriter fw = new FileWriter(fpath);
        bw = new BufferedWriter(fw);

        fmt = "%s, %s, %s, %s";
        data = String.format(fmt, dnum, dname2, dname3, prof2);

        bw.write(data);

        bw.close();
        fr.close();


        // 과목정보가 저장된 파일을 읽어서 출력하기
        // 학번 :
        // 이름 :
        // ...
        FileReader frr = new FileReader(fpath);
        BufferedReader br = new BufferedReader(frr); // 입출력 속도 빨라짐
        fmt = "과목번호 : %s\n과목명 : %s\n과목번호 : %s\n담당교수 : %s\n";

        while (br.ready()) {
            String line = br.readLine();
//            System.out.println(line);

            // 읽어온 데이터를 ',' 단위로 분리해서 (꼭 ,는 아니어도 된다고 함 / 슬래시, 탭 등 다양 활용 가능)
            // 배열변수에 저장
            String[] items = line.split(",");
            String result = String.format(fmt, items[0], items[1], items[2], items[3]);
            System.out.println(result);
        }

        br.close();
        fr.close();



    }
}
