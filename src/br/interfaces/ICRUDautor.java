/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.interfaces;
import java.util.ArrayList;

/**
 *
 * @author roger
 */
public interface ICRUDautor {
    
    void incluirAutor(String autor)throws Exception;
    String recuperar() throws Exception;
    public void alterarAutor(String autorAlterado )throws Exception;
    public void fecharAplicacao()throws Exception;
    
}
