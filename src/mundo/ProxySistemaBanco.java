/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mundo;

/**
 *
 * @author ACER
 */
public class ProxySistemaBanco implements IOperacionSistema {

    SistemaBanco sistema;
    
    @Override
    public TarjetaCredito procesarSolicitud(int puntajeDataCredito) {

        if (puntajeDataCredito < 700) { //Se ahorra el tener que ir al sistema para procesar todo, ahora solo ira al sistema si la persona cumple el requisito
            return null;
        }
        if (sistema == null) {
            sistema = SistemaBanco.getInstance(); // Aquí se inicializa
        }
        return sistema.procesarSolicitud(puntajeDataCredito);
    }

}
