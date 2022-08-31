package portfolio;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import Atxy2k.CustomTextField.RestrictedTextField;

public class Eleitor extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtIdade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Eleitor dialog = new Eleitor();
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
	public Eleitor() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Eleitor.class.getResource("/img/vote_counting_magnifier_icon_154141.png")));
		setTitle("Eleitor");
		setModal(true);
		setBounds(100, 100, 250, 211);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Idade");
		lblNewLabel.setBounds(26, 35, 46, 14);
		getContentPane().add(lblNewLabel);

		txtIdade = new JTextField();
		txtIdade.setBounds(70, 32, 55, 20);
		getContentPane().add(txtIdade);
		txtIdade.setColumns(10);

		JButton btnNewButton = new JButton("");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBorder(new LineBorder(Color.PINK, 5));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setIcon(new ImageIcon(Eleitor.class.getResource("/img/326572_check_icon.png")));
		btnNewButton.setToolTipText("Verificar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtIdade.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha sua Idade");
				} else {
					verificar();
				}
				
				
			}
		});
		btnNewButton.setBounds(26, 97, 64, 64);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setBorder(new LineBorder(Color.PINK, 5));
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setIcon(new ImageIcon(Eleitor.class.getResource("/img/9041260_eraser_fill_icon.png")));
		btnNewButton_1.setToolTipText("Limpar");
		btnNewButton_1.setBounds(131, 97, 64, 64);
		getContentPane().add(btnNewButton_1);
		
		//validacao
		RestrictedTextField validarIdade = new RestrictedTextField(txtIdade);
		validarIdade.setOnlyNums(true);
		validarIdade.setLimit(3);

	}// fim do construtor

	void verificar() {
		// variáveis
		int idade;
		// entrada
		idade = Integer.parseInt(txtIdade.getText());
		// processamento + saída
		if (idade < 16) {
			JOptionPane.showMessageDialog(null, "Proibido votar");
		} else if (idade > 17 && idade < 71) {
			JOptionPane.showMessageDialog(null, "Obrigatório votar");
		} else {
			JOptionPane.showMessageDialog(null, "Voto facultativo");
		}
	}
	
	//limpar dados
	void limpar() {
		txtIdade.setText(null);
	}
		

}// fim do código
