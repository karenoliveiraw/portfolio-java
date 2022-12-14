package portfolio;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Atxy2k.CustomTextField.RestrictedTextField;
import java.awt.Cursor;

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
		btnNewButton.setBorderPainted(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setToolTipText("Salvar");
		btnNewButton.setIcon(new ImageIcon(IMC.class.getResource("/img/326688_floppy_save_guardar_icon.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtNome.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Informe o seu Nome");
					txtNome.requestFocus();

				} else if (txtIdade.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Informe a sua Idade");
					txtIdade.requestFocus();
				} else if (txtPeso.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Informe o seu Peso");
					txtPeso.requestFocus();
				} else if (txtAltura.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Informe a sua Altura");
					txtAltura.requestFocus();
				} else {
					calcular();
				}

			}
		});
		btnNewButton.setBounds(122, 178, 64, 64);
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
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(IMC.class.getResource("/img/eraser.png")));
		btnNewButton_1.setToolTipText("Limpar");
		btnNewButton_1.setBounds(231, 178, 64, 64);
		getContentPane().add(btnNewButton_1);
		
		// validar 
		RestrictedTextField validarNome = new RestrictedTextField(txtNome, "0123456789.");
		RestrictedTextField validarIdade = new RestrictedTextField(txtIdade, "0123456789.");
		RestrictedTextField validarPeso = new RestrictedTextField(txtPeso, "0123456789.");
		RestrictedTextField validarAltura = new RestrictedTextField(txtAltura, "0123456789.");
		
		validarNome.setOnlyText(true);
		validarNome.setAcceptSpace(true);
		validarIdade.setLimit(3); 	
		validarPeso.setLimit(8);	
		validarAltura.setLimit(4); 

	}// fim do construtor

	// M?todo respons?vel pelo c?lculo do IMC
	void calcular() {
		// formatador de numeros
		DecimalFormat formatador = new DecimalFormat("#0.00");
		// Vari?veis
		String nome;
		int idade;
		double peso, altura, imc;

		// Entrada
		// Armazenando o conte?do da caixa de texto na vari?vel
		nome = txtNome.getText();
		// Integer.parseInt (converter o conte?do da caixa de texto para n?mero inteiro)
		idade = Integer.parseInt(txtIdade.getText());
		// Double.parseDouble (converter o conte?do da caixa de texto para n?meros
		// inteiros e n?o inteiro)
		peso = Double.parseDouble(txtPeso.getText());
		altura = Double.parseDouble(txtAltura.getText());

		// Processamento
		imc = peso / (altura * altura); 
		
		

		// Sa?da
		// A linha abaixo exibe o nome armazenado na vari?vel em uma caixa de mensagem.
		// Para personalizar a caixa de mensagem devemos adicionar um texto para o
		// t?tulo e um ?cone personalizado

		JOptionPane.showMessageDialog(null,
				"Nome: " + nome + "\nIdade: " + idade + "\nPeso: " + peso + "\nAltura: " + altura + "\nIMC: " + formatador.format(imc),
				"\nFicha do aluno", JOptionPane.DEFAULT_OPTION);
		
	}

//limpar
	void limpar() {
		txtNome.setText(null);
		txtIdade.setText(null);
		txtPeso.setText(null);
		txtAltura.setText(null);

	}
}// fim do codigo
