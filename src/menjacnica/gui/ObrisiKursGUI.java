package menjacnica.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class ObrisiKursGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldSifra;
	private JTextField textFieldNaziv;
	private JLabel lblKupovniKurs;
	private JTextField textFieldProdajniKurs;
	private JTextField textFieldKupovniKurs;
	private JLabel lblSrednjiKurs;
	private JLabel lblSkraceniNaziv;
	private JTextField textFieldSrednjiKurs;
	private JTextField textFieldSkraceniNaziv;

	/**
	 * Create the frame.
	 */
	public ObrisiKursGUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setTitle("Obrisi kurs");
		setBounds(100, 100, 429, 313);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		setLocationRelativeTo(null);

		final JButton btnObrisi = new JButton("Obrisi");
		btnObrisi.setEnabled(false);
		btnObrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int sifra = Integer.parseInt(textFieldSifra.getText());
					String naziv = textFieldNaziv.getText();
					double prodajniKurs = Double.parseDouble(textFieldProdajniKurs.getText());
					double kupovniKurs = Double.parseDouble(textFieldKupovniKurs.getText());
					double srednjiKurs = Double.parseDouble(textFieldSrednjiKurs.getText());
					String skraceniNaziv = textFieldSkraceniNaziv.getText();

					String noviKurs = "Obrisan je kurs - Sifra: " + sifra + "; Naziv: " + naziv + "; Prodajni kurs: " + prodajniKurs 
							+ "; Kupovni kurs: " + kupovniKurs + "; Srednji kurs: " + srednjiKurs
							+ "; Skraceni naziv: " + skraceniNaziv + "\n";

					MenjacnicaGUI.setZaStatus(MenjacnicaGUI.getZaStatus() + noviKurs);
					MenjacnicaGUI.setTextAreaStatus(MenjacnicaGUI.getZaStatus());

					dispose();
				} catch (Exception exc) {
					JOptionPane.showMessageDialog(contentPane,
							"Morate popuniti sva trazena polja.\nU polja za kurseve i sifru morate uneti brojeve.", 
							"Greska", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnObrisi.setBounds(20, 243, 180, 23);
		contentPane.add(btnObrisi);

		final JCheckBox chckbxZaistaObrisiKurs = new JCheckBox("Zaista obrisi kurs");
		chckbxZaistaObrisiKurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxZaistaObrisiKurs.isSelected()) {
					btnObrisi.setEnabled(true);
				} else {
					btnObrisi.setEnabled(false);
				}
			}
		});

		chckbxZaistaObrisiKurs.setBounds(20, 213, 180, 23);
		contentPane.add(chckbxZaistaObrisiKurs);

		JLabel lblSifra = new JLabel("Sifra");
		lblSifra.setBounds(20, 21, 180, 14);
		contentPane.add(lblSifra);

		JLabel lblNaziv = new JLabel("Naziv");
		lblNaziv.setBounds(223, 21, 180, 14);
		contentPane.add(lblNaziv);

		textFieldSifra = new JTextField();
		textFieldSifra.setBounds(20, 46, 180, 20);
		contentPane.add(textFieldSifra);
		textFieldSifra.setColumns(10);

		textFieldNaziv = new JTextField();
		textFieldNaziv.setBounds(223, 46, 180, 20);
		contentPane.add(textFieldNaziv);
		textFieldNaziv.setColumns(10);

		JLabel lblProdajniKurs = new JLabel("Prodajni kurs");
		lblProdajniKurs.setBounds(20, 90, 180, 14);
		contentPane.add(lblProdajniKurs);

		lblKupovniKurs = new JLabel("Kupovni kurs");
		lblKupovniKurs.setBounds(223, 90, 180, 14);
		contentPane.add(lblKupovniKurs);

		textFieldProdajniKurs = new JTextField();
		textFieldProdajniKurs.setBounds(20, 115, 180, 20);
		contentPane.add(textFieldProdajniKurs);
		textFieldProdajniKurs.setColumns(10);

		textFieldKupovniKurs = new JTextField();
		textFieldKupovniKurs.setBounds(223, 115, 180, 20);
		contentPane.add(textFieldKupovniKurs);
		textFieldKupovniKurs.setColumns(10);

		lblSrednjiKurs = new JLabel("Srednji kurs");
		lblSrednjiKurs.setBounds(20, 162, 180, 14);
		contentPane.add(lblSrednjiKurs);

		lblSkraceniNaziv = new JLabel("Skraceni naziv");
		lblSkraceniNaziv.setBounds(223, 162, 180, 14);
		contentPane.add(lblSkraceniNaziv);

		textFieldSrednjiKurs = new JTextField();
		textFieldSrednjiKurs.setBounds(20, 187, 180, 20);
		contentPane.add(textFieldSrednjiKurs);
		textFieldSrednjiKurs.setColumns(10);

		textFieldSkraceniNaziv = new JTextField();
		textFieldSkraceniNaziv.setBounds(223, 187, 180, 20);
		contentPane.add(textFieldSkraceniNaziv);
		textFieldSkraceniNaziv.setColumns(10);

		JButton btnOdustani = new JButton("Odustani");
		btnOdustani.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnOdustani.setBounds(223, 243, 180, 23);
		contentPane.add(btnOdustani);
	}
}
