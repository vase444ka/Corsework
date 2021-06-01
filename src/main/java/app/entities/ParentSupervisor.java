package app.entities;

public class ParentSupervisor {
    public ParentSupervisor(String name, String phone, Yearbook yearbook) {
        this.name = name;
        this.phone = phone;
        this.yearbook = yearbook;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Yearbook getYearbook() {
        return yearbook;
    }

    public void setYearbook(Yearbook yearbook) {
        this.yearbook = yearbook;
    }

    @Override
    public String toString() {
        return "ParentSupervisor{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", school=" + yearbook.getSchoolName() + '\'' +
                ", grade=" + yearbook.getGrade() +
                '}';
    }

    private String phone;
    Yearbook yearbook;
    private String name;
}
