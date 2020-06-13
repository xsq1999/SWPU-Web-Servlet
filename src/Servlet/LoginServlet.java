package Servlet;

import DataBase.DataBase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter(); //获得输出流

        String name = request.getParameter("name");
        String password = URLEncoder.encode(request.getParameter("password"),"utf-8");//password转码
        DataBase db = new DataBase();
        if (db.login(name, password)) {
            System.err.println("\n\n======================SUCCESS\n\n");
            response.getWriter().println("<h1>ssssssssssssssssssssssssssss</h1>");
//            request.getRequestDispatcher("/show.html").forward(request, response);
        } else {
            String fail = "<script type='text/javascript'>" +
                    "alert('用户名或密码错误！');" +
                    "location.href='login.html';</script>";
            out.println(fail);
        }
        db.Clocec();
        out.close();
    }
    /**
     * 你他妈 这不会没有登陆成功吧 ???不会吧我该之前实可以的没有啊我才发现我之前那个失败和成功都没有报连接数据库那你看看database
     * */
//#region
    protected void Log_Cookie(String name, String password, HttpServletResponse response) throws UnsupportedEncodingException {
        String cname = URLEncoder.encode(name, "UTF-8");//重新编码中文存入cookie
        Cookie cookienm = new Cookie("name", cname);
        cookienm.setMaxAge(60 * 60 * 30 * 24);
        response.addCookie(cookienm);//账号cookie

        String pname = URLEncoder.encode(password, "UTF-8");//重新编码中文存入cookie
        Cookie cookieps = new Cookie("password", pname);
        cookieps.setMaxAge(60 * 60 * 30 * 24);
        response.addCookie(cookieps);//密码cookie
    }

    protected void Log_Session(HttpServletResponse response) {

    }
//#endregion
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
