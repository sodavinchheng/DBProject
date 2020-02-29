import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ViewAllRecordsServlet")
public class ViewAllRecordsServlet extends HttpServlet {
    DBOperations dbop = new DBOperations();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> arr =  dbop.viewAllRecords();

        PrintWriter pw = response.getWriter();
        for (Student student : arr) {
            pw.println("Id: " + student.getId());
            pw.println("First Name: " + student.getFirstName());
            pw.println("Last Name: " + student.getLastName());
            pw.println("Batch: " + student.getBatch());
            pw.println("Rank: " + student.getRank());
            pw.println("===========================");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
