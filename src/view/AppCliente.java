package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
//import java.util.Date;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JCheckBox;
//import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.jdatepicker.impl.JDatePickerImpl;

import model.Cliente;
import model.ClienteDAO;
import model.Endereco;
import model.EnderecoDAO;

import javax.swing.JPanel;
import java.awt.GridLayout;

public class AppCliente extends JFrame implements ActionListener {

	private JLabel lblNome, lblresddd, lblrestel, lblcelddd, lblceltel, lblrg, lblrgEmissor, lblTipoPfPj, lblemail,
			lbldataNasc, lblcomplemento, lbllogradouro, lblrecomendacaoNome, lblrecomendacaoDataNasc, lblCpf, lblCnpj;

	private JTextField txtNome, txtresddd, txtrestel, txtcelddd, txtceltel, txtrg, txtPfPj, txtemail, txtdataNasc,
			txtcomplemento, txtlogradouro, txtrecomendacaoNome, txtrecomendacaoDataNasc, txtrgEmissor, txtTipoPfPj,txtCpf,txtCnpj;

	private JDatePickerImpl dataNasci, recomendacaoDataNasci;
//	private JComboBox cboxrgEmissor, cboxTipoPfPj;
	private JCheckBox cboxPfPj;

	private JButton btnEnviar, btnLimpar, btnBuscacep;
	private JLabel lblEndereco;
	private JLabel lblEstado;
	private JLabel lblCidade;
	private JLabel lblBairro;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtUf;
	private JTextField txtCep;
	private String cepi;

