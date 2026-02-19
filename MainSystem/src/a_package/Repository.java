/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package a_package;

/**
 *
 * @author redelyn
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Repository {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/information";
    private static final String USER = "root";
    private static final String PASSWORD = "Red123lyn45";

    public Repository() {
        createTable();
    }

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private void createTable() {
        String sql = """
            CREATE TABLE IF NOT EXISTS tbl_student (
                id INT PRIMARY KEY,
                firstName VARCHAR(100) NOT NULL,
                lastName VARCHAR(100) NOT NULL,
                age INT,
                course VARCHAR(100)
            );
            """;

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void save(Student student) {
        String sql = "INSERT INTO tbl_student(id, firstName, lastName, age, course) VALUES(?,?,?,?,?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, student.getID());
            pstmt.setString(2, student.getFIRSTNAME());
            pstmt.setString(3, student.getLASTNAME());
            pstmt.setInt(4, student.getAGE());
            pstmt.setString(5, student.getCOURSE());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Student> findAll() {
        List<Student> Students = new ArrayList<>();
        String sql = "SELECT * FROM tbl_student;";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Student student = new Student.StudentBuilder()
                        .ID(rs.getInt("id"))
                        .FIRSTNAME(rs.getString("firstName"))
                        .LASTNAME(rs.getString("lastName"))
                        .AGE(rs.getInt("age"))
                        .COURSE(rs.getString("course"))
                        .buildstudentBuilder();

                Students.add(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Students;
    }
}

