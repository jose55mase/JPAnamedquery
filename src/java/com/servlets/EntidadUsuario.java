/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlets;

import com.entidad.Usuario;
import com.jpa.controlador.ManagerJPAUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sebcas
 */
public class EntidadUsuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EntidadUsuario</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EntidadUsuario at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAPU");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Usuario> consultaUsuario = em.createNamedQuery("Usuario.findAll", Usuario.class);
        List<Usuario> lista = consultaUsuario.getResultList();

        System.out.println("*************Usuario*********");
        for (Usuario a : lista) {
            System.out.println(a.getNombre() + ",");
        }
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("lista", lista);
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EntidadUsuario</title>");
            out.println("</head>");
            out.println("<body>");
                out.println("<a href=\"index.jsp\">Inicio</a>");
                out.println("<table>");
                    out.println("<tr>");
                        out.println("<th>Nombre</th>");
                        out.println("<th>Usuario</th>");
                        out.println("<th>Clave</th>");
                    out.println("</tr>");
                for(Usuario usuario : lista){
                    out.println("<tr>");
                        out.println("<td>"+usuario.getNombre()+"<td>");
                        out.println("<td>"+usuario.getUsuario()+"<td>");
                        out.println("<td>"+usuario.getClave()+"<td>");
                    out.println("</tr>");                    
                }
                out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String nombre = request.getParameter("nombre");
        String clave = request.getParameter("clave");
        String usuarioTxt = request.getParameter("usuario");
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setClave(clave);
        usuario.setUsuario(usuarioTxt);
        ManagerJPAUsuario managerJPAUsuario = new ManagerJPAUsuario();
        managerJPAUsuario.gurdar(usuario);

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Guardar</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Estamos listos</h1>");
            out.println("<a href=\"index.jsp\">Inicio</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
