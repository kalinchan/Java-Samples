package servlets;

import objects.Dog;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/example")
public class ExampleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Dog dog = new Dog("Teddy", 1, false);

        //Create JSONB
        Jsonb jsonb = JsonbBuilder.create();
        String result = jsonb.toJson(dog);
        resp.getWriter().println("Result:" + result);

        //Deserialize
        dog = jsonb.fromJson(result, Dog.class);
        resp.getWriter().println("Deserialized version: " + dog);
    }
}
