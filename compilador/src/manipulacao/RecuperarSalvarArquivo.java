package manipulacao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Funcionalidade: Classe utilizada para recuperar e salvar arquivos 
 * @author diogo.lehner
 * @date 27/03/2015
 */
public class RecuperarSalvarArquivo {	
    /**
     * Funcionalidade: Retorna conteudo do arquivo txt selecionado
     * @author diogo.lehner
     * @date 27/03/2015
     * @param path
     * @return
     */
    public static String recuperarArquivo(Path path) {
        String linha, conteudo = "";
        try {
                BufferedReader bf = new BufferedReader(new FileReader(path.toString()));
                while((linha = bf.readLine()) != null) {
                        conteudo += linha + "\n";
                }
                bf.close();
        } 
        catch (Exception e) {
                System.err.println("Erro ao abrir o arquivo " + path + "\n" + e.getMessage());
        }
        return conteudo;
    }

    /**
     * Funcionalidade: Salva arquivo
     * @author diogo.lehner
     * @date 27/03/2015
     * @param conteudo
     * @param path
     * @return
     */
    public static String salvar(String conteudo, Path path) {
        BufferedWriter bf;

        try {
            if (!Files.exists(path)){
                    Files.createFile(path);
            }	
            bf = new BufferedWriter(new FileWriter(path.toString()));
            bf.write(conteudo);
            bf.flush();
            bf.close();
        } 
        catch (Exception e) {
            System.err.println("Erro ao salvar o arquivo " + path + "\n" + e.getMessage());
        }
        
        return conteudo;
    }
}
