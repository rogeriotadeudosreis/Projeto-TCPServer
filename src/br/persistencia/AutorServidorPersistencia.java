package br.persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.JOptionPane;
import br.interfaces.ICRUDautor;
import java.io.File;
import java.util.ArrayList;

public class AutorServidorPersistencia implements ICRUDautor {

    private String nomeDoArquivo;

    public AutorServidorPersistencia() throws Exception {

    }

    public AutorServidorPersistencia(String nomeDoArquivo) throws Exception {
        this.nomeDoArquivo = nomeDoArquivo;
    }

    private void verificarArquivo() throws Exception {
        File arquivo = new File(this.nomeDoArquivo);
        if (!arquivo.exists()) {
            arquivo.createNewFile();
            System.out.println("Criado o arquivo [" + this.nomeDoArquivo + "]");
        }
    }

    @Override
    public void incluirAutor(String objeto) throws Exception {
        try {
            verificarArquivo();
            FileWriter fw = new FileWriter(this.nomeDoArquivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(objeto + "#\n");
            bw.close();

        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, "Ocorreu um erro na gravação deste arquivo!" + erro);
        }
    }

    @Override
    public String recuperar() throws Exception {
        try {
            verificarArquivo();
            FileReader fr = new FileReader(this.nomeDoArquivo);
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            String dados = "";
            while ((linha = br.readLine()) != null) {
                dados = dados + linha;
            }
            br.close();
            System.out.println(dados);
            return dados;
        } catch (Exception erro) {
            throw new Exception("Ocorreu um erro ao recuperar o arquivo de autores.txt!" + erro);
        }
    }

    @Override
    public void alterarAutor(String autorAlterado) throws Exception {
        try {
            verificarArquivo();
            ArrayList<String> ArqExistDeAutores = new ArrayList<String>();

            FileReader fr = new FileReader(this.nomeDoArquivo);
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            while ((linha = br.readLine()) != null) {
                ArqExistDeAutores.add(linha);
            }
            br.close();

            FileWriter fw = new FileWriter(this.nomeDoArquivo);
            BufferedWriter bw = new BufferedWriter(fw);

            for (int pos = 0; pos < ArqExistDeAutores.size(); pos++) {
                if (ArqExistDeAutores.get(pos).equalsIgnoreCase(autorAlterado)) {
                    bw.write(autorAlterado + "\n");
                } 
                else {
                    bw.write(ArqExistDeAutores.get(pos)+ "\n");
                }
            }
            bw.close();

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }
    }
    
    public void fecharAplicacao()throws Exception{
        try {
            System.out.println("Fechando a aplicação!\nOk...Cliente encerrando a aplicação!\n");
            
        } catch (Exception erro) {
            throw new Exception("Erro ao fechar a aplicação!\n" + erro);
        }
    }
}
