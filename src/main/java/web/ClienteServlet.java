package web;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.sql.SQLException;

import entity.Cliente;
import data.ClienteDAO;

@WebServlet(name = "ClienteServlet", urlPatterns = {"/Cliente"})
public class ClienteServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClienteDAO dao = new ClienteDAO();
        try {
            List<Cliente> clientes = dao.selectQuery();
            request.setAttribute("clientes", clientes);
            request.getRequestDispatcher("/Cliente.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int opt = Integer.parseInt(request.getParameter("option"));
        Cliente cliente = new Cliente();
        cliente.setRfc(request.getParameter("rfc"));
        cliente.setNom_pila(request.getParameter("nombre"));
        cliente.setApellido1(request.getParameter("apellido1"));
        cliente.setApellido2(request.getParameter("apellido2"));
        cliente.setTelefono(request.getParameter("telefono"));
        cliente.setCalle(request.getParameter("calle"));
        cliente.setNumero(Integer.parseInt(request.getParameter("numero")));
        cliente.setCodigo_postal(request.getParameter("cp"));
        cliente.setCiudad(request.getParameter("ciudad"));
        cliente.setPais(request.getParameter("pais"));

        switch (opt) {
            case 1:
                insert(cliente);
                response.sendRedirect("InsertarCliente.jsp");
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

    private boolean insert(Cliente c) {
        if(c.getRfc().isEmpty())
            return false;
        if(c.getNom_pila().isEmpty())
            return false;
        if(c.getApellido1().isEmpty())
            return false;
        if(c.getApellido2().isEmpty())
            return false;
        if(c.getTelefono().isEmpty())
            return false;
        if(c.getCalle().isEmpty())
            return false;
        if(c.getNumero() < 0)
            return false;
        if(c.getCodigo_postal().isEmpty())
            return false;
        if(c.getCiudad().isEmpty())
            return false;
        if(c.getPais().isEmpty())
            return false;

        ClienteDAO dao = new ClienteDAO();

        try {
            dao.insertUpdate(c);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
