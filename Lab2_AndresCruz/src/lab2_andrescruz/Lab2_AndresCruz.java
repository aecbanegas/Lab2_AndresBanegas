/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2_andrescruz;

/**
 *
 * @author MBanegas
 */
import java.util.*;
import javax.swing.JOptionPane;

public class Lab2_AndresCruz {

    static Scanner s = new Scanner(System.in);
    static ArrayList<Avion> lista = new ArrayList();
    static String[] login = {"Xatruch", "anelcruba"};

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int opc = 0;
        boolean flag = false;
        while (opc != 4) {
            System.out.println("Usuario para login: " + login[0]);
            System.out.println("Contraseña para login: " + login[1]);
            System.out.println("Menu\n"
                    + "Opcion 1: Registro de los aviones\n"
                    + "Opcion 2: Manejo del trafico\n"
                    + "Opcion 3: Log in\n"
                    + "Opcion 4: Salir\n"
                    + "Ingrese su opcion: ");
            opc = s.nextInt();
            while (opc <= 0 || opc >= 5) {
                System.out.println("Menu\n"
                        + "Opcion 1: Registro de los aviones\n"
                        + "Opcion 2: Manejo del trafico\n"
                        + "Opcion 3: Log in\n"
                        + "Opcion 4: Salir\n"
                        + "Ingrese su opcion: ");
                opc = s.nextInt();
            }
            if (opc == 3) {
                System.out.println("Ingrese su usuario: ");
                String usuario = s.next();
                System.out.println("Ingrese la contraseña: ");
                String contra = s.next();
                flag = Log(usuario, contra);
                if (flag) {
                    System.out.println("Bienvenido!!!");
                } else {
                    System.out.println("Usuario o Contraseña Incorrectos");
                }
            }
            if (flag) {
                if (opc == 1) {
                    Registro();
                }
                if (opc == 2) {
                    ManejoTrafico();
                }
            } else {
                System.out.println("Debe iniciar su sesion.");
            }
        }
    }

    public static void ManejoTrafico() {
        int contesp = 0, contlisto = 0;
        String Estacionado = "", Espera = "", Listo = "", Vuelo = "";
        for (Object temp : lista) {
            if (temp instanceof Avion) {
                if (((Avion) temp).getEstado().equals("Estacionado")) {
                    Estacionado += lista.indexOf(temp) + "- " + temp + "\n";
                }
                if (((Avion) temp).getEstado().equals("Espera")) {
                    contesp++;
                    Espera += lista.indexOf(temp) + "- " + temp + "\n";
                }
                if (((Avion) temp).getEstado().equals("Listo")) {
                    contlisto++;
                    Listo += lista.indexOf(temp) + "- " + temp + "\n";
                }
                if (((Avion) temp).getEstado().equals("Vuelo")) {
                    Vuelo += lista.indexOf(temp) + "- " + temp + "\n";
                }
            }
        }
        System.out.println("Los aviones estacionados son: \n" + Estacionado);
        System.out.println("Los aciones en espera son: \n" + Espera);
        System.out.println("Los aviones listos son: \n" + Listo);
        System.out.println("Los aviones en vuelo son: \n" + Vuelo);
        System.out.println("Ingrese la posicion en la lista del avion para cambiar su estado: ");
        int posicion = s.nextInt();
        while (posicion < 0 || posicion >= lista.size()) {
            System.out.println("Ingrese la posicion en la lista del avion para cambiar su estado: ");
            posicion = s.nextInt();
        }
        if (((Avion) lista.get(posicion)).getEstado().equals("Vuelo")) {
            System.out.println("Cambios de estado posibles:\n"
                    + "1- Estacionado\n"
                    + "2- Vuelo\n"
                    + "Ingrese su opcion: ");
            int opc = s.nextInt();
            while (opc != 1 && opc != 2) {
                System.out.println("Cambios de estado posibles:\n"
                        + "1- Estacionado\n"
                        + "2- Vuelo\n"
                        + "Ingrese su opcion: ");
                opc = s.nextInt();
            }
            if (opc == 1) {
                ((Avion) lista.get(posicion)).setEstado("Estacionado");
            }
            if (opc == 2) {
                ((Avion) lista.get(posicion)).setEstado("Vuelo");
            }
        } else {
            if (((Avion) lista.get(posicion)).getEstado().equals("Estacionado") && contesp <= 10) {
                System.out.println("Cambios de estado posibles:\n"
                        + "1- Espera\n"
                        + "2- Estacionado\n"
                        + "Ingrese su opcion: ");
                int opc = s.nextInt();
                while (opc != 1 && opc != 2) {
                    System.out.println("Cambios de estado posibles:\n"
                            + "1- Espera\n"
                            + "2- Estacionado\n"
                            + "Ingrese su opcion: ");
                    opc = s.nextInt();
                }
                if (opc == 1) {
                    ((Avion) lista.get(posicion)).setEstado("Espera");
                }
                if (opc == 2) {
                    ((Avion) lista.get(posicion)).setEstado("Estacionado");
                }
            } else {
                if (((Avion) lista.get(posicion)).getEstado().equals("Espera") && contesp <= 10 && contlisto <= 5) {
                    System.out.println("Cambios de estado posibles:\n"
                            + "1- Listo\n"
                            + "2- Espera\n"
                            + "Ingrese su opcion: ");
                    int opc = s.nextInt();
                    while (opc != 1 && opc != 2) {
                        System.out.println("Cambios de estado posibles:\n"
                                + "1- Listo\n"
                                + "2- Espera\n"
                                + "Ingrese su opcion: ");
                        opc = s.nextInt();
                    }
                    if (opc == 1) {
                        ((Avion) lista.get(posicion)).setEstado("Listo");
                    }
                    if (opc == 2) {
                        ((Avion) lista.get(posicion)).setEstado("Espera");
                    }
                } else {
                    if (((Avion) lista.get(posicion)).getEstado().equals("Listo") && contesp <= 10 && contlisto <= 5) {
                        System.out.println("Cambios de estado posibles:\n"
                                + "1- Espera\n"
                                + "2- Vuelo\n"
                                + "3- Listo\n"
                                + "Ingrese su opcion: ");
                        int opc = s.nextInt();
                        while (opc != 1 && opc != 2 && opc != 3) {
                            System.out.println("Cambios de estado posibles:\n"
                                    + "1- Espera\n"
                                    + "2- Vuelo\n"
                                    + "3- Listo\n"
                                    + "Ingrese su opcion: ");
                            opc = s.nextInt();
                        }
                        if (opc == 1) {
                            ((Avion) lista.get(posicion)).setEstado("Espera");
                        }
                        if (opc == 2) {
                            ((Avion) lista.get(posicion)).setEstado("Vuelo");
                        }
                        if (opc == 3) {
                            ((Avion) lista.get(posicion)).setEstado("Listo");
                        }
                    }
                }
            }
        }
    }

    public static boolean Log(String usu, String contra) {
        if (usu.equals(login[0]) && contra.equals(login[1])) {
            return true;
        } else {
            return false;
        }
    }

    public static void Registro() {
        System.out.println("Menu\n"
                + "Opcion 1: Crear Aviones\n"
                + "Opcion 2: Leer Aviones\n"
                + "Opcion 3: Actualizar Aviones\n"
                + "Opcion 4: Borrar Aviones\n"
                + "Ingrese una opcion: ");
        int opc = s.nextInt();
        while (opc <= 0 || opc >= 5) {
            System.out.println("Menu\n"
                    + "Opcion 1: Crear Aviones\n"
                    + "Opcion 2: Leer Aviones\n"
                    + "Opcion 3: Actualizar Aviones\n"
                    + "Opcion 4: Borrar Aviones\n"
                    + "Ingrese una opcion correcta: ");
            opc = s.nextInt();
        }
        switch (opc) {
            case 1:
                System.out.println("Ingrese el codigo del avion: ");
                String cod = s.next();
                while (valcod(cod)) {
                    System.out.println("Ingrese el codigo del avion:\n**Debe ser alfanumerico con al menos una letra y un numero. ");
                    cod = s.next();
                }
                System.out.println("Ingrese el año de fabricacion: ");
                int aniof = s.nextInt();
                System.out.println("Ingrese el año de ingreso al aeropuerto: ");
                int anioa = s.nextInt();
                System.out.println("Ingrese la capacidad de pasajeros: ");
                int cap = s.nextInt();
                System.out.println("Ingrese la capacidad de peso en toneladas: ");
                double peso = s.nextDouble();
                System.out.println("Ingrese la cantidad de horas de vuelo en formato decimal: ");
                double horas = s.nextDouble();
                System.out.println("Ingrese la cantidad de motores: ");
                int motores = s.nextInt();
                System.out.println("Ingrese el nombre del ingeniero a cargo: ");
                s.nextLine();
                String ingcarg = s.nextLine();
                lista.add(new Avion(cod, aniof, anioa, cap, peso, horas, motores, ingcarg));
                break;
            case 2:
                String salida = "";
                for (Object temp : lista) {
                    if (temp instanceof Avion) {
                        salida += lista.indexOf(temp) + "- " + temp + "\n";
                    }
                }
                JOptionPane.showMessageDialog(null, salida);
                break;
            case 3:
                System.out.println("Ingrese la posicion en la lista del avion: ");
                int posicion = s.nextInt();
                while (posicion < 0 || posicion >= lista.size()) {
                    System.out.println("Ingrese la posicion en la lista del avion: ");
                    posicion = s.nextInt();
                }
                System.out.println("Elementos\n"
                        + "1- Codigo\n"
                        + "2- Año de fabricacion\n"
                        + "3- Año de ingreso al aeropuerto\n"
                        + "4- Capacidad de pasajeros\n"
                        + "5- Capacidad de peso\n"
                        + "6- Cantidad de Horas de Vuelo\n"
                        + "7- Numero de Motores\n"
                        + "8- Ingeniero a cargo\n"
                        + "Que elemento desea cambiar?");
                int elemento = s.nextInt();
                while (elemento <= 0 || elemento > 8) {
                    System.out.println("Elementos\n"
                            + "1- Codigo\n"
                            + "2- Año de fabricacion\n"
                            + "3- Año de ingreso al aeropuerto\n"
                            + "4- Capacidad de pasajeros\n"
                            + "5- Capacidad de peso\n"
                            + "6- Cantidad de Horas de Vuelo\n"
                            + "7- Numero de Motores\n"
                            + "8- Ingeniero a cargo\n"
                            + "Que elemento desea cambiar?");
                    elemento = s.nextInt();
                }
                switch (elemento) {
                    case 1:
                        System.out.println("Ingrese el codigo del avion: ");
                        String codc = s.next();
                        while (valcod(codc)) {
                            System.out.println("Ingrese el codigo del avion:\n**Debe ser alfanumerico con al menos una letra y un numero. ");
                            codc = s.next();
                        }
                        ((Avion) lista.get(posicion)).setCodigo(codc);
                        break;
                    case 2:
                        System.out.println("Ingrese el año de fabricacion: ");
                        int aniofc = s.nextInt();
                        ((Avion) lista.get(posicion)).setAniof(aniofc);
                        break;
                    case 3:
                        System.out.println("Ingrese el año de ingreso al aeropuerto: ");
                        int anioac = s.nextInt();
                        ((Avion) lista.get(posicion)).setAnioa(anioac);
                        break;
                    case 4:
                        System.out.println("Ingrese la cantidad de pasajeros: ");
                        int capc = s.nextInt();
                        ((Avion) lista.get(posicion)).setCap(capc);
                        break;
                    case 5:
                        System.out.println("Ingrese la cantidad de peso: ");
                        double pesoc = s.nextDouble();
                        ((Avion) lista.get(posicion)).setPeso(pesoc);
                        break;
                    case 6:
                        System.out.println("Ingrese la cantidad de Horas de Vuelo: ");
                        double horasc = s.nextDouble();
                        ((Avion) lista.get(posicion)).setHoras(horasc);
                        break;
                    case 7:
                        System.out.println("Ingrese la cantidad de motores: ");
                        int motoresc = s.nextInt();
                        ((Avion) lista.get(posicion)).setMotores(motoresc);
                        break;
                    case 8:
                        System.out.println("Ingrese el nombre del Ingeniero a Cargo: ");
                        s.nextLine();
                        String ingcargc = s.nextLine();
                        ((Avion) lista.get(posicion)).setIngcarg(ingcargc);
                        break;
                }
                break;
            case 4:
                System.out.println("Ingrese la posicion en la lista del avion: ");
                int posicionel = s.nextInt();
                while (posicionel < 0 || posicionel >= lista.size()) {
                    System.out.println("Ingrese la posicion en la lista del avion: ");
                    posicionel = s.nextInt();
                }
                lista.remove(posicionel);
                break;
        }
    }

    public static boolean valcod(String codigo) {
        int letra = 0, numero = 0;
        for (int i = 0; i < codigo.length(); i++) {
            if (Character.isLetter(codigo.charAt(i))) {
                letra++;
            }
            if (Character.isDigit(codigo.charAt(i))) {
                numero++;
            }
        }
        if (letra != 0 && numero != 0) {
            return false;
        } else {
            return true;
        }
    }
}
