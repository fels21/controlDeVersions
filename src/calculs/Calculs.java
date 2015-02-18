package calculs;

import static calculs.Dividir.divisio;
import static calculs.Modul.modul;
import static calculs.Multiplicacio.multiplicacio;
import static calculs.Resta.resta;
import static calculs.Sumar.suma;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

/**
* <b>El programa Calculs és una calculadora que fa operacions amb dos nombres.
* El programa espera una cadena amb dos nombres separats per un operador.</b>
* @author  Grup 1
* @version 1.0
* @since 15/01/2015
*
*/

public class Calculs {
    boolean  error=false;
    static final int MAX = 2147483647;
    static final int MIN = -2147483648;
    
    /**
     * <b>Crida al mètode Calculs</b>
     * @param args array de Strings imprescindible en el main.
     * @throws IOException
     * @see IOException 
     */
    public static void main(String[] args) throws IOException {
        Calculs calc = new Calculs();
    }
    
    /**
     * <b>Aquest mètode extreu els dos valors i l'operador de la cadena rebuda.
     * També controla els possibles errors i crida al mètode operador adecuat</b>
     * @exception IOException al introduir un valor no possible.
     * @see IOException
     */
    public Calculs() throws IOException{
        Scanner sc = new Scanner(System.in);
        String cadena;
        int part1;
        int part2;
        int resultat = 0;
        String[] parts = null;
        boolean operar; 
        
        //BufferedReader in;     //Modo fitxer
        //PrintStream out;       //Modo fitxer
        //in = new BufferedReader( new InputStreamReader( System.in) ); //Modo fitxer
        //out = System.out;                                             //Modo fitxer

        // Llegeix el fitxer linea per linea
        while(1==1){                                                    //Modo comandes
        // while( in.ready() ){                                          //Modo fitxer
            
            operar = true;            
            //cadena = in.readLine();                                   //Modo fitxer
            cadena = sc.nextLine();                                     //Modo comandes
            
            error = control(cadena);
            
            if(!error){
                try{
                    if (cadena.contains("-")) {
                       parts = cadena.split("-");
                       part1 = Integer.parseInt(parts[0]);
                       part2 = Integer.parseInt(parts[1]);
                       if(-2147483648 + part2 > part1){
                           operar = false;
                           System.out.println("Error");
                       }
                       else resultat=resta(part1,part2);
                    }
                    if (cadena.contains("+")) {
                       parts = cadena.split("\\+");
                       part1 = Integer.parseInt(parts[0]);
                       part2 = Integer.parseInt(parts[1]);
                       if(2147483647-part2 < part1){
                           operar = false;
                           System.out.println("Error");
                       }
                       else resultat=suma(part1,part2);                       
                    }
                    if (cadena.contains("/")) {
                       parts = cadena.split("/");
                       part1 = Integer.parseInt(parts[0]);
                       part2 = Integer.parseInt(parts[1]);
                       if(part2 == 0){
                           System.out.println("Error");
                           operar = false;
                       }
                       else resultat=divisio(part1,part2);                       
                    }
                    if (cadena.contains("*")) {
                       parts = cadena.split("\\*");
                       part1 = Integer.parseInt(parts[0]);
                       part2 = Integer.parseInt(parts[1]);
                       if(part2 == 0){
                           System.out.println("0");
                           operar = false;
                       }
                       else if(2147483647/part2 < part1){
                           operar = false;
                           System.out.println("Error");
                       }
                       else resultat=multiplicacio(part1,part2);
                    }
                    if (cadena.contains("%")) {
                       parts = cadena.split("%");
                       part1 = Integer.parseInt(parts[0]);
                       part2 = Integer.parseInt(parts[1]);
                       if(part2 == 0){
                           System.out.println("Error");
                           operar = false;
                       }
                       else resultat=modul(part1,part2);                       
                    }
                                        
                }catch(NumberFormatException e){
                    operar = false;
                    System.out.println("Error");
                }
                if(operar == true)System.out.println(resultat);
            }
            error = false;
        }
    }
    
    /**
     * <b>Aquest mètode comproba que la cadena inicii bé
     * i contingui els caràcters esperats</b>
     * @param x és la cadena que l'usuari introdueix i que es vol controlar
     * @return boolean - segons hi hagi error (true) o no (false)
     */
    public static boolean control(String x){
        if(x.startsWith("/") ||x.startsWith("+")||x.startsWith("*")||x.startsWith("%")||x.startsWith("-")){
            System.out.println("Error");
            return true;
        }
        else if (!(x.contains("-"))&&!(x.contains("/"))&&!(x.contains("+"))&&!(x.contains("*"))&&!(x.contains("%"))){
            System.out.println("Error");
            return true;
        }
        return false;
    }        
}