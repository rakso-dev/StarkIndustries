package web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

import data.FabricanteDAO;
import entity.Fabricante;

import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "FabricanteServlet", urlPatterns = {"/Fabricante"})
public class FabricanteServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FabricanteDAO dao = new FabricanteDAO();
        try {
           List<Fabricante> fabricantes = dao.selectQuery();
           request.setAttribute("fabricantes", fabricantes);
           request.getRequestDispatcher("/Fabricante.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

    }
}
