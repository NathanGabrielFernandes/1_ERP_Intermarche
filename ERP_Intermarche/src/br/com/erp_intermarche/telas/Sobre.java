package br.com.erp_intermarche.telas;

import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class Sobre extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sobre frame = new Sobre();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Sobre() {
		setResizable(false);
		setTitle("Sobre ERP_Intermarche");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 582, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Sistema de software que ajuda as organizações a automatizar e gerir processos de negócio");
		lblNewLabel.setToolTipText("");
		lblNewLabel.setBounds(10, 17, 681, 72);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Desenvolvido por Nathan Fernandes");
		lblNewLabel_1.setBounds(10, 100, 301, 34);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Sob a licença GPL");
		lblNewLabel_2.setBounds(10, 175, 114, 23);
		contentPane.add(lblNewLabel_2);

		ImageIcon icon = new ImageIcon(Sobre.class.getResource("/br/com/erp_intermarche/icones/gnu.png"));
		Image imagemOriginal = icon.getImage();
		Image imagemRedimensionada = imagemOriginal.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		ImageIcon iconRedimensionado = new ImageIcon(imagemRedimensionada);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(iconRedimensionado);
		lblNewLabel_3.setBounds(128, 163, 25, 46);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Ano 2023");
		lblNewLabel_4.setBounds(10, 225, 63, 14);
		contentPane.add(lblNewLabel_4);
	}
}
