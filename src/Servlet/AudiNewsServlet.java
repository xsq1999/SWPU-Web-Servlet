package Servlet;

import Service.NewsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/AudiNewsServlet")
public class AudiNewsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int newsId= Integer.parseInt(request.getParameter("newsID"));

        NewsService service=new NewsService();
        service.AudiNews(newsId);
        request.getRequestDispatcher("AdShowNewsServlet").forward(request,response);

    }
}
