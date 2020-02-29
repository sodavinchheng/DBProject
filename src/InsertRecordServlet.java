import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "InsertRecordServlet")
public class InsertRecordServlet extends HttpServlet {
    Student student = new Student();
    DBOperations dbop = new DBOperations();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String first_name = request.getParameter("first_name_insert");
        String last_name = request.getParameter("last_name_insert");
        String batch = request.getParameter("batch_insert");
        String rank = request.getParameter("rank_insert");

        student.setFirstName(first_name);
        student.setLastName(last_name);
        student.setBatch(batch);
        student.setRank(rank);

        PrintWriter pw = response.getWriter();

        if (dbop.insertRecord(student)) {
            pw.println("Success");
        } else {
            pw.println("Failed");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
