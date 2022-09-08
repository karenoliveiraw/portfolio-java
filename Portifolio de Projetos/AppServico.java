package portfolio;

import java.awt.Color;
import java.awt.Cursor;
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
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(AppServico.class.getResource("/img/spreadsheet_icon_126812.png")));
		setTitle("C\u00E1lculo do valor da hora de servi\u00E7o");
		setModal(true);
		setBounds(100, 100, 345, 485);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Remunera\u00E7\u00E3o:");
		lblNewLabel.setBounds(30, 14, 89, 14);
		getContentPane().add(lblNewLabel);

		txtRemuneracao = new JTextField();
		txtRemuneracao.setBounds(167, 14, 124, 20);
		getContentPane().add(txtRemuneracao);
		txtRemuneracao.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Custo operacional:");
		lblNewLabel_1.setBounds(30, 49, 109, 14);
		getContentPane().add(lblNewLabel_1);

		txtCusto = new JTextField();
		txtCusto.setBounds(167, 49, 124, 20);
		getContentPane().add(txtCusto);
		txtCusto.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Carga hor\u00E1ria mensal:");
		lblNewLabel_2.setBounds(30, 84, 179, 14);
		getContentPane().add(lblNewLabel_2);

		txtCargaHoraria = new JTextField();
		txtCargaHoraria.setBounds(167, 84, 124, 20);
		getContentPane().add(txtCargaHoraria);
		txtCargaHoraria.setColumns(10);

		JButton btnNewButton = new JButton("");
		btnNewButton.setBorder(null);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setToolTipText("Salvar");
		btnNewButton.setIcon(new ImageIcon(AppServico.class.getResource("/img/save 32.png")));
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtRemuneracao.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Informe sua Remuneração");
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
		btnNewButton.setBounds(40, 110, 79, 64);
		getContentPane().add(btnNewButton);

		JLabel lblNewLabel_3 = new JLabel("Valor da hora de servi\u00E7o:");
		lblNewLabel_3.setBounds(30, 188, 151, 14);
		getContentPane().add(lblNewLabel_3);

		txtHora = new JTextField();
		txtHora.setEditable(false);
		txtHora.setBounds(191, 185, 75, 20);
		getContentPane().add(txtHora);
		txtHora.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Estimativa de horas do servi\u00E7o:");
		lblNewLabel_4.setBounds(30, 296, 179, 14);
		getContentPane().add(lblNewLabel_4);

		txtTempoEstimado = new JTextField();
		txtTempoEstimado.setBounds(224, 293, 67, 20);
		getContentPane().add(txtTempoEstimado);
		txtTempoEstimado.setColumns(10);

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setToolTipText("Calcular");
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setIcon(new ImageIcon(AppServico.class.getResource("/img/spreadsheet_icon_126812.png")));
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtTempoEstimado.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Informe o Tempo Estimado");
					txtTempoEstimado.requestFocus();
				} else {
					calcularServico();
				}

			}
		});
		btnNewButton_1.setBounds(101, 362, 64, 64);
		getContentPane().add(btnNewButton_1);

		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(10, 226, 309, 4);
		getContentPane().add(panel);

		JButton btnLimpar = new JButton("");
		btnLimpar.setToolTipText("Limpar");
		btnLimpar.setBorder(null);
		btnLimpar.setContentAreaFilled(false);
		btnLimpar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}

		});
		btnLimpar.setIcon(new ImageIcon(AppServico.class.getResource("/img/eraser.png")));
		btnLimpar.setBounds(180, 362, 64, 64);
		getContentPane().add(btnLimpar);
//////////validacao
		// * Uso do atxy2k para validação
		RestrictedTextField validarCargaHoraria = new RestrictedTextField(txtCargaHoraria, "0123456789.");
		RestrictedTextField validarCusto = new RestrictedTextField(txtCusto, "0123456789.");
		RestrictedTextField validarRemuneracao = new RestrictedTextField(txtRemuneracao, "0123456789.");
		RestrictedTextField validarTempoEstimado = new RestrictedTextField(txtTempoEstimado, "0123456789.");
		validarTempoEstimado.setLimit(8);
		validarCargaHoraria.setLimit(8);
		validarCusto.setLimit(8);
		validarRemuneracao.setLimit(8);

	}// fim do construtor
	// formatador de numeros
			DecimalFormat formatador = new DecimalFormat("#0.00");
	// varíaveis globais
	double hora;

	// método usado para calcular o valor da hora
	void calcularHora() {
		// variáveis
		double remuneracao, custo, cargaHoraria;
		// entrada
		remuneracao = Double.parseDouble(txtRemuneracao.getText());
		custo = Double.parseDouble(txtCusto.getText());
		cargaHoraria = Double.parseDouble(txtCargaHoraria.getText());
		// processamento
		hora = (remuneracao + 0.3 * remuneracao + custo + 0.2 * remuneracao) / cargaHoraria;
		// saída
		txtHora.setText(String.valueOf(formatador.format(hora)));
	}

	// Método usado para calcular o valor do serviço
	void calcularServico() {
		// formatador de numeros
		DecimalFormat formatador1 = new DecimalFormat("#0.00");
		// variáveis
		double tempoEstimado, valor;
		// entrada
		tempoEstimado = Double.parseDouble(txtTempoEstimado.getText());
		// processamento
		valor = tempoEstimado * hora;
		// saída
		JOptionPane.showMessageDialog(null, "Valor do serviço: " + formatador1.format(valor), "Relatório", JOptionPane.DEFAULT_OPTION);
	}
	// método para calcular estimativa de serviço

	// metodo limpar
	void limpar() {
		txtCargaHoraria.setText(null);
		txtHora.setText(null);
		txtTempoEstimado.setText(null);
		txtCusto.setText(null);
		txtRemuneracao.setText(null);
		txtHora.requestFocus();
	}
}// fim do código
