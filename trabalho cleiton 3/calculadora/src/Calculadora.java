import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora {
    private JTextField txtPrimeirovalor;
    private JButton btnSomar;
    private JTextField txtSegundovalor;
    private JButton btnsubtrair;
    private JButton btnmultiplicar;
    private JButton btnDividir;
    private JButton btnLimpar;
    private JTextField txtResultado;
    private JPanel panelMain;

    public Calculadora() {
        btnSomar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Integer primeiroValor = Integer.parseInt(txtPrimeirovalor.getText());
                Integer segundoValor = Integer.parseInt(txtSegundovalor.getText());

                Integer soma = primeiroValor + segundoValor;
                txtResultado.setText(soma.toString());
            }
        });
        btnsubtrair.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             Integer primeiroValor = Integer.parseInt(txtPrimeirovalor.getText());
             Integer segundoValor = Integer.parseInt(txtSegundovalor.getText());
             Integer subtrair = primeiroValor - segundoValor;
             txtResultado.setText(subtrair.toString());
         }
        });
        btnmultiplicar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer primeiroValor = Integer.parseInt(txtPrimeirovalor.getText());
                Integer segundoValor = Integer.parseInt(txtSegundovalor.getText());
                Integer multiplicar = primeiroValor * segundoValor;
                txtResultado.setText(multiplicar.toString());
            }
        });
        btnDividir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer primeiroValor = Integer.parseInt(txtPrimeirovalor.getText());
                Integer segundoValor = Integer.parseInt(txtSegundovalor.getText());
                Integer dividir = primeiroValor / segundoValor;
                txtResultado.setText(dividir.toString());
            }
        });
        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtPrimeirovalor.setText("");
                txtSegundovalor.setText("");
                txtResultado.setText("");
            }
        });
    }


    public void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(new Calculadora().panelMain);
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}

