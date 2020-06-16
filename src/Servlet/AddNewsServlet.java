package Servlet;

import News.News;
import Service.NewsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(urlPatterns = "/AddNewsServlet")
public class AddNewsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        News news=new News();
        news.setNewsID(Integer.parseInt(request.getParameter("newsID")));
        news.setNewsTitle(request.getParameter("newsTitle"));
        String newsDate=request.getParameter("newsDate");
        SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date date= null;
        try {
            date = sDateFormat.parse(newsDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        news.setNewsDate(date);
        news.setNewsCon(request.getParameter("newsCon"));
        news.setNewsWriter(request.getParameter("newsWriter"));


        NewsService service=new NewsService();
        service.AddNews(news);
        request.getRequestDispatcher("ShowNewsServlet").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
