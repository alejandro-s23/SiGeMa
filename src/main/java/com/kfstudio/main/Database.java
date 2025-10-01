/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kfstudio.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author alejandro
 */
public class Database {
    
    // Informações de conexão com o banco de dados
    private String url = "jdbc:postgresql://localhost:5432/cautelasDB";
    private String usuario = "alejandro";
    private String senha = "277353";
    private Connection cnx = null;
    
    public Database(){
        
        
        
    }
    
    public ResultSet scriptSql(String sql, boolean retorno) throws SQLException{
        cnxBD();
        try{
            Statement stt = cnx.createStatement();
            if(retorno){
                ResultSet rs = stt.executeQuery(sql);
                fecharCnxBD();
                return rs;
            }else {
                stt.execute(sql);
                return null;
                
            }
            
        }catch (SQLException e){System.err.println("Erro no script sql");e.printStackTrace();return null;}
        
    }
    
    public void addMat(Material mat) throws SQLException{
        String sql = "INSERT INTO materiais (material, tipo, previsto, existente, sit_carga) VALUES ('"+ mat.getMaterial() +"', '"+ mat.getTipo() +"', "+ mat.getPrevisto() +", "+ mat.getExistente() +", " + mat.getSitCarga() + " );";
        cnxBD();
        scriptSql(sql,false);
        fecharCnxBD();
        System.out.println("Dados inseridos com sucesso");
    }
    
    private String[] dadosBD(){
        
        return null;
        
    }
    // Método para criar uma conexão com o banco de dados
    private Connection cnxBD() throws SQLException{
        
        try{
            
            if (cnx == null){
                cnx = DriverManager.getConnection(url, usuario, senha);
                System.out.println("Conectado com sucesso!");
            }else if (cnx.isClosed()){
                cnx = null;
                return cnxBD();
            }
            
        } catch (SQLException e){
            
            System.err.println("Erro na conexão com o banco de dados~");
            e.printStackTrace();
            return null;
           
        }
        return cnx;
    }
    
    // Fechar conexao
    private void fecharCnxBD(){
        
        if(cnx != null){
            try{
                cnx.close();
                System.out.println("Conexao encerrada");
            } catch(SQLException e){System.err.println("Falha ao fechar a conexao");e.printStackTrace();}
        }
        
    }
    
}
