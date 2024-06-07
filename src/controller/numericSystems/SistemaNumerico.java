package controller.numericSystems;

import java.text.DecimalFormat;
import java.util.ArrayList;

/* @author Alex Bonadio Classe: 142 */

public abstract class SistemaNumerico {

    private ArrayList<Long> resto = new ArrayList();    // vetor que armazena os resto de cada divisão e o quociente da última divisão
    private long entrada01;                   // variável que armazena a capturarEntrada do usuário para fazer a conversão
    private String entrada02 = "";            // variável String que valida a capturarEntrada do usuário
    private String resultado = "";            // exibe o vetor resto em uma string para imprimir no JLabel  
    private String saveNum = "";              // salva o resultado da última conversão para impedir inserções repetitivas no banco de dados 
    private boolean validado = true;          // se o valor da capturarEntrada do usuário não passar na validação, retornará falso 
    private short divisor;                    // variável que seta o divisor para fazer a divisão
    private short base;                       // variável que seta a base numérica para conversão usando multiplicação
    private short bit;                        // variável que armazena quantas posições foram usadas do vetor resto[]

    public SistemaNumerico() {
    }

    public abstract void capturarEntrada();
    // Ao Estender esta classe, será necessário construir um corpo para este método

    public void dividir() {
        // Método faz a divisão, armazena o resto de cada divisão e o quociente da última divisão no vetor resto[]
        if (divisor > entrada01) {
            resto.add(bit, entrada01);
        } else {
            while (entrada01 >= divisor) {             // Enquanto o entrada03 de capturarEntrada for igual ou maior que o divisor, será executado o loop
                resto.add(bit, entrada01 % divisor); // MOD
                entrada01 = entrada01 / divisor;     // são feitas divisões sucessivas  
                bit++;                              // o valor do indice (bit) do vetor é incrementado a cada Loop
            }
            resto.add(bit, entrada01);           // após terminar as divisões, o último quociente é armazenado no vetor
        }
    }

    public void multiplicar() {
        // Método percorre a String entrada02, convertendo os caracteres em número, faz a potenciação, soma e armazena o resultado na variável entrada01
        int potencia = 0;
        int y = entrada02.length() - 1;
        while (y >= 0) {
            entrada01 += Math.pow(base, potencia) * Character.getNumericValue(entrada02.charAt(y));
            potencia++;
            y--;
        }
        DecimalFormat df = new DecimalFormat("###,###");
        System.out.println("Decimal: " + df.format(entrada01));
    }

    public void imprimir() {
        // Método percorre o vetor resto e imprime o valor da última posição válida do índice até a primeira 
        if (divisor == 3) {
            System.out.print("Ternário: ");
        } else {
            System.out.print("Octal: ");
        }
        int y = bit;
        int x = 0;
        while (x <= bit) {
            // os valores armazenados dentro do vetor resto são exibidos da última posição válida até a primeira
            resultado = resultado + Long.toString(resto.get(y));
            x++;
            y--;
        }
        System.out.println(resultado);
    }

    public ArrayList<Long> getResto() {
        return resto;
    }

    public void setResto(ArrayList<Long> resto) {
        this.resto = resto;
    }

    public long getEntrada01() {
        return entrada01;
    }

    public void setEntrada01(long entrada01) {
        this.entrada01 = entrada01;
    }

    public String getEntrada02() {
        return entrada02;
    }

    public void setEntrada02(String entrada02) {
        this.entrada02 = entrada02;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public boolean isValidado() {
        return validado;
    }

    public void setValidado(boolean validado) {
        this.validado = validado;
    }

    public short getDivisor() {
        return divisor;
    }

    public void setDivisor(short divisor) {
        this.divisor = divisor;
    }

    public short getBase() {
        return base;
    }

    public void setBase(short base) {
        this.base = base;
    }

    public short getBit() {
        return bit;
    }

    public void setBit(short bit) {
        this.bit = bit;
    }

    public String getSaveNum() {
        return saveNum;
    }

    public void setSaveNum(String saveNum) {
        this.saveNum = saveNum;
    }
}
