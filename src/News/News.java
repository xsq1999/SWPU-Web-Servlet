package News;

import java.util.Date;

public class News {
    int newsID;
    String newstitle;
    String newsWriter;
    //    String Session;
    String newsDetail;
    String newsCon;
    Date newsDate;
    int newsAudi;

    //ID
    public int getNewsID() {
        return newsID;
    }

    public void setNewsID(int newsID) {
        this.newsID = newsID;
    }

    //news
    public String getNewsTitle() {
        return newstitle;
    }

    public void setNewsTitle(String newstitle) {
        this.newstitle = newstitle;
    }

    //作者
    public String getNewsWriter() {
        return newsWriter;
    }

    public void setNewsWriter(String newsWriter) {
        this.newsWriter = newsWriter;
    }

    //类型
    public String getNewsCon() {
        return newsCon;
    }

    public void setNewsCon(String newsCon) {
        this.newsCon = newsCon;
    }

    //时间
    public Date getNewsDate() {
        return newsDate;
    }

    public void setNewsDate(Date newsDate) {
        this.newsDate = newsDate;
    }

    //在线人数
//    public String getSession() {
//        return Session;
//    }
//
//    public void setSession(String Session) {
//        this.Session = Session;
//    }
    //审核状态
    public int getNewsAudi() {
        return newsAudi;
    }

    public void setNewsAudi(int newsAudi) {
        this.newsAudi = newsAudi;
    }

    //新闻内容
    public String getNewsDetail() {
        return newsDetail;
    }

    public void setNewsDetail(String newsDetail) {
        this.newsDetail = newsDetail;
    }
}
