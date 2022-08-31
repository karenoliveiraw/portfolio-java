package portfolio;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Atxy2k.CustomTextField.RestrictedTextField;

public class Juros extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtAplicacao;
	private JTextField txtTaxa;
	private JTextField txtPeriodo;
	private JTextField txtJuros;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Juros dialog = new Juros();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Juros() {
		setTitle("Juros Simples");
		setBounds(100, 100, 370, 390);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblAplicacao = new JLabel("Aplicacao");
		lblAplicacao.setToolTipText("Valor a ser Aplicado");
		lblAplicacao.setBounds(10, 32, 57, 20);
		contentPanel.add(lblAplicacao);

		JLabel lblTaxa = new JLabel("Taxa Mensal");
		lblTaxa.setBounds(10, 133, 94, 20);
		contentPanel.add(lblTaxa);

		JLabel lblPeriodo = new JLabel("Periodo");
		lblPeriodo.setToolTipText("Insira o periodo ");
		lblPeriodo.setBounds(10, 78, 73, 20);
		contentPanel.add(lblPeriodo);

		JLabel lblJuros = new JLabel("Valor do Juros Simples");
		lblJuros.setBounds(10, 182, 138, 20);
		contentPanel.add(lblJuros);

		txtAplicacao = new JTextField();
		txtAplicacao.setBackground(Color.PINK);
		txtAplicacao.setBounds(148, 20, 103, 28);
		contentPanel.add(txtAplicacao);
		txtAplicacao.setColumns(10);

		txtTaxa = new JTextField();
		txtTaxa.setBackground(Color.PINK);
		txtTaxa.setColumns(10);
		txtTaxa.setBounds(148, 121, 103, 28);
		contentPanel.add(txtTaxa);

		txtPeriodo = new JTextField();
		txtPeriodo.setBackground(Color.PINK);
		txtPeriodo.setColumns(10);
		txtPeriodo.setBounds(148, 66, 103, 28);
		contentPanel.add(txtPeriodo);

		txtJuros = new JTextField();
		txtJuros.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtJuros.setDisabledTextColor(Color.WHITE);
		txtJuros.setBackground(Color.PINK);
		txtJuros.setEnabled(false);
		txtJuros.setEditable(false);
		txtJuros.setColumns(10);
		txtJuros.setBounds(148, 174, 103, 28);
		contentPanel.add(txtJuros);

		JButton btnLimpar = new JButton("");
		btnLimpar.setBorder(new LineBorder(Color.PINK, 5));
		btnLimpar.setContentAreaFilled(false);
		btnLimpar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLimpar.setToolTipText("Limpar");
		btnLimpar.setIcon(new ImageIcon(Juros.class.getResource("/img/9041260_eraser_fill_icon.png")));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setBounds(176, 260, 64, 64);
		contentPanel.add(btnLimpar);

		JButton btnResultado = new JButton("");
		btnResultado.setBorder(new LineBorder(Color.PINK, 5));
		btnResultado.setContentAreaFilled(false);
		btnResultado.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnResultado.setToolTipText("Resultado");
		btnResultado.setIcon(new ImageIcon(Juros.class.getResource("/img/49863___search_icon.png")));
		btnResultado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (txtAplicacao.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Informe o valor de sua Aplicação");
					txtAplicacao.requestFocus();
				} else if (txtTaxa.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Informe Taxa Anual");
				} else if (txtPeriodo.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Informe o Periodo ");	
				} else {
					calcular();
				}
			}
		});
		btnResultado.setBounds(95, 260, 64, 64);
		contentPanel.add(btnResultado);
		
		// * Uso do atxy2k para validação
				RestrictedTextField validarAplicacao = new RestrictedTextField(txtAplicacao);
				RestrictedTextField validarPeriodo = new RestrictedTextField(txtPeriodo);
				RestrictedTextField validarTaxa = new RestrictedTextField(txtTaxa);
				validarAplicacao.setOnlyNums(true);
				validarAplicacao.setLimit(14); 
				validarPeriodo.setLimit(14); 
				validarPeriodo.setOnlyNums(true);
				validarTaxa.setOnlyNums(true);
				validarTaxa.setLimit(14);

	}// fim do construtor

	void calcular() {
		// variaveis
		double aplicacao, taxa, juros = 100;
		int periodo;

		// entrada
		aplicacao = Double.parseDouble(txtAplicacao.getText());
		taxa = Double.parseDouble(txtTaxa.getText());
		periodo = Integer.parseInt(txtPeriodo.getText());
		// processamento
		juros = aplicacao * periodo * taxa / 100;
		// saida
		txtJuros.setText(String.valueOf(juros));
		
	}

	// limpar
	void limpar() {
		txtAplicacao.setText(null);
		txtTaxa.setText(null);
		txtJuros.setText(null);
		txtPeriodo.setText(null);

	}
}// fim do codigo
