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
        IngenieroDAO ingd = new IngenieroDAO();
        try {
            List<Ingeniero> ing = ingd.selectQuery();
            req.setAttribute("ingenieros", ing);
            req.getRequestDispatcher("/Ingeniero.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int opt = Integer.parseInt(req.getParameter("option"));
        Ingeniero ingeniero = new Ingeniero();

        ingeniero.setCedula(req.getParameter("cedula"));
        ingeniero.setNom_pila(req.getParameter("nombre"));
        ingeniero.setApellido1(req.getParameter("primerApellido"));
        ingeniero.setApellido2(req.getParameter("segundoApellido"));
        ingeniero.setTelefono(req.getParameter("telefono"));
        ingeniero.setCalle(req.getParameter("calle"));
        ingeniero.setNumero(Integer.parseInt(req.getParameter("numero")));
        ingeniero.setCodigo_postal(req.getParameter("codigoPostal"));
        ingeniero.setCiudad(req.getParameter("ciudad"));
        ingeniero.setPais(req.getParameter("pais"));
        ingeniero.setEstudios(req.getParameter("estudios"));

        switch (opt) {
            case 1:
                if(!insert(ingeniero)){
                    break;
                }
                resp.sendRedirect("InsertarIngeniero.jsp");
                break;
            case 2:
                update(ingeniero);
                break;
            case 3:
                if(delete(ingeniero))
                   System.out.println("algo");
                break;
            default:
                resp.sendError(HttpServletResponse.SC_FORBIDDEN);
                break;
        }
    }

    private boolean insert(Ingeniero i) {
        if(i.getCedula().isEmpty())
            return false;
        if(i.getNom_pila().isEmpty())
            return false;
        if(i.getApellido1().isEmpty())
            return false;
        if(i.getTelefono().isEmpty())
            return false;
        if(i.getCalle().isEmpty())
            return false;
        if(i.getNumero() < 0)
            return false;
        if(i.getCodigo_postal().isEmpty())
            return false;
        if(i.getCiudad().isEmpty())
            return false;
        if(i.getPais().isEmpty())
            return false;
        IngenieroDAO dao = new IngenieroDAO();
        try{
            dao.insertUpdate(i);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private void update(Ingeniero i) {
        try{
            IngenieroDAO dao = new IngenieroDAO();
            dao.update(i);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean delete(Ingeniero i) {
        if(i.getCedula().isEmpty())
            return false;
        IngenieroDAO dao = new IngenieroDAO();
        try{
            dao.deleteUpdate(i);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}