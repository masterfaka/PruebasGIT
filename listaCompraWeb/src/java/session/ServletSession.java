package session;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Mañanas
 */
@WebServlet(urlPatterns = {"/ServletSession"})
public class ServletSession extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */ 
    /* aki ya no pintamos.. solo codigoy o mandamos dispatchamos a  un jsp si hay e pitnar
    
    se decara accion para saber ke y de donde viene cuando se accede al servlet
    
    */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion= request.getParameter("accion");
        HttpSession session=request.getSession();
                    ArrayList<Producto> listaCliente= new ArrayList<>();
                     ArrayList<Producto> lista= AcesoBD.listarP();
        if(accion.equals("listar")){
        
                //sacar lista productos y listar, luego dispatchar
               
                    
                request.setAttribute("lista", lista);
                session.setAttribute("listaC", listaCliente);
                //la session se ve en toa las pagina pero si se mete en el request como atributo
                //se ve solo en el ke lo manda y en el jsp dnd llega
                //las esion se guarda info sensible..e sto va en el request
                request.getRequestDispatcher("listaProductos.jsp").forward(request, response);//enviamos la lista para luego pintarla
                //aki se crea la lista de compras 
                //para tenerla desde el principio y luego al tenerla en la Session se puede recuperar y añadir datos+
                // se sabe en todo momento cuantos prdctos tenemos seleccionados
                
                
        }else if(accion.equals("comprar")){
            //get add set para actualizar la lista de compra  guardada en la sesion,mientras el usuario este comprando
                //peta pork en el jsp cojemos la listaTotal y habra ke mandarla siempre
            int id= Integer.parseInt(request.getParameter("id"));
            Producto p =AcesoBD.recuperarp(id);//sacamos el producto con esa id de la bd para guardarlo en la listaCompra
            listaCliente=(ArrayList<Producto>)session.getAttribute("listaC");//asi se recupera la lista anterior para luego actualizarla
            //cada vez ke entra al servlet de redeclara todo, por eso
            //se coge de la sesion ke es la unica var ke perdura
            //aki modifico el stock
                //p.setStock(p.getStock()-1);
            //actualizamos valor en bdd
            AcesoBD.modificarS(p.getId());
            listaCliente.add(p);//ahora tenemos la lista actualizada y la subimos a la sesion
            session.setAttribute("listaC", listaCliente);
            request.setAttribute("lista", lista);
            request.getRequestDispatcher("listaProductos.jsp").forward(request, response);//enviamos la lista para luego pintarla again? 
        }else if(accion.equals("comprobar")){
            String usuario= request.getParameter("usuario");
            String pass= request.getParameter("contra");
            boolean OK=AcesoBD.comprobar(usuario, pass);
            if(OK){//recargamos con la sesion
             session.setAttribute("usuario", usuario);
             request.getRequestDispatcher("index.jsp").forward(request, response);
            }else{//enviar a una pagina de rror
             //request.getRequestDispatcher("listaProductos.jsp").forward(request, response);
            }
        
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
