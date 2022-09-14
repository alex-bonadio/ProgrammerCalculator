package controller.numericSystems;

import javax.swing.JOptionPane;

/* @author Alex Bonadio Classe: 29 */

public class Ternario extends SistemaNumerico {

    public Ternario() {
    }

    @Override
    public void capturarEntrada() {
        // Metodo valida a Entrada do Usuário
        if (getEntrada02().length() > 40) {
            JOptionPane.showMessageDialog(null, "Digite um Número com até 40 algarismos!!");
            setValidado(false);
        } else {
            for (int y = getEntrada02().length() - 1; y >= 0; y--) {
                if (Character.getNumericValue(getEntrada02().charAt(y)) < 0
                        || Character.getNumericValue(getEntrada02().charAt(y)) > 2) {
                    JOptionPane.showMessageDialog(null, "Digite apenas 0, 1 ou 2!");
                    setValidado(false);
                    break;
                }
            }
        }
    }
}
