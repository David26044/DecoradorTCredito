/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mundo;

import java.util.Date;

/**
 *
 * @author ACER
 */
public class SolicitudTarjeta implements ISolicitudTarjeta{

    private String estado;
    private Date fecha;
    private Persona cliente;
    private Asesor asesor;

    public SolicitudTarjeta(Date fecha, Persona cliente) {
        this.fecha = fecha;
        this.cliente = cliente;
        estado = "En espera";
        asesor = GestorAsesores.getInstance().getAsesorAleatorio();
    }
    
   public TarjetaCredito iniciarSolicitud(){
       System.out.println(estado);
       System.out.println("     Se le asignó el asesor: " + asesor.getNombre());
       
       //Si no hay asesores en el gestor no hay quien procese la solicitud
       if (asesor == null) {
           estado = "No se pudo procesar la solicitud";
           System.out.println( estado + "no hay asesores disponibles");
           return null;
       }
       //Si hay un asesor asignado entonces comienza a procesar la solicitud
       TarjetaCredito tarjetaCliente = asesor.manejarSolicitud(cliente.getPuntajeDataCredito());
       //Si la tarjeta es null es porque no cumple con el puntaje minimo
       if (tarjetaCliente == null) {
           estado = "Rechazado";
           return null;
       }
       //La tarjeta retornada no es null. Por lo tanto, si fue aprobada
       estado = "Aprobado";
       return tarjetaCliente;
   }
    
}
