/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kfstudio.main;

/**
 *
 * @author alejandro
 */
public class Material {
    
    private int id = 0;
    private String material;
    private String tipo;
    private boolean sitCarga;
    private int previsto;
    private int existente;
    private int cautelado;
    private int saldo;
    
    public Material(String material, String tipo, int previsto, int existente, boolean sitCarga){
        
        this.material = material;
        this.tipo = tipo;
        this.sitCarga = sitCarga;
        this.previsto = previsto;
        this.existente = existente;
        
    }
    
    public Material(){
        
    }
    
    //Métodos Setters

    public void setId(int id) {
        this.id = id;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setSitCarga(boolean sitCarga) {
        this.sitCarga = sitCarga;
    }

    public void setPrevisto(int previsto) {
        this.previsto = previsto;
    }

    public void setExistente(int existente) {
        this.existente = existente;
    }

    public void setCautelado(int cautelado) {
        this.cautelado = cautelado;
        this.saldo = this.existente-this.cautelado;
    }
    
    //Métodos Getters
    
    public int getId() {
        return id;
    }

    public String getMaterial() {
        return material;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean getSitCarga() {
        return sitCarga;
    }

    public int getPrevisto() {
        return previsto;
    }

    public int getExistente() {
        return existente;
    }

    public int getCautelado() {
        return cautelado;
    }

    public int getSaldo() {
        return saldo;
    }
    
    @Override
    public String toString(){
        return this.id + " | " + this.material + " | Sit Carga: "+this.sitCarga+" P:E:C:S + " + this.previsto+":"+this.existente+":"+this.cautelado+":"+this.saldo;
    }
    
}
