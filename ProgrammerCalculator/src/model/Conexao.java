package model;

import controller.user.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* @author Alex Bonadio Classe: 305 Pacote: 704 */
public class Conexao {

    private Connection conn = null;
    private String msg = "";
    private String ip = "192.168.0.65";
    //private String ip = "192.168.0.38"; // CentOS 7 antigo
    private String data_registro = "";

    public Conexao() {
    }

    public boolean conectarDataBase() {
        boolean check = false;
        msg = "";
        try {
//          String de Conexão com o MySQL    
//            String driverName = "com.mysql.jdbc.Driver";
//            Class.forName(driverName).newInstance();
//            String serverName = ip;
//            String portNumber = "3306";
//            String schema = "conversor";
//            String url = "jdbc:mysql://" + serverName + ":" + portNumber + "/" + schema;
//            String username = "userConversor";
//            String password = "User159753";
//            conn = DriverManager.getConnection(url, username, password);

//          String de Conexão com o Oracle DataBase
            String driverName = "oracle.jdbc.driver.OracleDriver";
            Class.forName(driverName);
            String serverName = ip;
            String portNumber = "1521";
            String sid = "xe";
            String url = "jdbc:oracle:thin:@" + serverName + ":" + portNumber + ":" + sid;
            String username = "system";
            String password = "cabala";
            conn = DriverManager.getConnection(url, username, password);

//            String de Conexão com o Postgres
//            String driverName = "org.postgresql.Driver";
//            Class.forName(driverName);
//            String serverName = ip;
//            String portNumber = "5432";
//            String database = "calculator";
//            String url = "jdbc:postgresql://"+ serverName +":"+ portNumber +"/" + database;
//            String username = "postgres";
//            String password = "cabala";
//            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Conectado ao IP: " + ip);
            msg = msg + "[DataBase Online]\n";
            msg = msg + "Conectado ao IP: " + ip + "\n\n";
            check = true;
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro.getMessage());
            System.out.println("Não foi possível conectar ao IP: " + ip);
            msg = msg + "Não foi possível conectar ao IP: " + ip + "\n\n";
            check = false;
//mysql        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException erro) {
        } catch (ClassNotFoundException erro) {
            System.out.println("Erro: " + erro.getMessage());
            check = false;
        }
        return check;
    }

    public boolean inserirConversoesDataBase(String binario, String ternario, String octal, String decima, String hexadecimal, Integer id_usuario, String numero, int base) {
        boolean check = false;
        msg = "";
        try {
            String sql;
//        Oracle Insert
//          sql = "insert into conversao (binario, ternario, octal, decima, hexadecimal, data_registro, id_usuario) values(?,?,?,?,?,?,?)";
            sql = "insert into conversao (binario, ternario, octal, decima, hexadecimal, data_registro, id_usuario, numero, base) "
                    + "values('" + binario + "','" + ternario + "','" + octal + "','" + decima + "','" + hexadecimal + "',"
                    + "to_date('" + data_registro + "', 'dd/mm/yyyy hh24:mi:ss'),'" + id_usuario + "', '" + numero + "', '" + base + "')";

//            // MySQL Insert
//            sql = "insert into conversao (binario, ternario, octal, decima, hexadecimal, data_registro, id_usuario, numero, base) "
//                    + "values('" + binario + "','" + ternario + "','" + octal + "','" + decima + "','" + hexadecimal + "',"
//                    + "STR_TO_DATE('" + data_registro + "', '%d/%m/%Y %H:%i:%s'),'" + id_usuario + "', '" + numero + "', '" + base + "')";

            PreparedStatement execucao = conn.prepareStatement(sql);
//          execucao.execute(sql);
//          execucao.setString(1, binario);
//          execucao.setString(2, ternario);
//          execucao.setString(3, octal);
//          execucao.setString(4, decima);
//          execucao.setString(5, hexadecimal);
//          execucao.setString(6, data_in);
//          execucao.setInt(7, id_usuario);

            if (execucao.executeUpdate() > 0) {
                System.out.println("Dados Gravados com Sucesso!");
                msg = msg + "Dados Gravados com Sucesso!\n\n";
                check = true;
            }
            execucao.clearParameters();
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro.getMessage());
            msg = msg + "Erro ao Gravar os Dados\n\n";
            check = false;
        }
        return check;
    }

    public boolean inserirUserDataBase(String nome, String ip, String hostname) {
        boolean check = false;
        msg = "";
        try {
            
//          String sql = "insert into usuario (nome, ip, hostname) values(?,?,?)";
//          Oracle Insert
            String sql = "insert into usuario (nome, ip, hostname, data_registro) "
                    + "values('" + nome + "', '" + ip + "', '" + hostname + "',"
                    + "to_date('" + data_registro + "', 'dd/mm/yyyy hh24:mi:ss'))";
            // MySQL Insert
//            String sql = "insert into usuario (nome, ip, hostname, data_registro) "
//                    + "values('" + nome + "', '" + ip + "', '" + hostname + "',"
//                    + "STR_TO_DATE('" + data_registro + "', '%d/%m/%Y %H:%i:%s'))";

            PreparedStatement execucao = conn.prepareStatement(sql);
//          execucao.setString(1, nome);
//          execucao.setString(2, ip);
//          execucao.setString(3, hostname);
            if (execucao.executeUpdate() > 0) {
                System.out.println("Usuário Registrado");
                msg = msg + "Usuário Registrado \n\n";
                check = true;
            }
            execucao.clearParameters();
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro.getMessage());
            msg = msg + "Não foi possível Registrar o Usuário \n\n";
            check = false;
        }
        return check;
    }

    public int consultarUserDataBase(String nome, String ip, String hostname, Usuario user) {
        int check = 0;
        msg = "";
        try {
            String sql = "select * from usuario "
                    + "where nome = '" + nome + "' and ip = '" + ip
                    + "' and hostname = '" + hostname + "'";
            PreparedStatement execucao = conn.prepareStatement(sql);
            ResultSet resposta = execucao.executeQuery(sql);

            if (resposta.isBeforeFirst() == false) {
                System.out.println("Não há Usuário Registrado no DataBase");
                msg = msg + "Não há Usuário Registrado no MySQL\n\n";
                check = 0;
            } else {
                while (resposta.next()) {
                    // Todas as Tuplas são trazidas
                    System.out.println("[DataBase]");
                    //  msg = msg + "[DataBase]\n";

                    System.out.println("[Usuário]: " + resposta.getString("nome"));
                    msg = msg + "[Usuário]: " + resposta.getString("nome") + "\n";
                    user.setNome(resposta.getString("nome"));

                    System.out.println("[ID]: " + resposta.getString("id_usuario"));
                    msg = msg + "[ID]: " + resposta.getString("id_usuario") + "\n";
                    user.setId_usuario((Integer) resposta.getInt("id_usuario"));

                    System.out.println("[IP]: " + resposta.getString("ip"));
                    msg = msg + "[IP]: " + resposta.getString("ip") + "\n";
                    user.setIp(resposta.getString("ip"));

                    System.out.println("[Hostname]: " + resposta.getString("hostname"));
                    msg = msg + "[Hostname]: " + resposta.getString("hostname") + "\n";
                    user.setHostname(resposta.getString("hostname"));

                    System.out.println("[Data do Registro]: " + resposta.getDate("data_registro"));
                    msg = msg + "[Data do Registro]: " + resposta.getDate("data_registro") + "\n";

                    System.out.println("[Horário do Registro]: " + resposta.getTime("data_registro"));
                    msg = msg + "[Horário do Registro]: " + resposta.getTime("data_registro") + "\n\n";
                    check = 1;
                }
            }
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro.getMessage());
            msg = msg + "Usuário não Localizado\n\n";
            check = 2;
        }
        return check;
    }

    public boolean consultarConversoesDataBase(Integer id_usuario) {
        // Metodo faz consulta no DataBase
        boolean check = false;
        msg = "";
        try {
            String sql = "select * from conversao where id_usuario like '" + id_usuario + "'";
            PreparedStatement execucao = conn.prepareStatement(sql);
            ResultSet resposta = execucao.executeQuery(sql);
            if (resposta.isBeforeFirst() == false) {
                System.out.println("Não há Registros no Banco de Dados!");
                msg = msg + "Não há Registros no Banco de Dados! \n\n";
                check = true;
            } else {
                System.out.println("");
                while (resposta.next()) {
                    // Todas as Tuplas são trazidas
                    System.out.println("[DataBase]");
                    System.out.println("[Conversões]");
                    msg = msg + "[DataBase]\n";
                    msg = msg + "[Conversões]\n";
                    msg = msg + "[Data]: " + resposta.getDate("data_registro") + "\n";
                    System.out.println("[Data]: " + resposta.getDate("data_registro"));
                    System.out.println("[Horario]: " + resposta.getTime("data_registro"));
                    msg = msg + "[Horario]: " + resposta.getTime("data_registro") + "\n";
                    System.out.println("[ID do Usuário]: " + resposta.getString("id_usuario"));
                    msg = msg + "[ID do Usuário]: " + resposta.getString("id_usuario") + "\n";
                    System.out.println("[ID da Conversão]: " + resposta.getString("id_conversao"));
                    msg = msg + "[ID da Conversão]: " + resposta.getString("id_conversao") + "\n";

                    System.out.println("[Número Digitado]: " + resposta.getString("numero"));
                    msg = msg + "[Número Digitado]: " + resposta.getString("numero") + "\n";

                    System.out.println("[Base]: " + resposta.getInt("base"));
                    msg = msg + "[Base]: " + resposta.getInt("base") + "\n";

                    System.out.println("[Binario]: " + resposta.getString("binario"));
                    msg = msg + "[Binario]: " + resposta.getString("binario") + "\n";
                    System.out.println("[Ternario]: " + resposta.getString("ternario"));
                    msg = msg + "[Ternario]: " + resposta.getString("ternario") + "\n";
                    System.out.println("[Octal]: " + resposta.getString("octal"));
                    msg = msg + "[Octal]: " + resposta.getString("octal") + "\n";
                    System.out.println("[Decimal]: " + resposta.getString("decima"));
                    msg = msg + "[Decimal]: " + resposta.getString("decima") + "\n";
                    System.out.println("[Hexadecimal]: " + resposta.getString("Hexadecimal") + "\n");
                    msg = msg + "[Hexadecimal]: " + resposta.getString("Hexadecimal") + "\n\n";
                    check = true;
                }
            }
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro.getMessage());
            msg = msg + "Não foi possível Consultar o DataBase!\n\n";
            check = false;
        }
        return check;
    }

    public boolean deletarConversoesDataBase(Integer id_usuario) {
        boolean check = false;
        msg = "";
        try {
            String sql = "delete from conversao where id_usuario ='" + id_usuario + "'";
            PreparedStatement execucao = conn.prepareStatement(sql);
            if (execucao.executeUpdate() > 0) {
                System.out.println("Conversões Apagadas com Sucesso!!\n");
                msg = msg + "Conversões Apagadas com Sucesso!!\n\n";
            } else {
                System.out.println("Não há Conversões no DataBase para Apagar!\n");
                msg = msg + "Não há Conversões no DataBase para Apagar!\n\n";
            }
            check = true;
            execucao.clearParameters();
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro.getMessage());
            msg = msg + "Erro ao Deletar os Dados! Não foi Deletado\n\n";
            check = false;
        }
        return check;
    }

    public boolean deletarUserDataBase(Integer id_usuario) {
        boolean check = false;
        msg = "";
        try {
            String sql = "delete from usuario where id_usuario ='" + id_usuario + "'";
            PreparedStatement execucao = conn.prepareStatement(sql);
            if (execucao.executeUpdate() > 0) {
                System.out.println("Usuário Deletado com Sucesso!\n");
                msg = msg + "Usuário Deletado com Sucesso!\n\n";
            }
            check = true;
            execucao.clearParameters();
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro.getMessage());
            msg = msg + "Usuário não foi Deletado!\n\n";
            check = false;
        }
        return check;
    }

    public boolean atualizarUserDataBase(String nome, String ip, String hostname, Usuario user) {
        boolean check = false;
        msg = "";
        try {
            String sql = "update usuario set nome = '" + nome + "', ip = '" + ip + "', hostname = '" + hostname + "'"
                    + " where id_usuario = '" + user.geId_usuario() + "'";
            PreparedStatement execucao = conn.prepareStatement(sql);
            if (execucao.executeUpdate() > 0) {
                System.out.println("Usuário: " + user.getNome() + ", ID: " + user.geId_usuario() + "foi atualizado com Sucesso!");
                msg = msg + "Usuário: " + user.getNome() + ", ID: " + user.geId_usuario() + " foi atualizado com Sucesso!\n\n";
            }
            execucao.clearParameters();
            check = true;
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro.getMessage());
            System.out.println("Usuário não foi Atualizado\n");
            msg = msg + "Usuário não foi Atualizado\n\n";
            check = false;
        }
        return check;
    }

    public boolean fecharConexao() {
        boolean check = false;
        try {
            conn.close();
            if (conn.isClosed() == true) {
                conn = null;
                System.out.println("A Conexão com o Banco de Dados foi fechada\n");
                check = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("A Conexão com o Banco de Dados não foi fechada\n");
            check = false;
        }
        return check;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getData_registro() {
        return data_registro;
    }

    public void setData_registro(String data_registro) {
        this.data_registro = data_registro;
    }
}
