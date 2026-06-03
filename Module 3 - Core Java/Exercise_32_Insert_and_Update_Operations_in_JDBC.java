import java.sql.*;

public class StudentDAO {

    private static final String URL =
            "jdbc:mysql://localhost:3306/studentdb";

    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public void insertStudent(
            int id,
            String name
    ) {

        try(Connection con =
                    DriverManager.getConnection(
                            URL,
                            USER,
                            PASSWORD
                    )) {

            String sql =
                    "INSERT INTO students VALUES (?, ?)";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, id);
            ps.setString(2, name);

            ps.executeUpdate();

        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public void updateStudent(
            int id,
            String newName
    ) {

        try(Connection con =
                    DriverManager.getConnection(
                            URL,
                            USER,
                            PASSWORD
                    )) {

            String sql =
                    "UPDATE students SET name=? WHERE id=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, newName);
            ps.setInt(2, id);

            ps.executeUpdate();

        } catch(Exception e) {
            System.out.println(e);
        }
    }
}