/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.frameStart;

import controller.numericSystems.Octal;
import controller.numericSystems.SistemaNumerico;
import controller.numericSystems.Hexadecimal;
import controller.numericSystems.Decimal;
import controller.numericSystems.Ternario;
import controller.numericSystems.Binario;
import controller.database.ControllerFrameDataBase;
import view.FrameStart;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Alex
 */
public class ControllerFrameStart {

    public Binario base2;
    public Ternario base3;
    public Octal base8;
    public Decimal base10;
    public Hexadecimal base16;
    public ControllerFrameDataBase controllerFrameDataBase;
    public FrameStart start;

    public ControllerFrameStart() {
        base2 = new Binario();
        base3 = new Ternario();
        base8 = new Octal();
        base10 = new Decimal();
        base16 = new Hexadecimal();
        controllerFrameDataBase = new ControllerFrameDataBase();

    }

    public void getReference(FrameStart start) {
        this.start = start;
    }

    public void conectarDataBase() {
        // método é acionado quando o usuário clica no botão Online
        // ele chama os métodos que fazem a conexão com o DataBase
        configData(); // Pega a data e horário do PC e exibe na Tela e também salva no DataBase
        controllerFrameDataBase.conexao.conectarDataBase();

        if (controllerFrameDataBase.conexao.getConn() != null) {
            setOnline(true); // Quando conectado ao DataBase, imprime "Online" na Tela
            controllerFrameDataBase.frameDataBase.textArea.append(controllerFrameDataBase.conexao.getMsg());
            // Consulta o Usuario no banco de Dados
            controllerFrameDataBase.user.consultarUser(controllerFrameDataBase.conexao, controllerFrameDataBase.frameDataBase, controllerFrameDataBase.user);
            controllerFrameDataBase.frameDataBase.textArea.append(controllerFrameDataBase.conexao.getMsg());
            controllerFrameDataBase.frameDataBase.getReference(controllerFrameDataBase, start);
        } else {
            setOnline(false);
            controllerFrameDataBase.frameDataBase.textArea.append(controllerFrameDataBase.conexao.getMsg());
            controllerFrameDataBase.configurarIP();
            controllerFrameDataBase.frameDataBase.getReference(controllerFrameDataBase, start);
            if (controllerFrameDataBase.conexao.getConn() != null) {
                setOnline(true);
            } else {
                setOnline(false);
            }
        }
        controllerFrameDataBase.frameDataBase.setVisible(true);
    }

    public void setOnline(boolean conectado) {
        // método seta o JLabel quando o app está Online
        if (conectado == true) {
            start.jLabelMsg.setText("DataBase Server : ONLINE");
            //    start.jLabelMsg.setText("Oracle Server : ONLINE");
        } else {
            //    start.jLabelMsg.setText("Oracle Server : OFFLINE");
            start.jLabelMsg.setText("DataBase Server : OFFLINE");
        }
    }

    public SimpleDateFormat[] configData() {
        // método captura a data e horário do PC
        Date data = new Date();
        SimpleDateFormat[] formatDate = new SimpleDateFormat[3];
        formatDate[0] = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        /*Oracle*/
        formatDate[1] = new SimpleDateFormat("dd/MM/yyyy");
        formatDate[2] = new SimpleDateFormat("HH:mm:ss");

        controllerFrameDataBase.conexao.setData_registro(formatDate[0].format(data));
        controllerFrameDataBase.frameDataBase.textArea.append("Data: " + formatDate[1].format(data) + "\n");
        controllerFrameDataBase.frameDataBase.textArea.append("Horario: " + formatDate[2].format(data) + "\n\n");
        System.out.println("Data: " + controllerFrameDataBase.conexao.getData_registro());
        return formatDate;
    }

