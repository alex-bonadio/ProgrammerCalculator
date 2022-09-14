package controller.numericSystems;

import javax.swing.JOptionPane;

/* @author Alex Bonadio Classe: 54 */

public class Binario extends SistemaNumerico {

    public Binario() {
    }

    @Override
    public void capturarEntrada() {
        // Metodo valida a Entrada do Usuário
        if (getEntrada02().length() > 63) {
            JOptionPane.showMessageDialog(null, "Digite um Número com até 63 algarismos!!");
            setValidado(false);
        } else {
            for (int y = getEntrada02().length() - 1; y >= 0; y--) {
                if (Character.getNumericValue(getEntrada02().charAt(y)) < 0
                        || Character.getNumericValue(getEntrada02().charAt(y)) > 1) {
                    JOptionPane.showMessageDialog(null, "Digite apenas 0 ou 1!");
                    setValidado(false);
                    break;
                }
            }
        }
    }

    @Override
    public void imprimir() {
        // Método percorre o vetor resto e imprime o entrada03 da última posição válida do índice até a primeira         
        System.out.print("Binário: ");
        int bits = getBit() + 1;
        int mod = bits % 4;
        // Se a quantidade de bits não completar 4 no momento da impressão na tela, 
        // o loop completará com zero a esquerda (Os bits sempre serão agrupados em 4)
        if (mod != 0) {
            while (mod < 4) {
                setResultado(getResultado().concat("0"));
                mod++;
            }
        }
        int y = getBit();
        int x = 0;
        while (x <= getBit()) {
            // os valores armazenados dentro do vetor resto são exibidos da última posição válida até a primeira           
            setResultado(getResultado().concat(Long.toString(getResto().get(y))));
            x++;
            y--;
        }
        System.out.println(getResultado());
    }
}
