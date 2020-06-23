package Service;

import DataBase.DataBase;
import News.News;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewsService {
    public static PreparedStatement pstmt() {

        return null;
    }

    public boolean AddNews(News news) {
        String date = news.getNewsDate().toString();
        String sql = "insert into news (newsID,newsTitle,newsDetail,newsWriter,newsCon,newsDate,audi) values ( " + news.getNewsID() + ",'" + news.getNewsTitle() + "','" + news.getNewsDetail() + "','" + news.getNewsWriter() + "','" + news.getNewsCon() + "','" + new java.sql.Date(news.getNewsDate().getTime()) + "','" + 0 + "')";
        boolean result = DataBase.executeUpdate(sql);
        System.out.println(sql);
        return result;
    }


    public boolean DeleteNews(int newsID) {
        String sql = "delete from News where newsID = " + newsID;
        boolean result = DataBase.executeUpdate(sql);
        return result;
    }

    public boolean nomalDeleteNews(int newsID) {
        String sql = "update News set audi = " + 0 + " where newsID=" + newsID;
        System.out.println(sql);
        boolean result = DataBase.executeUpdate(sql);
        return result;
    }

    public boolean AudiNews(int newsID) {
        String sql = "update News set audi = " + 1 + " where newsID= " + newsID;
        System.out.println(sql);
        boolean result = DataBase.executeUpdate(sql);
        return result;
    }

    public boolean updateNews(News news) {
        String date = news.getNewsDate().toString();
        String sql = "update News set newsTitle=  '" + news.getNewsTitle() + "',newsDetail=  '" + news.getNewsDetail() +"', newsCon = '" + news.getNewsCon() + "', newsWriter = '" + news.getNewsWriter() + "', newsDate='" + new java.sql.Date(news.getNewsDate().getTime()) + "', audi = '" + news.getNewsAudi() + "' where newsID = " + news.getNewsID();
        System.out.println(sql);
        boolean result = DataBase.executeUpdate(sql);
        return result;
    }

    public boolean nomalupdateNews(News news) {
        String date = news.getNewsDate().toString();
        String sql = "update News set newsTitle=  '" + news.getNewsTitle() + "',newsDetail=  '" + news.getNewsDetail() + "', newsCon = '" + news.getNewsCon() + "', newsWriter = '" + news.getNewsWriter() + "', newsDate='" + new java.sql.Date(news.getNewsDate().getTime()) + "', audi = '" + 0 +"' where newsID = " + news.getNewsID();
        System.out.println(sql);
        boolean result = DataBase.executeUpdate(sql);
        return result;
    }

    public List<News> QueryNews() throws SQLException {
        String sql = "select * from News where audi = 1";
        ResultSet rs = DataBase.executeQuery(sql);
        List<News> lstNews = new ArrayList<>();
        while (rs.next()) {
            News news = new News();
            news.setNewsID(rs.getInt("newsID"));
            news.setNewsTitle(rs.getString("newsTitle"));
            news.setNewsWriter(rs.getString("newsWriter"));
            news.setNewsCon(rs.getString("newsCon"));
            news.setNewsDate(rs.getDate("newsDate"));
            news.setNewsAudi(rs.getInt("audi"));
            lstNews.add(news);
        }
        return lstNews;
    }

    public List<News> AdQueryNews() throws SQLException {
        String sql = "select * from News";
        System.out.println("list success");
        ResultSet rs = DataBase.executeQuery(sql);
        List<News> AdlstNews = new ArrayList<>();
        while (rs.next()) {
            News news = new News();
            news.setNewsID(rs.getInt("newsID"));
            news.setNewsTitle(rs.getString("newsTitle"));
            news.setNewsWriter(rs.getString("newsWriter"));
            news.setNewsCon(rs.getString("newsCon"));
            news.setNewsDate(rs.getDate("newsDate"));
            news.setNewsAudi(rs.getInt("audi"));

            AdlstNews.add(news);
        }
        return AdlstNews;
    }

    public News GetNews(int newsID) throws SQLException {
        String sql = "select * from News where newsID=" + newsID;
        ResultSet rs = DataBase.executeQuery(sql);
        News news = new News();
        if (rs.next()) {
            news.setNewsID(rs.getInt("newsID"));
            news.setNewsTitle(rs.getString("newsTitle"));
            news.setNewsWriter(rs.getString("newsWriter"));
            news.setNewsCon(rs.getString("newsCon"));
            news.setNewsDate(rs.getDate("newsDate"));
            news.setNewsDetail(rs.getString("newsDetail"));
        }
        return news;
    }

    public News AdGetNews(int newsID) throws SQLException {
        String sql = "select * from News where newsID=" + newsID;
        ResultSet rs = DataBase.executeQuery(sql);
        News news = new News();
        if (rs.next()) {
            news.setNewsID(rs.getInt("newsID"));
            news.setNewsTitle(rs.getString("newsTitle"));
            news.setNewsWriter(rs.getString("newsWriter"));
            news.setNewsCon(rs.getString("newsCon"));
            news.setNewsDate(rs.getDate("newsDate"));
            news.setNewsAudi(rs.getInt("audi"));
            news.setNewsDetail(rs.getString("newsDetail"));
        }
        return news;
    }
}
