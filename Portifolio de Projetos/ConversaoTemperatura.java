package portfolio;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
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
import javax.swing.border.LineBorder;

import Atxy2k.CustomTextField.RestrictedTextField;

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
		lblNewLabel.setBounds(74, 40, 83, 14);
		getContentPane().add(lblNewLabel);
		
		txtF = new JTextField();
		txtF.setBounds(155, 38, 83, 20);
		getContentPane().add(txtF);
		txtF.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Celsius");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(74, 102, 83, 14);
		getContentPane().add(lblNewLabel_1);
		
		txtC = new JTextField();
		txtC.setEditable(false);
		txtC.setBounds(155, 98, 83, 20);
		getContentPane().add(txtC);
		txtC.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setToolTipText("Converter para Fahrenheit");
		btnNewButton.setBorder(new LineBorder(Color.PINK, 2, true));
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setIcon(new ImageIcon(ConversaoTemperatura.class.getResource("/img/7795659_weather_warm_termometer_temperature_icon.png")));
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
		btnNewButton.setBounds(93, 158, 48, 48);
		getContentPane().add(btnNewButton);
		

		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setToolTipText("Limpar");
		btnNewButton_1.setBorder(new LineBorder(Color.PINK, 2, true));
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar ();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(ConversaoTemperatura.class.getResource("/img/9041260_eraser_fill_icon.png")));
		btnNewButton_1.setBounds(188, 158, 48, 48);
		getContentPane().add(btnNewButton_1);
		
	
	
		// * Uso do atxy2k para validação
		RestrictedTextField validarFahrenheit = new RestrictedTextField(txtF, "0123456789.");
		validarFahrenheit.setLimit(5);

		

	} //fim do construtor
	
	void converter () {
		
		// formatador de numeros
				DecimalFormat formatador = new DecimalFormat("#0.0");
		//variáveis
		double c,f;
		// entrada
		f = Double.parseDouble(txtF.getText());
  
		// processamento
		
		c = (5* (f - 32)) /9;
		// saída
		// a linha abaixo exibe o conteudo da variavel c na caixa de texto (é necessário converter para String)
		txtC.setText(String.valueOf(formatador.format(c)));
		
	}
	
	//metodo limpar


void limpar() {
	txtC.setText(null);
	txtF.setText(null);
	txtF.requestFocus();
	
}
		
}//fim do codigo
