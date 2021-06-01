package app.entities;

public class PortraitPhoto extends Photo{
    public Student getCapturedStudent() {
        return capturedStudent;
    }

    public void setCapturedStudent(Student capturedStudent) {
        this.capturedStudent = capturedStudent;
    }

    Student capturedStudent;

    public PortraitPhoto(Yearbook yearbook, String filePath) {
        super(yearbook, filePath);
    }

    public PortraitPhoto(Yearbook yearbook, String filePath, Student student) {
        super(yearbook, filePath);
        this.capturedStudent = student;
    }

    public PortraitPhoto(Yearbook yearbook, String filePath, boolean edited, boolean selected) {
        super(yearbook, filePath, edited, selected);
    }

    public PortraitPhoto(Yearbook yearbook, String filePath, boolean edited, boolean selected, Student student) {
        super(yearbook, filePath, edited, selected);
        this.capturedStudent = student;
    }
}
