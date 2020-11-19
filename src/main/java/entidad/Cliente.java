/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.util.Scanner;

/**
 *
 * @author mati
 */
public class Cliente {
    private int dni;
    private String nombre;
    private String apellido1;
    private String apellidos2;
    private String nick;
    private String password;
    private int moroso;
    private float saldo;

    public Cliente(int dni, String nombre, String apellido1, String apellidos2, String nick, String password, int moroso, float saldo) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellidos2 = apellidos2;
        this.nick = nick;
        this.password = password;
        this.moroso = moroso;
        this.saldo = saldo;
    }

    public Cliente() {
    }
    
    

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellidos2() {
        return apellidos2;
    }

    public void setApellidos2(String apellido2) {
        this.apellidos2 = apellido2;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMoroso() {
        return moroso;
    }

    public void setMoroso(int moroso) {
        this.moroso = moroso;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Cliente{" + "dni=" + dni + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellidos2=" + apellidos2 + ", nick=" + nick + ", password=" + password + ", moroso=" + moroso + ", saldo=" + saldo + '}';
    }
    
    
    
}
