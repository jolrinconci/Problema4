/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema4;

/**
 *
 * @author José Luis Rincón y Diana Marcela Molina
 * @version 1.0
 * since 02/26/2016
 */
public class Problema4 {
    /**
     * @param args the command line arguments
     */
    static int contador =1;
    static int contador2=0;
    static int ventaTotal=0;
    static int codigoProductos[]=new int[100];
    static String descripcionproducto[]= new String[100];
    static int preciosProducto[]=new int[100];
    static String nombreVendedor[]=new String[50];
    static int idvendedores[]=new int[50];
    static int documento;
    static int codpro;
    static int precio;
    static int registroVentas=0001;
    static String nombreVen;
    static String descripcion;
    public static void main(String[] args) {
        // TODO code application logic here
        registrarVenta();
    }
    
   public static void IngresardatosProducto(){
       java.util.Scanner lectura= new java.util.Scanner(System.in);
       int codigo;
       String descripcion;
       int precio1;
       System.out.println("Ingrese el codigo del producto");
       codigo= lectura.nextInt();
       codigoProductos[contador]=codigo;
       System.out.println("Ingrese la descripcion del producto");
       descripcion=lectura.next();
       descripcionproducto[contador]=descripcion;
       System.out.println("Ingrese el precio del producto");
       precio1=lectura.nextInt();
       precio=preciosProducto[contador];
       contador=contador+1;
   }
   
   public static void ingresarfecha(){//Para solicitar fecha a usurio e imprimir
       java.util.Scanner lectura= new java.util.Scanner(System.in);
       int dia;
       int mes;
       int año;
       int hora;
       int minutos;
       System.out.print("Ingrese el dia:");
       dia=lectura.nextInt();
       System.out.print("Ingrese el mes:");
       mes=lectura.nextInt();
       System.out.print("Ingrese el año:");
       año=lectura.nextInt();
       System.out.print("Ingrese la hora:");
       hora=lectura.nextInt();
       System.out.print("Ingrese los minutos:");
       minutos=lectura.nextInt();
       System.out.print(dia+"/"+mes+"/"+año+"hora:"+hora+":"+minutos);
       System.out.println("\n");
    }
   
   public static void crearVendedor(){//funcion para insertar vendedores
       java.util.Scanner lectura= new java.util.Scanner(System.in);
       int idVendedor;
       String nombreVen;
       System.out.println("Ingrese el documento del vendedor a crear:");
       idVendedor=lectura.nextInt();
       idvendedores[contador2]=idVendedor;
       System.out.println("Ingrese el Nombre del vendedor a crear:");
       nombreVen=lectura.next();
       nombreVen=nombreVendedor[contador2];
   }
   
   public static void Buscarvendedor(int documento){ //sirve para buscar el vendedor cuando se este realizando factura
       int i;
       int n=0;//variable para saber si el vendedor ya se encuentra en el arreglo
       int respuesta;
       java.util.Scanner lectura= new java.util.Scanner(System.in);
        for (i=1; i<50; i++){
           if (documento==idvendedores[i]){
               System.out.println("Nombre de vendedor es;"+nombreVendedor[i]);
               nombreVen=nombreVendedor[i];
               i=51;
               n=1;
           }
        }
        if (n==0){
            System.out.println("El documento del vendedor no se encuentra registrado");
            System.out.println("confirmar numero");
            System.out.println("¿Desea registrar un nuevo vendedor? 1:Si 2:No");
            respuesta=lectura.nextInt();
            if (respuesta==1){
            crearVendedor();
            
            
        }
        }
    }
  
   public static void buscarProducto(int codpro){
       int i;
       int n=0;
       int respuesta;
       java.util.Scanner lectura= new java.util.Scanner(System.in);
       for (i=1; i<100; i++){
           if (codpro==codigoProductos[i]){
               precio=preciosProducto[i];
               descripcion=descripcionproducto[i];
               n=1;
            }
        }
        if (n==0){
            System.out.println("El producto no se encuentra creado en la base de datos");
            System.out.println("¿Desea crear un nuevo producto? 1:si y 2:no");
            respuesta=lectura.nextInt();
            if (respuesta==1){
                IngresardatosProducto();
            }
        }

        
   }

   public static void registrarVenta(){
           int cantidad;
           int precioTotal;
           int formaPago;
           java.util.Scanner lectura= new java.util.Scanner(System.in);
           System.out.println("Ingrese el numero de documento del vendedor:");
           documento=lectura.nextInt();
           Buscarvendedor(documento);
           System.out.println("Ingrese el codigo del producto");
           codpro=lectura.nextInt();
           buscarProducto(codpro);
           System.out.println("Ingrese la cantidad");
           cantidad=lectura.nextInt();
           precioTotal=precio*cantidad;
           System.out.println("Ingrese Forma de Pago 0:efectivo, 1:debito y 2:credito");
           formaPago=lectura.nextInt();
           ingresarfecha();
           System.out.println("Factura : "+registroVentas);
           System.out.println("\n");
           System.out.println("Vendedor :"+nombreVen);
           System.out.println(cantidad+"  "+descripcion+".........."+precioTotal);
           System.out.println("Forma de pago:"+"Efectivo"); //TOCA CAMBIAR ESTO ES SOLO PARA PROBAR
           }
}
