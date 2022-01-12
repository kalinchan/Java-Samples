package servlets;

import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.StringReader;
import java.util.stream.Stream;

@WebServlet("/ParseJson")
public class ParseJsonServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        if (req.getParameter("json") == null) {
            try {
                resp.sendError(422, "json parameter is missing!");
                return;
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }

        String json = req.getParameter("json");
        JsonParser parser = Json.createParser(new StringReader(json));
        while(parser.hasNext()){
            JsonParser.Event event = parser.next();
            switch (event){
                case KEY_NAME:
                case VALUE_STRING:
                    resp.getWriter().println(parser.getString());
                    break;
                case VALUE_NUMBER:
                    resp.getWriter().println(parser.getBigDecimal());
                    break;
                case VALUE_TRUE:
                    resp.getWriter().println(true);
                    break;
                case VALUE_FALSE:
                    resp.getWriter().println(false);
                    break;

            }
        }
        parser.close();
    }
}
