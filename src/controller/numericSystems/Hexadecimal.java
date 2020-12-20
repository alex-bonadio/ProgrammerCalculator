package controller.numericSystems;

import javax.swing.JOptionPane;

/* @author Alex Bonadio Classe: 58 */

public class Hexadecimal extends SistemaNumerico {

    public Hexadecimal() {
    }

    @Override
    public void capturarEntrada() {
        // Metodo valida a Entrada do Usuário  
        if (getEntrada02().length() > 16) {
            JOptionPane.showMessageDialog(null, "Digite um Número com até 16 algarismos!!");
            setValidado(false);
        } else {
            for (int y = getEntrada02().length() - 1; y >= 0; y--) {
                if (Character.getNumericValue(getEntrada02().charAt(y)) < 0
                        || Character.getNumericValue(getEntrada02().charAt(y)) > 15) {
                    JOptionPane.showMessageDialog(null, "Digite apenas número Hexadecimal!");
                    setValidado(false);
                    break;
                }
            }
        }
    }

    @Override
    public void imprimir() {
        // Método percorre o vetor resto e imprime o valor da última posição válida do índice até a primeira
        System.out.print("Hexadecimal: ");
        int y = getBit();
        int x = 0;
        while (x <= getBit()) {
            // os valores armazenados dentro do vetor resto são exibidos da última posição válida até a primeira
            if (getResto().get(y) == 15) {
                setResultado(getResultado() + "F");
            } else if (getResto().get(y) == 14) {
                setResultado(getResultado() + "E");
            } else if (getResto().get(y) == 13) {
                setResultado(getResultado() + "D");
            } else if (getResto().get(y) == 12) {
                setResultado(getResultado() + "C");
            } else if (getResto().get(y) == 11) {
                setResultado(getResultado() + "B");
            } else if (getResto().get(y) == 10) {
                setResultado(getResultado() + "A");
            } else {
                setResultado(getResultado() + Long.toString(getResto().get(y)));
            }
            x++;
            y--;
        }
        System.out.println(getResultado());
    }
}
