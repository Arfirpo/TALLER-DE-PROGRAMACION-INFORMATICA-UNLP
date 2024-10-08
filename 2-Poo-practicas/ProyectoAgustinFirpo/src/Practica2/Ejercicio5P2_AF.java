/*
5- Se dispone de la clase Partido (en la carpeta tema2). Un objeto partido representa un encuentro entre dos equipos (local y visitante). 
Un objeto partido puede crearse sin valores iniciales o enviando en el mensaje de creación el nombre del equipo local, el nombre del visitante, la cantidad de goles del local y del visitante (en ese orden). Un objeto partido sabe responder a los siguientes mensajes:

   getLocal() | retorna el nombre (String) del equipo local.
   getVisitante() | retorna el nombre (String) del equipo visitante.
   getGolesLocal() | retorna la cantidad de goles (int) del equipo local.
   getGolesVisitante() | retorna la cantidad de goles (int) del equipo visitante.
   setLocal(X) | modifica el nombre del equipo local al “String” X.
   setVisitante(X) | modifica el nombre del equipo visitante al “String” X.
   setGolesLocal(X) | modifica la cantidad de goles del equipo local al “int” X.
   setGolesVisitante(X) | modifica la cantidad de goles del equipo visitante al “int” X.
   hayGanador() | retorna un boolean que indica si hubo (true) o no hubo (false) ganador.
   getGanador() | retorna el nombre (String) del ganador del partido (si no hubo retorna un String vacío).
   hayEmpate() | retorna un boolean que indica si hubo (true) o no hubo (false) empate

Implemente un programa que cargue un vector con a lo sumo 20 partidos disputados en el campeonato.

La información de cada partido se lee desde teclado hasta ingresar uno con nombre de visitante “ZZZ” o alcanzar los 20 partidos. 
Luego de la carga:
   - Para cada partido, armar e informar una representación String del estilo: {EQUIPO-LOCAL golesLocal VS EQUIPO-VISITANTE golesVisitante }
   - Calcular e informar la cantidad de partidos que ganó River.
   - Calcular e informar el total de goles que realizó Boca jugando de local.
 */
package Practica2;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

public class Ejercicio5P2_AF {

   private static final String corte_visitante = "zzz";
   private static final String equipo_river = "river";
   private static final String equipo_boca = "boca";
   private static final int dimF_partidos = 20;

   public static void main(String[] args) {
      int dimL = 0;
      Partido[] vPartidos = new Partido[dimF_partidos];
      String visitante;
      int i;

      System.out.print(
              "Ingrese nombre de equipo Visitante: ");
      visitante = Lector.leerString();

      System.out.println();

      while (!visitante.equalsIgnoreCase(corte_visitante) && dimL < dimF_partidos) {
         Partido p = new Partido();
         p.setVisitante(visitante);
         System.out.print("Ingrese Goles convertidos por el equipo Visitante: ");
         p.setGolesVisitante(Lector.leerInt());
         System.out.println();
         System.out.print("Ingrese nombre de equipo Local: ");
         p.setLocal(Lector.leerString());
         System.out.println();
         System.out.print("Ingrese goles convertidos por el equipo local: ");
         p.setGolesLocal(Lector.leerInt());
         System.out.println();
         vPartidos[dimL] = p; //guardar partido
         dimL++;
         System.out.print("Ingrese nombre de equipo Visitante: ");
         visitante = Lector.leerString();
         System.out.println();
      }

      int cantGanadosRiver = 0;
      int cantGolesBocaLocal = 0;

      System.out.println();
      System.out.println("----------| PARTIDOS |----------");
      System.out.println();
      for (i = 0; i < dimL; i++) {
         Partido partidoAct = vPartidos[i];
         if (partidoAct.hayGanador() && partidoAct.getGanador().equalsIgnoreCase(equipo_river)) {
            cantGanadosRiver++;
         }
         if (partidoAct.getLocal().equalsIgnoreCase(equipo_boca)) {
            cantGolesBocaLocal += partidoAct.getGolesLocal();
         }
         System.out.println(partidoAct.toString());
         System.out.println();
      }
      System.out.println("--------------------------------");
      System.out.println();
      System.out.println("River gano " + cantGanadosRiver + " partidos en total.");
      System.out.println("");
      System.out.println("Boca metio " + cantGolesBocaLocal + " goles de local.");
      System.out.println("");
   }
}
