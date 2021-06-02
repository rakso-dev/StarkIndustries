package web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import data.IngenieroDAO;
import entity.Ingeniero;

import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "IngenieroServlet", urlPatterns = {"/Ingeniero"})
public class IngenieroServlet extends HttpServlet  {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        IngenieroDAO ingd = new IngenieroDAO();
        try {
            ArrayList<Ingeniero> ing = ingd.selectQuery();
            for(Ingeniero inge : ing)
                out.println(inge.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}