	public AppCliente() {

		super("Cadastro de Clientes");// Titulo da janela JFrame, classe acima.
		// construtor vazio "super()", irá criar uma janela invisivel.
		setSize(450, 700); // Define a largura e altura da janela
		setLocation(550, 200); // Define a posiçãoo x e y da janela
		// setTitle("teste"); pode setar o titulo assim tb ou la em super como
		// foi feito
		// setLayout(new FlowLayout()); //está setando um layaut diferente do
		// padrão, o qual pula a linha qnd a janela acaba.
		getContentPane().setLayout(null); // sem layout

		lblNome = new JLabel("Nome: ");
		lblNome.setBounds(10, 10, 50, 20); // obrigatório utilizar x, y ,
											// largura, altura.
		txtNome = new JTextField(30);
		txtNome.setBounds(130, 10, 300, 20);
		lblresddd = new JLabel("DDD: ");
		lblresddd.setBounds(10, 35, 50, 20);
		txtresddd = new JTextField(30);
		txtresddd.setBounds(130, 35, 100, 20);
		lblrestel = new JLabel("Tel. resid�ncial: ");
		lblrestel.setBounds(10, 60, 200, 20);
		txtrestel = new JTextField(30);
		txtrestel.setBounds(130, 60, 200, 20);
		lblcelddd = new JLabel("DDD: ");
		lblcelddd.setBounds(10, 85, 50, 20);
		txtcelddd = new JTextField(30);
		txtcelddd.setBounds(130, 85, 100, 20);
		lblceltel = new JLabel("Tel. Celular: ");
		lblceltel.setBounds(10, 110, 100, 20);
		txtceltel = new JTextField(30);
		txtceltel.setBounds(130, 110, 200, 20);
		lblrg = new JLabel("RG: ");
		lblrg.setBounds(10, 135, 50, 20);
		txtrg = new JTextField(30);
		txtrg.setBounds(130, 135, 100, 20);
		lblrgEmissor = new JLabel("Emissor: ");
		lblrgEmissor.setBounds(230, 135, 60, 20);
		//String estados[] = { "DF", "BA", "GO", "MG" };
		txtrgEmissor = new JTextField(30);
		txtrgEmissor.setBounds(290, 135, 50, 20);

		//lblTipoPfPj = new JLabel("Tipo de DOC.:");
		//lblTipoPfPj.setBounds(10, 160, 80, 20);
		//String tipoDoc[] = { "CPF", "CNPJ" };
		//txtTipoPfPj = new JTextField(30);
		//txtTipoPfPj.setBounds(130, 160, 60, 20);
		//	txtPfPj = new JTextField(30);
		//	txtPfPj.setBounds(195, 160, 150, 20);
		
		cboxPfPj = new JCheckBox("Pessoa Jurídica?");
		cboxPfPj.setBounds(130, 160, 150, 20);
		cboxPfPj.addActionListener(this);
		
		lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(10,185,50,20);
		txtCpf = new JTextField(30);
		txtCpf.setBounds(130,185,200,20);
		
		lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setBounds(10, 210, 100, 20);
		txtCnpj = new JTextField(30);
		txtCnpj.setBounds(130, 210, 200, 20);
		txtCnpj.setVisible(false);
		
		lblemail = new JLabel("Email: ");
		lblemail.setBounds(10, 235, 100, 20);
		txtemail = new JTextField(30);
		txtemail.setBounds(130, 235, 300, 20);
		lbldataNasc = new JLabel("Data de Nasc.: ");
		lbldataNasc.setBounds(10, 260, 100, 20);
		
		/*
		txtdataNasc = new JTextField(30);
		txtdataNasc.setBounds(130, 260, 100, 20);
		*/
		// COLOCANDO O DATEPICKER DATANASC
		dataNasci = JulioDatePicker.criar(1980, true);
		dataNasci.setBounds(130, 260, 170, 20);
		
		lblcomplemento = new JLabel("Complemento: ");
		lblcomplemento.setBounds(10, 285, 100, 20);
		txtcomplemento = new JTextField(30);
		txtcomplemento.setBounds(130, 285, 100, 20);
		lbllogradouro = new JLabel("Logradouro");
		lbllogradouro.setBounds(10, 526, 100, 20);
		txtlogradouro = new JTextField(30);
		txtlogradouro.setEditable(false);
		txtlogradouro.setBounds(110, 527, 159, 20);
		
		lblrecomendacaoNome = new JLabel("Recomendação: ");
		lblrecomendacaoNome.setBounds(10, 335, 100, 20);
		txtrecomendacaoNome = new JTextField(30);
		txtrecomendacaoNome.setBounds(130, 335, 300, 20);
		lblrecomendacaoDataNasc = new JLabel("Data de Nasc.: ");
		lblrecomendacaoDataNasc.setBounds(10, 360, 100, 20);
		
		/*
		txtrecomendacaoDataNasc = new JTextField(30);
		txtrecomendacaoDataNasc.setBounds(130, 360, 70, 20);
		*/
		// COLOCANDO O DATEPICKER RECOMENDACAODATANASC
		recomendacaoDataNasci = JulioDatePicker.criar(2000, false);
		recomendacaoDataNasci.setBounds(130, 360, 170, 20);

		btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(10, 385, 80, 20);
		btnEnviar.addActionListener(this);
		btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(90, 385, 80, 20);
		btnLimpar.addActionListener(this);

		// essa � a ordem que se insere os componentes.
		getContentPane().add(lblNome);
		getContentPane().add(txtNome);
		getContentPane().add(lblresddd);
		getContentPane().add(txtresddd);
		getContentPane().add(lblrestel);
		getContentPane().add(txtrestel);
		getContentPane().add(lblcelddd);
		getContentPane().add(txtcelddd);
		getContentPane().add(lblceltel);
		getContentPane().add(txtceltel);
		getContentPane().add(lblrg);
		getContentPane().add(txtrg);
		getContentPane().add(lblrgEmissor);
		getContentPane().add(txtrgEmissor);
		
		//Escolhendo o tipo
		//add(lblTipoPfPj);
		//add(txtTipoPfPj);
		
		getContentPane().add(cboxPfPj);
		
		getContentPane().add(lblCpf);
		getContentPane().add(txtCpf);
		getContentPane().add(lblCnpj);
		getContentPane().add(txtCnpj);
		//		add(txtPfPj);
		getContentPane().add(lblemail);
		getContentPane().add(txtemail);
		getContentPane().add(lbldataNasc);
		getContentPane().add(dataNasci); // add(txtdataNasc);
		getContentPane().add(lblcomplemento);
		getContentPane().add(txtcomplemento);
		getContentPane().add(lbllogradouro);
		getContentPane().add(txtlogradouro);
		getContentPane().add(lblrecomendacaoNome);
		getContentPane().add(txtrecomendacaoNome);
		getContentPane().add(lblrecomendacaoDataNasc);
		getContentPane().add(recomendacaoDataNasci); //add(txtrecomendacaoDataNasc);
		getContentPane().add(btnEnviar);
		getContentPane().add(btnLimpar);
		
		lblEndereco = new JLabel("Endereço");
		lblEndereco.setBounds(10, 434, 70, 15);
		getContentPane().add(lblEndereco);
		
		lblEstado = new JLabel("Estado");
		lblEstado.setBounds(10, 461, 70, 15);
		getContentPane().add(lblEstado);
		
		lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(10, 483, 70, 15);
		getContentPane().add(lblCidade);
		
		lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(10, 507, 70, 15);
		getContentPane().add(lblBairro);
		
		txtBairro = new JTextField();
		txtBairro.setEditable(false);
		txtBairro.setBounds(110, 505, 159, 19);
		getContentPane().add(txtBairro);
		txtBairro.setColumns(10);
		
		txtCidade = new JTextField();
		txtCidade.setEditable(false);
		txtCidade.setBounds(110, 481, 159, 19);
		getContentPane().add(txtCidade);
		txtCidade.setColumns(10);
		
		txtUf = new JTextField();
		txtUf.setEditable(false);
		txtUf.setBounds(110, 459, 159, 19);
		getContentPane().add(txtUf);
		txtUf.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setBounds(10, 558, 70, 15);
		getContentPane().add(lblCep);
		
		txtCep = new JTextField();
		txtCep.setBounds(110, 556, 114, 19);
		getContentPane().add(txtCep);
		txtCep.setColumns(10);
		
		btnBuscacep = new JButton("Busca CEP");
		btnBuscacep.setBounds(10, 595, 117, 25);
		btnBuscacep.addActionListener(this);
		getContentPane().add(btnBuscacep);

		setVisible(true);

	}

