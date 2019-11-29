package servlet;

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;;

/*** NOTA: CODICE DECISAMENTE MIGLIORABILE, POCO TEMPO PER FARLO ***/

@WebServlet(name = "MyServlet", urlPatterns = { "/dizionario" })
public class Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletOutputStream out = resp.getOutputStream();
        String query = "select * from dizionario where word='" + req.getParameter("word").toLowerCase() + "'";
        JSONObject jsonResponse = new JSONObject();
        ResultSet result = performQuery(query);
        try {
            while (result.next()) {
                jsonResponse.put(result.getString("word"), result.getString("meaning"));
                out.println(jsonResponse.toJSONString());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletOutputStream out = resp.getOutputStream();
        String statement = "update Dizionario set word='" + req.getParameter("word").toLowerCase() + "', meaning='"
                + req.getParameter("meaning") + "' where word='" + req.getParameter("word").toLowerCase() + "'";
        String query = "select * from dizionario where word='" + req.getParameter("word").toLowerCase() + "'";
        boolean wordExists = false;
        ResultSet result = performQuery(query);
        try {
            while (result.next()) {
                if (result.getString("word") != null) {
                    wordExists = true;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (wordExists) {
            performUpdate(statement);
            JSONObject jsonResponse = new JSONObject();
            jsonResponse.put(req.getParameter("word").toLowerCase(), req.getParameter("meaning"));
            out.println(jsonResponse.toJSONString());
        } else {
            out.println("{'status': 'word doesn't exists'}");
        }
        out.close();
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletOutputStream out = resp.getOutputStream();
        String statement = "insert into Dizionario values ('" + req.getParameter("meaning") + "','"
                + req.getParameter("word").toLowerCase() + "')";
        String query = "select * from dizionario where word='" + req.getParameter("word").toLowerCase() + "'";
        boolean wordExists = false;
        ResultSet result = performQuery(query);
        try {
            while (result.next()) {
                if (result.getString("word") != null) {
                    wordExists = true;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (!wordExists) {
            performUpdate(statement);
            JSONObject jsonResponse = new JSONObject();
            jsonResponse.put(req.getParameter("word").toLowerCase(), req.getParameter("meaning"));
            out.println(jsonResponse.toJSONString());
        } else {
            out.println("{'status': 'word already exists'}");
        }

        out.close();
    }

    private void performUpdate(String st) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:ucanaccess://C:/Users/GioDots/Code/dodesini/5IAS/TPSIT/dizservlet-access/Dizionario.accdb;memory=false");
            Statement statement = connection.createStatement();
            statement.executeUpdate(st);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private ResultSet performQuery(String query) {
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:ucanaccess://C:/Users/GioDots/Code/dodesini/5IAS/TPSIT/dizservlet-access/Dizionario.accdb;memory=false");
            Statement statement = connection.createStatement();
            return statement.executeQuery(query);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
