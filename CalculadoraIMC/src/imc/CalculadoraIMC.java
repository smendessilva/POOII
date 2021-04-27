package imc;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CalculadoraIMC extends JFrame {

	private JPanel contentPane;
	private JTextField txtPeso;
	private JTextField txtAltura;
	private JLabel lblResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculadoraIMC frame = new CalculadoraIMC();
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
	public CalculadoraIMC() {
		setTitle("Calculadora IMC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Digite seu Peso. Ex:100 ");
		lblNewLabel.setBounds(38, 11, 130, 14);
		contentPane.add(lblNewLabel);

		txtPeso = new JTextField();
		txtPeso.setBounds(203, 8, 140, 20);
		contentPane.add(txtPeso);
		txtPeso.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Digite sua Altura. Ex: 1.40");
		lblNewLabel_1.setBounds(38, 68, 130, 14);
		contentPane.add(lblNewLabel_1);

		txtAltura = new JTextField();
		txtAltura.setBounds(203, 65, 140, 20);
		contentPane.add(txtAltura);
		txtAltura.setColumns(10);

		JButton btnOk = new JButton("Calcular");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcularIMC();
			}
		});
		btnOk.setBounds(137, 139, 89, 23);
		contentPane.add(btnOk);

		lblResultado = new JLabel("RESULTADO");
		lblResultado.setBounds(101, 198, 323, 14);
		contentPane.add(lblResultado);
	}

	public void calcularIMC() {
		float peso = Float.parseFloat(txtPeso.getText());
		float altura = Float.parseFloat(txtAltura.getText());
		float imc = peso / (altura * altura);
		if (imc < 18.5) {
			lblResultado.setText("Você está abaixo do peso! IMC = " + Float.toString(imc));
		} else if (imc > 18.5 && imc < 24.9) {
			lblResultado.setText("Peso ideal (Parabens!) IMC = " + Float.toString(imc));
		} else if (imc > 25.0 && imc < 29.9) {
			lblResultado.setText("Levemente acima do peso. IMC = " + Float.toString(imc));
		} else if (imc > 30.0 && imc < 34.9) {
			lblResultado.setText("Obesidade grau I. IMC = " + Float.toString(imc));
		} else if (imc > 35.0 && imc < 39.9) {
			lblResultado.setText("Obesidade Grau II (Severa!) IMC = " + Float.toString(imc));
		} else if (imc > 40) {
			lblResultado.setText("Obesidade III (mórbida!) IMC = " + Float.toString(imc));
		} else {
			lblResultado.setText("Dados Inválidos!");

		}
		

	}
}
