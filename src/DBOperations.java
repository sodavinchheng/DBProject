import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBOperations {
    Connection con = null;
    public Connection getCon() throws ClassNotFoundException, SQLException {
        if (con == null) {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kit", "root", "");
        }
        return con;
    }

    public boolean insertRecord(Student student) {
        PreparedStatement ps = null;
        try {
            getCon();
            ps = con.prepareStatement("insert into students (first_name, last_name, batch, rank) values (?,?,?,?)");
            ps.setString(1, student.getFirstName());
            ps.setString(2, student.getLastName());
            ps.setString(3, student.getBatch());
            ps.setString(4, student.getRank());
            ps.execute();
            return true;
        } catch (SQLException e) {
            return false;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    public Student viewRecord(int id) {
        PreparedStatement ps = null;
        Student student = new Student();
        try {
            getCon();
            ps = con.prepareStatement("select * from students where id = ?");
            ps.setInt(1, id);
            ResultSet res = ps.executeQuery();
            res.next();

            student.setId(id);
            student.setFirstName(res.getString("first_name"));
            student.setLastName(res.getString("last_name"));
            student.setBatch(res.getString("batch"));
            student.setRank(res.getString("rank"));

            return student;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // PreparedStatement Doesn't Work For Some Reason
    public boolean updateRecord(Student student) {
//        String query = "update students set ? = ? where id = ?";
//        PreparedStatement ps = null;
        try {
            getCon();
            Statement statement = con.createStatement();
            if (student.getFirstName() != "") {
//                ps = con.prepareStatement(query);
//                ps.setString(1, "first_name");
//                ps.setString(2, student.getFirstName());
//                ps.setInt(3, student.getId());
//                ps.addBatch();
                statement.addBatch("update students set first_name = '"+ student.getFirstName() +"' where id = " + student.getId());
            }

            if (student.getLastName() != "") {
//                ps = con.prepareStatement(query);
//                ps.setString(1, "last_name");
//                ps.setString(2, student.getLastName());
//                ps.setInt(3, student.getId());
//                ps.addBatch();
                statement.addBatch("update students set last_name = '"+ student.getLastName() +"' where id = " + student.getId());
            }

            if (student.getBatch() != null) {
//                ps = con.prepareStatement(query);
//                ps.setString(1, "batch");
//                ps.setString(2, student.getBatch());
//                ps.setInt(3, student.getId());
//                ps.addBatch();
                statement.addBatch("update students set batch = '"+ student.getBatch() +"' where id = " + student.getId());
            }

            if (student.getRank() != null) {
//                ps = con.prepareStatement(query);
//                ps.setString(1, "rank");
//                ps.setString(2, student.getRank());
//                ps.setInt(3, student.getId());
//                ps.addBatch();
                statement.addBatch("update students set rank = '"+ student.getRank() +"' where id = " + student.getId());
            }

//            if (ps != null) {
//                ps.executeBatch();
//            }

            statement.executeBatch();
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteRecord(int id) {
        String query = "delete from students where id = ?";
        PreparedStatement ps = null;

        try {
            getCon();
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List viewAllRecords() {
        List<Student> arr = new ArrayList<Student>();

        try {
            getCon();
            Statement statement = con.createStatement();
            ResultSet res = statement.executeQuery("select * from students");

            while (res.next()) {
                Student student = new Student();
                student.setId(res.getInt("id"));
                student.setFirstName(res.getString("first_name"));
                student.setLastName(res.getString("last_name"));
                student.setBatch(res.getString("batch"));
                student.setRank(res.getString("rank"));
                arr.add(student);
            }
            return arr;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
