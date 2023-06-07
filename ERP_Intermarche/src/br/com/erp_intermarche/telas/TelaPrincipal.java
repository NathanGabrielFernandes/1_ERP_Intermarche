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
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.FlowLayout;

public class TelaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblData;
	public static JMenuItem mntmRelatorioLogistica; // comando importante para conseguir acessar o JMenuItem em outra telas
	public static JMenuItem mntmUsuario;			// comando importante para conseguir acessar o JMenuItem em outra telas
	public static JLabel lblUsuarioAtual;
	public static JLabel lblNivelAcesso;
	
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
	
	private TelaUsuario telaUsuario; // Variável para armazenar a referência à instância da tela de usuário
	private Sobre	telasobre;		// Variável para armazenar a referência à instância da tela de usuário
	
	public TelaPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaPrincipal.class.getResource("/br/com/erp_intermarche/icones/Imagem2.jpg")));
		setTitle("ERP Intermarche - Tela Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 977, 662);
		
		JMenuBar Menu = new JMenuBar();
		setJMenuBar(Menu);
		
		JMenu mnNewMenu = new JMenu("Cadastro");
		Menu.add(mnNewMenu);
		
		JMenuItem mntmUsuario = new JMenuItem("Novo Usuário");
		mntmUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			      if (telaUsuario == null) { // Verifica se a tela de usuário já está aberta
		                telaUsuario = new TelaUsuario();
		                telaUsuario.setLocationRelativeTo(null);
		            }
		            telaUsuario.setVisible(true);	
		            
			}
			
		});
		mntmUsuario.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, InputEvent.ALT_DOWN_MASK));
		mntmUsuario.setEnabled(false);
		mnNewMenu.add(mntmUsuario);
		TelaPrincipal.mntmUsuario = mntmUsuario; // comando importante para conseguir acessar o JMenuItem em outra telas
		
		JMenuItem mntmNovoFornecedor = new JMenuItem("Novo Fornecedor");
		mntmNovoFornecedor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.ALT_DOWN_MASK));
		mnNewMenu.add(mntmNovoFornecedor);
		
		JMenuItem mntmNovoArtigo = new JMenuItem("Novo Artigo");
		mntmNovoArtigo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.ALT_DOWN_MASK));
		mnNewMenu.add(mntmNovoArtigo);
		
		JMenu mnRelatorioLogistica = new JMenu("Logistica");
		Menu.add(mnRelatorioLogistica);
		
		JMenuItem mntmRecebimento = new JMenuItem("Recebimento");
		mntmRecebimento.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.ALT_DOWN_MASK));
		mnRelatorioLogistica.add(mntmRecebimento);
		
		JMenuItem mntmExedicao = new JMenuItem("Expedição");
		mntmExedicao.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.ALT_DOWN_MASK));
		mnRelatorioLogistica.add(mntmExedicao);
		
		JSeparator separator = new JSeparator();
		mnRelatorioLogistica.add(separator);
		
		
		JMenuItem mntmRelatorioLogistica = new JMenuItem("Relatório");
		mntmRelatorioLogistica.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.ALT_DOWN_MASK));
		mntmRelatorioLogistica.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
			}
		});
		TelaPrincipal.mntmRelatorioLogistica = mntmRelatorioLogistica;  // comando importante para conseguir acessar o JMenuItem em outra telas
		mntmRelatorioLogistica.setEnabled(false);
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
				
				if (telasobre==null) {				
					telasobre = new Sobre();
					telasobre.setLocationRelativeTo(null);
					
				}else {
					
				telasobre.setVisible(true);	
				}
			}
		});
		mnNewMenu_3.add(mntmSobre_ERP);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		
		JLabel lblNivelAcesso_1 = new JLabel("Nível de acesso atual");
		TelaPrincipal.lblNivelAcesso = lblNivelAcesso_1;
		
		JLabel lblNewLabel_1 = new JLabel("Nível de acesso:");
		
		JLabel lblNewLabel = new JLabel("Usuário:");
		
		JLabel lblUsuarioAtual_1 = new JLabel("usuárioatual");
		TelaPrincipal.lblUsuarioAtual = lblUsuarioAtual_1;
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblUsuarioAtual_1)
					.addGap(75)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNivelAcesso_1)
					.addContainerGap(578, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(579, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(lblNivelAcesso_1)
						.addComponent(lblNewLabel_1)
						.addComponent(lblUsuarioAtual_1)))
		);
		contentPane.setLayout(gl_contentPane);
		
		
	}
}

