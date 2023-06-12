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
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.sql.*;
import br.com.erp_intermarche.dal.ModuloConexao;




public class TelaUsuario extends JFrame {
	 private JComboBox<String> cboPerfil; 
	 private JComboBox<String> cboPerfil_1;
	
	// conexao é a variavel que eu criei na minha Classe ModuloConexao
	Connection conexao = null;
	
	// A linha abaixo prepara o código para receber comandos SQL
	PreparedStatement pst = null;
	
	// A linha abaixo exibe o resultado das intruções SQL
	ResultSet rs = null;
	
	private JPanel contentPane;
	private JTextField textUsuNome;
	private JTextField textSenha;
	private JTextField textEmail;
	private JTextField textUsuId;
	
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
		cboPerfil = new JComboBox<String>();
		// A linha abaixo chama o metodo conector
		conexao = ModuloConexao.conector();
			
		setResizable(false);
		setTitle("Usuários");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaUsuario.class.getResource("/br/com/erp_intermarche/icones/Imagem2.jpg")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 920, 556);
		ImageIcon icon = new ImageIcon(TelaUsuario.class.getResource("/br/com/erp_intermarche/icones/home.png"));
		Image image = icon.getImage(); // Obtém a imagem do ícone
		Image newImage = image.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		
		
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
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(15);
		flowLayout.setHgap(10);
		JButton btnUsuCreate = new JButton("");
		btnUsuCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionar();				
			}
		});
		panel.add(btnUsuCreate);
		btnUsuCreate.setIcon(iconRedimensionado);
		JButton btnUsuRead = new JButton("");
		btnUsuRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textUsuId.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Insira um valor no campo ID para visualizar os dados do usuário");
				} else {
					consultar();
				}																
			}
		});
		panel.add(btnUsuRead);
		btnUsuRead.setIcon(iconRedimensionado2);
		JButton btnUsuUpdate = new JButton("");
		btnUsuUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterar();
		}
		});
		panel.add(btnUsuUpdate);
		btnUsuUpdate.setIcon(iconRedimensionado3);
		JButton btnUsuDelete = new JButton("");
		btnUsuDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remover();
		}
		});
		panel.add(btnUsuDelete);
		btnUsuDelete.setIcon(iconRedimensionado4);
		
		JLabel lblTitle = new JLabel("Editar Cadastro de Usuários");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 16));
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		
		JLabel lblPerfil = new JLabel("Perfil");
		lblPerfil.setBounds(79, 154, 34, 18);
		panel_1.add(lblPerfil);
		lblPerfil.setFont(new Font("Segoe UI", Font.BOLD, 13));
		
		cboPerfil_1 = new JComboBox();
		cboPerfil_1.setBounds(209, 152, 61, 22);
		panel_1.add(cboPerfil_1);
		cboPerfil_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		cboPerfil_1.setModel(new DefaultComboBoxModel(new String[] {"user", "admin"}));
		
		textSenha = new JTextField();
		textSenha.setBounds(209, 123, 244, 22);
		panel_1.add(textSenha);
		textSenha.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		textSenha.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(79, 125, 161, 18);
		panel_1.add(lblSenha);
		lblSenha.setFont(new Font("Segoe UI", Font.BOLD, 13));
		
		textEmail = new JTextField();
		textEmail.setBounds(209, 90, 548, 22);
		panel_1.add(textEmail);
		textEmail.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		textEmail.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(79, 92, 117, 18);
		panel_1.add(lblEmail);
		lblEmail.setFont(new Font("Segoe UI", Font.BOLD, 13));
		
		textUsuNome = new JTextField();
		textUsuNome.setBounds(209, 63, 548, 22);
		panel_1.add(textUsuNome);
		textUsuNome.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		textUsuNome.setColumns(10);
		
		JLabel lblNomeCompleto = new JLabel("Nome completo");
		lblNomeCompleto.setBounds(79, 63, 129, 18);
		panel_1.add(lblNomeCompleto);
		lblNomeCompleto.setFont(new Font("Segoe UI", Font.BOLD, 13));
		
		textUsuId = new JTextField();
		textUsuId.setBounds(209, 34, 61, 20);
		panel_1.add(textUsuId);
		textUsuId.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(79, 36, 27, 14);
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 13));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(80)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 776, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(80)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 776, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(323)
							.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(50, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(31)
					.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(119, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_2 = new JLabel("*");
		lblNewLabel_2.setBounds(198, 65, 19, 14);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("*");
		lblNewLabel_3.setBounds(198, 95, 25, 14);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("*");
		lblNewLabel_4.setBounds(198, 128, 34, 14);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("*");
		lblNewLabel_5.setBounds(198, 157, 37, 14);
		panel_1.add(lblNewLabel_5);
		
		
		ImageIcon icon6 = (new ImageIcon(TelaUsuario.class.getResource("/br/com/erp_intermarche/icones/clean.png")));
		Image imagem6 = icon6.getImage();
		Image imagemRedimensionada6 = imagem6.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		ImageIcon iconRedimensionado6 = new ImageIcon(imagemRedimensionada6);
		
		
		JButton btnLimpar = new JButton("");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();	
			}
		});
		btnLimpar.setHorizontalAlignment(SwingConstants.LEFT);
		btnLimpar.setBounds(723, 30, 34, 22);
		panel_1.add(btnLimpar);
		getContentPane().setLayout(groupLayout);
		btnLimpar.setIcon(iconRedimensionado6);														
		btnLimpar.setHorizontalAlignment(SwingConstants.CENTER);
		
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
	// Metodo para consultar usuários no banco de dados
	private void consultar() {
	    String sql = "select * from usuarios_senhas where id_usuarios=?";
	    try {
	        pst = conexao.prepareStatement(sql);
	        int idUsuario = Integer.parseInt(textUsuId.getText());
	        pst.setInt(1, idUsuario);
	        rs = pst.executeQuery();
	        if (rs.next()) {
	            textUsuNome.setText(rs.getString(5));
	            textEmail.setText(rs.getString(1));
	            textSenha.setText(rs.getString(2));            	                   
	            cboPerfil_1.setSelectedItem(rs.getString(3));
	            
	        } else {
	        	JOptionPane.showMessageDialog(null,"Usuário não cadastrado");
	        	// As linhas abaixo limpam os campos 
	        	textUsuNome.setText(null);
	        	textEmail.setText(null);
	            textSenha.setText(null);            	                   
	            cboPerfil_1.setSelectedItem(null);
	        }
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(null, e);
	    }
	}
	
	private void limparCampos() {
		// Limpar os campos após a atualização
		textUsuId.setText(null);
        textUsuNome.setText(null);
        textEmail.setText(null);
        textSenha.setText(null);
        cboPerfil_1.setSelectedItem(null);
	}
	
	
	//Metodo para adicionar usuários
	private void adicionar () {
		String sql = "insert into usuarios_senhas(email,senhas,perfil,nome_completo) values(?,?,?,?)";
		try {
			pst=conexao.prepareStatement(sql);
			pst.setString(1,textEmail.getText());
			pst.setString(2,textSenha.getText());
			pst.setString(3,cboPerfil_1.getSelectedItem().toString());
			pst.setString(4,textUsuNome.getText());
	//Validação dos campos obrigatórios
	// se txtUsuId estiver vazio e textUsuNome for diferente de vazio .... 
			if (textUsuId.getText().isEmpty() && !textUsuNome.getText().isEmpty() && !textEmail.getText().isEmpty() && !textSenha.getText().isEmpty() && cboPerfil_1.getSelectedItem()!= null) {
							
	//A linha abaixo atualiza a tabela usuario com os dados do formulário
	//A estrutura abaixo é usada para confirmar a inserção dos dados na tabela
			int adicionado = pst.executeUpdate();
			if(adicionado>0) {
				JOptionPane.showMessageDialog(null,"Usário adicionado com sucesso");
			}
			
	// As linhas abaixo limpam os campos 		
			textUsuNome.setText(null);
        	textEmail.setText(null);
            textSenha.setText(null);            	                   
            cboPerfil_1.getSelectedItem().toString();
			}
			else {
				JOptionPane.showMessageDialog(null, "Para cadastrar um usuário o campo ID tem que estar vazio e todos os outros campos marcados com * tem que estar preenchidos");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}		
	}
	
	//Criando o método para alterar dados do usuário
	private void alterar() {
	    String sql = "update usuarios_senhas set email=?, senhas=?, perfil=?, nome_completo=? where id_usuarios=?";
	    try {
	        pst = conexao.prepareStatement(sql);
	        pst.setString(1, textEmail.getText());
	        pst.setString(2, textSenha.getText());
	        pst.setString(3, cboPerfil_1.getSelectedItem().toString());
	        pst.setString(4, textUsuNome.getText());
	        pst.setString(5, textUsuId.getText());
	        
	     // Converter o valor de textUsuId para um valor numérico
	        int idUsuarios = Integer.parseInt(textUsuId.getText());
	        pst.setInt(5, idUsuarios);
	        
	        if (!textUsuId.getText().isEmpty() && !textUsuNome.getText().isEmpty() && !textEmail.getText().isEmpty() && !textSenha.getText().isEmpty() && cboPerfil_1.getSelectedItem() != null) {
	            int adicionado = pst.executeUpdate();
	            if (adicionado > 0) {
	                JOptionPane.showMessageDialog(null, "Dados do usuário alterados com sucesso");
	            }

	            // Limpar os campos após a atualização
	            textUsuNome.setText(null);
	            textEmail.setText(null);
	            textSenha.setText(null);
	            cboPerfil_1.setSelectedItem(null);
	        } else {
	            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios *");
	        }
	    }
	      catch (NumberFormatException e) {
	            JOptionPane.showMessageDialog(null, "O campo ID não pode estar vazio e deve ser um valor numérico.");
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(null, e);
	    }
	}
	
	// Método responsável pela remoção de usuários
	private void remover() {
		//a estrutura abaixo confirma a remoção do usuário
		int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este usuário ?","Atenção",JOptionPane.YES_NO_OPTION);
		if(confirma == JOptionPane.YES_OPTION) {
			String sql = "delete from usuarios_senhas where id_usuarios=?";
			try {
				
				pst = conexao.prepareStatement(sql);
				pst.setString(1,textUsuId.getText());
				// Converter o valor de textUsuId para um valor numérico
		        int idUsuarios = Integer.parseInt(textUsuId.getText());
		        pst.setInt(1, idUsuarios);
				int apagado = pst.executeUpdate();
				if(apagado>0) {
					JOptionPane.showMessageDialog(null,"Usuário removido com sucesso !");
				// Limpar os campos após a atualização
					textUsuId.setText(null);
		            textUsuNome.setText(null);
		            textEmail.setText(null);
		            textSenha.setText(null);
		            cboPerfil_1.setSelectedItem(null);					
				}				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}
	}
	
	
}
