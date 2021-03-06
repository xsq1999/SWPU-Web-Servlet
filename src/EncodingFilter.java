
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.xml.ws.WebFault;

public class EncodingFilter implements Filter { //继承Filter类
    //字符编码
    String encoding="utf-8";
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        if(encoding!=null){
            //设置request字符编码
            request.setCharacterEncoding(encoding);
            //设置response字符编码
            response.setContentType("text/html;charset="+encoding);
        }
        //传递给下一个过滤器
        chain.doFilter(request, response);
    }
    public void init(FilterConfig filterConfig) throws ServletException {
    }
    public void destroy() {
    }
}