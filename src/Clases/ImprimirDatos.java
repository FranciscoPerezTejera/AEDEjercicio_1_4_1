package Clases;

import Interfaces.ValidacionRegistroContacto;
import java.time.LocalDate;

public class ImprimirDatos {

    public ImprimirDatos() {

        ValidacionRegistroContacto.ResultadoValidacion resultado;

        Contacto[] contactos = {
            new Contacto("Pedro", "pedro@gmail.com", "+34987654321", LocalDate.of(2000, 1, 15)),
            new Contacto("Jose Francisco", "josefranciscogmail.com", "+34654321098", LocalDate.of(1995, 5, 10)),
            new Contacto("Carlos", "carlos@gmail.com", "+35123456789", LocalDate.of(2003, 8, 25)),
            new Contacto("Jose Luis", "joseluis@gmail.com", "+34123456789", LocalDate.of(2006, 8, 25))

        };

        ValidacionRegistroContacto validacion = valor -> {

            if (valor.getTelefono().startsWith("+34") && valor.getEmail().contains("@")) {
                LocalDate fechaActual = LocalDate.now();
                int edad = fechaActual.getYear() - valor.getNacimiento().getYear();
                if (edad >= 18) {
                    return ValidacionRegistroContacto.ResultadoValidacion.SATISFACTORIO;
                } else {
                    return ValidacionRegistroContacto.ResultadoValidacion.NO_ES_ADULTO;
                }
            } else if (!valor.getTelefono().startsWith("+34")) {
                return ValidacionRegistroContacto.ResultadoValidacion.NUMERO_DE_CONTACTO_NO_VALIDO;
            } else {
                return ValidacionRegistroContacto.ResultadoValidacion.EMAIL_NO_VALIDO;
            }
        };

        for (int i = 0; i < contactos.length; i++) {

            Contacto contacto = contactos[i];
            resultado = validacion.apply(contacto);
            System.out.println("[i] Validacion del contacto numero (" + (i + 1) + ") con nombre " + contacto.getNombre() + ": " + resultado);

            if (!resultado.equals(ValidacionRegistroContacto.ResultadoValidacion.SATISFACTORIO)) {

                if (resultado.equals(ValidacionRegistroContacto.ResultadoValidacion.EMAIL_NO_VALIDO)) {
                    System.out.println("[!] El contacto numero (" + (i + 1) + ") con nombre: " + contacto.getNombre()
                            + ", tiene datos erroneos en el email: " + contacto.getEmail() + " 'Falta el @'");

                } else if (resultado.equals(ValidacionRegistroContacto.ResultadoValidacion.NUMERO_DE_CONTACTO_NO_VALIDO)) {
                    System.out.println("[!] El contacto numero (" + (i + 1) + ") con nombre: " + contacto.getNombre()
                            + ", tiene datos erroneos en el numero de telefono: " + contacto.getTelefono() + " no tiene el prefijo +34");

                } else if (resultado.equals(ValidacionRegistroContacto.ResultadoValidacion.NO_ES_ADULTO)) {

                    LocalDate fechaActual = LocalDate.now();
                    int edad = fechaActual.getYear() - contacto.getNacimiento().getYear();
                    System.out.println("[!] El contacto numero (" + (i + 1) + ") con nombre: " + contacto.getNombre()
                            + ", no es mayor de edad, tiene " + edad);
                }

            }
        }
    }
}
