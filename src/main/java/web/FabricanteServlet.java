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
        int opt = Integer.parseInt(request.getParameter("option"));

        Fabricante fabricante = new Fabricante();
        fabricante.setRfc(request.getParameter("rfc"));
        fabricante.setNombre(request.getParameter("nombre"));
        fabricante.setCalle(request.getParameter("calle"));
        fabricante.setNumero(Integer.parseInt(request.getParameter("numero")));
        fabricante.setCodigo_postal(request.getParameter("codigoPostal"));
        fabricante.setCiudad(request.getParameter("ciudad"));
        fabricante.setPais(request.getParameter("pais"));

        insert(fabricante);

        switch (opt) {
            case 1:
                if(!insert(fabricante)){
                    break;
                }
                response.sendRedirect("/InsertarFabricante.jsp");
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                response.sendError(HttpServletResponse.SC_FORBIDDEN);
                break;
        }


    }

    private boolean insert(Fabricante f) {
        if(f.getRfc().isEmpty())
            return false;
        if(f.getNombre().isEmpty())
            return false;
        if(f.getCalle().isEmpty())
            return false;
        if(f.getNumero() < 0)
            return false;
        if(f.getCodigo_postal().isEmpty())
            return false;
        if(f.getCiudad().isEmpty())
            return false;
        if(f.getPais().isEmpty())
            return false;
        FabricanteDAO dao = new FabricanteDAO();
        try {
            dao.insertUpdate(f);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
