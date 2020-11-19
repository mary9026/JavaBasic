package lab;

public class Student {
        int stdnum;
        String name;
        String adress;
        String birth;
        String major;
        String prof;

        // 기본생성자
        public Student() {
                stdnum = 20125006;
                name = "송혜교";
                adress = "서울 영등포구";
                birth = "1988.9.17";
                major = "컴퓨터";
                prof = "301";

        }

        // 매개변수를 포함하는 생성자
        public Student(int stdnum, String name, String adress, String birth, String major, String prof) {
                this.stdnum=stdnum;
                this.name=name;
                this.adress=adress;
                this.birth=birth;
                this.major=major;
                this.prof=prof;
        }


}
