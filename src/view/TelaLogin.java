package view;

import controller.SugarConnection;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class TelaLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfUsuario;
	private JPasswordField pfSenha;
	private JButton btnLogar;
	private JButton btnSair;
	private JLabel lblUsuario;
	private JLabel lblSenha;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame frame = new TelaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaLogin() {
		
		
		KeyListener kl = new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				loginKeyPressed(e);
			}
			
		};
		
		addKeyListener(kl);

		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblUsuario = new JLabel("Usu\u00E1rio:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsuario.setBounds(39, 31, 53, 21);
		contentPane.add(lblUsuario);

		tfUsuario = new JTextField();
		tfUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tfUsuario.setBounds(39, 52, 156, 21);
		contentPane.add(tfUsuario);
		tfUsuario.setColumns(10);
		tfUsuario.addKeyListener(kl);

		lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSenha.setBounds(39, 84, 45, 21);
		contentPane.add(lblSenha);

		pfSenha = new JPasswordField();
		pfSenha.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pfSenha.setBounds(39, 105, 156, 21);
		contentPane.add(pfSenha);
		pfSenha.addKeyListener(kl);

		btnLogar = new JButton("Logar");
		btnLogar.setBounds(69, 162, 89, 34);
		btnLogar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				proximaTela();

			}
		});
		contentPane.add(btnLogar);

		btnSair = new JButton("Sair");
		btnSair.setBounds(69, 207, 89, 23);
		contentPane.add(btnSair);
		btnSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});

	}

	private void loginKeyPressed(KeyEvent evt) {
		if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
			proximaTela();
		} else if(evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
			this.dispose();
		}
	}

	private void proximaTela() {
		String usuario = tfUsuario.getText();
		String senha = new String(pfSenha.getPassword());

		if (!usuario.isEmpty() && !senha.isEmpty()) {

			if (SugarConnection.SugarLogin(usuario, senha)) {
				JFrame tela = new TelaPrincipal();
				tela.setVisible(true);
				dispose();
			}
		}
	}
	
	
}
