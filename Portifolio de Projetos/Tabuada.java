package portfolio;

import java.awt.Color;
import java.awt.Cursor;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import Atxy2k.CustomTextField.RestrictedTextField;

public class Tabuada extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtTabuada;
	private JTextArea txtArea;
	private JButton btnCalcular;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tabuada dialog = new Tabuada();
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
	public Tabuada() {
		setTitle("Tabuada");
		setResizable(false);
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Tabuada.class.getResource("/img/9022696_math_operations_duotone_icon.png")));
		setBounds(100, 100, 311, 430);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tabuada");
		lblNewLabel.setBounds(38, 36, 64, 14);
		getContentPane().add(lblNewLabel);
		
		txtTabuada = new JTextField();
		txtTabuada.setSelectionColor(Color.BLACK);
		txtTabuada.setDisabledTextColor(Color.BLACK);
		txtTabuada.setForeground(Color.BLACK);
		txtTabuada.setBounds(101, 33, 116, 20);
		getContentPane().add(txtTabuada);
		txtTabuada.setColumns(10);
		
		btnCalcular = new JButton("");
		btnCalcular.setBorder(new LineBorder(Color.PINK, 2, true));
		btnCalcular.setToolTipText("Calcular a Tabuada");
		btnCalcular.setContentAreaFilled(false);
		btnCalcular.setIcon(new ImageIcon(Tabuada.class.getResource("/img/igual.png")));
		btnCalcular.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if (txtTabuada.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Informe o Valor da Tabuada");
					txtTabuada.requestFocus();
					} else {
					calcular();
					}
			}
		});
		btnCalcular.setBounds(67, 61, 53, 51);
		getContentPane().add(btnCalcular);
		
		JButton btnLimpar = new JButton("");
		btnLimpar.setBorder(new LineBorder(Color.PINK, 2, true));
		btnLimpar.setToolTipText("Limpar");
		btnLimpar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar ();
			}
		});
		btnLimpar.setContentAreaFilled(false);
		btnLimpar.setIcon(new ImageIcon(Tabuada.class.getResource("/img/9041260_eraser_fill_icon.png")));
		btnLimpar.setBounds(164, 64, 53, 51);
		getContentPane().add(btnLimpar);
		
		txtArea = new JTextArea();
		txtArea.setFont(new Font("Monospaced", Font.BOLD, 13));
		txtArea.setBackground(Color.PINK);
		txtArea.setBounds(52, 126, 170, 254);
		getContentPane().add(txtArea);
		
		
		// * Uso do atxy2k para validação
		RestrictedTextField validarTabuada = new RestrictedTextField(txtTabuada);
		validarTabuada.setOnlyNums(true);
		validarTabuada.setLimit(5);

	}//fim do construtor
	void calcular () {
		//variaveis + entrada
		int valor = Integer.parseInt(txtTabuada.getText());
		//processamento + saida
		for (int i = 1; i < 11; i++) {
			txtArea.append(" " + String.valueOf(valor) + " x " + String.valueOf(i) +" = " + String.valueOf(valor * i) + "\n");
			
		}
		btnCalcular.setEnabled(false);
	}
	void limpar () {
		txtTabuada.setText(null);
		txtArea.setText(null);
		btnCalcular.setEnabled(true);
	}
	
	
}//fim do codigo
