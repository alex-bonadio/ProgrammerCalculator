package controller.user;

import view.FrameDataBase;
import view.FrameStart;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Conexao;

/* @author Alex Bonadio Classe: 106 */
public class Usuario {

    // Classe Utilizada para Armazenar os Dados do Usuário
    private Integer id_usuario = 0;
    private String nome = "";
    private String ip = "";
    private String hostname = "";

    public Usuario() {
    }

    public void gravarUser(String nome, String ip, String hostname, Conexao conex, FrameDataBase frameDataBase, Usuario user) {
        // método gravarUser chama o método de inserção do usuário no banco de Dados
        boolean check = conex.inserirUserDataBase(nome, ip, hostname);
        if (check == true) {
            reconsultarUser(nome, ip, hostname, conex, frameDataBase, user);

        }
    }

    public void reconsultarUser(String nome, String ip, String hostname, Conexao conex, FrameDataBase frameDataBase, Usuario user) {
        int check = conex.consultarUserDataBase(nome, ip, hostname, user);
        if (check == 1) {
            frameDataBase.textArea.append("Este novo Usuário foi Registrado no Sistema!\n\n");
        }
    }

    public void consultarUser(Conexao conex, FrameDataBase frameDataBase, Usuario user) {
        // Método pega os dados do micro e compara com os dados do MySQL para saber se o usuario já está registrado no banco
        // Senão tiver, ele prepara a gravação do novo usuário no banco, ou atualiza os seus dados, se só foi trocado o IP do micro
        String[] dados = dadosPC();
        // Método consulta o usuário no banco e salva as informações no objeto user
        int check = conex.consultarUserDataBase(dados[0], dados[1], dados[2], user);
        // chamado método para Validar o Usuário
        if (check == 0) {
            //   validateUser(dados, conex, frameDataBase, user);
            gravarUser(dados[0], dados[1], dados[2], conex, frameDataBase, user);  // metodo para gravação do Usuário no DataBase
        } else if (check == 1) {
            System.out.println("\nUsuário: " + nome + " já existe no Banco de Dados!");
            frameDataBase.textArea.append("Seja Bem-Vindo(a) " + nome + "!\n\n");
        }
    }

    public String[] dadosPC() {
        // Método pega o nome do usuario do S.O., o IP e o nome do micro para verificar se o usuário já está salvo no MySQL
        String[] dados = new String[3];
        try {
            dados[0] = System.getProperty("user.name");                      // pega o nome do usuario do S.O.
            dados[1] = InetAddress.getLocalHost().getHostAddress();         // pega o IP
            dados[2] = InetAddress.getLocalHost().getCanonicalHostName();  // pega o hostname@dominio 
        } catch (UnknownHostException ex) {
            Logger.getLogger(FrameStart.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dados;
    }

    public Integer geId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }
}
