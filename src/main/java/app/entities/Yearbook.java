package app.entities;

public class Yearbook {
    //whether to put id or not
    private int grade;
    private String schoolName;
    private String type;
    private boolean photographed;

    @Override
    public String toString() {
        return "Yearbook{" +
                "grade=" + grade +
                ", schoolName='" + schoolName + '\'' +
                ", type='" + type + '\'' +
                ", photoghraphed=" + photographed +
                ", edited=" + edited +
                '}';
    }

    private boolean edited;
    private int price;

    public Yearbook(int grade, String schoolName, String type, int price) {
        this.grade = grade;
        this.schoolName = schoolName;
        this.type = type;
        this.photographed = false;
        this.edited = false;
        this.price = price;
    }

    public Yearbook(int grade, String schoolName, String type, int price, boolean photographed, boolean edited) {
        this.grade = grade;
        this.schoolName = schoolName;
        this.type = type;
        this.photographed = photographed;
        this.edited = edited;
        this.price = price;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isPhotographed() {
        return photographed;
    }

    public void setPhotographed(boolean photographed) {
        this.photographed = photographed;
    }

    public boolean isEdited() {
        return edited;
    }

    public void setEdited(boolean edited) {
        this.edited = edited;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
