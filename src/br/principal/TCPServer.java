/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.principal;

import br.persistencia.PersistirArquivo;
import br.service.ComunicadorTCP;
import java.io.IOException;

/**
 *
 * @author daniel
 */
public class TCPServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, Exception {
        // TODO code application logic here
        int porta = 6789;
        String mensagem;
        String path = new String();

        path = "/home/rogerio/tcpServer/";
        PersistirArquivo objeto = new PersistirArquivo(path);
        System.out.println("Comunicação iniciada...");
        while (true) {

            ComunicadorTCP comunicacao = new ComunicadorTCP(porta);
            mensagem = comunicacao.receberMensagem();
            System.out.println("Msg - client " + mensagem);
            mensagem = objeto.persistirArq(mensagem);
            comunicacao.enviarMensagem(mensagem);
            //comunicacao.getSocket();
            comunicacao.getServerSocket().close();
            System.out.println("Comunicação em andamento...");

        }
    }
}
