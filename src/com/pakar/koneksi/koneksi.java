/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pakar.koneksi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class koneksi {
  private static Connection mysqlconfig;
  public static Connection configDB() throws SQLException{
      try{
//          String url="jdbc:mysql://localhost/pakar"; //url database
//          String user="adi_sptro"; //user database
//          String pass="12345678"; //user password jika ada
          String url="jdbc:mysql://localhost/pakar"; //url database
          String user="adi_sptro"; //user database
          String pass="12345678"; //user password jika ada
          DriverManager.registerDriver(new com.mysql.jdbc.Driver());
          mysqlconfig=DriverManager.getConnection(url, user, pass);
      } catch (Exception e){
          //Untuk menampilkan jika Koneksi Gagal
          System.err.println(" Koneksi Gagal "+e.getMessage());
      }
      return mysqlconfig;
  }
}

