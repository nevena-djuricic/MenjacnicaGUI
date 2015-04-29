package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JSlider;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class IzvrsiZamenuGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldKupovniKurs;
	private JTextField textFieldProdajniKurs;
	private JTextField textFieldIznos;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	JSlider slider = new JSlider();
	JComboBox comboBoxValuta = new JComboBox();
	JRadioButton rdbtnKupovina = new JRadioButton("Kupovina");

	/**
	 * Create the frame.
	 */
	public IzvrsiZamenuGUI() {
		setResizable(false);
		setTitle("Izvrsi zamenu");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblKupovniKurs = new JLabel("Kupovni kurs");
		lblKupovniKurs.setBounds(10, 11, 145, 14);
		contentPane.add(lblKupovniKurs);
		
		JLabel lblValuta = new JLabel("Valuta");
		lblValuta.setBounds(173, 11, 82, 14);
		contentPane.add(lblValuta);
		
		JLabel lblProdajniKurs = new JLabel("Prodajni kurs");
		lblProdajniKurs.setBounds(276, 11, 145, 14);
		contentPane.add(lblProdajniKurs);
		
		textFieldKupovniKurs = new JTextField();
		textFieldKupovniKurs.setEditable(false);
		textFieldKupovniKurs.setBounds(10, 36, 145, 20);
		contentPane.add(textFieldKupovniKurs);
		textFieldKupovniKurs.setColumns(10);
		
		textFieldProdajniKurs = new JTextField();
		textFieldProdajniKurs.setEditable(false);
		textFieldProdajniKurs.setColumns(10);
		textFieldProdajniKurs.setBounds(276, 36, 145, 20);
		contentPane.add(textFieldProdajniKurs);
		
		comboBoxValuta.setModel(new DefaultComboBoxModel(new String[] {"EUR", "USD", "CHF"}));
		comboBoxValuta.setBounds(173, 36, 82, 20);
		contentPane.add(comboBoxValuta);
		
		JLabel lblIznos = new JLabel("Iznos");
		lblIznos.setBounds(10, 101, 46, 14);
		contentPane.add(lblIznos);
		
		textFieldIznos = new JTextField();
		textFieldIznos.setColumns(10);
		textFieldIznos.setBounds(10, 126, 173, 20);
		contentPane.add(textFieldIznos);
		
		JLabel lblVrstaTransakcije = new JLabel("Vrsta transakcije");
		lblVrstaTransakcije.setBounds(233, 101, 109, 14);
		contentPane.add(lblVrstaTransakcije);
		
		rdbtnKupovina.setSelected(true);
		buttonGroup.add(rdbtnKupovina);
		rdbtnKupovina.setBounds(243, 125, 109, 23);
		contentPane.add(rdbtnKupovina);
		
		JRadioButton rdbtnProdaja = new JRadioButton("Prodaja");
		buttonGroup.add(rdbtnProdaja);
		rdbtnProdaja.setBounds(243, 146, 109, 23);
		contentPane.add(rdbtnProdaja);
		
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				textFieldIznos.setText(slider.getValue() + "");
			}
		});
		
		slider.setMinorTickSpacing(5);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMajorTickSpacing(10);
		slider.setBounds(27, 181, 384, 45);
		contentPane.add(slider);
		
		JButton btnIzvrsiZamenu = new JButton("Izvrsi zamenu");
		btnIzvrsiZamenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String naziv = comboBoxValuta.getSelectedItem().toString();
				int iznos = Integer.parseInt(textFieldIznos.getText());
				String vrstaTransakcije;
				if (rdbtnKupovina.isSelected()) {
					vrstaTransakcije = "Kupovina";
				} else {
					vrstaTransakcije = "Prodaja";
				}
				
				String zamena = "Zamenjen je kurs - Naziv: " + naziv + "; Iznos: " + iznos
						+ "; Vrsta transakcije: " + vrstaTransakcije;
				
				MenjacnicaGUI.setZaStatus(MenjacnicaGUI.getZaStatus() + zamena);
				MenjacnicaGUI.setTextAreaStatus(MenjacnicaGUI.getZaStatus());

				dispose();
			}
		});
		btnIzvrsiZamenu.setBounds(37, 237, 146, 23);
		contentPane.add(btnIzvrsiZamenu);
		
		JButton btnOdustani = new JButton("Odustani");
		btnOdustani.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnOdustani.setBounds(261, 237, 145, 23);
		contentPane.add(btnOdustani);
	}
}
