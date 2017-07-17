/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package productobinariodivideyvenceras;

import java.util.Scanner;
/**
 *
 * @author Carlos
 */
public class ProductoBinarioDivideyVenceras {
    /**
     * @param args the command line arguments
     */
    public static String rellena(String cadena){
       String s="";
        int res;
        int tam =cadena.length();
        int x=1;
            if(tam==1){
                s="0";
            }   
            else{
                while(tam>x){
                x*=2;
                }
            }
            res=x-tam;
                for(int j=0; j<res; j++){
                    s+="0";
                }
            s+=cadena;
            return s; 
        }
    
    public static String Obtener(String cadena, String lado){
        int mitad=(cadena.length()/2);
        String subcadena;
            if(lado.equals("I")){
                subcadena=cadena.substring(0,mitad);
                //System.out.println(subcadena);
                return subcadena;
            }
        subcadena=cadena.substring(mitad);
        //System.out.println(subcadena);
        return subcadena;
    }
    
    public static String Verifica(String cadenaA,int dif){
        String verificada;
        verificada="";
        int i;
            for(i=0;i<dif;i++){
                verificada=verificada+"0";
              }
            verificada=verificada+cadenaA;
        return verificada;
    }
    
    public static int PBDyV(String A, String B, int n){
        int ta=A.length();
        int tb=B.length();
        int resultado;
                if((ta&tb)==1){
                    int sa=Integer.parseInt(A);
                    int sb=Integer.parseInt(B);
                return sa*sb;
               }
                else{
            String IA=(Obtener(A,"I"));
            String DA=(Obtener(A,"D"));
            String IB=(Obtener(B,"I"));
            String DB=(Obtener(B,"D"));
            
            int sp1=PBDyV(IA, IB, n/2);
            int sp2=PBDyV(IA, DB, n/2);
            int sp3=PBDyV(DA, IB, n/2);
            int sp4=PBDyV(DA, DB, n/2);
      
            resultado= (int)(Math.pow(2, n)*sp1)+(int)(Math.pow(2,(n/2))*sp2)+(int)(Math.pow(2, (n/2))*sp3)+sp4;
            // System.out.println(sp1);
        return resultado;
        }
    }
    
    public static void main(String[] args) {
       Scanner scan;
       scan = new Scanner(System.in);
       System.out.println("Ingresa el primer numero binario:");
       String a=scan.nextLine();
       System.out.println("Ingresa el segundo numero binario:");
       String b=scan.nextLine();
       String rellenadauno;
       String rellenadados;
       int subtam;
        
     /*  for(int i=0; i<a.length();i++){
           for(int j=0; j<b.length();j++){
           if(a.charAt(i)=='0'||a.charAt(i)=='1'){
               System.out.println("Introduce solamente numero binario");
               System.exit(0);    
           }   
         }
       }
      */
       /*for(int i=0; i<b.length();i++){
           if(b.charAt(i)!='0'||b.charAt(i)!='1'){
               System.out.println("Introduce solamente numero binario");
               System.exit(0);    
           }   
       }
       */
       //if((a.equals("1")||a.equals("0")&&(b.equals("1")||))    
       if(a.length()!=b.length()){
                if(a.length()>b.length()){
                    subtam=a.length()-b.length();
                    String B=ProductoBinarioDivideyVenceras.Verifica(b,subtam);
                    rellenadauno=ProductoBinarioDivideyVenceras.rellena(a);
                    rellenadados=ProductoBinarioDivideyVenceras.rellena(B);
                    int n=rellenadauno.length();
                    System.out.println("El resultado del producto de binarios es: "+ProductoBinarioDivideyVenceras.PBDyV(rellenadauno, rellenadados, n));
                }
                else{
                    if(b.length()>a.length()){
                        subtam=b.length()-a.length();
                        String A=ProductoBinarioDivideyVenceras.Verifica(a, subtam);
                        rellenadauno=ProductoBinarioDivideyVenceras.rellena(A);
                        rellenadados=ProductoBinarioDivideyVenceras.rellena(b);
                        int n=rellenadauno.length();
                        System.out.println("El resultado del producto de binarios es: "+ProductoBinarioDivideyVenceras.PBDyV(rellenadauno, rellenadados, n));    
                    }
                }
            }
            else{
                rellenadauno=ProductoBinarioDivideyVenceras.rellena(a);
                rellenadados=ProductoBinarioDivideyVenceras.rellena(b);
                int n=rellenadauno.length();
                System.out.println("El resultado del producto de binarios es: "+ProductoBinarioDivideyVenceras.PBDyV(rellenadauno, rellenadados, n));
            }
        }
    }