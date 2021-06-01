package app.entities;

public class Student {
    @Override
    public String toString() {
        return "Student{" +
                "fullName='" + fullName + '\'' +
                ", school=" + yearbook.getSchoolName() + '\'' +
                ", grade=" + yearbook.getGrade() +
                '}';
    }

    public Student(String fullName, Yearbook yearbook) {
        this.fullName = fullName;
        this.yearbook = yearbook;
    }

    public Student(String fullName, String tgUsername, Yearbook yearbook) {
        this.fullName = fullName;
        this.tgUsername = tgUsername;
        this.yearbook = yearbook;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getTgUsername() {
        return tgUsername;
    }

    public void setTgUsername(String tgUsername) {
        this.tgUsername = tgUsername;
    }

    public Yearbook getYearbook() {
        return yearbook;
    }

    public void setYearbook(Yearbook yearbook) {
        this.yearbook = yearbook;
    }

    //whether to put id or not
    private String fullName;
    private String tgUsername;
    Yearbook yearbook;
}
