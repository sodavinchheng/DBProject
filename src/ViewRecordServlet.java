import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ViewRecordServlet")
public class ViewRecordServlet extends HttpServlet {
    DBOperations dbop = new DBOperations();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id_view"));

        Student student = dbop.viewRecord(id);
        PrintWriter pw = response.getWriter();
        pw.println("Id: " + student.getId());
        pw.println("First Name: " + student.getFirstName());
        pw.println("Last Name: " + student.getLastName());
        pw.println("Batch: " + student.getBatch());
        pw.println("Rank: " + student.getRank());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
