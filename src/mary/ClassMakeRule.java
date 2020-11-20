package mary;

    // 클래스 종류
    // VO/DTO : ValueObject, Data Transfer Object (데이터를 가져오거나 내 보낼때 사용)
    // 계층간 데이터교환을 위한 자바빈즈를 의미
    // 값만 저장하기 위해 생성하는 클래스
    // 주로 데이터베이스 테이블의 각 열과 연계해서 작성

    // DAO : data access object (db를 사용하던지, 연속성을 지원하는 시스템에서 데이터를 조회/추가/수정/삭제하는 기능만 전담)
    // 데이터베이스를 사용해서 데이터를 추가/조회/수정/삭제하는 기능을 전담하는 클래스
    // VO 클래스와 연계해서 작성함
    // 인터페이스로 기능을 정의하고 클래스로 구현함
    // 기능은 메서드가 담당 ? (데이터베이스 관련된 기능을 담당하는 것)

    // Service : 비지니스 로직 처리를 담당하는 클래스 (db에 집어넣기 전 중간단계를 서비스라고 함)
    // VO로 저장된 데이터를 DAO로 넘기기 전에 처리해야 하는 일반적인 작업을 기능으로 구현한 클래스

    // 일반적인 프로그래밍 작성 흐름 : VO -> Service -> DAO
    // J2EE 개발에 최적화된 방식
public class ClassMakeRule {
    public static void main(String[] args) {
        // 세금계산을 위한 객체 생성
        ComputeTax choi = new ComputeTax(3500, 1);

        System.out.println(choi.manageTax());

        choi = new ComputeTax(7800, 0);
        System.out.println(choi.manageTax());

    }
}

    class ComputeTax {
        private int salary;
        private int isMarried;  // 예 : 0, 아니요 : 1


        public ComputeTax() {
        }

        public ComputeTax(int salary, int isMarried) {
            this.salary = salary;
            this.isMarried = isMarried;
        }

        public int getSalary() {
            return salary;
        }

        public void setSalary(int salary) {
            this.salary = salary;
        }

        public int getIsMarried() {
            return isMarried;
        }

        public void setIsMarried(int isMarried) {
            this.isMarried = isMarried;
        }

        // 세금계산
        public double manageTax() {

            double tax = 0;

            if(isMarried == 0) { // 기혼
                if (salary < 6000)
                    tax = salary * 0.15;
                else
                    tax = salary * 0.35;

            }else { // 미혼
                    if (salary < 3000)
                        tax = salary * 0.10;
                    else
                        tax = salary * 0.25;

            } return tax;
        } // manageTax


    } //class

