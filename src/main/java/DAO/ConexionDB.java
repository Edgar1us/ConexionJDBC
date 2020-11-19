/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidad.Cliente;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mati
 */
public class ConexionDB {
static Scanner teclado = new Scanner(System.in); 
 
    public Connection abrirConexion() throws ClassNotFoundException, SQLException{
        
        Connection con = null;
        Class.forName("com.mysql.jdbc.Driver");
        String urlOdbc = "jdbc:mysql://localhost:3306/clientesdb";
        
        con=(java.sql.DriverManager.getConnection(urlOdbc, "root", ""));
        
        return con;
    }
    
    public void cerrarConexion(Connection con){
        if (con!=null) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public Cliente altaCliente(){
        
        System.out.println("Dime el DNI (sin letra): ");
        int dni  =Integer.parseInt(teclado.nextLine());
        
        System.out.println("Dime el nombre: ");
        String nombre = teclado.nextLine();
        
        System.out.println("Dime el primer apellido: ");
        String apellido1 = teclado.nextLine();
        
        System.out.println("Dime el segundo apellido: ");
        String apellidos2 = teclado.nextLine();
        
        System.out.println("Dime el nick: ");
        String nick = teclado.nextLine();
        
        System.out.println("Dime el password: ");
        String password = teclado.nextLine();
        
        System.out.println("Dime el saldo: ");
        Float saldo = Float.parseFloat(teclado.nextLine());
        
        System.out.println("Dime si es moroso: ");
        int moroso = Integer.parseInt(teclado.nextLine());
        
        Cliente cliente = new Cliente(dni, nombre, apellido1, apellidos2, nick, password, moroso, saldo );
        
        return cliente;
        
    }
    
}
