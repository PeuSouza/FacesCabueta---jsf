/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devpaula.controladores;

import com.devpaula.model.dao.ManagerDao;
import com.devpaula.model.entidades.Cadeira;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Peu Souza
 */
@ManagedBean
@SessionScoped
public class CadeiraController {
    
    private Cadeira cadastro;
    private Cadeira select;
   
    public CadeiraController(){
        this.cadastro= new Cadeira();
    }
    
    public void LimparDados(){
        this.cadastro= new Cadeira();
    }
    
    //cadastrar
    
    public String cadastrar(){
        ManagerDao.getCurrentInstance().insert(this.cadastro);
        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage("Cadeira adicionada com sucesso!"));
        
        return "index";
    }
    
    // listar ou vizualizar
    public List<Cadeira> getAllCadeiras(){
        List<Cadeira> cadeiras = ManagerDao.getCurrentInstance()
                .read("select c from Cadeira c", Cadeira.class);
        
        return cadeiras;
    }
    
    //edidar ou modificar
       public String editar(){
        
        ManagerDao.getCurrentInstance().update(this.select);
        
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Cadeira editada com sucesso"));
        
        return "ListadeCadeiras";
        
       } 
       
     //Deletar
       public void delete(){
        
        ManagerDao.getCurrentInstance().delete(this.select);
        
         FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Cadeira deletada com sucesso!"));
            
    }


    public Cadeira getCadastro() {
        return cadastro;
    }

    public void setCadastro(Cadeira cadastro) {
        this.cadastro = cadastro;
    }

    public Cadeira getSelect() {
        return select;
    }

    public void setSelect(Cadeira select) {
        this.select = select;
    }
    
    
}

