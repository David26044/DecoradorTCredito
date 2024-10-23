/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mundo;

/**
 *
 * @author ACER
 */
public class SolicitudTarjetaDecorator implements ISolicitudTarjeta {

    protected ISolicitudTarjeta solicitudDecorada;

    public SolicitudTarjetaDecorator(ISolicitudTarjeta solicitudDecorada) {
        this.solicitudDecorada = solicitudDecorada;
    }

    @Override
    public TarjetaCredito iniciarSolicitud() {
        // Ejecuta la solicitud decorada(original)
        TarjetaCredito tarjeta = solicitudDecorada.iniciarSolicitud();

        // Agrego el comportamiento de notificación después
        notificar(tarjeta);

        return tarjeta;
    }

    private void notificar(TarjetaCredito tarjeta) {
        if (tarjeta != null) {
            System.out.println("Notificación: Su tarjeta de crédito ha sido aprobada.");
        } else {
            System.out.println("Notificación: Lamentablemente, su solicitud de tarjeta de crédito fue rechazada.");
        }
    }
}
