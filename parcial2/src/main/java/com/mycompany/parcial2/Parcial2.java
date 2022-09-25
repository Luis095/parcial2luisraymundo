/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.parcial2;

import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Parcial2 {

   static Scanner tipo = new Scanner (System.in);


    //////////////////BuscarNiv//////////////////
public static void BuscarNiv(){
       System.out.println("ingrese el niv para buscalo");
      String niv = tipo.next();
        String url = "jdbc:mysql://localhost:3306/parcialluis?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try {
         
            Connection conexion = DriverManager.getConnection(url,"root","macarena");
           
            Statement sentencia = conexion.createStatement();
          
            String sql = "SELECT * FROM luis_table where niv = " +niv;
          
            ResultSet resultado = sentencia.executeQuery(sql);
       
            while(resultado.next()){
                System.out.println("\nNiv   ="+resultado.getInt(1));
                System.out.println("Nombre  = "+resultado.getString(2));
                System.out.println("Enero   ="+resultado.getInt(3));
                System.out.println("Febrero ="+resultado.getInt(4));
                System.out.println("Marzo   ="+resultado.getInt(5));
                System.out.println("Abril   ="+resultado.getInt(6));
                System.out.println("Mayo    ="+resultado.getInt(7));
                System.out.println("Junio ="+resultado.getInt(8));
                System.out.println("\n");
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
}//////FinBUSCAR////////


public static void ConsultasSuma(){
         System.out.println("Sumas de los empleados");

        String url = "jdbc:mysql://localhost:3306/parcialluis?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try {
            
            Connection conexion = DriverManager.getConnection(url,"root","macarena");
           
            Statement sentencia = conexion.createStatement();
          
            String sql = "Select niv, nombre, (enero+febrero+marzo+abril+mayo+junio) from luis_table;";
             
          
            ResultSet resultado = sentencia.executeQuery(sql);
       
            while(resultado.next()){
                 System.out.println("\nNiv ="+resultado.getInt(1));
                System.out.println("Nombre = "+resultado.getString(2));
                System.out.println("TOTAL ="+resultado.getInt(3));
               
                
              
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
}//fin de suma


public static void CambiarNombre(){
    System.out.println("Por favor, ingrese el Niv: ");
  String niv = tipo.next();
    System.out.println("Por favor ingrese el nuevo nombre: ");
    String nuevonombre = tipo.next();
    
     String url = "jdbc:mysql://localhost:3306/parcialluis?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try {
            
            Connection conexion = DriverManager.getConnection(url,"root","macarena");
           
            Statement sentencia = conexion.createStatement();
          
            String sql = "update luis_table set nombres = '"+nuevonombre+"' where niv = '"+niv+"' ";
             
          
            sentencia.executeUpdate(sql);
                      
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
}
      


public static void Eliminar(){
   
    System.out.println("Por favor, ingrese el Niv a eliminar: ");
String niv = tipo.next();
int elec;
 System.out.println("Esta seguro de Eliminarlo?: ");
  System.out.println("1. SI ");
  System.out.println("2. NO ");
  
elec=tipo.nextInt();
    switch(elec){
        case 1:
            
            break;
            
       case 2:
        
            break;
      
         
    }
     String url = "jdbc:mysql://localhost:3306/parcialluis?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try {
            
            Connection conexion = DriverManager.getConnection(url,"root","macarena");
           
            Statement sentencia = conexion.createStatement();
          
            String sql = "delete from luis_table  where niv = '"+niv+"' ";
             
          
            sentencia.executeUpdate(sql);
                      
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
}


public static void main(String[] args) {
    int menu;
         System.out.println("1. BuscarNiv");
          System.out.println("2. Total de las Sumas ");
          System.out.println("3. Cambiar Nombre ");
          System.out.println("4. Eliminar ");
    menu=tipo.nextInt();
    switch(menu){
        case 1:
            BuscarNiv();
            break;
            
       case 2:
        ConsultasSuma();
            break;
       case 3:
           CambiarNombre();
            break;
       case 4:
            Eliminar();
            break;  
         
    }


}
}