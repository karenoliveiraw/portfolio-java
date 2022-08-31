package portfolio;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
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

import Atxy2k.CustomTextField.RestrictedTextField;
import java.awt.Cursor;

public class Combustivel extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtEtanol;
	private JTextField txtGasolina;
	private JLabel lblStatus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Combustivel dialog = new Combustivel();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Combustivel() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Combustivel.class.getResource("/img/gasoline_oil_gas_fuel_pump_icon_150429.png")));
		setModal(true);
		setTitle("Etanol x Gasolina");
		setBounds(100, 100, 342, 377);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 316, 338);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Etanol");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel.setBounds(10, 38, 46, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Gasolina");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_1.setBounds(10, 72, 70, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			txtEtanol = new JTextField();
			txtEtanol.setFont(new Font("Tahoma", Font.BOLD, 11));
			txtEtanol.setForeground(new Color(255, 255, 255));
			txtEtanol.setBackground(new Color(204, 0, 102));
			txtEtanol.setBounds(136, 35, 86, 20);
			contentPanel.add(txtEtanol);
			txtEtanol.setColumns(10);
		}
		{
			txtGasolina = new JTextField();
			txtGasolina.setFont(new Font("Tahoma", Font.BOLD, 11));
			txtGasolina.setForeground(new Color(255, 255, 255));
			txtGasolina.setBackground(new Color(204, 51, 102));
			txtGasolina.setBounds(136, 71, 86, 20);
			contentPanel.add(txtGasolina);
			txtGasolina.setColumns(10);
		}
		{
			JButton btnNewButton = new JButton("");
			btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnNewButton.setToolTipText("Calcular ");
			btnNewButton.setIcon(new ImageIcon(Combustivel.class.getResource("/img/49863___search_icon.png")));
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnNewButton.setForeground(new Color(255, 255, 255));
			btnNewButton.setBackground(new Color(204, 0, 102));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// validação obrigatoria 
					if (txtEtanol.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Informe o valor do Etanol");
						txtEtanol.requestFocus();
					} else if (txtGasolina.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Informe o valor da Gasolina");
						txtGasolina.requestFocus();
					} else {
						calcular();
					}
				}
			});
			btnNewButton.setBounds(91, 110, 64, 64);
			contentPanel.add(btnNewButton);
		}

		lblStatus = new JLabel("");
		lblStatus.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		lblStatus.setIcon(new ImageIcon(Combustivel.class.getResource("/img/neutro.png")));
		lblStatus.setBounds(0, 159, 360, 200);
		contentPanel.add(lblStatus);
		{
			JButton btnNewButton = new JButton("");
			btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					limpar();
				}
			});
			btnNewButton.setToolTipText("Limpar");
			btnNewButton.setIcon(new ImageIcon(Combustivel.class.getResource("/img/9041260_eraser_fill_icon.png")));
			btnNewButton.setForeground(Color.WHITE);
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnNewButton.setBackground(new Color(204, 0, 102));
			btnNewButton.setBounds(185, 110, 64, 64);
			contentPanel.add(btnNewButton);
		}
		////////// validacao
		// * Uso do atxy2k para validação
		RestrictedTextField validarGasolina = new RestrictedTextField(txtGasolina);
		validarGasolina.setOnlyNums(true);
		validarGasolina.setLimit(5);
		RestrictedTextField validarEtanol = new RestrictedTextField(txtEtanol);
		validarEtanol.setOnlyNums(true);
		validarEtanol.setLimit(5);
	} // fim do construtor

	void calcular() {
		// variaveis
		double etanol, gasolina;
		// entrada
		etanol = Double.parseDouble(txtEtanol.getText());
		gasolina = Double.parseDouble(txtGasolina.getText());
		// processamento/saida
		if (etanol < 0.7 * gasolina) {
			JOptionPane.showMessageDialog(null, "Abastecer com Etanol");
			lblStatus.setIcon(new ImageIcon(Combustivel.class.getResource("/img/etanol.png")));
		} else {
			JOptionPane.showMessageDialog(null, "Abastecer com Gasolina");
			lblStatus.setIcon(new ImageIcon(Combustivel.class.getResource("/img/gasolina.png")));
		}

	}

	// limpar
	void limpar() {
		txtEtanol.setText(null);
		txtGasolina.setText(null);
		lblStatus.setIcon(new ImageIcon(Combustivel.class.getResource("/img/neutro.png")));
	}

} // fim do codigo