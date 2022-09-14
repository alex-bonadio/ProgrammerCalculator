
package controller.numericSystems;

import javax.swing.JOptionPane;

/* @author Alex Bonadio Classe: 29 */

public class Decimal extends SistemaNumerico {

    @Override
    public void capturarEntrada() {
        // Metodo valida a Entrada do Usuário
        if (getEntrada02().isEmpty()) {
            setEntrada02("0");
        } else if (getEntrada02().length() > 18) {
            JOptionPane.showMessageDialog(null, "Digite um Número com até 18 algarismos!!");
            setValidado(false);
        } else {
            for (int y = getEntrada02().length() - 1; y >= 0; y--) {
                if (Character.getNumericValue(getEntrada02().charAt(y)) < 0
                        || Character.getNumericValue(getEntrada02().charAt(y)) > 9) {
                    JOptionPane.showMessageDialog(null, "Digite apenas algarismos entre 0 e 9!");
                    setValidado(false);
                    break;
                }
            }
        }
    }
}
