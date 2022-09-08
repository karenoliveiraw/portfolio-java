package portfolio;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import cep.Cep;

import java.awt.Font;

public class Portfolio extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblData;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Portfolio frame = new Portfolio();
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
	public Portfolio() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				Date data = new Date();
				DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
				lblData.setText(formatador.format(data));
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(Portfolio.class.getResource("/img/pc.png")));
		setResizable(false);
		setTitle("Portf\u00F3lio de projetos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBorder(new LineBorder(new Color(255, 175, 175), 3, true));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setToolTipText("Calcular IMC");
		btnNewButton.setIcon(new ImageIcon(Portfolio.class.getResource("/img/4394714_healthcare_scale_sports_weight_icon.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// as linhas abaixo fazem o link com o formulário IMC
				IMC imc = new IMC();
				imc.setVisible(true);
			}
		});
		btnNewButton.setBounds(124, 37, 64, 64);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setIcon(new ImageIcon(Portfolio.class.getResource("/img/2180880_me_profile_user_icon.png")));
		btnNewButton_1.setToolTipText("Sobre");
		btnNewButton_1.setBorder(new LineBorder(Color.PINK, 3, true));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//evento clicar no botão
				Sobre sobre = new Sobre();
				sobre.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(500, 263, 64, 64);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setBorder(new LineBorder(Color.PINK, 3, true));
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_2.setToolTipText("Calculadora da M\u00E9dia");
		btnNewButton_2.setIcon(new ImageIcon(Portfolio.class.getResource("/img/4213589_calculate_calculator_doodle_education_line_icon.png")));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Media media = new Media();
				media.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(50, 37, 64, 64);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setBorder(new LineBorder(new Color(255, 175, 175), 3, true));
		btnNewButton_3.setContentAreaFilled(false);
		btnNewButton_3.setToolTipText("Calcular Temperatura");
		btnNewButton_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_3.setIcon(new ImageIcon(Portfolio.class.getResource("/img/7795659_weather_warm_termometer_temperature_icon.png")));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConversaoTemperatura conversao = new ConversaoTemperatura();
				conversao.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(124, 131, 64, 64);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.setBorder(new LineBorder(new Color(255, 175, 175), 3, true));
		btnNewButton_5.setContentAreaFilled(false);
		btnNewButton_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_5.setToolTipText("Calcular Porcentagem de Desconto");
		btnNewButton_5.setIcon(new ImageIcon(Portfolio.class.getResource("/img/percentage_3155.png")));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalculoPorcentagem porcentagem = new CalculoPorcentagem();
				porcentagem.setVisible(true);
			}
		});
		btnNewButton_5.setBounds(198, 37, 64, 64);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("");
		btnNewButton_6.setBorder(new LineBorder(Color.PINK, 3, true));
		btnNewButton_6.setContentAreaFilled(false);
		btnNewButton_6.setToolTipText("Calcular Hora de Servi\u00E7o");
		btnNewButton_6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_6.setIcon(new ImageIcon(Portfolio.class.getResource("/img/spreadsheet_icon_126812.png")));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AppServico servico = new AppServico();
				servico.setVisible(true);
			}
		});
		btnNewButton_6.setBounds(198, 131, 64, 64);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("");
		btnNewButton_7.setToolTipText("Etanol x Gasolina");
		btnNewButton_7.setIcon(new ImageIcon(Portfolio.class.getResource("/img/gasoline_oil_gas_fuel_pump_icon_150429.png")));
		btnNewButton_7.setBorder(new LineBorder(Color.PINK, 3));
		btnNewButton_7.setContentAreaFilled(false);
		btnNewButton_7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Combustivel combustivel = new Combustivel();
				combustivel.setVisible(true);
			}
		});
		btnNewButton_7.setBounds(272, 131, 64, 64);
		contentPane.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("");
		btnNewButton_8.setToolTipText("Verificar Eleitor");
		btnNewButton_8.setIcon(new ImageIcon(Portfolio.class.getResource("/img/vote_counting_magnifier_icon_154141.png")));
		btnNewButton_8.setBorder(new LineBorder(Color.PINK, 3, true));
		btnNewButton_8.setContentAreaFilled(false);
		btnNewButton_8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Eleitor eleitor = new Eleitor();
				eleitor.setVisible(true);
			}
		});
		btnNewButton_8.setBounds(272, 37, 64, 64);
		contentPane.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dado dado = new Dado ();
				dado.setVisible(true);
			}
		});
		btnNewButton_9.setToolTipText("Dados");
		btnNewButton_9.setIcon(new ImageIcon(Portfolio.class.getResource("/img/dados.png")));
		btnNewButton_9.setBorder(new LineBorder(Color.PINK, 3, true));
		btnNewButton_9.setContentAreaFilled(false);
		btnNewButton_9.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_9.setBounds(50, 131, 64, 64);
		contentPane.add(btnNewButton_9);
		
		JButton btnNewButton_8_1 = new JButton("");
		btnNewButton_8_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_8_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tabuada tabuada = new Tabuada();
				tabuada.setVisible(true);
			}
		});
		btnNewButton_8_1.setIcon(new ImageIcon(Portfolio.class.getResource("/img/9022696_math_operations_duotone_icon.png")));
		btnNewButton_8_1.setToolTipText("Tabuada");
		btnNewButton_8_1.setContentAreaFilled(false);
		btnNewButton_8_1.setBorder(new LineBorder(Color.PINK, 3, true));
		btnNewButton_8_1.setBounds(357, 37, 64, 64);
		contentPane.add(btnNewButton_8_1);
		
		JButton btnNewButton_7_1_1 = new JButton("");
		btnNewButton_7_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_7_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Carta carta = new Carta();
				carta.setVisible(true);
			}
		});
		btnNewButton_7_1_1.setIcon(new ImageIcon(Portfolio.class.getResource("/img/3525389_card_casino_deck_gambling_magic_icon.png")));
		btnNewButton_7_1_1.setToolTipText("Sorteio da Carta");
		btnNewButton_7_1_1.setContentAreaFilled(false);
		btnNewButton_7_1_1.setBorder(new LineBorder(Color.PINK, 3));
		btnNewButton_7_1_1.setBounds(357, 131, 64, 64);
		contentPane.add(btnNewButton_7_1_1);
		
		JButton btnNewButton_7_1_2 = new JButton("");
		btnNewButton_7_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Hello hello = new Hello();
				hello.setVisible(true); 
			}
		});
		btnNewButton_7_1_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_7_1_2.setIcon(new ImageIcon(Portfolio.class.getResource("/img/hello.png")));
		btnNewButton_7_1_2.setToolTipText("Hello");
		btnNewButton_7_1_2.setContentAreaFilled(false);
		btnNewButton_7_1_2.setBorder(new LineBorder(Color.PINK, 3));
		btnNewButton_7_1_2.setBounds(124, 220, 64, 64);
		contentPane.add(btnNewButton_7_1_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setForeground(Color.WHITE);
		panel.setBounds(10, 338, 554, 41);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblData = new JLabel("New label");
		lblData.setForeground(Color.WHITE);
		lblData.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblData.setBounds(123, 0, 421, 41);
		panel.add(lblData);
		
		JButton btnNewButton_7_1_2_1 = new JButton("");
		btnNewButton_7_1_2_1.setIcon(new ImageIcon(Portfolio.class.getResource("/img/3702385_back_cash_money_icon (1).png")));
		btnNewButton_7_1_2_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_7_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Juros juros = new Juros();
				juros.setVisible(true);
			}
		});
		btnNewButton_7_1_2_1.setToolTipText("Calcular Juros Simples");
		btnNewButton_7_1_2_1.setContentAreaFilled(false);
		btnNewButton_7_1_2_1.setBorder(new LineBorder(Color.PINK, 3));
		btnNewButton_7_1_2_1.setBounds(50, 220, 64, 64);
		contentPane.add(btnNewButton_7_1_2_1);
		
		JButton btnNewButton_7_1_2_2 = new JButton("");
		btnNewButton_7_1_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cep cep = new Cep();
				cep.setVisible(true);
			}
		});
		btnNewButton_7_1_2_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_7_1_2_2.setIcon(new ImageIcon(Portfolio.class.getResource("/img/3512626_gps_location_map_navigation_pin_icon.png")));
		btnNewButton_7_1_2_2.setToolTipText("Buscar CEP");
		btnNewButton_7_1_2_2.setContentAreaFilled(false);
		btnNewButton_7_1_2_2.setBorder(new LineBorder(Color.PINK, 3));
		btnNewButton_7_1_2_2.setBounds(198, 220, 64, 64);
		contentPane.add(btnNewButton_7_1_2_2);
		
		JButton btnNewButton_7_1_2_2_1 = new JButton("");
		btnNewButton_7_1_2_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Energia energia = new Energia ();
				energia.setVisible(true);
			}
		});
		btnNewButton_7_1_2_2_1.setIcon(new ImageIcon(Portfolio.class.getResource("/img/energia.png")));
		btnNewButton_7_1_2_2_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_7_1_2_2_1.setToolTipText("Calcular Consumo da Energia");
		btnNewButton_7_1_2_2_1.setContentAreaFilled(false);
		btnNewButton_7_1_2_2_1.setBorder(new LineBorder(Color.PINK, 3));
		btnNewButton_7_1_2_2_1.setBounds(272, 220, 64, 64);
		contentPane.add(btnNewButton_7_1_2_2_1);
		
		JButton btnNewButton_7_1_2_2_1_1 = new JButton("");
		btnNewButton_7_1_2_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaJogo telajogo = new TelaJogo ();
				telajogo.setVisible(true);
			
			}
		});
		btnNewButton_7_1_2_2_1_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_7_1_2_2_1_1.setIcon(new ImageIcon(Portfolio.class.getResource("/img/pngmaos.png")));
		btnNewButton_7_1_2_2_1_1.setToolTipText("Jokenpo");
		btnNewButton_7_1_2_2_1_1.setContentAreaFilled(false);
		btnNewButton_7_1_2_2_1_1.setBorder(new LineBorder(Color.PINK, 3));
		btnNewButton_7_1_2_2_1_1.setBounds(357, 220, 64, 64);
		contentPane.add(btnNewButton_7_1_2_2_1_1);
	}// fim do construtor
	
	
}
