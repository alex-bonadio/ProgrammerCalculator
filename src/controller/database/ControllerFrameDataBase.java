package controller.database;

import controller.user.Usuario;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Conexao;
import view.FrameDataBase;

/**
 *
 * @author Alex
 */
public class ControllerFrameDataBase {

    public Usuario user;
    public Conexao conexao;
    public FrameDataBase frameDataBase;

    public ControllerFrameDataBase() {
        user = new Usuario();
        conexao = new Conexao();
        frameDataBase = new FrameDataBase();
    }

    public boolean deletar() {
        boolean check = false;
        if (conexao.getConn() != null) {
            check = conexao.deletarConversoesDataBase(user.geId_usuario());
            frameDataBase.textArea.append(conexao.getMsg());
        } else {
            System.out.println("Não foi Possível Deletar os Resultados!\nO DataBase está OFFLINE!\n\n");
            frameDataBase.textArea.append("Não foi Possível Deletar os Resultados!\nO DataBase está OFFLINE!\n\n");
            check = false;
        }
        return check;
    }

    public boolean consultar() {
        boolean check = false;
        if (conexao.getConn() != null) {
            check = conexao.consultarConversoesDataBase(user.geId_usuario());
            frameDataBase.textArea.append(conexao.getMsg());
        } else {
            frameDataBase.textArea.append("Não foi Possível Consultar o DataBase!\n\n");
            check = false;
        }
        return check;
    }

    // método valida se o IPv4 está no formato correto e se estiver o usará para conectar o programa no MySQL
    public void configurarIP() throws IOException {
        boolean check = true;  // se o IP estiver correto, check no final do método continuará TRUE
        String ip = JOptionPane.showInputDialog("Qual é o IPv4 do Servidor do Banco de Dados?");
        if (ip == null) {
            System.out.println("Configuração Cancelada");
            JOptionPane.showMessageDialog(null, "Configuração Cancelada");
            frameDataBase.textArea.append("Configuração Cancelada\n\n");
        } else {                            // bloco else verifica se o ip tem pontos
            int i = 0, c = 0;
            for (; ip.length() > i; i++) {
                if (ip.charAt(i) == '.') {  // percorre a string ip e incrementa c, se tiver pontos
                    c = c + 1;
                }
            }
            if (c != 3) {         // verifica se o IP tem mais, ou menos de 3 pontos
                check = false;   // se tiver, o IP é Inválido
            } else {            // se tiver apenas 3 pontos, é checado se o IP tem 4 partes
                String[] ipSplited = ip.split("\\.");  // divide o IP em partes pelos pontos
                if (ipSplited.length != 4) {          // se a quant. de partes forem diferentes de 4, check será false
                    check = false;                   // se forem, o IP é Inválido
                } else {                            // se o IP tem 4 partes, então é válido 
                    int num = 0, count = 0;
                    for (String parteIP : ipSplited) {        // for percorre cada parte do ip
                        if (parteIP.matches("^[0-9]*$")) {    // verifica se cada parte só tem números 
                            num = Integer.valueOf(parteIP);   // se tiver, converte a string em inteiro
                            if (count == 0) {
                                if (num >= 1 && num <= 255) {     // verifica se a 1º parte do ip é >=1 e <=255
                                    check = true;                 // se for, check fica verdadeiro
                                } else {
                                    check = false;                // senão, fica falso
                                    break;
                                }
                            } else {
                                if (num >= 0 && num <= 255) {     // verifica se as 3 últimas partes do ip são >=0 e <=255
                                    check = true;                 // se for, check fica verdadeiro
                                } else {
                                    check = false;                // senão, fica falso
                                    break;
                                }
                            }
                        } else {                              // se tem letras, caracteres especiais
                            check = false;                    // check é configurado para false
                            break;                            // para o loop a força, já que se tiver uma parte errada, todo o IP será inválido
                        }
                        count++;
                    }
                }
            }
        }
        exibirMsgConfigIP(check, ip);
    }

    public void exibirMsgConfigIP(boolean check, String ip) throws IOException {
        if (check == false) {                          // se o ip nao passou na validação, check é falso
            System.out.println("IP Inválido: " + ip); // assim a mensagem de ip inválido é exibida
            JOptionPane.showMessageDialog(null, "IP Inválido: " + ip);
            frameDataBase.textArea.append("IP Inválido: " + ip + "\n\n");
            configurarIP();                          // se o IP não passou no Teste, o método é chamado 
        } else {                                     // se passou no teste e a string ip não é nula
            if (ip != null) {                        // então é tentado fazer a conexao com o DataBase
                conexao.setIp(ip);
//                gravarIP(ip);
                conexao.conectarDataBase();
                frameDataBase.textArea.append(conexao.getMsg());
                if (conexao.getConn() != null) {
                    user.consultarUser(conexao, frameDataBase, user);
                    frameDataBase.textArea.append(conexao.getMsg());
                }
            }
//            if (ip == null) {
//                lerIP();
//            }
        }
    }

//    public void gravarIP(String ip) throws IOException {
//        try {
//            FileWriter iptext = new FileWriter("c:\\ip.txt");
//            try (PrintWriter iptextwriter = new PrintWriter(iptext)) {
//                iptextwriter.printf(ip);
//            }
//        } catch (IOException ex) {
//        }
//    }

//    public void lerIP() {
//        try {
//            BufferedReader buffRead = new BufferedReader(new FileReader("c:\\ip.txt"));
//            String ip;
//            try {
//                ip = buffRead.readLine();
//                conexao.setIp(ip);
//            } catch (IOException ex) {
//                Logger.getLogger(ControllerFrameDataBase.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(ControllerFrameDataBase.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
}
