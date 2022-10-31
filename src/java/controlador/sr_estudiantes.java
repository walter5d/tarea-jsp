
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Estudiantes;


public class sr_estudiantes extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Estudiantes estudiantes;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Empleado</title>");            
            out.println("</head>");
            out.println("<body>");
            estudiantes = new Estudiantes(request.getParameter("txt_carne"),Integer.valueOf(request.getParameter("drop_id_tipo_sangre")),Integer.valueOf(request.getParameter("txt_id")),request.getParameter("txt_nombres"),request.getParameter("txt_apellidos"),request.getParameter("txt_direccion"),request.getParameter("txt_correo"),request.getParameter("txt_telefono"),request.getParameter("txt_fn"));
            // Boton agregar 
            if ("agregar".equals(request.getParameter("btn_agregar"))){
             if (estudiantes.agregar()>0){
             response.sendRedirect("index.jsp");
             
             }else{
             out.println("<h1> xxxxxxx No se Ingreso xxxxxxxxxxxx </h1>");
             out.println("<a href='index.jsp'>Regresar...</a>");
             }
             }
            
            // Boton modificar 
            if ("modificar".equals(request.getParameter("btn_modificar"))){
             if (estudiantes.modificar()>0){
             response.sendRedirect("index.jsp");
             
             }else{
             out.println("<h1> xxxxxxx No se Modifico xxxxxxxxxxxx </h1>");
             out.println("<a href='index.jsp'>Regresar...</a>");
             }
             }
            
            // Boton eliminar 
            if ("eliminar".equals(request.getParameter("btn_eliminar"))){
             if (estudiantes.eliminar()>0){
             response.sendRedirect("index.jsp");
             
             }else{
             out.println("<h1> xxxxxxx No se Elimino xxxxxxxxxxxx </h1>");
             out.println("<a href='index.jsp'>Regresar...</a>");
             }
             }
            
            
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
