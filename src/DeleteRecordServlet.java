import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DeleteRecordServlet")
public class DeleteRecordServlet extends HttpServlet {
    DBOperations dbop = new DBOperations();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id_delete"));

        PrintWriter pw = response.getWriter();
        if (dbop.deleteRecord(id)) {
            pw.println("Success");
        } else {
            pw.println("Failed");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
