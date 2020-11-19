package lab;

public class Major {
        String major;
        String phone;
        String office;
        String chief;


        //  기본생성자
        public Major() {
                major = "의상디자인";
                phone = "234-5678-9012";
                office = "A동 1층";
                chief = "301";
        }

        public Major(String major, String phone, String office, String chief) {
                this.major = major;
                this.phone = phone;
                this.office = office;
                this.chief = chief;
        }


}
