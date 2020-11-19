package lab.movies;

public class MovieMain {
    public static void main(String[] args) {
        String[] genre = {"범죄"};
        String[] dirtor = {"박정배"};
        String[] actor = {"이제훈", "신혜선"};
        String[] summary = {"2020.11.04 개봉한 도굴꾼들의 범죄오락 영화!"};
        String[] desc = {"흙 맛만 봐도 보물을 찾아내는 타고난 천재 도굴꾼 강동구(이제훈). 자칭 한국의 '인디아나 존스'로 불리는 고분벽화 도굴 전문가 존스 박사(조우진), 전설의 삽질 달인 삽다리(임원희)를 만나 환상(?)의 팀플레이를 자랑하며 위험천만하고도 짜릿한 도굴의 판을 키운다."};

        Movie dogul = new Movie("도굴", "2020", 114, "CJ엔터테인먼트", genre, dirtor, actor, summary, desc);

        System.out.println(dogul.getTitle());
        System.out.println(dogul.getYear());
        System.out.println(dogul.getRuntime());
        System.out.println(dogul.getPrdtin());
        System.out.println(dogul.getGenre());
        System.out.println(dogul.getDirtor());
        System.out.println(dogul.getActor());
        System.out.println(dogul.getSummary());
//        System.out.println(dogul.getDesc()[0]);

        // 참조형 변수이므로 배열의 내용대신 내용이 저장된 위치가 출력됨
        // 반복문으로 이용해서 처리
        for(int i = 0; i < genre.length; ++i)
            System.out.println(dogul.getDesc()[i]);

    }
}
