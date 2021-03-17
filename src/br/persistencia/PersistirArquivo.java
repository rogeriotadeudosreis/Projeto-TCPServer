/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.persistencia;

/**
 *
 * @author roger
 */
public class PersistirArquivo {

    public String path;

    public PersistirArquivo(String path) {
        this.path = path;
    }

    public String persistirArq(String objeto) throws Exception {
        String msg = new String();
        String[] opObjeto = objeto.split(";");
        
        if (opObjeto[1].equals("Autor")) {
            System.out.println("Persistir autor...");
            
            AutorServidorPersistencia arq = new AutorServidorPersistencia(path + "Autor.txt");
            if (opObjeto[0].equals("1")) {
                arq.incluirAutor(opObjeto[2] + ";"  +  opObjeto[3]);
                msg = "ok --> autor";
            }
            if (opObjeto[0].equals("2")) {
                msg = arq.recuperar();
            }
            if (opObjeto[0].equals("3")) {
                arq.alterarAutor(opObjeto[2] + ";" + opObjeto[3]);
            }
           
        }
        return msg;
    }

}
