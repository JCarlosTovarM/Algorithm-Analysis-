/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package productobinariodivideyvencerascuartos;

import java.util.Scanner;

/**
 *
 * @author Carlos
 */
public class ProductoBinarioDivideyVencerasCuartos {

    public static String rellena(String cadena){
       String s="";
        int res;
        int tam =cadena.length();
        int x=1;
            if(tam==1){
                s="000";
            }   
            else{
                while(tam>x){
                x*=4;
                }
            }
            res=x-tam;
                for(int j=0; j<res; j++){
                    s+="0";
                }
            s+=cadena;
        //    System.out.println(s);
            return s; 
        }
    
    public static String Obtener(String cadena, String lado){
        int cuarto=(cadena.length()/4);
        String subcadena;
            if(lado.equals("I")){
                subcadena=cadena.substring(0,cuarto);
              //  System.out.print(subcadena+" ");
                return subcadena;
            }
            else {
                if(lado.equals("M")){
                    subcadena=cadena.substring(cuarto,2*cuarto);
                //    System.out.print(subcadena+" ");
                    return subcadena;
                }
                else {
                    if(lado.equals("M1")){
                        subcadena=cadena.substring(2*cuarto,3*cuarto);
                       // System.out.print(subcadena+ " ");
                        return subcadena;
                    }
                }
            }
        subcadena=cadena.substring(3*cuarto);
       // System.out.print(subcadena+" ");
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
            String MA=(Obtener(A,"M"));
            String M1A=(Obtener(A,"M1"));
            String DA=(Obtener(A,"D"));
            
            String IB=(Obtener(B,"I"));
            String MB=(Obtener(B,"M"));
            String M1B=(Obtener(B,"M1"));
            String DB=(Obtener(B,"D"));
            
            int sp1=PBDyV(IA, IB, n/4);
            int sp2=PBDyV(IA, MB, n/4);
            int sp3=PBDyV(IA, M1B, n/4);
            int sp4=PBDyV(IA, DB, n/4);
            
            int sp5=PBDyV(MA, IB, n/4);
            int sp6=PBDyV(MA, MB, n/4);
            int sp7=PBDyV(MA, M1B, n/4);
            int sp8=PBDyV(MA, DB, n/4);
            
            int sp9=PBDyV(M1A, IB, n/4);
            int sp10=PBDyV(M1A, MB, n/4);
            int sp11=PBDyV(M1A, M1B, n/4);
            int sp12=PBDyV(M1A, DB, n/4);
            
            int sp13=PBDyV(DA, IB, n/4);
            int sp14=PBDyV(DA, MB, n/4);
            int sp15=PBDyV(DA, M1B, n/4);
            int sp16=PBDyV(DA, DB, n/4);
     
            resultado= (int)(Math.pow(2, 3*n/2)*sp1)+(int)(Math.pow(2,(5*n/4))*sp2)+(int)(Math.pow(2, (n))*sp3)+(int)(Math.pow(2, (3*n)/4)*sp4)+
                    (int)(Math.pow(2, 5*n/4)*sp5)+(int)(Math.pow(2,(n))*sp6)+(int)(Math.pow(2, (3*n/4))*sp7)+(int)(Math.pow(2, (n/2))*sp8)+
                            (int)(Math.pow(2, n)*sp9)+(int)(Math.pow(2,(3*n/4))*sp10)+(int)(Math.pow(2, (n/2))*sp11)+(int)(Math.pow(2, (n/4))*sp12)+
                                    (int)(Math.pow(2, 3*n/4)*sp13)+(int)(Math.pow(2,(n/2))*sp14)+(int)(Math.pow(2, (n/4))*sp15)+sp16;
            // System.out.println(sp1);
            /*
            
            resultado= (int)(Math.pow(2, 3*n)*sp1)+(int)(Math.pow(2,(5*n/2))*sp2)+(int)(Math.pow(2, (2*n))*sp3)+(int)(Math.pow(2, (3*n)/2)*sp4)+
                    (int)(Math.pow(2, 5*n/2)*sp5)+(int)(Math.pow(2,(2*n))*sp6)+(int)(Math.pow(2, (3*n/2))*sp7)+(int)(Math.pow(2, (n))*sp8)+
                            (int)(Math.pow(2, 2*n)*sp9)+(int)(Math.pow(2,(3*n/2))*sp10)+(int)(Math.pow(2, (n))*sp11)+(int)(Math.pow(2, (n/2))*sp12)+
                                    (int)(Math.pow(2, 3*n/2)*sp13)+(int)(Math.pow(2,(n))*sp14)+(int)(Math.pow(2, (n/2))*sp15)+sp16;
            */
        return resultado;
        }
    }
    /**
     * @param args the command line arguments
     */
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
       
 
       if(a.length()!=b.length()){
                if(a.length()>b.length()){
                    subtam=a.length()-b.length();
                    String B=ProductoBinarioDivideyVencerasCuartos.Verifica(b,subtam);
                    rellenadauno=ProductoBinarioDivideyVencerasCuartos.rellena(a);
                    rellenadados=ProductoBinarioDivideyVencerasCuartos.rellena(B);
                    int n=rellenadauno.length();
                    System.out.println("El resultado del producto de binarios es: "+ProductoBinarioDivideyVencerasCuartos.PBDyV(rellenadauno, rellenadados, n));
                }
                else{
                    if(b.length()>a.length()){
                        subtam=b.length()-a.length();
                        String A=ProductoBinarioDivideyVencerasCuartos.Verifica(a, subtam);
                        rellenadauno=ProductoBinarioDivideyVencerasCuartos.rellena(A);
                        rellenadados=ProductoBinarioDivideyVencerasCuartos.rellena(b);
                        int n=rellenadauno.length();
                        System.out.println("El resultado del producto de binarios es: "+ProductoBinarioDivideyVencerasCuartos.PBDyV(rellenadauno, rellenadados, n));    
                    }
                }
            }
            else{
                rellenadauno=ProductoBinarioDivideyVencerasCuartos.rellena(a);
                rellenadados=ProductoBinarioDivideyVencerasCuartos.rellena(b);
                int n=rellenadauno.length();
                System.out.println("El resultado del producto de binarios es: "+ProductoBinarioDivideyVencerasCuartos.PBDyV(rellenadauno, rellenadados, n));
            }
  }
  
  
        //ProductoBinarioDivideyVencerasCuartos.Obtener("12345678", "D");
       //System.out.println(ProductoBinarioDivideyVencerasCuartos.rellena("11111111111111111"));
        // TODO code application logic here
    }
       

