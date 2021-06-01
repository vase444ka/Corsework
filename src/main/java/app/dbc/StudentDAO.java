package app.dbc;

import app.entities.Student;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentDAO {

    private static List<Student> parseFromRS(ResultSet rs) throws SQLException {
        LinkedList<Student> students = new LinkedList<>();
        while (rs.next()) {
            long id = rs.getLong("id");
            String fullName = rs.getString("full_name");
            long yearbookId = rs.getLong("yearbook_id");
            Student nextStudent = new Student(id, fullName, YearbookDAO.findByID(yearbookId));
            students.add(nextStudent);
        }
        return students;
    }

    public static boolean insert(Student student) {
        String sql = "INSERT INTO student(full_name, yearbook_id) VALUES (?,?)";
        try {
            Connection con = JDBC.getConnection();
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, student.getFullName());
            statement.setLong(2, student.getYearbook().getId());
            statement.executeUpdate();

            statement.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static List<Student> getAll() {
        String sql = "SELECT * FROM student";
        try {
            Connection con = JDBC.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<Student> res = parseFromRS(rs);
            st.close();
            con.close();
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new LinkedList<>();
    }

    public Student findByID(long id){
        String sql = "SELECT * FROM student WHERE id = ?";
        try {
            Connection con = JDBC.getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            st.setLong(1, id);
            ResultSet rs = st.executeQuery();
            Student res = parseFromRS(rs).get(0);
            st.close();
            con.close();
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<String> stringList() {
        return getAll().stream()
                .map(Student::toString)
                .collect(Collectors.toList());
    }
}
