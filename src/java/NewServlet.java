/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */


import Clases.Alumno;
import Clases.AlumnoController;
import Clases.ConexionBaseDeDatos;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JP
 */
@WebServlet(urlPatterns = {"/NewServlet"})
public class NewServlet extends HttpServlet {
    Alumno alumno;
    AlumnoController registroAlumno;
     Alumno[] alumnosRegistrados;

    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
        try ( PrintWriter respuesta = response.getWriter()) {            
            alumno=new Alumno(
                Integer.parseInt(request.getParameter("codigo")),
                request.getParameter("nombre"),
                request.getParameter("correo"),
                request.getParameter("direccion"),
                 Integer.parseInt(request.getParameter("opcion"))
            );       
            
                        
            if(registroAlumno==null){
                 registroAlumno=new AlumnoController();
            }
           
            //registroAlumno.guardarAlumno(alumno);//almacenarlo en el array
            
           if(registroAlumno.guardarAlumno2(alumno)){//almacenarlo en BD
               respuesta.println(1);
           }else{
               respuesta.println(0);
           }
           StringBuffer res = new StringBuffer();
           registroAlumno.getAlumnos2(res);
           respuesta.write(res.toString());
           respuesta.flush();
           respuesta.close();
            //alumnosRegistrados= registroAlumno.getAlumnos(); 
            
           
            /*for (int i = 0; i < alumnosRegistrados.length; i++){
                   //if(!alumnosRegistrados[i].getCodigo().isEmpty()){
                    if(alumnosRegistrados[i].getCodigo()>0){
                       respuesta.println("<tr><td>" + alumnosRegistrados[i].getCodigo()+ "</td>");
                       respuesta.println("<td>" + alumnosRegistrados[i].getNombre() + "</td>");
                       respuesta.println("<td>" + alumnosRegistrados[i].getDireccion()+ "</td>");
                       respuesta.println("<td>" + alumnosRegistrados[i].getCorreo()+ "</td>");
                       respuesta.println("<td>" + alumnosRegistrados[i].getTipo()+ "</td>");
                       respuesta.println("<td>"
                               + "<button type=\"button\" class=\"btn btn-warning\"></i>Editar</button> "
                               + "<button type=\"button\" class=\"btn btn-danger\">Eliminar</button>"
                               + "</td></tr>");
                    }
                }
            //respuesta.println(1);*/
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
