package servlets;

import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Stream;

@WebServlet("/CreateJson")
public class CreateJsonServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        //Create JSON With Name, Age and In Education Param
        if (Stream.of("name", "age", "inEducation").anyMatch(param -> req.getParameter(param) == null)) {
            try {
                resp.sendError(422, "Parameter is missing, required parameters are name, age and inEducation");
                return;
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }

        JsonObject jsonObject = Json.createObjectBuilder()
                .add("name", req.getParameter("name"))
                .add("age", Integer.valueOf(req.getParameter("age")))
                .add("inEducation", Boolean.valueOf(req.getParameter("inEducation"))).build();

        resp.getWriter().println(jsonObject.toString());
    }
}
