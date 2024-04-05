/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devpaula.controladores;

import com.devpaula.model.dao.ManagerDao;
import com.devpaula.model.entidades.Estudante;
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
public class EstudanteController {
    
    private Estudante cadastro;
    private Estudante select;
    
    public EstudanteController(){
        this.cadastro= new Estudante();
    }
    
    public void LimparCamposCadastro(){
         this.cadastro= new Estudante();
    }
    
    // cadastrar
    public String cadastrar(){
        
        ManagerDao.getCurrentInstance().insert(this.cadastro);
        
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Estudante Cadastrado com Sucesso!"));
        
    
        return "index";
    }
    
    // ler ou vizualizar 
    public List<Estudante> getAllestudantes(){
    List<Estudante> estudantes = ManagerDao.getCurrentInstance().read("select e from Estudante e",Estudante.class);
  
    return estudantes;
    }
 //edidar ou modificar
       public String editar(){
        
        ManagerDao.getCurrentInstance().update(this.select);
        
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Estudante editado com sucesso"));
        
        return "ListaEstudantes";
        
       } 
       
     //Deletar
       public void delete(){
        
        ManagerDao.getCurrentInstance().delete(this.select);
        
         FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Estudante deletado com sucesso!"));
            
    }

    public Estudante getCadastro() {
        return cadastro;
    }

    public void setCadastro(Estudante cadastro) {
        this.cadastro = cadastro;
    }

    public Estudante getSelect() {
        return select;
    }

    public void setSelect(Estudante select) {
        this.select = select;
    }
 
}
