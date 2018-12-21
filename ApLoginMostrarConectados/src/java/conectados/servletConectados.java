/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conectados;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mañanas
 */
@WebServlet(name = "servletConectados", urlPatterns = {"/servletConectados"})
public class servletConectados extends HttpServlet {

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
         ServletContext aplicacion=request.getServletContext();
         ArrayList<Persona> conectados=(ArrayList<Persona>)aplicacion.getAttribute("lista");
          ArrayList<Persona> lista;
         if (conectados==null)//se puede comprobar nullm aunke nos e utilice y no peta
         {
         lista= new ArrayList<Persona>();
         }else
         {
           lista=conectados; 
         }
         
        String n= request.getParameter("nombre");
        String c= request.getParameter("contra");
        String texto="";
        Persona p= new Persona(n, c);
        boolean ok=AcesoBd.comprobarU(p);
        if(ok){
            //ir pagina secreta saludar, añadir a la lista total
            //recuperamos la lista actual
            
            lista.add(p);
            texto+="Saludos" +p.getNombre()+"!";
         
            for (int i = 0; i < lista.size(); i++) {   //añadir conectados  
                if(i==0){
                texto+=" Ahora estan conectados: ";
                }
                     texto+=lista.get(i).getNombre()+", ";
                   }
                 //aclualizamos la lista en aplicacion.
            aplicacion.setAttribute("lista", lista);
            
            request.setAttribute("texto", texto);
            request.setAttribute("loginOk", ok);
            request.getRequestDispatcher("index.jsp").forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
