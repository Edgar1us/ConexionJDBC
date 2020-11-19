/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import DAO.ConexionDB;
import entidad.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author mati
 */
public class App {

    static Scanner teclado = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // TODO code application logic here

        /*
        System.out.println("abriendo conexión");
        
        System.out.println("Conexion abierta");*/

        //Statement stmt = null;
        //stmt=con.createStatement();
        //stmt.executeUpdate("INSERT INTO cliente (dni, nombre, apellido1, apellidos2, nick, password, saldo, moroso)" + "VALUES(20888333, 'Antonio', 'Gil', 'Lopez', 'toni', '1234', 1000, 1);");
        
        
       /* ConexionDB conexion_DB = new ConexionDB();
        Connection con = conexion_DB.abrirConexion();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        stmt = con.prepareStatement("SELECT * FROM cliente");
        //stmt=con.prepareStatement("SELECT * FROM cliente WHERE dni=?");
        //stmt.setInt(1, 20444666);
        rs = stmt.executeQuery();
        while (rs.next()) {
            Cliente cliente = new Cliente();
            cliente.setDni(rs.getInt("dni"));
            cliente.setNombre(rs.getString("nombre"));
            cliente.setApellido1(rs.getString("apellido1"));
            cliente.setApellidos2(rs.getString("apellidos2"));
            cliente.setNick(rs.getString("nick"));
            cliente.setPassword(rs.getString("password"));
            cliente.setSaldo(rs.getFloat("saldo"));

            if (rs.getInt("moroso") == 0) {
                cliente.setMoroso(false);

            } else {
                cliente.setMoroso(true);

            }
            System.out.println(cliente);
        }

        System.out.println("Cerrando conexión");
        conexion_DB.cerrarConexion(con);
        System.out.println("Conexion cerrada");*/

        int opc = 0;

        do {
            verMenu();
            opc = Integer.parseInt(teclado.nextLine());
            switch (opc) {
                case 1:
                    
                    
                    
                    ConexionDB conexion_DB = new ConexionDB();
                    Cliente c = new Cliente();
                    c = conexion_DB.altaCliente();
                    
                    Connection con = conexion_DB.abrirConexion();
                    PreparedStatement stmt = null;
                    stmt=con.prepareStatement("INSERT INTO cliente(dni, nombre, apellido1, apellidos2, nick, password, saldo, moroso)" + "VALUES(?, ?, ?, ?, ?, ?, ?, ?);");
                    
                    stmt.setInt(1, c.getDni());
                    stmt.setString(2, c.getNombre());
                    stmt.setString(3, c.getApellido1());
                    stmt.setString(4, c.getApellidos2());
                    stmt.setString(5, c.getNick());
                    stmt.setString(6, c.getPassword());
                    stmt.setFloat(7, c.getSaldo());
                    stmt.setInt(8, c.getMoroso());
                    stmt.executeUpdate();
                    
                    System.out.println("Cliente dado de alta en Base de Datos\n");
                    break;
                    
                case 2:
                    ConexionDB conexion_DB2 = new ConexionDB();
                    Connection con2 = conexion_DB2.abrirConexion();
                    PreparedStatement stmt2 = null;
                    System.out.println("Dime el dni (sin letra): ");
                    int dni = Integer.parseInt(teclado.nextLine());
                    stmt=con2.prepareStatement("DELETE FROM cliente WHERE dni = " + dni);
                    stmt.executeUpdate();
                    break;
                case 3:

                    System.out.println("Has elegido la opcion de modificar cliente");
                    break;
                    
                case 4:

                    ConexionDB conexion_DB4 = new ConexionDB();
                    Connection con4 = conexion_DB4.abrirConexion();
                    PreparedStatement stmt4 = null;
                    System.out.println("Dime el dni (sin letra): ");
                    stmt=con4.prepareStatement("SELECT * FROM cliente");
                    stmt.executeUpdate();
                    break;
                case 5:

                    System.out.println("Has elegido la opcion de consultar clientes");
                    break;
                    
                default:

                    
                    break;
            }

        } while (opc != 6);

    }

    public static void verMenu() {

        System.out.println("1.- Alta clientes: ");
        System.out.println("2.- Baja clientes: ");
        System.out.println("3.- Modificación cliente: ");
        System.out.println("4.- Listado clientes: ");
        System.out.println("5.- Consulta clientes: ");
        System.out.println("6.- Finalizar");
        System.out.println("Elige una opción: ");
    }

}
