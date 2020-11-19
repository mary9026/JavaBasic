package lab;

public class Book {
    // 멤버변수 선언
    String name;
    String writer;
    String pubname;
    String pubdate;
    int price;
    double discnt;
    String bkimg; // java.png

    // 생성자

    public Book() {

    }


    // 매개변수 생성자
    public Book(String name, String writer, String pubname, String pubdate, int price, double discnt, String bkimg) {
        this.name = name;
        this.writer = writer;
        this.pubname = pubname;
        this.pubdate = pubdate;
        this.price = price;
        this.discnt = discnt;
        this.bkimg = bkimg;
    }
}
