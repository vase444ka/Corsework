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

    public Student(long id, String fullName, Yearbook yearbook) {
        this.id = id;
        this.fullName = fullName;
        this.yearbook = yearbook;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Yearbook getYearbook() {
        return yearbook;
    }

    public void setYearbook(Yearbook yearbook) {
        this.yearbook = yearbook;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    //whether to put id or not
    private long id;
    private String fullName;
    private Yearbook yearbook;
}
