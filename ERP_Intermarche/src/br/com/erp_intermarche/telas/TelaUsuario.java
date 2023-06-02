package br.com.erp_intermarche.telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Toolkit;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.SwingConstants;

public class TelaUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField textNomeCompleto;
	private JTextField textSenha;
	private JTextField textEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaUsuario frame = new TelaUsuario();
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
	@SuppressWarnings("unused")
	public TelaUsuario() {
		setResizable(false);
		setTitle("Usuários");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaUsuario.class.getResource("/br/com/erp_intermarche/icones/Imagem2.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 920, 556);
		ImageIcon icon = new ImageIcon(TelaUsuario.class.getResource("/br/com/erp_intermarche/icones/home.png"));
		Image image = icon.getImage(); // Obtém a imagem do ícone
		Image newImage = image.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		
		JLabel lblNomeCompleto = new JLabel("Nome completo");
		lblNomeCompleto.setBounds(115, 106, 161, 18);
		lblNomeCompleto.setFont(new Font("Segoe UI", Font.BOLD, 13));
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(115, 182, 161, 18);
		lblSenha.setFont(new Font("Segoe UI", Font.BOLD, 13));
		
		JLabel lblPerfil = new JLabel("Perfil");
		lblPerfil.setBounds(115, 222, 161, 18);
		lblPerfil.setFont(new Font("Segoe UI", Font.BOLD, 13));
		
		textNomeCompleto = new JTextField();
		textNomeCompleto.setBounds(286, 104, 548, 22);
		textNomeCompleto.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		textNomeCompleto.setColumns(10);
		
		textSenha = new JTextField();
		textSenha.setBounds(286, 180, 244, 22);
		textSenha.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		textSenha.setColumns(10);
		
		JComboBox cboPerfil = new JComboBox();
		cboPerfil.setBounds(286, 220, 61, 22);
		cboPerfil.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		cboPerfil.setModel(new DefaultComboBoxModel(new String[] {"user", "admin"}));
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(115, 139, 117, 18);
		lblEmail.setFont(new Font("Segoe UI", Font.BOLD, 13));
		
		textEmail = new JTextField();
		textEmail.setBounds(286, 137, 548, 22);
		textEmail.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		textEmail.setColumns(10);
		
		
		ImageIcon icon1 = new ImageIcon(TelaUsuario.class.getResource("/br/com/erp_intermarche/icones/add.png"));
		Image imagem = icon1.getImage();
		Image imagemRedimensionada = imagem.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon iconRedimensionado = new ImageIcon(imagemRedimensionada);
		
		
		
		ImageIcon icon2 =(new ImageIcon(TelaUsuario.class.getResource("/br/com/erp_intermarche/icones/search.png")));
		Image imagem2 = icon2.getImage();
		Image imagemRedimensionada2 = imagem2.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon iconRedimensionado2 = new ImageIcon(imagemRedimensionada2);
	
		ImageIcon icon3 = (new ImageIcon(TelaUsuario.class.getResource("/br/com/erp_intermarche/icones/edit.png")));
		Image imagem3 = icon3.getImage();
		Image imagemRedimensionada3 = imagem3.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon iconRedimensionado3 = new ImageIcon(imagemRedimensionada3);
		
		
		ImageIcon icon4 = (new ImageIcon(TelaUsuario.class.getResource("/br/com/erp_intermarche/icones/delete.png")));
		Image imagem4 = icon4.getImage();
		Image imagemRedimensionada4 = imagem4.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon iconRedimensionado4 = new ImageIcon(imagemRedimensionada4);
		
		
		
		ImageIcon icon5 = (new ImageIcon(TelaUsuario.class.getResource("/br/com/erp_intermarche/icones/home.png")));
		Image imagem5 = icon5.getImage();
		Image imagemRedimensionada5 = imagem5.getScaledInstance(30,30,image.SCALE_SMOOTH);
		ImageIcon iconRedimensionado5 = new ImageIcon(imagemRedimensionada5);
		JButton btnHome = new JButton("");
		btnHome.setBounds(10, 11, 61, 48);
		btnHome.setIcon(iconRedimensionado5);
		
		
		
		getContentPane().setLayout(null);
		getContentPane().add(lblSenha);
		getContentPane().add(lblNomeCompleto);
		getContentPane().add(lblEmail);
		getContentPane().add(lblPerfil);
		getContentPane().add(cboPerfil);
		getContentPane().add(textEmail);
		getContentPane().add(textSenha);
		getContentPane().add(textNomeCompleto);
		getContentPane().add(btnHome);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(15);
		flowLayout.setHgap(10);
		panel.setBounds(112, 313, 723, 87);
		getContentPane().add(panel);
		JButton btnAdicionar = new JButton("");
		panel.add(btnAdicionar);
		btnAdicionar.setIcon(iconRedimensionado);
		JButton btnProcurar = new JButton("");
		panel.add(btnProcurar);
		btnProcurar.setIcon(iconRedimensionado2);
		JButton btnEditar = new JButton("");
		panel.add(btnEditar);
		btnEditar.setIcon(iconRedimensionado3);
		JButton btnExcluir = new JButton("");
		panel.add(btnExcluir);
		btnExcluir.setIcon(iconRedimensionado4);
		
		JLabel lblTitle = new JLabel("Editar Cadastro de Usuários");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblTitle.setBounds(328, 41, 255, 18);
		getContentPane().add(lblTitle);
		
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 850, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 487, Short.MAX_VALUE)
		);
		contentPane.setLayout(gl_contentPane);
		
	}
}
