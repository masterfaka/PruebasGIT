/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provinciasBD;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mañanas
 */
@WebServlet(name = "miServlet", urlPatterns = {"/miServlet"})
public class miServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre= request.getParameter("texto");//aaki el valor del input mandado desde ajax
            ArrayList<String> localidades= new ArrayList<>();
            localidades=AccesoBdd.recuperarL(nombre);
        //ahora esto se manda a untra jsp k solo muestra json.
        //formato JSON
     /*   {
    municipios":[{"nombre":"Albacete", "id_muni":45, "id_prov":23},
                    {"nombre":"Soria", "id_muni":78, "id_prov":16},...
                    ]
            }
*/
      //formar json
      String json="{\"municipios\":[";
      for (int i = 0; i < localidades.size(); i++) {
            String loc=localidades.get(i);
            if(i==localidades.size()-1){//ultima pasada sin coma
                json+=" {\" "+loc+"\"}";
            }else{
                json+=" {\" "+loc+"\"},";
            }
        }
       json+="] }";
      //asi no se reenvia pork estamos todavia en index desde ajax y el servlet no puede autoredirect preguntar luisagain
       request.setAttribute("json", json);
       //a esto solo llega si se accede al servlet por get: pasandole la variable
       //http://localhost:8080/AjaxJson/miServlet?texto=alca
       request.getRequestDispatcher("json.jsp").forward(request, response);
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
