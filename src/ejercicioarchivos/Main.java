/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioarchivos;

import java.io.IOException;
import java.util.*;

/**
 *
 * @author Estudiante
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        System.out.println("Gestion de Enteros");
        Gui gui = new Gui();
        DAO bd = new DAO();
        GestionArchivo archivos = new GestionArchivo("enteros.txt");
        int opcion = 0;
        int valor = 0;
        int posicion = 0;
        
        boolean ciclo = true;
        
        Scanner lectura = new Scanner(System.in);
        while(ciclo){
            opcion = gui.menu();
            switch(opcion){
                case 0:
                    ciclo = false;
                    break;
                case 1:
                    System.out.println("Ingrese dato:");
                    valor = lectura.nextInt();
                    bd.addBd(valor);
                    break;
                case 2:
                    System.out.println("Guardando...");
                    archivos.guardar(bd.getBd());
                    break;
                case 3:
                    System.out.println("Cargando...");
                    archivos.cargar();
                    break;
                case 4:
                    System.out.println("Lista:");
                    gui.listar(bd.getBd());
                    break;
                case 5:
                    System.out.println("Ingrese Posicion:");
                    posicion = lectura.nextInt();
                    System.out.println("Ingrese Numero");
                    valor = lectura.nextInt();
                    if(!bd.modificar(valor, posicion)) {
                        System.out.println("");
                    }
                    break;
            }
        }
    }
    
}
