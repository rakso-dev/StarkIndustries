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
import java.util.List;

@WebServlet(name = "IngenieroServlet", urlPatterns = {"/Ingeniero"})
public class IngenieroServlet extends HttpServlet  {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        IngenieroDAO ingd = new IngenieroDAO();
        try {
            List<Ingeniero> ing = ingd.selectQuery();
            req.setAttribute("ingenieros", ing);
            req.getRequestDispatcher("Ingeniero.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int opt = Integer.parseInt(req.getParameter("action"));
        Ingeniero ingeniero = new Ingeniero();

        ingeniero.setCedula(req.getParameter("Cedula"));
        ingeniero.setNom_pila(req.getParameter("Nombre"));
        ingeniero.setApellido1(req.getParameter("PrimerApellido"));
        ingeniero.setApellido2(req.getParameter("SegundoApellido"));


        IngenieroDAO act = new IngenieroDAO();
        try {
            switch (opt) {
                case 1:
                    act.insertUpdate(ingeniero);
                    break;
                case 2:
                    act.update(ingeniero);
                    break;
                case 3:
                    act.deleteUpdate(ingeniero);
                    break;
                default:
                    resp.sendError(HttpServletResponse.SC_FORBIDDEN);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}