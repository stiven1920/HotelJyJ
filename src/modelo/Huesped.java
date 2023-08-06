/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Jopcion
 */
public class Huesped {
    
      //creamos los atributos necesarios para la clase Huesped haciendo el debido mapeo
    private int cedula;
    private String nombre;
    private String apellido;
    private int telefono;
    private String direccion;
    private String correo;
    private String contrasenia;
    //creamos el constructor
    
    public Huesped(){}
    
    public Huesped(int cedula, String nombre, String apellido, int telefono, String direccion, String correo, String contrasenia) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
        this.contrasenia = contrasenia;
    }

    public Huesped(String user, int contraseña) {
      this.correo = user;
      this.cedula = contraseña;
    }
    //luego sus respectivos setters y getters
    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    
}
