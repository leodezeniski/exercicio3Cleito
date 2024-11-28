import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AplicativoNotas {

    private JFrame frame;
    private JTextField notaField;
    private JTextArea notasArea;
    private JLabel mediaLabel;
    private JLabel statusLabel;
    private ArrayList<Double> notas;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AplicativoNotas().iniciar());
    }

    public AplicativoNotas() {
        notas = new ArrayList<>();
    }

    public void iniciar() {
        frame = new JFrame("Aplicativo de Notas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new FlowLayout());

        // Campo para inserir notas
        notaField = new JTextField(10);
        frame.add(notaField);

        // Botão para adicionar a nota
        JButton addButton = new JButton("Adicionar Nota");
        frame.add(addButton);

        // Área para mostrar as notas
        notasArea = new JTextArea(10, 30);
        notasArea.setEditable(false);
        frame.add(new JScrollPane(notasArea));

        // Botão para calcular a média
        JButton calcularButton = new JButton("Calcular Média");
        frame.add(calcularButton);

        // Label para exibir a média
        mediaLabel = new JLabel("Média: ");
        frame.add(mediaLabel);

        // Label para exibir o status (Aprovado/Reprovado)
        statusLabel = new JLabel("Status: ");
        frame.add(statusLabel);

        // Ação do botão Adicionar Nota
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double nota = Double.parseDouble(notaField.getText());
                    notas.add(nota);
                    atualizarNotas();
                    notaField.setText("");  // Limpa o campo de nota
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, insira um valor numérico válido.");
                }
            }
        });

        // Ação do botão Calcular Média
        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularMedia();
            }
        });

        frame.setVisible(true);
    }

    // Atualiza a lista de notas na interface
    private void atualizarNotas() {
        StringBuilder listaNotas = new StringBuilder("Notas inseridas:\n");
        for (Double nota : notas) {
            listaNotas.append(nota).append("\n");
        }
        notasArea.setText(listaNotas.toString());
    }

    // Calcula a média e atualiza os labels de média e status
    private void calcularMedia() {
        if (notas.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Não há notas para calcular.");
            return;
        }

        double soma = 0;
        for (Double nota : notas) {
            soma += nota;
        }
        double media = soma / notas.size();

        mediaLabel.setText("Média: " + String.format("%.2f", media));

        if (media >= 7.0) {
            statusLabel.setText("Status: Aprovado");
        } else {
            statusLabel.setText("Status: Reprovado");
        }
    }
}
