package controller.numericSystems;

import javax.swing.JOptionPane;

/* @author Alex Bonadio Classe: 29 */

public class Octal extends SistemaNumerico {

    public Octal() {
    }

    @Override
    public void capturarEntrada() {
        // Metodo valida a Entrada do Usuário
        if (getEntrada02().length() > 21) {
            JOptionPane.showMessageDialog(null, "Digite um Número com até 21 algarismos!!");
            setValidado(false);
        } else {
            for (int y = getEntrada02().length() - 1; y >= 0; y--) {
                if (Character.getNumericValue(getEntrada02().charAt(y)) < 0
                        || Character.getNumericValue(getEntrada02().charAt(y)) > 7) {
                    JOptionPane.showMessageDialog(null, "Digite apenas algarismos entre 0 e 7!");
                    setValidado(false);
                    break;
                }
            }
        }
    }
}
