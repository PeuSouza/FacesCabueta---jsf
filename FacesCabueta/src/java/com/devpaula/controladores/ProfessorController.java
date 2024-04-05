/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devpaula.controladores;

import com.devpaula.model.dao.ManagerDao;
import com.devpaula.model.entidades.Professor;
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
public class ProfessorController {
    private Professor cadastro;
    private Professor select;
    
    public ProfessorController(){
    this.cadastro = new Professor();
    }
    
    public void limparCampos(){
    this.cadastro = new Professor();
    }
    
    public String cadastrar(){
        ManagerDao.getCurrentInstance().insert(this.cadastro);
        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage("Professor(a) adicionado(a) com sucesso!"));
        
        return "index";
    }
    
    public List<Professor> getAllProfessores(){
        List<Professor> professores = ManagerDao.getCurrentInstance()
                .read("select p from Professor p", Professor.class);
        
        return professores;
    }

 //edidar ou modificar
       public String editar(){
        
        ManagerDao.getCurrentInstance().update(this.select);
        
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Professor editado com sucesso"));
        
        return "ListaProfessores";
        
       } 
       
     //Deletar
       public void delete(){
        
        ManagerDao.getCurrentInstance().delete(this.select);
        
         FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Professor deletado com sucesso!"));
            
    }
 
    public Professor getCadastro() {
        return cadastro;
    }

    public void setCadastro(Professor cadastro) {
        this.cadastro = cadastro;
    }

    public Professor getSelect() {
        return select;
    }

    public void setSelect(Professor select) {
        this.select = select;
    }

}
