/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devpaula.model.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Peu Souza
 */
@Entity
@Table (name= "Estudante")
public class Estudante{
    @Id   
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="CODIGO")
    int codigo;
    @Column(length = 40)
    String nome;
    @Column(length = 50)
    String email;
    @Column(length = 20)
    String senha;
    @Column(name="ANO_ENTRADA")
    int anoEntrada;
    
    // Denuncia denuncia;
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getAnoEntrada() {
        return anoEntrada;
    }

    public void setAnoEntrada(int anoEntrada) {
        this.anoEntrada = anoEntrada;
    }
    
    
}
