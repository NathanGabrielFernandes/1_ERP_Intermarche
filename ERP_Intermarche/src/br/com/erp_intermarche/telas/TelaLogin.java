package br.com.erp_intermarche.telas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JPasswordField;
import java.sql.*;
import br.com.erp_intermarche.dal.ModuloConexao;
import java.io.Serializable;

public class TelaLogin extends JFrame implements Serializable {
    private static final long serialVersionUID = 1L;

	// conexao é a variavel que eu criei na minha Classe ModuloConexao
	Connection conexao = null;
	// A linha abaixo prepara o código para receber comandos SQL
	PreparedStatement pst = null;
	// A linha abaixo exibe o resultado das intruções SQL
	ResultSet rs = null;
		
	
	private JTextField textField;
	private JPasswordField passwordField;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaLogin() {
		// A linha abaixo chama o metodo conector
		conexao = ModuloConexao.conector();
		
		// A linha abaixo serve de apoio ao status da conexão
		//System.out.println(conexao);
		
				
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\nathan.fernandes\\Pictures\\PlanoDeFundo\\Imagem2.jpg"));
		setTitle("Intermarché - Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 519, 266);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuário");
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 52, 47, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Senha");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 107, 38, 24);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(67, 54, 234, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLogin.setBounds(130, 155, 96, 30);
		contentPane.add(btnLogin);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(220, 3, 41));
		panel.setBounds(311, 0, 216, 304);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\nathan.fernandes\\Pictures\\PlanoDeFundo\\Imagem2.jpg"));
		lblNewLabel_2.setBounds(38, 46, 126, 95);
		panel.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(67, 109, 234, 24);
		contentPane.add(passwordField);
		
		JLabel lblStatus = new JLabel("");
		lblStatus.setBounds(10, 197, 75, 30);
		contentPane.add(lblStatus);
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		if (conexao != null) {
		    ImageIcon icon = new ImageIcon(getClass().getResource("/br/com/erp_intermarche/icones/dbokk.png"));
		    Image image = icon.getImage().getScaledInstance(22, 22, Image.SCALE_SMOOTH);
		    ImageIcon scaledIcon = new ImageIcon(image);
		    lblStatus.setIcon(scaledIcon);
		} else {
		    ImageIcon icon = new ImageIcon(getClass().getResource("/br/com/erp_intermarche/icones/dberro.png"));
		    Image image = icon.getImage().getScaledInstance(22, 22, Image.SCALE_SMOOTH);
		    ImageIcon scaledIcon = new ImageIcon(image);
		    lblStatus.setIcon(scaledIcon);
		}

	}
}
