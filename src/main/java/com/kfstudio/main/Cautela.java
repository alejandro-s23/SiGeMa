/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kfstudio.main;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 *
 * @author alejandro
 */
public class Cautela {
    
    private int id = 0;
    private int materialId;
    private int qnt;
    private int descautelado = 0;
    private LocalDate data_cautela;
    private String pg;
    private String nome;
    private String obs;
    private boolean sit_cautela;
    private Date data_descautela;
    private Material material;
    
    public Cautela(int materialId, int qnt, Date data_cautela, String pg, String nome, String obs, boolean sit_cautela){
        
        this.materialId = materialId;
        this.qnt = qnt;
        this.data_cautela = LocalDate.ofInstant(data_cautela.toInstant(), ZoneId.systemDefault());
        this.pg = pg;
        this.nome = nome;
        this.obs = obs;
        this.sit_cautela = sit_cautela;
        
    }
    
    public Cautela(){
        
    }
    
    public boolean descautelar(int qnt){
        
        boolean fecharCaut;
        if(this.descautelado < this.qnt){
            fecharCaut = false;
        }else   {
            fecharCaut = true;
        }
        
        this.descautelado += qnt;
        this.qnt -= qnt;
        
        BancoDados.descautelarMat(this, fecharCaut, true);
        return fecharCaut;
    }
    
    public void setId(int id){
        this.id = id;
    }

    public int getDescautelado() {
        return descautelado;
    }

    public void setDescautelado(int descautelado) {
        this.descautelado = descautelado;
    }

    public void setMaterialId(int material_id) {
        this.materialId = material_id;
        this.material = BancoDados.getMaterial(material_id);
    }

    public void setQnt(int qnt) {
        this.qnt = qnt;
    }

    public void setData_cautela(Date dataCautela) {
        this.data_cautela = LocalDate.from(Instant.ofEpochMilli(dataCautela.getTime()).atZone(ZoneId.systemDefault()).toLocalDate());
    }
    
    public void setData_cautela(LocalDate data_cautela){
        this.data_cautela = data_cautela;
    }

    public void setPg(String pg) {
        this.pg = pg;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public void setSit_cautela(boolean sit_cautela) {
        this.sit_cautela = sit_cautela;
    }

    public void setData_descautela(Date data_descautela) {
        this.data_descautela = data_descautela;
    }
    
    public String getMaterialName(){
        return this.material.getMaterial();
    }
    
    public int getId(){
        return this.id;
    }

    public int getMaterial_id() {
        return materialId;
    }

    public int getQnt() {
        return qnt;
    }

    public LocalDate getData_cautela() {
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

    public boolean getSit_cautela() {
        return sit_cautela;
    }

    public Date getData_descautela() {
        return data_descautela;
    }
    
    @Override
    public String toString(){
        return material.getMaterial() + " | " + this.qnt + " | " + this.data_cautela + " | " + this.pg + " " + this.nome + " | " + this.obs;
    }
    
}
