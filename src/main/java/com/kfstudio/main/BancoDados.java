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
import java.time.ZoneId;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author alejandro
 */
public class BancoDados {
    
    // Informações de conexão com o banco de dados
    private static String url = "jdbc:postgresql://localhost:5432/cautelasDB";
    private static String usuario = "alejandro";
    private static String senha = "277353";
    private static ArrayList<Material> materiais;
    private static ArrayList<Cautela> cautelas;
    private static Connection cnx = null;
    private static Statement stt = null;
    
    public static void carregarMateriais(boolean fecharCnx){
        
        ArrayList<Material> temp = new ArrayList<Material>();
        Material mat = null;
        String sql = "SELECT * FROM materiais";
        try{
            ResultSet rs = scriptSql(sql, true, fecharCnx);
            while(rs.next()){
                mat = new Material();
                mat.setId(rs.getInt("id"));
                mat.setMaterial(rs.getString("material"));
                mat.setTipo(rs.getString("tipo"));
                mat.setPrevisto(rs.getInt("previsto"));
                mat.setExistente(rs.getInt("existente"));
                mat.setSitCarga(rs.getBoolean("sit_carga"));
                mat.setCautelado(getQntCautelas(mat,false));
                temp.add(mat);
            }
            materiais = temp;
        }catch(SQLException e){System.err.println("Falha ao carregar os materiais");e.printStackTrace();}
    }
    
    public static void carregarCautelas(boolean fecharCnx){
        
        ArrayList<Cautela> temp = new ArrayList<Cautela>();
        Cautela caut = null;
        String sql = "SELECT * FROM cautelas;";
        try{
            ResultSet rs = scriptSql(sql, true,fecharCnx);
            while(rs.next()){
                caut = new Cautela();
                caut.setId(rs.getInt("id"));
                caut.setMaterialId(rs.getInt("material_id"));
                caut.setQnt(rs.getInt("qnt"));
                caut.setData_cautela(rs.getDate("data_cautela"));
                caut.setPg(rs.getString("pg"));
                caut.setNome(rs.getString("nome"));
                caut.setObs(rs.getString("obs"));
                caut.setSit_cautela(rs.getBoolean("sit_cautela"));
                caut.setData_descautela(rs.getDate("data_descautela"));
                caut.setDescautelado(rs.getInt("descautelado"));
                temp.add(caut);
            }
        }catch(SQLException e){e.printStackTrace();}
        cautelas = temp;
    }
    
    public static int getListSize(Class cls){
        
        if(cls == Material.class){
            return materiais.size();
        }else if(cls == Cautela.class){
            return cautelas.size();
        }
        return -1;
    }
    
    public static Material getMaterial(int id){
        for(int i = 0; i < materiais.size(); i++){
            if(materiais.get(i).getId() == id){
                return materiais.get(i);
            }
        }
        return null;
    }
    
    public static Cautela getCautela(int id){
        
        for(int i = 0; i < cautelas.size(); i++){
            if(cautelas.get(i).getId() == id){
                return cautelas.get(i);
            }
        }
        return null;
    }
    
    private static int getQntCautelas(Material mat, boolean fecharCnx){
        
        try {
            String sql = "SELECT COUNT(*) FROM cautelas WHERE material_id = " + mat.getId();
            ResultSet rs = scriptSql(sql, true,fecharCnx);
            if(rs.next()){
                return rs.getInt("count");
            }

        } catch (SQLException e){e.printStackTrace();}
        
        return -1;
    }
    
    public static void addMatTabela(Material mat, JPanel parent, boolean fecharCnx){
        
        String sql = "INSERT INTO materiais (material, tipo, previsto, existente, sit_carga) VALUES ('"+mat.getMaterial()+"', '"+mat.getTipo()+"', '"+mat.getPrevisto()+"', '"+mat.getExistente()+"', '"+mat.getSitCarga()+"')";
        System.out.println(sql);
        scriptSql(sql,false,false);
        carregarMateriais(fecharCnx);
        JOptionPane.showMessageDialog(parent, "Material: " + getMaterial(materiais.getLast().getId())+"\n Adicionado com sucesso");
        
    }
    
    public static void addCautela(Cautela caut, JPanel parent, boolean fecharCnx){
        
        String sql = "INSERT INTO cautelas (material_id, qnt, data_cautela, pg, nome, obs) VALUES ("+caut.getMaterial_id()+", "+caut.getQnt()+", '"+caut.getData_cautela()+"', '"+caut.getPg()+"', '"+caut.getNome()+"', '"+caut.getObs()+"')";
        System.out.println(sql);
        scriptSql(sql,false,false);
        carregarCautelas(false);
        carregarMateriais(fecharCnx);
        JOptionPane.showMessageDialog(parent, "Material: " + caut+"\n Adicionado com sucesso");
        
    }
    
    public static void descautelarMat(Cautela caut, boolean fecharCaut, boolean fecharCnx){
        
        String sql = "UPDATE cautelas SET descautelado = " + caut.getDescautelado() + ", qnt = " + caut.getQnt();
        String sqlMatId = " WHERE id = " + caut.getId() + ";";
        if(fecharCaut)
            sql += ", sit_cautela = FALSE, data_descautela = CURRENT_DATE";
        sql += sqlMatId;
        scriptSql(sql,false,false);
        carregarCautelas(false);
        carregarMateriais(fecharCnx);
        System.out.println(sql);
        
    }
    
    private static ResultSet scriptSql(String sql, boolean retorno, boolean fecharCnx){
        
        try{
            if(cnx == null || cnx.isClosed())
                cnxBD();
            stt = cnx.createStatement();
            if(retorno){
                ResultSet rs = stt.executeQuery(sql);
                if(fecharCnx)
                    fecharCnxBD();
                return rs;
            }else {
                if(fecharCnx)
                    fecharCnxBD();
                stt.execute(sql);
                return null;
            }
            
        }catch (SQLException e){System.err.println("Erro no script sql");e.printStackTrace();return null;}
        
    }
    
    private static String[] dadosBD(){
        
        return null;
        
    }
    // Método para criar uma conexão com o banco de dados
    private static Connection cnxBD(){
        
        try{
            
            if (cnx == null){
                cnx = DriverManager.getConnection(url, usuario, senha);
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
    private static void fecharCnxBD(){
        
        if(cnx != null){
            try{
                cnx.close();
            } catch(SQLException e){System.err.println("Falha ao fechar a conexao");e.printStackTrace();}
        }
        
    }
    
}
