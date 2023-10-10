
package Clases;

import java.time.LocalDate;


public class Contacto {
    
    private final String nombre;
    private final String email;
    private final String telefono;
    private final LocalDate nacimiento;
    
    

    public Contacto(String nombre, String email, String telefono, LocalDate nacimiento) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.nacimiento = nacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public LocalDate getNacimiento() {
        return nacimiento;
    }

    @Override
    public String toString() {
        return "Contacto{" + "nombre=" + nombre + ", email=" + email + ", telefono=" + telefono + ", nacimiento=" + nacimiento + '}';
    }
    
    
    
    
}
