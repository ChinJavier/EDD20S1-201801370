/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareadosedd;

import java.util.Iterator;
import jdk.nashorn.internal.objects.NativeArray;
import static tareadosedd.TareaDosEdd.coins;
import static tareadosedd.TareaDosEdd.scanner;

/**
 *
 * @author Javier C
 */
public class Moneda {

    private String nombre;
    private String material;
    private double monto;

    public Moneda() {

    }

    public Moneda(String nombre, String material, double monto) {
        this.nombre = nombre;
        this.material = material;
        this.monto = monto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public static void crearMoneda(String nombre, String material, double monto) {
        coins.add(new Moneda(nombre, material, monto));
    }

    public static void nombrarMoneda(String nombre) {

    }

    public static void listarMoneda() {
        if (coins.isEmpty()) {
            System.out.println("No hay monedas en el sistema" + '\n');
        } else {
            System.out.println("***Las monedas existentes son: ");
            for (Moneda moneda : coins) {
                System.out.println(moneda.getNombre() + " tiene de existencia: " + moneda.getMonto());

            }
        }
    }

    public static boolean existeMoneda(String nombre) {
        boolean bool = false;
        for (Moneda moneda : coins) {
            if (moneda.getNombre().equals(nombre)) {
                bool = true;
                break;
            }
        }
        return bool;
    }

}
