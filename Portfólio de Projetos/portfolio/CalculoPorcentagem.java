package portfolio;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Atxy2k.CustomTextField.RestrictedTextField;
import java.awt.Cursor;

public class CalculoPorcentagem extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtX;
	private JTextField txtY;
	private JTextField txtValor;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField txtCusto;
	private JTextField txtLucro;
	private JTextField txtVenda;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JTextField txtSub;
	private JLabel lblNewLabel_8;
	private JTextField txtDesconto;
	private JLabel lblNewLabel_9;
	private JButton btnNewButton_2;
	private JTextField txtTotal;
	private JButton btnNewButton_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculoPorcentagem dialog = new CalculoPorcentagem();
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
	public CalculoPorcentagem() {
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(CalculoPorcentagem.class.getResource("/img/percentage_3155.png")));
		setModal(true);
		setTitle("C\u00E1lculo da Porcentagem");
		setBounds(100, 100, 543, 476);
		getContentPane().setLayout(null);

		txtX = new JTextField();
		txtX.setBounds(23, 48, 63, 20);
		getContentPane().add(txtX);
		txtX.setColumns(10);

		JLabel lblNewLabel = new JLabel("% de");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(96, 48, 57, 17);
		getContentPane().add(lblNewLabel);

		txtY = new JTextField();
		txtY.setBounds(148, 48, 63, 20);
		getContentPane().add(txtY);
		txtY.setColumns(10);

		JButton btnNewButton = new JButton(" = ");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (txtX.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "PREENCHA O PRIMEIRO BLOCO!");
					txtX.requestFocus();
					} else if (txtY.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "PREENCHA O SEGUNDO BLOCO!");
					txtY.requestFocus();
					} else {
					calcular();
					}
			}
		});
		btnNewButton.setBounds(232, 47, 57, 23);
		getContentPane().add(btnNewButton);

		txtValor = new JTextField();
		txtValor.setEditable(false);
		txtValor.setBounds(309, 48, 135, 20);
		getContentPane().add(txtValor);
		txtValor.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Regra de 3");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(23, 16, 109, 20);
		getContentPane().add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("Custo x Venda");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(23, 101, 109, 14);
		getContentPane().add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("Custo");
		lblNewLabel_3.setBounds(10, 137, 46, 14);
		getContentPane().add(lblNewLabel_3);

		txtCusto = new JTextField();
		txtCusto.setBounds(59, 134, 77, 20);
		getContentPane().add(txtCusto);
		txtCusto.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Lucro");
		lblNewLabel_4.setBounds(159, 137, 37, 14);
		getContentPane().add(lblNewLabel_4);

		txtLucro = new JTextField();
		txtLucro.setBounds(206, 134, 51, 20);
		getContentPane().add(txtLucro);
		txtLucro.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("%");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(267, 131, 26, 23);
		getContentPane().add(lblNewLabel_5);

		JButton btnNewButton_1 = new JButton("Venda");
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (txtCusto.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "PREENCHA O CUSTO!");
					txtCusto.requestFocus();
					} else if (txtLucro.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "PREENCHA O LUCRO!");
					txtLucro.requestFocus();
					} else {
					calcularVenda();
					}
				
			}
		});
		btnNewButton_1.setBounds(303, 133, 77, 23);
		getContentPane().add(btnNewButton_1);

		txtVenda = new JTextField();
		txtVenda.setEditable(false);
		txtVenda.setBounds(393, 134, 109, 20);
		getContentPane().add(txtVenda);
		txtVenda.setColumns(10);

		lblNewLabel_6 = new JLabel("Calcular desconto");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setBounds(23, 201, 113, 14);
		getContentPane().add(lblNewLabel_6);

		lblNewLabel_7 = new JLabel("Sub total");
		lblNewLabel_7.setBounds(38, 238, 77, 14);
		getContentPane().add(lblNewLabel_7);

		txtSub = new JTextField();
		txtSub.setColumns(10);
		txtSub.setBounds(23, 263, 92, 20);
		getContentPane().add(txtSub);

		lblNewLabel_8 = new JLabel("Desconto");
		lblNewLabel_8.setBounds(162, 238, 77, 14);
		getContentPane().add(lblNewLabel_8);

		txtDesconto = new JTextField();
		txtDesconto.setColumns(10);
		txtDesconto.setBounds(159, 263, 62, 20);
		getContentPane().add(txtDesconto);

		lblNewLabel_9 = new JLabel("%");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_9.setBounds(231, 260, 26, 23);
		getContentPane().add(lblNewLabel_9);

		btnNewButton_2 = new JButton("Total");
		btnNewButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtSub.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "PREENCHA O SUB TOTAL!");
					txtSub.requestFocus();
					} else if (txtDesconto.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "PREENCHA O DESCONTO!");
					txtDesconto.requestFocus();
					} else {
					calcularDesconto();
					}
			}
		});
		btnNewButton_2.setBounds(267, 262, 77, 23);
		getContentPane().add(btnNewButton_2);

		txtTotal = new JTextField();
		txtTotal.setEditable(false);
		txtTotal.setColumns(10);
		txtTotal.setBounds(370, 263, 119, 20);
		getContentPane().add(txtTotal);

		btnNewButton_3 = new JButton("");
		btnNewButton_3.setContentAreaFilled(false);
		btnNewButton_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnNewButton_3.setToolTipText("Limpar");
		btnNewButton_3.setIcon(new ImageIcon(CalculoPorcentagem.class.getResource("/img/eraser.png")));
		btnNewButton_3.setBounds(406, 333, 64, 64);
		getContentPane().add(btnNewButton_3);

		// Uso da biblioteca Atxy2k

		RestrictedTextField validarTotal = new RestrictedTextField(txtTotal);
		RestrictedTextField validarY = new RestrictedTextField(txtY);
		RestrictedTextField validarX = new RestrictedTextField(txtX);
		RestrictedTextField validarDesconto = new RestrictedTextField(txtDesconto);
		RestrictedTextField validarSub = new RestrictedTextField(txtSub);
		RestrictedTextField validarValor = new RestrictedTextField(txtValor);
		RestrictedTextField validarCusto = new RestrictedTextField(txtCusto);
		RestrictedTextField validarVenda = new RestrictedTextField(txtVenda);
		RestrictedTextField validarLucro = new RestrictedTextField(txtLucro);
		validarTotal.setOnlyNums(true);
		validarTotal.setLimit(8);
		validarY.setOnlyNums(true);
		validarY.setLimit(8);
		validarX.setOnlyNums(true);
		validarX.setLimit(8);
		validarDesconto.setOnlyNums(true);
		validarDesconto.setLimit(8);
		validarSub.setOnlyNums(true);
		validarSub.setLimit(8);
		validarValor.setOnlyNums(true);
		validarValor.setLimit(8);
		validarCusto.setOnlyNums(true);
		validarCusto.setLimit(8);
		validarVenda.setOnlyNums(true);
		validarVenda.setLimit(8);
		validarLucro.setOnlyNums(true);
		validarLucro.setLimit(8);

	}// fim do construtor

	// Método Regra de 3
	void calcular() {
		// variáveis
		double x, y, valor;
		// entrada
		x = Double.parseDouble(txtX.getText());
		y = Double.parseDouble(txtY.getText());
		// processamento
		valor = (x * y) / 100;
		// saída
		txtValor.setText(String.valueOf(valor));
	}

	// Método Venda
	void calcularVenda() {
		// variáveis
		double custo, lucro, venda;
		// entrada
		custo = Double.parseDouble(txtCusto.getText());
		lucro = Double.parseDouble(txtLucro.getText());
		// processamento
		venda = custo + ((lucro * custo) / 100);
		// saída
		txtVenda.setText(String.valueOf(venda));
	}

	// Método Desconto
	void calcularDesconto() {
		// variavéis
		double total, desconto, totaldesc;
		// entrada
		total = Double.parseDouble(txtSub.getText());
		desconto = Double.parseDouble(txtDesconto.getText());
		// processamento
		totaldesc = total - (total * desconto) / 100;
		// saida
		txtTotal.setText(String.valueOf(totaldesc));

	}

	// metodo limpar
	void limpar() {
		txtTotal.setText(null);
		txtY.setText(null);
		txtX.setText(null);
		txtDesconto.setText(null);
		txtSub.setText(null);
		txtValor.setText(null);
		txtCusto.setText(null);
		txtVenda.setText(null);
		txtLucro.setText(null);
	}

}// fim
