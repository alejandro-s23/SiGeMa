/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kfstudio.main;

import java.util.Date;

/**
 *
 * @author alejandro
 */
public class Cautela {
    
    private int material_id;
    private int qnt;
    private Date data_cautela;
    private String pg;
    private String nome;
    private String obs;
    private boolean sit_cautela;
    private Date data_descautela;
    
    public Cautela(int material_id, int qnt, Date data_cautela, String pg, String nome, String obs, boolean sit_cautela){
        
        this.material_id = material_id;
        this.qnt = qnt;
        this.data_cautela = data_cautela;
        this.pg = pg;
        this.nome = nome;
        this.obs = obs;
        this.sit_cautela = sit_cautela;
        
    }

    public int getMaterial_id() {
        return material_id;
    }

    public int getQnt() {
        return qnt;
    }

    public Date getData_cautela() {
        return data_cautela;
    }

    public String getPg() {
        return pg;
    }

    public String getNome() {
        return nome;
    }

    public String getObs() {
        return obs;
    }

    public boolean isSit_cautela() {
        return sit_cautela;
    }

    public Date getData_descautela() {
        return data_descautela;
    }
    
    
    
}
