import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AgendaDiaria {

    private JFrame frame;
    private JTextField compromissoField;
    private JSpinner dataHoraSpinner;
    private JTable tabelaCompromissos;
    private DefaultTableModel modeloTabela;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AgendaDiaria().iniciar());
    }

    public AgendaDiaria() {
        // Inicialização da interface gráfica
    }

    public void iniciar() {
        frame = new JFrame("Agenda Diária");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());

        // Painel de entrada de dados
        JPanel painelEntrada = new JPanel();
        painelEntrada.setLayout(new FlowLayout());

        // Campo de texto para descrição do compromisso
        compromissoField = new JTextField(20);
        painelEntrada.add(new JLabel("Compromisso:"));
        painelEntrada.add(compromissoField);

        // Spinner para selecionar data e hora
        SpinnerDateModel modeloSpinner = new SpinnerDateModel();
        dataHoraSpinner = new JSpinner(modeloSpinner);
        JSpinner.DateEditor editor = new JSpinner.DateEditor(dataHoraSpinner, "dd/MM/yyyy HH:mm");
        dataHoraSpinner.setEditor(editor);
        painelEntrada.add(new JLabel("Data e Hora:"));
        painelEntrada.add(dataHoraSpinner);

        // Botão para adicionar o compromisso
        JButton adicionarButton = new JButton("Adicionar Compromisso");
        painelEntrada.add(adicionarButton);

        // Adiciona o painel de entrada ao frame
        frame.add(painelEntrada, BorderLayout.NORTH);

        // Tabela para exibir os compromissos
        modeloTabela = new DefaultTableModel();
        modeloTabela.addColumn("Data/Hora");
        modeloTabela.addColumn("Compromisso");

        tabelaCompromissos = new JTable(modeloTabela);
        JScrollPane scrollPane = new JScrollPane(tabelaCompromissos);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Botão para remover compromisso
        JButton removerButton = new JButton("Remover Compromisso");
        painelEntrada.add(removerButton);

        // Ação do botão Adicionar Compromisso
        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarCompromisso();
            }
        });

        // Ação do botão Remover Compromisso
        removerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removerCompromisso();
            }
        });

        frame.setVisible(true);
    }

    // Método para adicionar compromisso à tabela
    private void adicionarCompromisso() {
        String compromisso = compromissoField.getText().trim();
        Date dataHora = (Date) dataHoraSpinner.getValue();

        // Validação de campos vazios
        if (compromisso.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Por favor, insira a descrição do compromisso.");
            return;
        }

        // Formatar data/hora
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String dataHoraStr = sdf.format(dataHora);

        // Adicionar o compromisso à tabela
        modeloTabela.addRow(new Object[]{dataHoraStr, compromisso});

        // Limpar os campos após adicionar
        compromissoField.setText("");
        dataHoraSpinner.setValue(new Date());
    }

    // Método para remover compromisso selecionado
    private void removerCompromisso() {
        int linhaSelecionada = tabelaCompromissos.getSelectedRow();
        if (linhaSelecionada != -1) {
            modeloTabela.removeRow(linhaSelecionada);
        } else {
            JOptionPane.showMessageDialog(frame, "Selecione um compromisso para remover.");
        }
    }
}
