/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

public class Alumno {
    private String codigo;
    private String nombre;
    private String correo;
    private String direccion;
    Alumno[] tablaALumno;
    int indiceArray;
    
    public Alumno(String codigo, String nombre, String correo, String direccion){
        this.codigo=codigo;
        this.nombre=nombre;
        this.correo=correo;
        this.direccion=direccion;      
        this.tablaALumno = new Alumno[100];
        this.indiceArray=0;
    }
    
    public Alumno(){
        this.nombre="Alumno de ejemplo";
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public void guardarAlumno(Alumno alumno){
        this.tablaALumno[this.indiceArray]=alumno;  
        this.indiceArray=this.indiceArray+1;
    }
    
    public Alumno[] getAlumnos(){
        return this.tablaALumno;
    }
    
}
