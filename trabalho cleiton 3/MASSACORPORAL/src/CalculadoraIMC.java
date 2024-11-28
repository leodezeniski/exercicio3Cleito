import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraIMC {

    private JFrame frame;
    private JTextField pesoField, alturaField;
    private JLabel resultadoLabel, categoriaLabel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CalculadoraIMC().iniciar());
    }

    public CalculadoraIMC() {
        // Inicialização da interface gráfica
    }

    public void iniciar() {
        frame = new JFrame("Calculadora de IMC");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 300);
        frame.setLayout(new FlowLayout());

        // Campo de texto para peso
        pesoField = new JTextField(10);
        frame.add(new JLabel("Peso (kg):"));
        frame.add(pesoField);

        // Campo de texto para altura
        alturaField = new JTextField(10);
        frame.add(new JLabel("Altura (m):"));
        frame.add(alturaField);

        // Botão para calcular o IMC
        JButton calcularButton = new JButton("Calcular IMC");
        frame.add(calcularButton);

        // Label para exibir o resultado do IMC
        resultadoLabel = new JLabel("Resultado: ");
        frame.add(resultadoLabel);

        // Label para exibir a categoria do IMC
        categoriaLabel = new JLabel("Categoria: ");
        frame.add(categoriaLabel);

        // Ação do botão Calcular IMC
        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularIMC();
            }
        });

        frame.setVisible(true);
    }

    // Método para calcular e exibir o IMC
    private void calcularIMC() {
        try {
            // Obter os valores do peso e altura
            double peso = Double.parseDouble(pesoField.getText().trim());
            double altura = Double.parseDouble(alturaField.getText().trim());

            // Validar entrada de valores
            if (peso <= 0 || altura <= 0) {
                JOptionPane.showMessageDialog(frame, "Por favor, insira valores válidos para peso e altura.");
                return;
            }

            // Calcular o IMC
            double imc = peso / (altura * altura);

            // Exibir o resultado do IMC
            resultadoLabel.setText("Resultado: " + String.format("%.2f", imc));

            // Determinar a categoria do IMC
            String categoria = obterCategoriaIMC(imc);
            categoriaLabel.setText("Categoria: " + categoria);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Por favor, insira valores numéricos válidos.");
        }
    }

    // Método para determinar a categoria do IMC
    private String obterCategoriaIMC(double imc) {
        if (imc < 18.5) {
            return "Baixo peso";
        } else if (imc >= 18.5 && imc < 24.9) {
            return "Peso normal";
        } else if (imc >= 25 && imc < 29.9) {
            return "Sobrepeso";
        } else {
            return "Obesidade";
        }
    }
}
