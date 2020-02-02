/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareadosedd;

import java.util.ArrayList;
import static tareadosedd.TareaDosEdd.coins;

/**
 *
 * @author Javier C
 */
class Usuario {

    private String nombre;
    private double cantidad;
    private  ArrayList<Moneda> monedas;

    public Usuario(String nombre) {
        this.nombre = nombre;
        this.cantidad = 0;
        this.monedas = new ArrayList<Moneda>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public ArrayList<Moneda> getMonedas() {
        return monedas;
    }

    public void setMonedas(Moneda moneda) {
        this.monedas.add(moneda);
    }

    public static boolean existeUsuario(String nombre) {
        boolean bool = false;
        for (Usuario usuario : TareaDosEdd.usuarios) {
            if (usuario.getNombre().equals(nombre)) {
                bool = true;
                break;
            }
        }
        return bool;
    }
    
    

}
