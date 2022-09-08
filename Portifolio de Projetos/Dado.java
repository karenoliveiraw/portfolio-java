package portfolio;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Toolkit;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Dado extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtDado;
	private JLabel lblFacedoDado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dado dialog = new Dado();
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
	public Dado() {
		getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Dado.class.getResource("/img/face.png")));
		setTitle("Jogo do Dado");
		setBounds(100, 100, 360, 300);
		getContentPane().setLayout(null);

		JButton btnLancar = new JButton("");
		btnLancar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lancar();
			}
		});
		btnLancar.setBackground(Color.PINK);
		btnLancar.setToolTipText("Lançar Dado");
		btnLancar.setIcon(new ImageIcon(Dado.class.getResource("/img/dado64x64.png")));
		btnLancar.setBounds(85, 186, 64, 64);
		getContentPane().add(btnLancar);

		JButton btnLimpar = new JButton("");
		btnLimpar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();

			}
		});
		btnLimpar.setBackground(Color.PINK);
		btnLimpar.setIcon(new ImageIcon(Dado.class.getResource("/img/limpar.png")));
		btnLimpar.setToolTipText("Limpar");
		btnLimpar.setBounds(207, 186, 64, 64);
		getContentPane().add(btnLimpar);

		txtDado = new JTextField();
		txtDado.setBorder(new LineBorder(new Color(255, 175, 175), 2, true));
		txtDado.setForeground(Color.PINK);
		txtDado.setCaretColor(Color.PINK);
		txtDado.setHorizontalAlignment(SwingConstants.CENTER);
		txtDado.setFont(new Font("Nexa Bold", Font.BOLD, 15));
		txtDado.setDisabledTextColor(Color.BLACK);
		txtDado.setEnabled(false);
		txtDado.setEditable(false);
		txtDado.setBounds(115, 137, 115, 27);
		getContentPane().add(txtDado);
		txtDado.setColumns(10);
		
		lblFacedoDado = new JLabel("");
		lblFacedoDado.setIcon(new ImageIcon(Dado.class.getResource("/img/face.png")));
		lblFacedoDado.setBounds(115, 11, 115, 115);
		getContentPane().add(lblFacedoDado);

	}// fim do construtor

	public void lancar() {
		Random random = new Random();

		int face = random.nextInt(6) + 1;
		switch (face) {

		case 1:
			lblFacedoDado.setIcon(new ImageIcon(Dado.class.getResource("/img/face1.png")));
			break;
		case 2:
			lblFacedoDado.setIcon(new ImageIcon(Dado.class.getResource("/img/face2.png")));
			break;
		case 3:
			lblFacedoDado.setIcon(new ImageIcon(Dado.class.getResource("/img/face3.png")));
			break;
		case 4:
			lblFacedoDado.setIcon(new ImageIcon(Dado.class.getResource("/img/face4.png")));
			break;
		case 5:
			lblFacedoDado.setIcon(new ImageIcon(Dado.class.getResource("/img/face5.png")));
			break;
		case 6:
			lblFacedoDado.setIcon(new ImageIcon(Dado.class.getResource("/img/face6.png")));
			break;
		}
		txtDado.setText(String.valueOf(face));
		
	}

	// limpar
	void limpar() {
		txtDado.setText(null);
		lblFacedoDado.setIcon(new ImageIcon(Dado.class.getResource("/img/face.png")));
	}
}// fim do codigo
