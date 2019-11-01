import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class App extends HttpServlet{
    
    private static final long serialVersionUID = -3967314453512919811L;
    private JSONObject jsonObject;
    private static final String filename= "C:/Users/GioDots/Code/dodesini/5IAS/TPSIT/DizServletJSON/dictionary.json";
    
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java 1");
    }

    public void init() throws ServletException {
        try{
            JSONParser parser = new JSONParser();
            FileReader reader = new FileReader(filename);
            jsonObject = (JSONObject) parser.parse(reader);
        }catch(IOException e){
            throw new RuntimeException(e);
        }catch(Exception p){
            throw new RuntimeException(p);
        }
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
        // Setting up the content type of web page
        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        String word = req.getParameter("word");
        if(word != null){
            returnMeaning(req,res, word);
        }else{
            PrintWriter out = res.getWriter();
            out.println("{}");
        }
    }
    public void doPut(HttpServletRequest req, HttpServletResponse res) throws IOException{
        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        addWord(req, res);
    }
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException{
        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        modifyWord(req, res);
    }
    private void returnMeaning(HttpServletRequest req, HttpServletResponse res, String word) throws IOException{
        PrintWriter out = res.getWriter();
        JSONArray result = (JSONArray) jsonObject.get(word.toLowerCase());
        JSONObject obj = new JSONObject();
        obj.put(word, result);
        out.println(obj);
        
    }
    private void addWord(HttpServletRequest req, HttpServletResponse res) throws IOException{
        String word = req.getParameter("word");
        String meaning = req.getParameter("meaning");
        JSONObject result = new JSONObject();
        if(jsonObject.get(word) == null){
            JSONArray arr = new JSONArray();
            arr.add(meaning);
            jsonObject.put(word, arr);
            result.put(word, arr);
        }else{
            JSONArray arr = (JSONArray) jsonObject.get(word);
            arr.add(meaning);
            jsonObject.put(word, arr);
            result.put(word, arr);
        }
        try (FileWriter file = new FileWriter(filename)) {
            file.write(jsonObject.toJSONString());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter out = res.getWriter();
        out.println(result);
    }
    private void modifyWord(HttpServletRequest req, HttpServletResponse res) throws IOException{
        String word = req.getParameter("word");
        String meaning = req.getParameter("meaning");
        int index = (req.getParameter("index") == null) ? Integer.parseInt(req.getParameter("index")) : 0;
        PrintWriter out = res.getWriter();
        if(jsonObject.get(word) != null){
            JSONArray arr = (JSONArray) jsonObject.get(word);
            arr.remove(index);
            arr.add(index, meaning);
            JSONObject obj = new JSONObject();
            obj.put(word, arr);
            jsonObject.replace(word.toLowerCase(), arr);
            try (FileWriter file = new FileWriter(filename)) {
                file.write(jsonObject.toJSONString());
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }   
            out.println(obj);
        }else{
            JSONObject obj = new JSONObject();
            obj.put("result", "word not found");
            out.println(obj);
        }
    }
}