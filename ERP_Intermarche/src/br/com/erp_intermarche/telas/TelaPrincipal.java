package br.com.erp_intermarche.telas;

import java.awt.EventQueue;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import java.awt.Toolkit;
import java.text.DateFormat;

import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JLabel lblData;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setLocationRelativeTo(null);
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
	public TelaPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaPrincipal.class.getResource("/br/com/erp_intermarche/icones/Imagem2.jpg")));
		setTitle("ERP Intermarche - Tela Principal");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 977, 544);
		
		JMenuBar Menu = new JMenuBar();
		setJMenuBar(Menu);
		
		JMenu mnNewMenu = new JMenu("Cadastro");
		Menu.add(mnNewMenu);
		
		JMenuItem mntmNovoFornecedor = new JMenuItem("Novo Fornecedor");
		mnNewMenu.add(mntmNovoFornecedor);
		
		JMenuItem mntmNovoArtigo = new JMenuItem("Novo Artigo");
		mnNewMenu.add(mntmNovoArtigo);
		
		JMenu mnRelatorioLogistica = new JMenu("Logistica");
		Menu.add(mnRelatorioLogistica);
		
		JMenuItem mntmRecebimento = new JMenuItem("Recebimento");
		mnRelatorioLogistica.add(mntmRecebimento);
		
		JMenuItem mntmExedicao = new JMenuItem("Expedição");
		mnRelatorioLogistica.add(mntmExedicao);
		
		JSeparator separator = new JSeparator();
		mnRelatorioLogistica.add(separator);
		
		JMenuItem mntmRelatorioLogistica = new JMenuItem("Relatório");
		mnRelatorioLogistica.add(mntmRelatorioLogistica);
		
		JMenu mnNewMenu_2 = new JMenu("Opções");
		Menu.add(mnNewMenu_2);
		
		JMenuItem mntmR_Erro_Sugestoes = new JMenuItem("Reportar Erro / Sugestões");
		mnNewMenu_2.add(mntmR_Erro_Sugestoes);
		
		JMenu mnNewMenu_3 = new JMenu("Sistema");
		Menu.add(mnNewMenu_3);
		
		JMenuItem mntmSobre_ERP = new JMenuItem("Sobre ERP_Intermarche");
		mntmSobre_ERP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sobre telasobre = new Sobre();
				telasobre.setVisible(true);				
			}
		});
		mnNewMenu_3.add(mntmSobre_ERP);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 488, 963, -476);
		contentPane.add(desktopPane);
		desktopPane.setLayout(null);
		
		
	}
	
}

