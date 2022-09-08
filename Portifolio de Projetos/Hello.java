package portfolio;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import javax.swing.SwingConstants;

public class Hello extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hello dialog = new Hello();
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
	public Hello() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Hello.class.getResource("/img/hello.png")));
		setModal(true);
		setTitle("Hello World");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.setBorder(null);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setToolTipText("Hello");
		btnNewButton.setIcon(new ImageIcon(Hello.class.getResource("/img/hello.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//executar o método helloWorld()
				helloWorld();
			}
		});
		btnNewButton.setBounds(163, 110, 64, 64);
		getContentPane().add(btnNewButton);

	}//fim do construtor

	void helloWorld() {
		JOptionPane.showMessageDialog(null, "Hello World");
	}
	
}//fim
