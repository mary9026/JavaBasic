package lab.movies;

public class Producer {
    private String name;
    private String address;
    private String[] movie;

    public Producer() {
    }

    public Producer(String name, String address, String[] movie) {
        this.name = name;
        this.address = address;
        this.movie = movie;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String[] getMovie() {
        return movie;
    }

    public void setMovie(String[] movie) {
        this.movie = movie;
    }
}
