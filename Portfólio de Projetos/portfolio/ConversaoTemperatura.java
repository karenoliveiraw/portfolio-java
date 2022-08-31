package portfolio;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Atxy2k.CustomTextField.RestrictedTextField;
import javax.swing.ImageIcon;
import java.awt.Cursor;

public class ConversaoTemperatura extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtF;
	private JTextField txtC;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConversaoTemperatura dialog = new ConversaoTemperatura();
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
	public ConversaoTemperatura() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConversaoTemperatura.class.getResource("/img/7795659_weather_warm_termometer_temperature_icon.png")));
		setForeground(Color.LIGHT_GRAY);
		setTitle("Convers\u00E3o de Temperatura");
		setModal(true);
		setBounds(100, 100, 350, 258);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Fahrenheit");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 46, 83, 14);
		getContentPane().add(lblNewLabel);
		
		txtF = new JTextField();
		txtF.setBounds(103, 45, 86, 20);
		getContentPane().add(txtF);
		txtF.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Celsius");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(22, 113, 83, 14);
		getContentPane().add(lblNewLabel_1);
		
		txtC = new JTextField();
		txtC.setEditable(false);
		txtC.setBounds(103, 109, 155, 20);
		getContentPane().add(txtC);
		txtC.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setIcon(new ImageIcon(ConversaoTemperatura.class.getResource("/img/49863___search_icon.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtF.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "PREENCHA  FAHRENHEIT !");
					txtF.requestFocus();
					} else if (txtF.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "PREENCHA CELSIUS!");
					txtF.requestFocus();
					} else {
					converter();
					}
			
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(113, 160, 48, 48);
		getContentPane().add(btnNewButton);
		
		// * Uso do atxy2k para validação
		RestrictedTextField validarF = new RestrictedTextField(txtF);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar ();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(ConversaoTemperatura.class.getResource("/img/9041260_eraser_fill_icon.png")));
		btnNewButton_1.setBounds(194, 160, 48, 48);
		getContentPane().add(btnNewButton_1);
		validarF.setOnlyNums(true);
		validarF.setLimit(4);
	


	} //fim do construtor
	
	void converter () {
		//variáveis
		double c,f;
		// entrada
		f = Double.parseDouble(txtF.getText());
  
		// processamento
		
		c = (5* (f - 32)) /9;
		// saída
		// a linha abaixo exibe o conteudo da variavel c na caixa de texto (é necessário converter para String)
		txtC.setText(String.valueOf(c));
		
	}
	
	//metodo limpar


void limpar() {
	txtC.setText(null);
	txtF.setText(null);
	txtF.requestFocus();
	
}
		
}//fim do codigo