	public static void main(String[] args) {
		AppCliente appcliente = new AppCliente();

	} 

	@Override
	public void actionPerformed(ActionEvent clique) {
		// TODO Auto-generated method stub

		if (btnEnviar == clique.getSource()) { 
			/*JOptionPane.showMessageDialog(null, "Dados teste:"
					+ "\ndata: " + dataNasc.getJFormattedTextField().getText()
					+ "\nboolean: " + cboxPfPj.isSelected()
					+ ""); */
						
			Cliente objCliente = new Cliente();
			objCliente.setNome(txtNome.getText());
			objCliente.setResddd(Integer.parseInt(txtresddd.getText()));
			objCliente.setRestel(Integer.parseInt(txtrestel.getText()));
			objCliente.setCelddd(Integer.parseInt(txtcelddd.getText()));
			objCliente.setCeltel(Integer.parseInt(txtceltel.getText()));
			objCliente.setPfpj(cboxPfPj.isSelected());
			
			if(cboxPfPj.isSelected()){
				objCliente.setCnpj(Integer.parseInt(txtCnpj.getText()));
			} else {
				objCliente.setRg(Integer.parseInt(txtrg.getText()));
				objCliente.setRgemissor(txtrgEmissor.getText());
				objCliente.setCpf(Integer.parseInt(txtCpf.getText()));
			}
			objCliente.setEmail(txtemail.getText());
			objCliente.setDataNasc(LocalDate.parse(dataNasci.getJFormattedTextField().getText()));
			objCliente.setComplemento(txtcomplemento.getText());
			objCliente.setIdlogradouro(Integer.parseInt(txtlogradouro.getText()));
			objCliente.setRecomendacaonome(txtrecomendacaoNome.getText());
			if(recomendacaoDataNasci.getJFormattedTextField().getValue() != null) {
			objCliente.setRecomendacaodatanasc(LocalDate.parse(recomendacaoDataNasci.getJFormattedTextField().getText()));
			}
			try {
				ClienteDAO dao = new ClienteDAO();
				dao.inserir(objCliente);
				JOptionPane.showMessageDialog(null, "Gravado");

			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e);
			}
		
		} 
		else if (btnLimpar == clique.getSource()){
			txtNome.setText("");
			txtresddd.setText("");
			txtrestel.setText("");
			txtcelddd.setText("");
			txtceltel.setText("");
			txtrg.setText("");
			txtrgEmissor.setText("");
			txtTipoPfPj.setText("");
			txtCpf.setText("");
			txtCnpj.setText("");
			txtemail.setText("");
			txtdataNasc.setText("");
			txtcomplemento.setText("");
			txtlogradouro.setText("");
			txtrecomendacaoNome.setText("");
			txtrecomendacaoDataNasc.setText("");
			
		}
		else if (cboxPfPj == clique.getSource()) {
			if(cboxPfPj.isSelected()) {
				txtCpf.setVisible(false);
				txtrg.setVisible(false);
				txtrgEmissor.setVisible(false);
				txtCnpj.setVisible(true);
			} else {
				txtCpf.setVisible(true);
				txtrg.setVisible(true);
				txtrgEmissor.setVisible(true);
				txtCnpj.setVisible(false);
			}
		}
		else if (btnBuscacep == clique.getSource()) {
			try {
				cepi = txtCep.getText();
				EnderecoDAO dao = new EnderecoDAO();
				Endereco endereco;
				endereco = dao.buscarEndereco(Integer.parseInt(cepi));
				txtUf.setText(endereco.getUf());
				txtCidade.setText(endereco.getCidade());
				txtBairro.setText(endereco.getBairro());
				txtlogradouro.setText(endereco.getLogradouro().getNome());
				//JOptionPane.showMessageDialog(null, endereco.getLogradouro().getNome());
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
			
		

	}
}