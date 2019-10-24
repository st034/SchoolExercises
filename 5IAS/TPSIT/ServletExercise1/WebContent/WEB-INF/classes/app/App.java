package app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletConfig;

public class App extends HttpServlet{

    private String mymsg;

    public void init(ServletConfig config) throws ServletException 
    {  
        super.init(config);
        mymsg = config.getInitParameter("mymsg");
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
        // Setting up the content type of web page      
        res.setContentType("text/html");
        // Writing the message on the web page      
        PrintWriter out = res.getWriter();   
        String parameter = req.getParameter("v");
        out.println("<h1>" + this.mymsg + "</h1>");      
        out.println("<p>" + "Try to send me a parameter, it must be like: <b>?v=</b><i>some-text</i>" + "</p>");
        if(parameter!=null){
            out.println("<p>" + "You sent me: "+ parameter + "</p>");
        }
    }

}