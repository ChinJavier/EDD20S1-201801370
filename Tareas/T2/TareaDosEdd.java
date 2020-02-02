/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareadosedd;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Javier C
 */
public class TareaDosEdd {

    /**
     * @param args the command line arguments
     */
    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    public static ArrayList<Moneda> coins = new ArrayList<Moneda>();

    public static void main(String[] args) {
        Moneda moneda = new Moneda();
        boolean menu = true;
        String opcion;
        do {
            System.out.println("***Bienvenido al sistema monetario CoinUsac***");
            System.out.println("Ingrese el número de operación que desea realizar" + '\n');
            System.out.println("1. Creación de moneda" + '\n' + "2. Listar monedas" + '\n' + "3. Cantidad de monedas por usuarios"
                    + '\n' + "4. Listar Usuarios " + '\n' + "5. Tranferencia de monedero" + '\n'
                    + "6. Transferencia entre usuarios" + '\n' + "7. Crear usario" + '\n' + "8. Salir");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    String nombre;
                    String material;
                    String existencia;
                    System.out.println("Ingrese el nombre de la moneda");
                    nombre = scanner.nextLine();
                    System.out.println("Ingrese el material");
                    material = scanner.nextLine();
                    System.out.println("Ingrese la existencia total");
                    existencia = scanner.nextLine();
                    try {
                        moneda.crearMoneda(nombre, material, Double.parseDouble(existencia));
                    } catch (Exception e) {
                        System.out.println("Ha introducido un dato invalido");
                    }

                    break;

                case "2":
                    moneda.listarMoneda();
                    break;

                case "3":
                    monedasUsuarios();
                    break;

                case "4":
                    listarUsuarios();
                    break;

                case "5":
                    transferir();
                    break;

                case "6":
                    transferenciaEntreUsuarios();
                    break;

                case "7":
                    crearUsuario();
                    break;
                case "8":
                    menu = false;
                    break;
                default:
                    System.out.println("Ingrese una opción correcta");
            }

        } while (menu);

    }

    public static void crearUsuario() {
        String nombre;
        System.out.println("Ingrese el nombre del usuario");
        nombre = scanner.nextLine();
        usuarios.add(new Usuario(nombre));
        System.out.println("Usuario creado exitosamente" + '\n');
    }

    private static void monedasUsuarios() {
        if (coins.isEmpty()) {
            System.out.println("No hay monedas" + '\n');
        } else {
            if (usuarios.isEmpty()) {
                System.out.println("No hay usuarios en el sistema" + '\n');
            } else {
                for (Usuario usuario : usuarios) {
                    System.out.println("---USUARIO: " + usuario.getNombre());
                    System.out.println(usuario.getMonedas().size());
                    for (Moneda moneda : usuario.getMonedas()) {
                        System.out.println("-Moneda: " + moneda.getNombre() + " disponible: " + moneda.getMonto());
                    }
                }
            }
        }

    }

    private static void transferir() {
        Moneda moneda = new Moneda();
        boolean existenciaMoneda = false;
        if (usuarios.isEmpty()) {
            System.out.println("NO HAY USUARIOS EN EL SISTEMA");
        } else {
            String usuarioDestino;
            System.out.println("Ingrese el usuario destino");
            usuarioDestino = scanner.nextLine();
            boolean encontrado = false;
            for (Usuario usuario : usuarios) {
                if (usuario.getNombre().equals(usuarioDestino)) {
                    encontrado = true;
                    String monedaNombre;
                    System.out.println("Ingrese la moneda a transferir");
                    monedaNombre = scanner.nextLine();
                    existenciaMoneda = moneda.existeMoneda(monedaNombre);

                    if (existenciaMoneda) {
                        double transferencia;
                        System.out.println("Ingrese el monto a transferir");
                        transferencia = scanner.nextDouble();

                        for (Moneda monedaTotal : coins) {
                            if (monedaTotal.getNombre().equals(monedaNombre)) { //Si existe la moneda
                                if ((monedaTotal.getMonto() - transferencia) >= 0) {

                                    monedaTotal.setMonto(monedaTotal.getMonto() - transferencia);

                                    if (usuario.getMonedas().isEmpty()) {
                                        usuario.setMonedas(new Moneda(monedaNombre, moneda.getMaterial(), transferencia));
                                    } else {
                                        adicionar(monedaNombre, moneda.getMaterial(), transferencia, usuario.getNombre());

                                    }

                                    System.out.println("TRANSFERENCIA EXITOSA" + '\n');

                                } else {
                                    System.out.println("No tiene la cantidad de transferencia necesaria");
                                }

                            }
                        }
                    } else {
                        System.out.println("Moneda no encontrada");
                    }

                } else {

                }
            }

            if (!encontrado) {
                System.out.println("USUARIO NO ENCONTRADO");
            }

        }
    }

    private static void listarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios en el sistema" + '\n');
        } else {
            for (Usuario usuario : usuarios) {
                System.out.println(usuario.getNombre());
            }
        }

    }

    private static void transferenciaEntreUsuarios() {

        Moneda moneda = new Moneda();
        boolean existenciaMoneda = false;
        if (usuarios.isEmpty()) {
            System.out.println("NO HAY USUARIOS EN EL SISTEMA");
        } else {
            String usuarioDestino1;
            String usuarioDestino2;
            System.out.println("Ingrese el usuario emisor");
            usuarioDestino1 = scanner.nextLine();
            System.out.println("Ingrese el usuario receptor");
            usuarioDestino2 = scanner.nextLine();

            boolean encontrado1 = false;
            boolean encontrado2 = false;

            for (Usuario usuario : usuarios) {
                if (usuario.getNombre().equals(usuarioDestino1)) {
                    encontrado1 = true;
                } else if (usuario.getNombre().equals(usuarioDestino2)) {
                    encontrado2 = true;
                } else {

                }
            }

            if (encontrado1 && encontrado2) {
//Estoy acá
                String monedaNombre;
                System.out.println("Ingrese la moneda a transferir");
                monedaNombre = scanner.nextLine();
                existenciaMoneda = moneda.existeMoneda(monedaNombre);

                if (existenciaMoneda) {

                    for (Usuario usuario1 : usuarios) {
                        if (usuario1.getNombre().equals(usuarioDestino1)) { //Obtengo el usuario emisor
                            if (usuario1.getMonedas().isEmpty()) { //Veo que tenga monedas
                                System.out.println("USTED NO TIENE MONEDAS");
                            } else {
                                double debito;
                                System.out.println("Ingrese la cantidad a transferir");
                                debito = scanner.nextDouble();

                                for (Moneda moneda1 : usuario1.getMonedas()) {
                                    if (moneda1.getNombre().equals(monedaNombre)) { //Si existe la moneda
                                        if ((moneda1.getMonto() - debito) >= 0) { //Si es mayor a 0
                                            moneda1.setMonto(moneda1.getMonto() - debito);
                                            for (Usuario usuario2 : usuarios) {
                                                if (usuario2.getNombre().equals(usuarioDestino2)) { //Obtengo el usuario receptor
                                                    if (usuario2.getMonedas().isEmpty()) {
                                                        usuario2.setMonedas(new Moneda(monedaNombre, moneda.getMaterial(), debito));
                                                    } else {
                                                        adicionar(monedaNombre, moneda.getMaterial(), debito, usuario2.getNombre());

                                                    }
                                                    System.out.println("TRANSFERENCIA EXITOSA" + '\n');
                                                }
                                            }

                                        } else {
                                            System.out.println("No tiene la cantidad de transferencia necesaria");
                                        }
                                    }
                                    /*moneda1.setMonto(moneda1.getMonto() - debito); //Le descuento al usuario 1

                                            if (usuario2.getMonedas().isEmpty()) {
                                                usuario.setMonedas(new Moneda(monedaNombre, moneda.getMaterial(), transferencia));
                                            } else {
                                                adicionar(monedaNombre, moneda.getMaterial(), transferencia, usuario.getNombre());

                                            }*/

                                }
                            }

                        }
                    }
                }

            } else {
                System.out.println("USUARIO NO ENCONTRADO");
            }

        }

    }

    private static void adicionar(String monedaNombre, String material, double transferencia, String nombreUsuario) {
        boolean bandera = false;
        Moneda monedero = new Moneda();
        for (Usuario usuario : usuarios) {
            if (usuario.getNombre().equals(nombreUsuario)) {

                for (Moneda moneda : usuario.getMonedas()) {
                    if (moneda.getNombre().equals(monedaNombre)) {
                        monedero = moneda;
                        moneda.setMonto(moneda.getMonto() + transferencia);
                        bandera = true;
                    }
                }

                if (bandera) {

                } else {
                    usuario.setMonedas(new Moneda(monedaNombre, monedero.getMaterial(), transferencia));
                }
            }

        }
    }

}
