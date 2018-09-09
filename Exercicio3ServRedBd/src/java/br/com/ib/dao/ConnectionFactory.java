/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ib.dao;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author daniel
 */
public class ConnectionFactory {
    public static Connection getConnection() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Conectado com sucesso!");
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/exerc3",
                    "root", "root");
        }catch(Exception e) {
            throw new RuntimeException(e);
        }
    }  
}
