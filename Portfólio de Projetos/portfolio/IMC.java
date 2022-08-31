package portfolio;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class IMC extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNome;
	private JTextField txtIdade;
	private JTextField txtPeso;
	private JTextField txtAltura;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IMC dialog = new IMC();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public IMC() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(IMC.class.getResource("/img/4394714_healthcare_scale_sports_weight_icon.png")));
		setModal(true);
		setTitle("IMC");
		setResizable(false);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(46, 42, 46, 14);
		getContentPane().add(lblNewLabel);

		txtNome = new JTextField();
		txtNome.setBounds(97, 39, 272, 20);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);

		JButton btnNewButton = new JButton("");
		btnNewButton.setToolTipText("Salvar");
		btnNewButton.setIcon(new ImageIcon(IMC.class.getResource("/img/326688_floppy_save_guardar_icon.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcular();
			}
		});
		btnNewButton.setBounds(46, 178, 64, 64);
		getContentPane().add(btnNewButton);

		JLabel lblNewLabel_1 = new JLabel("Idade");
		lblNewLabel_1.setBounds(46, 83, 46, 14);
		getContentPane().add(lblNewLabel_1);

		txtIdade = new JTextField();
		txtIdade.setBounds(97, 77, 86, 20);
		getContentPane().add(txtIdade);
		txtIdade.setColumns(10);

		JLabel lblPeso = new JLabel("Peso");
		lblPeso.setBounds(46, 126, 46, 14);
		getContentPane().add(lblPeso);

		txtPeso = new JTextField();
		txtPeso.setBounds(97, 123, 86, 20);
		getContentPane().add(txtPeso);
		txtPeso.setColumns(10);

		txtAltura = new JTextField();
		txtAltura.setBounds(283, 123, 86, 20);
		getContentPane().add(txtAltura);
		txtAltura.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Altura");
		lblNewLabel_2.setBounds(227, 126, 46, 14);
		getContentPane().add(lblNewLabel_2);

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(IMC.class.getResource("/img/eraser.png")));
		btnNewButton_1.setToolTipText("Limpar");
		btnNewButton_1.setBounds(324, 178, 64, 64);
		getContentPane().add(btnNewButton_1);

	}// fim do construtor

	// Método responsável pelo cálculo do IMC
	void calcular() {
		// Variáveis
		String nome;
		int idade;
		double peso, altura, imc;

		// Entrada
		// Armazenando o conteúdo da caixa de texto na variável
		nome = txtNome.getText();
		// Integer.parseInt (converter o conteúdo da caixa de texto para número inteiro)
		idade = Integer.parseInt(txtIdade.getText());
		// Double.parseDouble (converter o conteúdo da caixa de texto para números
		// inteiros e não inteiro)
		peso = Double.parseDouble(txtPeso.getText());
		altura = Double.parseDouble(txtAltura.getText());

		// Processamento
		imc = peso / (altura * altura);

		// Saída
		// A linha abaixo exibe o nome armazenado na variável em uma caixa de mensagem.
		// Para personalizar a caixa de mensagem devemos adicionar um texto para o
		// título e um ícone personalizado

		JOptionPane.showMessageDialog(null,
				"Nome: " + nome + "\nIdade: " + idade + "\nPeso: " + peso + "\nAltura: " + altura + "\nIMC: " + imc,
				"Ficha do aluno", JOptionPane.DEFAULT_OPTION);
	}

//limpar
	void limpar() {
		txtNome.setText(null);
		txtIdade.setText(null);
		txtPeso.setText(null);
		txtAltura.setText(null);

	}
}// fim do codigo
