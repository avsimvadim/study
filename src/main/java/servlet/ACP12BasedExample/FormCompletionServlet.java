package servlet.ACP12BasedExample;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/form"})
public class FormCompletionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/form.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login  = req.getParameter("login");
        String password =  req.getParameter("password");
        String message;
        if ((login.isEmpty() || login == null) && (!password.isEmpty() && password != null)){
            message = "enter login field";
            req.setAttribute("message", message);
            req.getRequestDispatcher("/WEB-INF/error.jsp").forward(req,resp);
        } else if ((password.isEmpty() || password == null) && (!login.isEmpty() && login != null)) {
            message = "enter password field";
            req.setAttribute("message", message);
            req.getRequestDispatcher("/WEB-INF/error.jsp").forward(req, resp);
        } else if(password.isEmpty() || password == null || login.isEmpty() || login == null){
            message = "enter password and login fields";
            req.setAttribute("message", message);
            req.getRequestDispatcher("/WEB-INF/error.jsp").forward(req, resp);
        } else {
            int id = (int)(Math.random() * 10000);
            req.setAttribute("login", login);
            req.setAttribute("password", password);
            req.setAttribute("id", id);
            req.getRequestDispatcher("/WEB-INF/client-info.jsp").forward(req,resp);
        }
    }
}
