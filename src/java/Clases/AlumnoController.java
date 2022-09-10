/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author JP
 */
public class AlumnoController {
      Alumno[] tablaALumno;
    int indiceArray;
    private ConexionBaseDeDatos conectorBD;
    private Connection conexion;
    private PreparedStatement prstmt = null;
    private ResultSet result = null;
    
    public AlumnoController(){
        this.tablaALumno = new Alumno[100];
        this.indiceArray=0;
    }
    
     public void guardarAlumno(Alumno alumno){
        this.tablaALumno[this.indiceArray]=alumno;  
        this.indiceArray=this.indiceArray+1;
        // procedimiento para almacenar en la Base de Datos
    }
    
    public Alumno[] getAlumnos(){
        return this.tablaALumno;
    }
    
    public void abrirConexion(){
        conectorBD= new ConexionBaseDeDatos();
        conexion=conectorBD.conectar();
    }
    
    public boolean guardarAlumno2(Alumno alumno){        
        String sql = "INSERT INTO universidad.alumno(numero_carne, nombre, correo, genero_idgenero) ";
             sql += " VALUES( ?,?,?,?)"; 
        try{
            abrirConexion();
            prstmt = conexion.prepareStatement(sql); 
            prstmt.setString(1, alumno.getCodigo());
            prstmt.setString(2, alumno.getNombre());
            prstmt.setString(3, alumno.getCorreo());
            prstmt.setString(4, alumno.getTipo());
             int resultado = prstmt.executeUpdate(); 
                if(resultado > 0){
                    return true;
                }else{
                    return false;
                }
        }catch(SQLException e){
            String error = e.getMessage();  
            return false;
        }    
    }
    
    
}
