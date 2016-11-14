package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
//import java.util.Date;

import javax.swing.JButton;
//import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Cliente;
import model.ClienteDAO;

public class AppCliente extends JFrame implements ActionListener {

	private JLabel lblNome, lblresddd, lblrestel, lblcelddd, lblceltel, lblrg, lblrgEmissor, lblTipoPfPj, lblemail,
			lbldataNasc, lblcomplemento, lbllogradouro, lblrecomendacaoNome, lblrecomendacaoDataNasc, lblCpf, lblCnpj;

	private JTextField txtNome, txtresddd, txtrestel, txtcelddd, txtceltel, txtrg, txtPfPj, txtemail, txtdataNasc,
			txtcomplemento, txtlogradouro, txtrecomendacaoNome, txtrecomendacaoDataNasc, txtrgEmissor, txtTipoPfPj,txtCpf,txtCnpj;

//	private JComboBox cboxrgEmissor, cboxTipoPfPj;

	private JButton btnEnviar, btnLimpar;

	public AppCliente() {

		super("Cadastro de Clientes");// Titulo da janela JFrame, classe acima.
		// construtor vazio "super()", ir� criar uma janela invisivel.
		setSize(450, 500); // Define a largura e altura da janela
		setLocation(550, 200); // Define a posi��o x e y da janela
		// setTitle("teste"); pode setar o titulo assim tb ou la em super como
		// foi feito
		// setLayout(new FlowLayout()); //est� setando um layaut diferente do
		// padr�o, o qual pula a linha qnd a janela acaba.
		setLayout(null); // sem layout

		lblNome = new JLabel("Nome: ");
		lblNome.setBounds(10, 10, 50, 20); // obrigat�rio utilizar x, y ,
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

		lblTipoPfPj = new JLabel("Tipo de DOC.:");
		lblTipoPfPj.setBounds(10, 160, 80, 20);
		//String tipoDoc[] = { "CPF", "CNPJ" };
		txtTipoPfPj = new JTextField(30);
		txtTipoPfPj.setBounds(130, 160, 60, 20);
		//	txtPfPj = new JTextField(30);
		//	txtPfPj.setBounds(195, 160, 150, 20);
		
		lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(10,185,50,20);
		txtCpf = new JTextField(30);
		txtCpf.setBounds(130,185,200,20);
		lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setBounds(10, 210, 100, 20);
		txtCnpj = new JTextField(30);
		txtCnpj.setBounds(130, 210, 200, 20);
		
		lblemail = new JLabel("Email: ");
		lblemail.setBounds(10, 235, 100, 20);
		txtemail = new JTextField(30);
		txtemail.setBounds(130, 235, 300, 20);
		lbldataNasc = new JLabel("Data de Nasc.: ");
		lbldataNasc.setBounds(10, 260, 100, 20);
		txtdataNasc = new JTextField(30);
		txtdataNasc.setBounds(130, 260, 100, 20);
		
		lblcomplemento = new JLabel("Complemento: ");
		lblcomplemento.setBounds(10, 285, 100, 20);
		txtcomplemento = new JTextField(30);
		txtcomplemento.setBounds(130, 285, 100, 20);
		lbllogradouro = new JLabel("Logradouro: ");
		lbllogradouro.setBounds(10, 310, 100, 20);
		txtlogradouro = new JTextField(30);
		txtlogradouro.setBounds(130, 310, 100, 20);
		
		lblrecomendacaoNome = new JLabel("Recomenda��o: ");
		lblrecomendacaoNome.setBounds(10, 335, 100, 20);
		txtrecomendacaoNome = new JTextField(30);
		txtrecomendacaoNome.setBounds(130, 335, 300, 20);
		lblrecomendacaoDataNasc = new JLabel("Data de Nasc.: ");
		lblrecomendacaoDataNasc.setBounds(10, 360, 100, 20);
		txtrecomendacaoDataNasc = new JTextField(30);
		txtrecomendacaoDataNasc.setBounds(130, 360, 70, 20);

		btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(10, 385, 80, 20);
		btnEnviar.addActionListener(this);
		btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(90, 385, 80, 20);
		btnLimpar.addActionListener(this);

		// essa � a ordem que se insere os componentes.
		add(lblNome);
		add(txtNome);
		add(lblresddd);
		add(txtresddd);
		add(lblrestel);
		add(txtrestel);
		add(lblcelddd);
		add(txtcelddd);
		add(lblceltel);
		add(txtceltel);
		add(lblrg);
		add(txtrg);
		add(lblrgEmissor);
		add(txtrgEmissor);
		add(lblTipoPfPj);
		add(txtTipoPfPj);
		add(lblCpf);
		add(txtCpf);
		add(lblCnpj);
		add(txtCnpj);
		//		add(txtPfPj);
		add(lblemail);
		add(txtemail);
		add(lbldataNasc);
		add(txtdataNasc);
		add(lblcomplemento);
		add(txtcomplemento);
		add(lbllogradouro);
		add(txtlogradouro);
		add(lblrecomendacaoNome);
		add(txtrecomendacaoNome);
		add(lblrecomendacaoDataNasc);
		add(txtrecomendacaoDataNasc);
		add(btnEnviar);
		add(btnLimpar);

		setVisible(true);

	}

	public static void main(String[] args) {
		AppCliente appcliente = new AppCliente();

	}

	@Override
	public void actionPerformed(ActionEvent clique) {
		// TODO Auto-generated method stub

		if (btnEnviar == clique.getSource()) {
			Cliente objCliente = new Cliente();
			objCliente.setNome(txtNome.getText());
			objCliente.setResddd(Integer.parseInt(txtresddd.getText()));
			objCliente.setRestel(Integer.parseInt(txtrestel.getText()));
			objCliente.setCelddd(Integer.parseInt(txtcelddd.getText()));
			objCliente.setCeltel(Integer.parseInt(txtceltel.getText()));
			objCliente.setRg(Integer.parseInt(txtrg.getText()));
			objCliente.setRgemissor(txtrgEmissor.getText());
		  //objCliente.setPfpj(Boolean.parseBoolean(txtPfPj.getText()));
			if (txtTipoPfPj.getText() == "cpf"){
				txtCnpj.setText(null);
				objCliente.setCpf(Integer.parseInt(txtCpf.getText()));
				objCliente.setPfpj(Boolean.parseBoolean(null));
			}
			else if(txtTipoPfPj.getText() == "cnpj"){
				txtCpf.setText(null);
				objCliente.setCnpj(Integer.parseInt(txtPfPj.getText()));
				objCliente.setPfpj(Boolean.parseBoolean(null));
			}
			objCliente.setEmail(txtemail.getText());
			objCliente.setDataNasc(txtdataNasc.getText());
			objCliente.setComplemento(txtcomplemento.getText());
			objCliente.setIdlogradouro(Integer.parseInt(txtlogradouro.getText()));
			objCliente.setRecomendacaonome(txtrecomendacaoNome.getText());
			objCliente.setRecomendacaodatanasc(txtrecomendacaoDataNasc.getText());

			try {
				ClienteDAO dao = new ClienteDAO();
				dao.inserir(objCliente);
				JOptionPane.showMessageDialog(null, "Gravado");

			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro");
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
		
			
		

	}
}