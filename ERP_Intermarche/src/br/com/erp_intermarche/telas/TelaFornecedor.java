package br.com.erp_intermarche.telas;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TelaFornecedor extends JFrame {

	private JPanel contentPane;
	private JTextField textForNome;
	private JTextField textForEndereco;
	private JTextField textForemail;
	private JTextField textForTelefone;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JPanel panel;
	private JTextField textField;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaFornecedor frame = new TelaFornecedor();
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
	public TelaFornecedor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 844, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		ImageIcon icon1 = new ImageIcon(TelaFornecedor.class.getResource("/br/com/erp_intermarche/icones/add.png"));
		Image imagem = icon1.getImage();
		Image imagemRedimensionada = imagem.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon iconRedimensionado = new ImageIcon(imagemRedimensionada);

		ImageIcon icon2 = new ImageIcon(TelaFornecedor.class.getResource("/br/com/erp_intermarche/icones/edit.png"));
		Image imagem2 = icon2.getImage();
		Image imagemRedimensionada2 = imagem2.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon iconRedimensionado2 = new ImageIcon(imagemRedimensionada2);

		ImageIcon icon3 = new ImageIcon(TelaFornecedor.class.getResource("/br/com/erp_intermarche/icones/delete.png"));
		Image imagem3 = icon3.getImage();
		Image imagemRedimensionada3 = imagem3.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon iconRedimensionado3 = new ImageIcon(imagemRedimensionada3);

		JLabel lblForNome = new JLabel("* Nome");

		textForNome = new JTextField();
		textForNome.setHorizontalAlignment(SwingConstants.LEFT);
		textForNome.setColumns(10);

		JLabel lblForEndereco = new JLabel("* Endereço");

		textForEndereco = new JTextField();
		textForEndereco.setHorizontalAlignment(SwingConstants.LEFT);
		textForEndereco.setColumns(10);

		JLabel lblForEmail = new JLabel("* e-mail");

		textForemail = new JTextField();
		textForemail.setHorizontalAlignment(SwingConstants.LEFT);
		textForemail.setColumns(10);

		JLabel lblForTelefone = new JLabel("* Telefone");

		textForTelefone = new JTextField();
		textForTelefone.setHorizontalAlignment(SwingConstants.LEFT);
		textForTelefone.setColumns(10);

		panel = new JPanel();
		btnNewButton = new JButton(iconRedimensionado);
		btnNewButton_1 = new JButton(iconRedimensionado2);
		btnNewButton_2 = new JButton(iconRedimensionado3);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(120).addComponent(btnNewButton).addGap(100)
						.addComponent(btnNewButton_1).addGap(100).addComponent(btnNewButton_2)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(
				gl_panel.createSequentialGroup().addGap(5).addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton).addComponent(btnNewButton_1).addComponent(btnNewButton_2))));
		panel.setLayout(gl_panel);

		textField = new JTextField();
		textField.setColumns(10);

		lblNewLabel = new JLabel("* Campos obrigatórios");

		ImageIcon icon4 = new ImageIcon(
				TelaFornecedor.class.getResource("/br/com/erp_intermarche/icones/search detail.png"));
		Image imagem4 = icon4.getImage();
		Image imagemRedimensionada4 = imagem4.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		ImageIcon iconRedimensionado4 = new ImageIcon(imagemRedimensionada4);
		lblNewLabel_1 = new JLabel(iconRedimensionado4);

		table = new JTable();

		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, },
				new String[] { "New column", "New column", "New column", "New column" }));

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup().addGap(48).addGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup().addGroup(gl_contentPane
								.createParallelGroup(Alignment.LEADING).addComponent(lblForEndereco)
								.addComponent(lblForNome, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblForEmail, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblForTelefone)).addGap(18).addGroup(
										gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(textField, GroupLayout.PREFERRED_SIZE, 322,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addComponent(lblNewLabel_1)
														.addPreferredGap(ComponentPlacement.RELATED, 161,
																Short.MAX_VALUE)
														.addComponent(lblNewLabel))
												.addComponent(
														textForTelefone, GroupLayout.PREFERRED_SIZE, 158,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(table, GroupLayout.PREFERRED_SIZE, 1,
														GroupLayout.PREFERRED_SIZE)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
														.addComponent(textForEndereco, Alignment.LEADING)
														.addComponent(textForemail, Alignment.LEADING,
																GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
														.addComponent(textForNome, Alignment.LEADING,
																GroupLayout.PREFERRED_SIZE, 316,
																GroupLayout.PREFERRED_SIZE)))))
						.addGap(27))
				.addGroup(Alignment.TRAILING,
						gl_contentPane.createSequentialGroup().addContainerGap(121, Short.MAX_VALUE)
								.addComponent(table_1, GroupLayout.PREFERRED_SIZE, 689, GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(17)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel))
								.addComponent(lblNewLabel_1))
						.addGap(33).addComponent(table, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(table_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblForNome)
								.addComponent(textForNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(5)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblForEndereco)
								.addComponent(textForEndereco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(5)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblForEmail)
								.addComponent(textForemail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(5)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblForTelefone)
								.addComponent(textForTelefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(16).addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)));
		contentPane.setLayout(gl_contentPane);

	}
}
