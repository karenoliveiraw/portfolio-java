package portfolio;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

public class TelaJogo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnPedra;
	private JRadioButton rdbtnPapel;
	private JRadioButton rdbtnTesoura;
	private JLabel lblPC;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaJogo frame = new TelaJogo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaJogo() {
		setFont(new Font("Nexa Slab Bold", Font.BOLD | Font.ITALIC, 13));
		setTitle("JoKenPo");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 380);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaJogo.class.getResource("/img/papel.png")));
		lblNewLabel.setBounds(170, 11, 64, 64);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TelaJogo.class.getResource("/img/pedra.png")));
		lblNewLabel_1.setBounds(70, 11, 64, 64);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(TelaJogo.class.getResource("/img/tesoura.png")));
		lblNewLabel_1_1.setBounds(263, 11, 64, 64);
		contentPane.add(lblNewLabel_1_1);

		lblPC = new JLabel("");
		lblPC.setIcon(new ImageIcon(TelaJogo.class.getResource("/img/pcc.png")));
		lblPC.setBounds(130, 191, 171, 139);
		contentPane.add(lblPC);

		rdbtnPedra = new JRadioButton("");
		rdbtnPedra.setForeground(new Color(0, 0, 0));
		buttonGroup.add(rdbtnPedra);
		rdbtnPedra.setBackground(Color.WHITE);
		rdbtnPedra.setBounds(90, 82, 51, 23);
		contentPane.add(rdbtnPedra);

		rdbtnPapel = new JRadioButton("");
		buttonGroup.add(rdbtnPapel);
		rdbtnPapel.setBackground(new Color(255, 255, 255));
		rdbtnPapel.setBounds(190, 82, 51, 23);
		contentPane.add(rdbtnPapel);

		rdbtnTesoura = new JRadioButton("");
		buttonGroup.add(rdbtnTesoura);
		rdbtnTesoura.setBackground(Color.WHITE);
		rdbtnTesoura.setBounds(287, 82, 51, 23);
		contentPane.add(rdbtnTesoura);

		JButton btnPOW = new JButton("");
		btnPOW.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPOW.setToolTipText("Jogar");
		btnPOW.setIcon(new ImageIcon(TelaJogo.class.getResource("/img/maos.png")));
		btnPOW.setFont(new Font("Nexa Slab Regular", Font.BOLD, 11));
		btnPOW.setForeground(new Color(0, 0, 0));
		btnPOW.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pow();
			}
		});
		btnPOW.setBounds(177, 116, 64, 64);
		contentPane.add(btnPOW);
	}// fim do construtor

	void pow() {
		// validação

		if (!rdbtnPapel.isSelected() && !rdbtnPedra.isSelected() && !rdbtnTesoura.isSelected()) {
			JOptionPane.showMessageDialog(null, "Escolha uma opção");

		} else {
			// lógica principal
			Random random = new Random();
			int pc = random.nextInt(3);
			// Dica para verificar o número sorteado
			// System.out.println(pc);
			// Associar o numero a imagem
			switch (pc) {
			case 0:
			lblPC.setIcon(new ImageIcon(TelaJogo.class.getResource("/img/pcpapel.png")));
			break;
			case 1:
			lblPC.setIcon(new ImageIcon(TelaJogo.class.getResource("/img/pcpedra.png")));
			break;
			case 2:
			lblPC.setIcon(new ImageIcon(TelaJogo.class.getResource("/img/pctesoura.png")));
			break;				
			}
			//Comparações para determinar o vencedor ou empate
			if ((rdbtnPapel.isSelected() && pc == 0) || (rdbtnPedra.isSelected() && pc == 1) ||(rdbtnTesoura.isSelected() && pc == 2)) {
				JOptionPane.showMessageDialog(null, "EMPATE");
			} else if ((rdbtnPapel.isSelected() && pc == 1) || (rdbtnPedra.isSelected() && pc == 0) ||(rdbtnTesoura.isSelected() && pc == 0)) {
				JOptionPane.showMessageDialog(null, "JOGADOR VENCEU");
			} else {
				JOptionPane.showMessageDialog(null, "PC VENCE");
				
			}
			//limpar os campos
			lblPC.setIcon(new ImageIcon(TelaJogo.class.getResource("/img/pc.png")));
			buttonGroup.clearSelection();
		
		}
	}

}// fim do codigo
