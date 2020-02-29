import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UpdateRecordServlet")
public class UpdateRecordServlet extends HttpServlet {
    DBOperations dbop = new DBOperations();
    Student student = new Student();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id_update"));
        String first_name = request.getParameter("first_name_update");
        String last_name = request.getParameter("last_name_update");
        String batch = request.getParameter("batch_update");
        String rank = request.getParameter("rank_update");

        student.setId(id);
        student.setFirstName(first_name);
        student.setLastName(last_name);
        student.setBatch(batch);
        student.setRank(rank);

        PrintWriter pw = response.getWriter();
        if (dbop.updateRecord(student)) {
            pw.println("Success");
        } else {
            pw.println("Failed");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
