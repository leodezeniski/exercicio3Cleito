import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CadastroContatos {

    private JFrame frame;
    private JTextField nomeField, telefoneField, emailField;
    private JList<String> listaContatos;
    private DefaultListModel<String> listaModel;
    private JButton adicionarButton, removerButton;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CadastroContatos().iniciar());
    }

    public CadastroContatos() {
        listaModel = new DefaultListModel<>();
    }

    public void iniciar() {
        frame = new JFrame("Cadastro de Contatos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new FlowLayout());

        // Campo de texto para nome
        nomeField = new JTextField(20);
        frame.add(new JLabel("Nome:"));
        frame.add(nomeField);

        // Campo de texto para telefone
        telefoneField = new JTextField(20);
        frame.add(new JLabel("Telefone:"));
        frame.add(telefoneField);

        // Campo de texto para e-mail
        emailField = new JTextField(20);
        frame.add(new JLabel("E-mail:"));
        frame.add(emailField);

        // Botão para adicionar o contato
        adicionarButton = new JButton("Adicionar Contato");
        frame.add(adicionarButton);

        // Lista para exibir os contatos
        listaContatos = new JList<>(listaModel);
        listaContatos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        frame.add(new JScrollPane(listaContatos));

        // Botão para remover o contato selecionado
        removerButton = new JButton("Remover Contato");
        frame.add(removerButton);

        // Ação do botão Adicionar Contato
        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarContato();
            }
        });

        // Ação do botão Remover Contato
        removerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removerContato();
            }
        });

        frame.setVisible(true);
    }

    // Método para adicionar um novo contato
    private void adicionarContato() {
        String nome = nomeField.getText().trim();
        String telefone = telefoneField.getText().trim();
        String email = emailField.getText().trim();

        // Validação: garantir que todos os campos sejam preenchidos
        if (nome.isEmpty() || telefone.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Por favor, preencha todos os campos.");
            return;
        }

        // Formatar o novo contato e adicionar à lista
        String contato = "Nome: " + nome + " | Telefone: " + telefone + " | E-mail: " + email;
        listaModel.addElement(contato);

        // Limpar os campos após adicionar
        nomeField.setText("");
        telefoneField.setText("");
        emailField.setText("");
    }

    // Método para remover o contato selecionado
    private void removerContato() {
        int selectedIndex = listaContatos.getSelectedIndex();

        // Verifica se há um item selecionado
        if (selectedIndex != -1) {
            listaModel.remove(selectedIndex);
        } else {
            JOptionPane.showMessageDialog(frame, "Selecione um contato para remover.");
        }
    }
}
