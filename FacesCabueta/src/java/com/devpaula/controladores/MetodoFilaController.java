/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devpaula.controladores;

import com.devpaula.model.dao.ManagerDao;
import com.devpaula.model.entidades.MetodoFila;
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
public class MetodoFilaController {
    
    private MetodoFila cadastro;
    private MetodoFila select;
    
    public MetodoFilaController(){
    this.cadastro = new MetodoFila();
    }
    
    public void LimparCampos(){
     this.cadastro = new MetodoFila();
    }
    
    // cadastrar
     public String cadastrar(){
        ManagerDao.getCurrentInstance().insert(this.cadastro);
        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage("Metodo da fila adicionada com sucesso!"));
        
        return "index";
    }
    
     //ler 
    public List<MetodoFila> getAllMetodosdefila(){
        List<MetodoFila> metodos = ManagerDao.getCurrentInstance()
                .read("select mf from MetodoFila mf", MetodoFila.class);
        
        return metodos;
    }
     //edidar ou modificar
       public String editar(){
        
        ManagerDao.getCurrentInstance().update(this.select);
        
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Metodo de Fila editado com sucesso"));
        
        return "ListaMetodosFila";
        
       } 
       
     //Deletar
       public void delete(){
        
        ManagerDao.getCurrentInstance().delete(this.select);
        
         FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Metodo de fila deletado com sucesso!"));
            
    }

    
    public MetodoFila getCadastro() {
        return cadastro;
    }

    public void setCadastro(MetodoFila cadastro) {
        this.cadastro = cadastro;
    }

    public MetodoFila getSelect() {
        return select;
    }

    public void setSelect(MetodoFila select) {
        this.select = select;
    }

    
}
