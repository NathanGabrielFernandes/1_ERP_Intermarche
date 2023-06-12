package br.com.erp_intermarche.telas;

import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Toolkit;
import javax.swing.JTextPane;
import javax.swing.JFormattedTextField;
import java.awt.Font;

public class Sobre extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sobre frame = new Sobre();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Sobre() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Sobre.class.getResource("/br/com/erp_intermarche/icones/Imagem2.jpg")));
		setResizable(false);
		setTitle("Sobre ERP_Intermarche");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 703, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String texto = "Com o objetivo de aprimorar minhas habilidades em programação Java, foi proposto "+
				"pelo time de Desenvolvimento da SystemHaus a "+
				"elaboração de um programa que utilizasse os comandos básicos da linguagem Java, "+
				"estabelecendo interações com um banco de dados PostgreSQL. Como resultado, criei um "+
				"protótipo de um ERP (Enterprise Resource Planning) para aplicar os principais fundamentos básicos "+
				"do Java.";
						
		
		JLabel lblNewLabel = new JLabel("<html><div style='text-align: justify'>" + texto + "</div></html>");
		lblNewLabel.setToolTipText("");
		lblNewLabel.setBounds(21, 60, 640, 83);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Desenvolvido por Nathan Fernandes");
		lblNewLabel_1.setBounds(21, 194, 301, 34);
		contentPane.add(lblNewLabel_1);

		ImageIcon icon = new ImageIcon(Sobre.class.getResource("/br/com/erp_intermarche/icones/gnu.png"));
		Image imagemOriginal = icon.getImage();
		Image imagemRedimensionada = imagemOriginal.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		ImageIcon iconRedimensionado = new ImageIcon(imagemRedimensionada);
		
		JLabel lblNewLabel_4 = new JLabel("Ano 2023");
		lblNewLabel_4.setBounds(21, 258, 63, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_6 = new JLabel("SystemHaus");
		lblNewLabel_6.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel_6.setBounds(289, 11, 112, 38);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(Sobre.class.getResource("/br/com/erp_intermarche/icones/logo_systemhaus.png")));
		lblNewLabel_7.setBounds(332, 194, 339, 119);
		contentPane.add(lblNewLabel_7);
	}
}
