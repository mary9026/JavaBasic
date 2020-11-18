package mary;

import java.util.Scanner;

/**
 * 파일명 : Mathod
 * 작성일 : 2020.11.18
 *
 * 프로그램설명 : 성적처리 프로그램 V4
 * 학생 3명의 성적데이터를 키보드로 입력받아
 * 총점, 평균, 학점을 계산하고 결과 출력
 * name, kor, eng, mat, sum, mean, grd
 *
 * 평균은 소수점 첫째 자리까지 출력하고
 * 학점기준은 '수우미양가'로 하되
 * switch 문으로 학점을 계산하도록 함
 *
 * 단, 성적처리 결과 출력 시 출력문을 하나만 사용
 *
 * 성적처리 기능을 구현함으로써 코드가 길어지고
 * 내용파악이 어려워 지는 것을 방지하기 위해
 * 함수(메서드)로 재정의해서 코드를 개선함
 *
 */
public class Mathod {

    // 메서드
    // 특정 작업을 수행하기 위해 작성한 명령어들의 묶음
    // C언어의 함수와 비슷한 성격을 가지는 프로그래밍 요소
    // 입력값을 통해 무언가를 하고 그 결과를 도출하는 수학의 함수(블랙박스)와 비슷한 개념

    // 메서드의 목적
    // 프로그램을 작성하다 보면 반복적으로 쓰는 코드를
    // 종종 보는데, 효율적으로 작성하려면 반복문으로 처리하면 되지만,
    // 만일 반복문이 반복된다면 ? 메서드를 적용하면 기능별로 모듈화를 적용할 수 있기 때문에
    // 프로그램 가독성이  좋아지고, 협업시에도 유용하며, 기능변경 시 유지보수에도 좋음

    // 메서드 정의
    // 접근제한자 리턴값 메서드이름(타입 매개변수명) {
    //      메서드 몸체
    // }
    public static void main(String[] args) {
        // Hello, World !! 메세지 출력
//        System.out.println("Hello,World!!");
//
//        // Hello, World !! 메세지 3번 출력
//        for(int i=1; i<=3; i++) {
//            System.out.println("Hello,World!!");
//        }

        // Hello, World !! 메세지 3번 출력을 3번 반복하는 코드에서
        // 메세지 변경함 : Hello, Java !!

        // 인사말 출력 메서드 호출(call)
//        sayHello();
//        sayHello2();

//        sayHello3("Hello, World !!"); // msg 라는 매개변수는 자동으로 생성됨 (인텔리제이 고유 기능)
//        sayHello3("Hello, Java !!");
//        sayHello3("Hello, Android !!");
//
//        String result =  sayHello4("안녕하세요, 세상아!");
//        System.out.println(result);

//        computerNum(10, 8);



//        computeAllSum(2, 6);
//        computeAllSum(5, 1);

        computeAllSum2(1, 100);


       }

       // 간단한 인사말 출력 메서드
        // public : 접근제한자, 외부 클래스의 이 메서드 사용허가 여부
        // static : 정적 메서드, 객체생성 없이 바로 사용가능 메서드
        // void : 메서드가 반환하는 값이 없음
        public static void sayHello() {
            System.out.println("Hello, World!!");
        }
        // 간단한 인사말 3번 출력하는 메서드 : sayHello2
        public static void sayHello2() {
            for(int i=1; i<=3; i++) {
                System.out.println("Hello, World!!");
            }

        }

        //  간단한 인사말을 출력하는 메서드 : sayHello3
        // 단, 인사말은 언제든 변경하도록 재작성
        // 매개변수 : 메서드 처리시 필요로 하는 입력값
        public static void sayHello3( String msg ) {

            System.out.println(msg); // mag 라는 매개변수로 출력값 가져옴
        }

        //  간단한 인사말을 출력하는 메서드 : sayHello4
        // 단, 인삿말은 언제든 변경하도록 재작성
        // 단, 인삿말 출력을 메서드가 바로 하지 않고
        // 인삿말 생성후 호출한 대상에게 넘김
        // return : 메서드내에서 처리한 값을 외부로 보내려면
        // return 이라는 명령문 사용
        // return 시 값의 type과 메서드의 return type은 반드시 일치해야 함
        public static String sayHello4(String name) {
            return name;
        }

        // 두개의 정수를 매개변수로 선언하고
        // 사칙연산한 결과를 출력하는 메서드 : computerNum
        // ? + ? = ?
        // ? - ? = ?
        // ? × ? = ?
        // ? ÷ ? = ?
        public static void computerNum(int a, int b) {

//            System.out.println(a +  "+" + b + "=" + (a+b));
//            System.out.println(a +  "-" + b + "=" + (a-b));
//            System.out.println(a +  "×" + b + "=" + (a*b));
//            System.out.println(a +  "÷" + b + "=" + (a/b));

            String fmt1 = "%d + %d = %d\n";
            String fmt2 = "%d - %d = %d\n";
            String fmt3 = "%d × %d = %d\n";
            String fmt4 = "%d ÷ %d = %d\n";
            String result =
                    String.format(fmt1, a,b,a+b) +
                            String.format(fmt2, a,b,a-b) +
                            String.format(fmt3, a,b,a*b) +
                            String.format(fmt4, a,b,a/b) ;

            System.out.println(result);

        }

       // 두개의 정수를 매개변수로 선언하고
        // 두 정수를 범위로 설정해서 그 것의 모든 합을
        // 구하고 출력하는 메서드 :  computeAllSum
        // ex) 5, 1 -> 1+2+3+4+5 => 15
        public static void computeAllSum(int a, int b) {
            int min = a;
            int max = b;
            int sum=0;
            String fmt = "%d와 %d 정수범위의 총합 : %d\n";
            if (a > b) { min = b; max = a; }
            for (int i = min; i <= max; ++i) {
                sum = sum + i; // sum += i;
            }
            System.out.printf( fmt, min,max,sum );
        }
        public static void computeAllSum2(int x, int y) {
            int result = 0;
            if(y%2==0) {
                result = (x+y)*((x+y)/2);
            }else {
                result = (x+y)*((x+y)/2) - (x+y)/2;
            }
            System.out.println(result);
        }


    }
