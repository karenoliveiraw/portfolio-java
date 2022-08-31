package portfolio;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Atxy2k.CustomTextField.RestrictedTextField;

public class AppServico extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtRemuneracao;
	private JTextField txtCusto;
	private JTextField txtCargaHoraria;
	private JTextField txtHora;
	private JTextField txtTempoEstimado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppServico dialog = new AppServico();
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
	public AppServico() {
		setTitle("C\u00E1lculo do valor da hora de servi\u00E7o");
		setModal(true);
		setBounds(100, 100, 345, 485);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Remunera\u00E7\u00E3o:");
		lblNewLabel.setBounds(30, 28, 89, 14);
		getContentPane().add(lblNewLabel);

		txtRemuneracao = new JTextField();
		txtRemuneracao.setBounds(142, 25, 124, 20);
		getContentPane().add(txtRemuneracao);
		txtRemuneracao.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Custo operacional:");
		lblNewLabel_1.setBounds(30, 63, 109, 14);
		getContentPane().add(lblNewLabel_1);

		txtCusto = new JTextField();
		txtCusto.setBounds(166, 60, 100, 20);
		getContentPane().add(txtCusto);
		txtCusto.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Carga hor\u00E1ria mensal:");
		lblNewLabel_2.setBounds(30, 98, 140, 14);
		getContentPane().add(lblNewLabel_2);

		txtCargaHoraria = new JTextField();
		txtCargaHoraria.setBounds(180, 95, 86, 20);
		getContentPane().add(txtCargaHoraria);
		txtCargaHoraria.setColumns(10);

		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtRemuneracao.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Informe sua Remunera��o");
					txtRemuneracao.requestFocus();

				} else if (txtCusto.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Informe o Custo");
					txtCusto.requestFocus();
				} else if (txtCargaHoraria.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Informe sua Carga Horaria Mensal");
					txtCargaHoraria.requestFocus();
				} else {
					calcularHora();
				}
				
			}
		});
		btnNewButton.setBounds(30, 146, 89, 23);
		getContentPane().add(btnNewButton);

		JLabel lblNewLabel_3 = new JLabel("Valor da hora de servi\u00E7o:");
		lblNewLabel_3.setBounds(30, 202, 151, 14);
		getContentPane().add(lblNewLabel_3);

		txtHora = new JTextField();
		txtHora.setEditable(false);
		txtHora.setBounds(191, 199, 75, 20);
		getContentPane().add(txtHora);
		txtHora.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Estimativa de horas do servi\u00E7o:");
		lblNewLabel_4.setBounds(30, 276, 179, 14);
		getContentPane().add(lblNewLabel_4);

		txtTempoEstimado = new JTextField();
		txtTempoEstimado.setBounds(224, 273, 67, 20);
		getContentPane().add(txtTempoEstimado);
		txtTempoEstimado.setColumns(10);

		JButton btnNewButton_1 = new JButton("Calcular");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcularServico();
			}
		});
		btnNewButton_1.setBounds(30, 363, 89, 23);
		getContentPane().add(btnNewButton_1);

		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(10, 247, 309, 4);
		getContentPane().add(panel);

		JButton btnLimpar = new JButton("");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}

		});
		btnLimpar.setIcon(new ImageIcon(AppServico.class.getResource("/img/eraser.png")));
		btnLimpar.setBounds(177, 342, 64, 64);
		getContentPane().add(btnLimpar);
//////////validacao
	// * Uso do atxy2k para valida��o
	RestrictedTextField validarCargaHoraria = new RestrictedTextField(txtCargaHoraria);
	RestrictedTextField validarTempoEstimado = new RestrictedTextField(txtTempoEstimado);
	RestrictedTextField validarCusto = new RestrictedTextField(txtCusto);
	RestrictedTextField validarRemuneracao = new RestrictedTextField(txtRemuneracao);
	RestrictedTextField validarHora = new RestrictedTextField(txtHora);
	validarCargaHoraria.setOnlyNums(true);
	validarCargaHoraria.setLimit(8); 
	validarHora.setOnlyNums(true);
	validarHora.setLimit(8);
	validarTempoEstimado.setOnlyNums(true);
	validarTempoEstimado.setLimit(8);
	validarCusto.setOnlyNums(true);
	validarCusto.setLimit(8);
	validarRemuneracao.setOnlyNums(true);
	validarRemuneracao.setLimit(8);

	}// fim do construtor
	
	// var�aveis globais
	double hora;

	// m�todo usado para calcular o valor da hora
	void calcularHora() {
		// vari�veis
		double remuneracao, custo, cargaHoraria;
		// entrada
		remuneracao = Double.parseDouble(txtRemuneracao.getText());
		custo = Double.parseDouble(txtCusto.getText());
		cargaHoraria = Double.parseDouble(txtCargaHoraria.getText());
		// processamento
		hora = (remuneracao + 0.3 * remuneracao + custo + 0.2 * remuneracao) / cargaHoraria;
		// sa�da
		txtHora.setText(String.valueOf(hora));
	}

	// M�todo usado para calcular o valor do servi�o
	void calcularServico() {
		// vari�veis
		double tempoEstimado, valor;
		// entrada
		tempoEstimado = Double.parseDouble(txtTempoEstimado.getText());
		// processamento
		valor = tempoEstimado * hora;
		// sa�da
		JOptionPane.showMessageDialog(null, "Valor do servi�o: " + valor, "Relat�rio", JOptionPane.DEFAULT_OPTION);
	}
	//m�todo para calcular estimativa de servi�o
	
	
	

	// metodo limpar
	void limpar() {
		txtCargaHoraria.setText(null);
		txtHora.setText(null);
		txtTempoEstimado.setText(null);
		txtCusto.setText(null);
		txtRemuneracao.setText(null);
		txtHora.requestFocus();
	}
}// fim do c�digo
