package br.com.erp_intermarche.telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.lang.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JMenuItem;

import br.com.erp_intermarche.dal.ModuloConexao;

public class TelaLogin extends JFrame implements Serializable {
    private static final long serialVersionUID = 1L;

	// conexao é a variavel que eu criei na minha Classe ModuloConexao
	Connection conexao = null;
	
	// A linha abaixo prepara o código para receber comandos SQL
	PreparedStatement pst = null;
	
	// A linha abaixo exibe o resultado das intruções SQL
	ResultSet rs = null;
	
	public void logar() {
		String sql ="select * from usuarios_senhas where email=? and senhas=? ";
		try {
			
			//As linhas abaixo preparam a consulta ao banco em função do que foi
			//digitado nas caixas de texto, o "?" é substituido pelo conteúdo das variáveis
			pst = conexao.prepareStatement(sql);
			pst.setString(1,textUsuario.getText());
			String captura = new String(pwdSenha.getPassword());
			pst.setString(2,captura);
			
			//A linha abaixo executa a query da variável "sql"
			rs = pst.executeQuery();
			
			//Se existir usuário e senha correspondente
			if (rs.next()) {
				//A linha abaixo obtem o conteudo do campo perfil da tabela usuarios_senhas do banco de dados
				String perfil = rs.getString(3); // número 3 é o número da coluna que contem o perfil no banco de dados
				
				//A estrutura abaixo faz o tratamento do perfil do usuário
				
				if(perfil.equals("admin")) {					
				TelaPrincipal principal = new TelaPrincipal();  					 // chama a tela principal
				principal.setLocationRelativeTo(null);								 // centraliza a tela principal
				principal.setVisible(true);											 // deixa visível 
				((JMenuItem) TelaPrincipal.mntmRelatorioLogistica).setEnabled(true); // habilita a opção de relatório da tela principal
				((JMenuItem) TelaPrincipal.mntmUsuario).setEnabled(true);			 // habilita a opção de novo usuário da tela principal
				((JLabel)TelaPrincipal.lblUsuarioAtual).setText(rs.getString(1));	 // altera a label para o nome de usuario pegando o dado do banco de dados
				((JLabel)TelaPrincipal.lblNivelAcesso).setText(rs.getString(3));	 // altera a label para o nível de acesso do usuario pegando do banco de dados
				this.dispose();														 // fecha a tela de login	
				conexao.close();													 // fecha a conexão com o banco de dados
				}else {
					TelaPrincipal principal = new TelaPrincipal();
					principal.setLocationRelativeTo(null);
					principal.setVisible(true);
					((JLabel)TelaPrincipal.lblUsuarioAtual).setText(rs.getString(1));
					((JLabel)TelaPrincipal.lblNivelAcesso).setText(rs.getString(3));
				}
			}else {
				JOptionPane.showMessageDialog(null,"Usuário ou Senha inválido");
			}
				
									
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,e);
		}
			
	}
	
	private JTextField textUsuario;
	private JPasswordField pwdSenha;
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
		setBounds(100, 100, 519, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuário");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 42, 59, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Senha");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 97, 59, 24);
		contentPane.add(lblNewLabel_1);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(79, 44, 222, 24);
		contentPane.add(textUsuario);
		textUsuario.setColumns(10);
		
		JButton btnLogin = new JButton("Entrar");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Chamando o método logar
				logar();
			}
		});
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBackground(new Color(220, 3, 41));
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLogin.setBounds(132, 172, 96, 30);
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
		
		pwdSenha = new JPasswordField();
		pwdSenha.setBounds(79, 99, 222, 24);
		contentPane.add(pwdSenha);
		
		JLabel lblStatus = new JLabel("Status conexão ao banco");
		lblStatus.setBounds(10, 209, 134, 30);
		contentPane.add(lblStatus);
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		JCheckBox chckbxVisualizarSenha = new JCheckBox("Visualizar senha");
		chckbxVisualizarSenha.setFont(new Font("Tahoma", Font.PLAIN, 10));
		chckbxVisualizarSenha.setBounds(79, 130, 134, 23);
		contentPane.add(chckbxVisualizarSenha);
		
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
		
		chckbxVisualizarSenha.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                if (chckbxVisualizarSenha.isSelected()) {
                    pwdSenha.setEchoChar((char) 0); // Mostra o texto do campo passwordField
                } else {
                    pwdSenha.setEchoChar('\u2022'); // Oculta o texto do campo passwordField com um caractere de senha
                }
            }
		});
	}
}
