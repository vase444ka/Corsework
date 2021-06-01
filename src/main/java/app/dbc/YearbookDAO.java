package app.dbc;

import app.entities.Yearbook;

import java.io.InputStream;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class YearbookDAO {
    private static List<Yearbook> parseFromRS(ResultSet rs) throws SQLException {
        LinkedList<Yearbook> yearbook = new LinkedList<>();
        while (rs.next()) {
            int grade = rs.getInt("grade");
            String school_name = rs.getString("school_name");
            String type = rs.getString("type");
            boolean photographed = rs.getBoolean("is_photographed");
            boolean edited = rs.getBoolean("is_edited");
            int price = rs.getInt("price");
            Yearbook nextYearbook = new
                    Yearbook(grade, school_name, type, price, photographed, edited);
            yearbook.add(nextYearbook);

        }
        return yearbook;
    }

    public static boolean insert(Yearbook yearbook, InputStream inp) {
        String sql = "INSERT INTO yearbook(grade, school_name, type, is_photographed, is_edited, price) VALUES (?,?,?,?,?,?)";
        try {
            Connection con = JDBC.getConnection(inp);
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, yearbook.getGrade());
            statement.setString(2, yearbook.getSchoolName());
            statement.setString(3, yearbook.getType());
            statement.setBoolean(4, yearbook.isPhotographed());
            statement.setBoolean(5, yearbook.isEdited());
            statement.setInt(6, yearbook.getPrice());
            statement.executeUpdate();

            statement.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static List<Yearbook> getAll(InputStream inp) {
        String sql = "SELECT * FROM yearbook";
        try {
            Connection con = JDBC.getConnection(inp);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<Yearbook> res = parseFromRS(rs);
            st.close();
            con.close();
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new LinkedList<>();
    }

    public static List<String> stringList(InputStream inp) {
        return getAll(inp).stream()
                .map(Yearbook::toString)
                .collect(Collectors.toList());
    }
}
