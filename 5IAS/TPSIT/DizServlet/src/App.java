import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class App extends HttpServlet{
    
    private static final long serialVersionUID = -3967314453512919811L;
    private JSONObject jsonObject;
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java 1");
    }

    public void init() throws ServletException {
        try{
            JSONParser parser = new JSONParser();
            FileReader reader = new FileReader("C:/Users/GioDots/Code/dodesini/5IAS/TPSIT/ServletExercise1/dictionary.json");
            jsonObject = (JSONObject) parser.parse(reader);
        }catch(IOException e){
            throw new RuntimeException(e);
        }catch(Exception p){
            throw new RuntimeException(p);
        }
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
        // Setting up the content type of web page
        res.setContentType("text/html"); 

        PrintWriter out = res.getWriter();
        out.println("<h1>Hi</h1>");      
        out.println("<p>Search a word:</p>");
        out.println("<form action='http://localhost:8080/WebContent/welcome' method='post'><input type='text' name='word'></input><input type='submit'><form>");
        
    }
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException{
        res.setContentType("text/html");
        String word = req.getParameter("word");
        PrintWriter out = res.getWriter();
        String result = (String) jsonObject.get(word.toLowerCase());
        out.println("<h1>Meaning of "+word+":</h1>");
        out.println("<p>"+result+"</p");
    }
}