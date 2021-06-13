package web;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.sql.SQLException;

import data.DistribuidorDAO;
import entity.Distribuidor;

@WebServlet(name = "DistribuidorServlet", urlPatterns = {"/Distribuidor"})
public class DistribuidorServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DistribuidorDAO dao = new DistribuidorDAO();
        try {
            List<Distribuidor> distribuidores = dao.selectQuery();
            request.setAttribute("distribuidores", distribuidores);
            request.getRequestDispatcher("/Distribuidor.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int opt = Integer.parseInt(request.getParameter("option"));

        Distribuidor distribuidor = new Distribuidor();
        distribuidor.setRfc(request.getParameter("rfc"));
        distribuidor.setNombre(request.getParameter("nombre"));
        distribuidor.setCalle(request.getParameter("calle"));
        distribuidor.setNumero(Integer.parseInt(request.getParameter("numero")));
        distribuidor.setCodigo_postal(request.getParameter("codigoPostal"));
        distribuidor.setCiudad(request.getParameter("ciudad"));
        distribuidor.setPais(request.getParameter("pais"));

        switch (opt) {
            case 1:
                if(insert(distribuidor))
                   break;
                response.sendRedirect("InsertarDistribuidor.jsp");
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

    private boolean insert(Distribuidor d) {
        if(d.getRfc().isEmpty())
            return false;
        if(d.getNombre().isEmpty())
            return false;
        if (d.getCalle().isEmpty())
            return false;
        if(d.getNumero() < 0)
            return false;
        if(d.getCodigo_postal().isEmpty())
            return false;
        if(d.getCiudad().isEmpty())
            return false;
        if(d.getPais().isEmpty())
            return false;
        DistribuidorDAO dao = new DistribuidorDAO();
        try{
            dao.insertUpdate(d);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