    public void conversaoHub(SistemaNumerico base, short baseNum) {
        // Método é acionado quando o Usuário seleciona o botão Rádio Binário e clica em Converter
        boolean check = conferir(base.getSaveNum(), (short) baseNum);
        base.setEntrada02(start.inputTextBox.getText());
        base.capturarEntrada();                // validará a capturarEntrada do usuário
        if (base.isValidado() == false) {
            limparEntrada();
            base.setValidado(true);
        } else {
            System.out.println("\n[Conversão]");
            System.out.println("Número Digitado: " + start.inputTextBox.getText() + " na base " + baseNum);
            base.setSaveNum(start.inputTextBox.getText());
            base.setBase((short) baseNum);
            base.multiplicar();     // converterá em decimal  
            String formatar = String.format("%,d", base.getEntrada01());
            start.texto_dec.setText(formatar);   // exibirá em decimal
            switch (baseNum) {
                case 2:
                    conversaoBase3(base.getEntrada01());
                    conversaoBase8(base.getEntrada01());
                    conversaoBase16(base.getEntrada01());
                    break;
                case 3:
                    conversaoBase2(base.getEntrada01());    // número está convertido em decimal
                    conversaoBase8(base.getEntrada01());
                    conversaoBase16(base.getEntrada01());
                    start.texto_tern.setText(base.getEntrada02());
                    break;
                case 8:
                    conversaoBase2(base.getEntrada01());      // número está convertido em decimal
                    conversaoBase3(base.getEntrada01());
                    conversaoBase16(base.getEntrada01());
                    start.texto_oct.setText(base.getEntrada02());
                    break;
                case 10:
                    conversaoBase2(base.getEntrada01());
                    conversaoBase3(base.getEntrada01());
                    conversaoBase8(base.getEntrada01());
                    conversaoBase16(base.getEntrada01());
                    break;
                case 16:
                    conversaoBase2(base.getEntrada01());    // número está convertido em decimal
                    conversaoBase3(base.getEntrada01());
                    conversaoBase8(base.getEntrada01());
                    start.texto_hex.setText(base.getEntrada02().toUpperCase());
                    break;
                default:
                    break;
            }
            String decimal = String.valueOf(base.getEntrada01());
            if (!base2.getEntrada02().isEmpty() && baseNum == 2) {
                conversaoBase2(base.getEntrada01());
            }
            if (baseNum != 2) {
                base.setResultado(base.getEntrada02());
            }
            if (check == false) { // se o número digitado ainda não foi salvo no database
                insertResults(decimal, base); // então ele é salvo. Do contrário, não será salvo novamente
            }
            zerarValores();
        }
    }

    public void conversaoBase2(long entrada01) {
        base2.setEntrada01(entrada01);
        base2.setDivisor((short) 2);
        base2.dividir();     // converterá em binário     
        base2.imprimir();
        start.texto_bin.setText(base2.getResultado());
    }

    public void conversaoBase3(long entrada01) {
        base3.setEntrada01(entrada01);
        base3.setDivisor((short) 3);
        base3.dividir();
        base3.imprimir();
        start.texto_tern.setText(base3.getResultado());
    }

    public void conversaoBase8(long entrada01) {
        base8.setEntrada01(entrada01);
        base8.setDivisor((short) 8);
        base8.dividir();
        base8.imprimir();
        start.texto_oct.setText(base8.getResultado());
    }

    public void conversaoBase16(long entrada01) {
        base16.setEntrada01(entrada01);
        base16.setDivisor((short) 16);
        base16.dividir();
        base16.imprimir();
        start.texto_hex.setText(base16.getResultado());
    }

    public void zerarValores() {
        // Método para Zerar as variáveis de Instância
        base2.setResultado("");
        base3.setResultado("");
        base8.setResultado("");
        base16.setResultado("");

        base2.setBit((short) 0);
        base3.setBit((short) 0);
        base8.setBit((short) 0);
        base10.setBit((short) 0);
        base16.setBit((short) 0);

        base2.setEntrada01(0);
        base3.setEntrada01(0);
        base8.setEntrada01(0);
        base10.setEntrada01(0);
        base16.setEntrada01(0);

        base2.setEntrada02("");
        base3.setEntrada02("");
        base8.setEntrada02("");
        base10.setEntrada02("");
        base16.setEntrada02("");

        start.inputTextBox.requestFocus();
    }

    public void limparEntrada() {
        start.inputTextBox.setText("");
        start.texto_bin.setText("0");
        start.texto_tern.setText("0");
        start.texto_oct.setText("0");
        start.texto_dec.setText("0");
        start.texto_hex.setText("0");
        start.inputTextBox.requestFocus();
    }

    public boolean conferir(String entrada02, short baseNum) {
        boolean check = false;
        if (controllerFrameDataBase.conexao.getConn() != null) {
            if (entrada02.equals(start.inputTextBox.getText())) {
                controllerFrameDataBase.frameDataBase.textArea.append("O número " + entrada02 + " na base " + baseNum + " já foi convertido!\nE não será salvo novamente no Banco de Dados!\n\n");
                System.out.println("O número " + entrada02 + " na base " + baseNum + " já foi convertido!\nE não será salvo novamente no Banco de Dados!\n");
                check = true;
            }
        }
        return check;
    }

    public void insertResults(String decimal, SistemaNumerico base) {
        if (controllerFrameDataBase.conexao.getConn() != null) {
            controllerFrameDataBase.conexao.inserirConversoesDataBase(base2.getResultado(), base3.getResultado(),
                    base8.getResultado(), decimal, base16.getResultado(), controllerFrameDataBase.user.geId_usuario(), base.getEntrada02(), base.getBase());        // insere os resultados no DataBase (Base: conversor)
            controllerFrameDataBase.frameDataBase.textArea.append(controllerFrameDataBase.conexao.getMsg());
        } else {
            base.setSaveNum("");
        }
    }
}
