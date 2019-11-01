import java.io.*;
import java.nio.file.*;
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
            FileReader reader = new FileReader("C:/Users/GioDots/Code/dodesini/5IAS/TPSIT/DizServlet/dictionary.json");
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
        String word = req.getParameter("word");
        if(word != null){
            returnMeaning(req,res, word);
        }else{
            PrintWriter out = res.getWriter();
            out.println("<h1>Hi</h1>");      
            out.println("<p>Search a word:</p>");
            out.println("<form action='http://localhost:8080/WebContent/welcome' method='get'>"+
                        "<input type='text' name='word'><br>"+
                        "<input type='submit'>"+
                        "</form>");
            out.println("<p>Add word:</p>"+
                        "<form action='http://localhost:8080/WebContent/welcome' method='post'>"+
                        "Parola: <input type='text' name='addword'><br>"+
                        "Significato: <input type='text' name='meaning'><br>"+
                        "<input type='submit'>"+
                        "</form>");
        }
    }
    public void doPut(HttpServletRequest req, HttpServletResponse res) throws IOException{
        res.setContentType("text/html");
        addWord(req, res);
    }
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException{
        res.setContentType("text/html");
        modifyWord(req, res)
    }
    private void returnMeaning(HttpServletRequest req, HttpServletResponse res, String word) throws IOException{
        PrintWriter out = res.getWriter();
        String result = (String) jsonObject.get(word.toLowerCase());
        out.println("<h1>Meaning of "+word+":</h1>");
        out.println("<p>"+result+"</p");
    }
    private void addWord(HttpServletRequest req, HttpServletResponse res) throws IOException{
        res.setContentType("text/html");
        String filename= "C:/Users/GioDots/Code/dodesini/5IAS/TPSIT/DizServlet/dictionary.json";
        String word = req.getParameter("addword");
        String meaning = req.getParameter("meaning");
        jsonObject.put(word.toLowerCase(), meaning);
        Files.write(Paths.get(filename), jsonObject.toJSONString().getBytes());
        PrintWriter out = res.getWriter();
        out.println("<h2>Added:</h2>"+
                    "<ul><li>"+word+": "+meaning+"</li></ul>");
    }
    private void modifyWord(HttpServletRequest req, HttpServletResponse res){
        req.getParameter("word");
    }
}