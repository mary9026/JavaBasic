package mary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// ArrayList
// 동적배열의 한 종류
// List 인터페이스를 구현해서 만든 컬렉션 프레임워크
// 요소의 저장순서가 유지
// 중복으로 데이터를 저장할 수 있음
// 크기가 늘어나면 새로운 배열을 생성하고
// 기존의 요소들을 옮겨야 하는 복잡한 과정이 동반됨
public class ArrayLists {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();

        // 데이터 추가 : add(대상)
        names.add("혜교");
        names.add("지현");
        names.add("수지");

        // 특정 위치에 데이터 추가 : add(위치,대상)
        names.add(1, "수현");

        // 컬렉션 자료구조에 저장된 데이터를
        // 출력하려면 foreach 구문 사용
        for(String name : names) {
            System.out.println(name);
        }

        // 요소 추출 : get(위치)
        System.out.println(names.get(1));

        // 요소 수정 : set(위치, 대상)
        names.set(1, "윤아");
        System.out.println(names.get(1));

        // 요소 삭제 : remove(위치)
        names.remove(1);
        System.out.println(names.get(1));

        // 요소 모두 삭제 : clear()
        names.clear();
        System.out.println(names);

        // 데이터 검색하기
        // 매열에서 원하는 데이터를 찾는 방법은 2가지
        // 위치로 찾음 : get(위치)
        // 실제값으로 찾음 : contains, indexOf
        String[] game = {"스타크래프트", "디아블로", "워크래프트"};

        // ArrayList<String> games = (ArrayList<String>)Arrays.asList(game); // 이론적으론 가능하나 실행 불가
        // 문법적으로는 문제없지만 실행 시 다운캐스팅 오류발생

        List<String> games = Arrays.asList(game);
        // 일반배열을 동적배열로 변환하려면
        // Arrays 클래스의 asList메서드를 사용함

        System.out.println( games );

        // games  동적배열에서 '디아블로'를 찾아봄
        // 전체를 훑어가며 대상을 찾기 때문에 성능 '나쁨' ! // 배열에서는 length 동적배열에서는 size를 씀
        for(int i=0; i<games.size(); ++i) { // 정적배열, int char 기본자료형 변수/ 일반배열에는 for문
            if(games.get(i).equals("디아블로")) {
                System.out.println((i+1) + "번째에서 찾음");
                break;
            }
        } // 위치기반 검색
        for (String g : games) { // foreach문 : 동적배열 컬렉션으로 만들었을 경우, 객체형?은 foreach문 사용
            if(g.equals("디아블로")) {
                System.out.println("데이터 찾음"); // 여기서는 n번째 찾음은 못쓰고 찾고/못찾고만 구현 가능 / 존재여부만 체크
                break;
            }
        } // 값기반 검색

        if (games.contains("디아블로")) {
            System.out.println("데이터 찾음!!");
        } // 값 기반 검색
        System.out.println(games.indexOf("디아블로"));
        // 위치 기반 검색
        // 이 두가지를 사용하면, 데이터 존재의 여부 및 위치를 파악할 수 있음

        // 게임 정보에 대한 객체 생성
        GameInfo g1 = new GameInfo("디아블로", 35000);
        GameInfo g2 = new GameInfo("스타크래프트", 45000);
        GameInfo g3 = new GameInfo("워크래프트", 55000);

        // 생성한 객체들을 동적배열에 저장
        ArrayList<GameInfo> games2 = new ArrayList<>();
        games2.add(g1);
        games2.add(g2);
        games2.add(g3);

        // '스타크래프트' 요소를 출력
        // ArrayList의 타입은 GameInfo의 객체이므로
        // GameInfo 객체의 주소가 저장됨
        System.out.println(games2.get(1)); // 객체형의 경우 값의 주소만 출력됨
        // 따라서, GameInfo 객체의 실제값을 출력하려면
        // 대상.변수명 또는 대상.getter를 이용해야 함
        System.out.println(games2.get(1).name);
        System.out.println(games2.get(1).price);

        // 특정 요소를 검색하는 코드를
        // 4가지 버젼(for, foreach, contains, indexOf) 으로 작성
        for(int i=0; i<games2.size(); ++i) {
            if(games2.get(i).name.equals("워크래프트")) {
                System.out.println((i+1) + "번째에서 찾음");
                break;
            }
        }

        for (GameInfo gam2: games2) {
            if(gam2.name.equals("워크래프트")) {
                System.out.println("데이터 찾음");
                break;
            }
        }

        for (GameInfo gam2: games2) {
            if(gam2.name.contains("워크래프트")) {
                System.out.println("데이터 찾음 ! ");
                break;
            }
        }

        for (GameInfo gam2: games2) {
            if(gam2.name.indexOf("워크래프트") >=0 ) {
                System.out.println("데이터 찾음 !! ");
                break;
            }
        }

//        if(games2.contains("워크래프트")) {
//            System.out.println("데이터 찾음 !!!");
//        }
//        System.out.println(games2.indexOf("워크래프트"));
    }
}

class GameInfo {
    String name;
    int price;

    public GameInfo(String name, int price) {
        this.name = name;
        this.price = price;
    }
}