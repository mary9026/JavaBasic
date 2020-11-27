package mary;

// 스트림Stream
// 데이터를 비트등의 단위로 조각내어 일련의 연속성을
// 갖도록 만든 데이터의 열
// 일반적으로 스트림이라하면 이러한 데이터의 열과
// 이것을 활용하기 위해 사용하는 모듈을 합쳐 부르는 것

// 스트림은 데이터를 읽고 쓰기 위한 공통된 방법 제공
// 자바에서 스트림 처리방식은 모든 데이터를 '바이트'로 보는
// 바이트 단위의 스트림과 문자데이터만을 위한 문자단위 스트림등이 있음

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// 문자 스트림을 다루는 클래스 : java.io 패키지에 포함
// Reader/Writer => FileReader/FileWriter
public class FileReaderWriter {
    public static void main(String[] args) throws IOException {
        // 자신의 이름, 키, 나이를 파일에 저장
        String name = "지현";
        int height = 175;
        int age = 30;

        // 파일에 기록
        // 데이터를 저장할 위치와 파일명 지정
        String fpath = "c:/Java/info.txt";

        // 파일쓰기(문자 출력 스트림) 객체 생성 (이걸 만드는 이유는 write라는 메서드를 불러스 쓰기 위해)
        FileWriter fw = new FileWriter(fpath); // FileWriter에 빨간 밑줄 생기는데 alt+엔터 치고 첫번째 누르면 13/14/19행 코멘트 생성됨

        // 파일에 내용 쓰기
        fw.write(name + "\n");
        fw.write(height+ "\n");
        fw.write(age+ "\n");

        // 파일쓰기를 끝내고 작업 마무리
         fw.close();

         // 파일에 저장된 데이터를 화면에 출력하기 1
        // 한 문자씩 읽어와서 출력

        // 읽어올 파일명과 위치 지정
        FileReader fr = new FileReader(fpath);

        // 파일로부터 문자 하나를 읽어서 화면에 출력
        // 이러한 작업을 더이상 읽을 문자가 없을때까지 반복 (-1을 기재한 것은 더이상 읽을 문자가 없을때까지라는 의미 )
        // 아스키코드는 문자하나에 할당된 숫자코드
        int ch = 0;
        while((ch = fr.read()) != -1) {
            System.out.println(ch + "/" + (char)ch);
        }
        //  파일 읽기가 끝나면 작업 마무리
        fr.close();

        // 파일에 저장된 데이터를 화면에 출력하기 2
        // 한 행씩 읽어와서 출력
        // BufferedReader를 이용해서 처리하면 입력속도를 높일 수 있음
        fr = new FileReader(fpath);
        BufferedReader br = new BufferedReader(fr);

        // .ready() 읽어올 데이터가 있는지 먼저 확인
        while(br.ready()) {
            // 만일, 있다면 한행씩 읽어서 화면에 출력
            System.out.println(br.readLine());
        }

        // 파일읽기가 끝나면 작업 마무리
        br.close();;
        fr.close();

    }
}
