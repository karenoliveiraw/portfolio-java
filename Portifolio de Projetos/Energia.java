package portfolio;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Atxy2k.CustomTextField.RestrictedTextField;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;

public class Energia extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtPotencia;
	private JTextField txtHoras;
	private JTextField txtMes;
	private JTextField txtCusto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Energia dialog = new Energia();
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
	public Energia() {
		getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Energia.class.getResource("/img/energia.png")));
		setTitle("Calcular Consumo de Energia");
		setBounds(100, 100, 423, 482);
		getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("");
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setToolTipText("Calcular Potencia");
		btnNewButton.setIcon(new ImageIcon(Energia.class.getResource("/img/energia.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtPotencia.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Insira a Potência em Watts");
					txtPotencia.requestFocus();
				} else if (txtHoras.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Insira as horas de consumo");
					txtHoras.requestFocus();
				} else if (txtMes.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Insira os dias de uso durante o mÃªs");
					txtMes.requestFocus();
				} else {
					calcular();
				}
			}
		});
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBounds(123, 209, 64, 64);
		getContentPane().add(btnNewButton);

		txtPotencia = new JTextField();
		txtPotencia.setToolTipText("Insira a Potência do Aparelho em Watts)");
		txtPotencia.setBounds(46, 36, 86, 25);
		getContentPane().add(txtPotencia);
		txtPotencia.setColumns(10);

		JLabel lblNewLabel = new JLabel("Potência do Aparelho:");
		lblNewLabel.setBounds(20, 11, 124, 14);
		getContentPane().add(lblNewLabel);

		txtHoras = new JTextField();
		txtHoras.setToolTipText("Insira o uso de horas por dia ");
		txtHoras.setColumns(10);
		txtHoras.setBounds(46, 97, 86, 25);
		getContentPane().add(txtHoras);

		JLabel lblHorasDeUso = new JLabel("Horas de uso por dia:");
		lblHorasDeUso.setBounds(20, 72, 124, 14);
		getContentPane().add(lblHorasDeUso);

		txtMes = new JTextField();
		txtMes.setToolTipText("Insira o uso durante o Mês");
		txtMes.setColumns(10);
		txtMes.setBounds(46, 158, 86, 25);
		getContentPane().add(txtMes);

		JLabel lblDiasDeUso = new JLabel("Dias de uso durante o Mês:");
		lblDiasDeUso.setBounds(20, 133, 167, 14);
		getContentPane().add(lblDiasDeUso);

		JLabel lblEOMs = new JLabel("Custo");
		lblEOMs.setBounds(207, 97, 167, 14);
		getContentPane().add(lblEOMs);

		txtCusto = new JTextField();
		txtCusto.setToolTipText("Custo ao M\u00EAs");
		txtCusto.setEditable(false);
		txtCusto.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtCusto.setColumns(10);
		txtCusto.setBounds(197, 122, 100, 25);
		getContentPane().add(txtCusto);
		// validacao atx2k
		RestrictedTextField validarHoras = new RestrictedTextField(txtHoras, "0123456789.");
		validarHoras.setLimit(9);
		RestrictedTextField validarPotencia = new RestrictedTextField(txtPotencia, "0123456789.");
		validarPotencia.setLimit(9);
		RestrictedTextField validarMes = new RestrictedTextField(txtMes, "0123456789.");

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(Energia.class.getResource("/img/limpar.png")));
		btnNewButton_1.setToolTipText("Limpar");
		btnNewButton_1.setBounds(213, 219, 58, 56);
		getContentPane().add(btnNewButton_1);
		validarMes.setLimit(9);
	}// fim do construtor

	void calcular() {
		

		// formatador de numeros
		//DecimalFormat formatador = new DecimalFormat("0.00 kWh");
		DecimalFormat formatador = new DecimalFormat("R$ 0.00");

		// variaveis
		double potencia, horas, mes, custo, resultado;
		
		// entrada
		potencia = Double.parseDouble(txtPotencia.getText());
		mes = Double.parseDouble(txtMes.getText());
		horas = Double.parseDouble(txtHoras.getText());
	
		// processamento
		 custo = potencia * horas * mes / 1000;	
		 resultado = custo * 0.709 ;
		 //saida
		 txtCusto.setText(String.valueOf(formatador.format(resultado)));
	
	//calculo 2
		
		
	}
	// limpar

	void limpar() {
		txtHoras.setText(null);
		txtPotencia.setText(null);
		txtMes.setText(null);
		txtCusto.setText(null);
	}
}
// fim do codigo
