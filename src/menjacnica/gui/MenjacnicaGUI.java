package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFileChooser;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Component;

import javax.swing.JPopupMenu;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import java.awt.Dimension;

import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;






import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Toolkit;

public class MenjacnicaGUI extends JFrame {

	private static JPanel contentPane;
	private JTable table;
	private static String zaStatus = "";
	final static JTextArea textAreaStatus = new JTextArea();
	
	public static JTextArea getTextAreaStatus() {
		return textAreaStatus;
	}
	
	public static void setTextAreaStatus(String status) {
		MenjacnicaGUI.textAreaStatus.setText(status);
	}

	public static String getZaStatus() {
		return zaStatus;
	}

	public static void setZaStatus(String status) {
		zaStatus = status;
	}

	private static void ugasiProgram() {
		int sifra = JOptionPane.showConfirmDialog(contentPane, 
				"Da li zelite da izadjete iz programa?", "Izlaz", 
				JOptionPane.YES_NO_CANCEL_OPTION);
		if (sifra == JOptionPane.YES_OPTION)
			System.exit(0);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenjacnicaGUI frame = new MenjacnicaGUI();
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
	public MenjacnicaGUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenjacnicaGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent arg0) {
				ugasiProgram();
			}
		});
		setTitle("Menjacnica");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 684, 430);

		setLocationRelativeTo(null);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);

		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(contentPane,
						"Nevena Djuricic", "Autor", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnHelp.add(mntmAbout);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setModel(new DefaultTableModel(
				new Object[][] {
						{null, "", null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
				},
				new String[] {
						"\u0160ifra", "Skra\u0107eni naziv", "Prodajni", "Srednji", "Kupovni", "Naziv"
				}
				) {
			Class[] columnTypes = new Class[] {
					Integer.class, String.class, Double.class, Double.class, Double.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(85);
		table.getColumnModel().getColumn(1).setPreferredWidth(85);
		table.getColumnModel().getColumn(2).setPreferredWidth(85);
		table.getColumnModel().getColumn(3).setPreferredWidth(85);
		table.getColumnModel().getColumn(4).setPreferredWidth(85);
		table.getColumnModel().getColumn(5).setPreferredWidth(85);
		scrollPane.setViewportView(table);

		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(table, popupMenu);

		JMenuItem mntmDodajKurs = new JMenuItem("Dodaj kurs");
		mntmDodajKurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new DodajKursGUI().setVisible(true);
			}
		});
		popupMenu.add(mntmDodajKurs);

		JMenuItem mntmObrisiKurs = new JMenuItem("Obrisi kurs");
		mntmObrisiKurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ObrisiKursGUI().setVisible(true);
			}
		});
		popupMenu.add(mntmObrisiKurs);

		JMenuItem mntmIzvrsiZamenu = new JMenuItem("Izvrsi zamenu");
		mntmIzvrsiZamenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new IzvrsiZamenuGUI().setVisible(true);
			}
		});
		popupMenu.add(mntmIzvrsiZamenu);

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(140, 10));
		contentPane.add(panel, BorderLayout.EAST);
		panel.setLayout(null);

		JButton btnDodajKurs = new JButton("Dodaj kurs");
		btnDodajKurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new DodajKursGUI().setVisible(true);
			}
		});
		btnDodajKurs.setBounds(10, 5, 120, 23);
		panel.add(btnDodajKurs);

		JButton btnObrisiKurs = new JButton("Obrisi kurs");
		btnObrisiKurs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ObrisiKursGUI().setVisible(true);
			}
		});
		btnObrisiKurs.setBounds(10, 33, 120, 23);
		panel.add(btnObrisiKurs);

		JButton btnIzvrsiZamenu = new JButton("Izvrsi zamenu");
		btnIzvrsiZamenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new IzvrsiZamenuGUI().setVisible(true);
			}
		});
		btnIzvrsiZamenu.setBounds(10, 61, 120, 23);
		panel.add(btnIzvrsiZamenu);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setPreferredSize(new Dimension(2, 60));
		scrollPane_1.setBorder(new TitledBorder(null, "STATUS", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		contentPane.add(scrollPane_1, BorderLayout.SOUTH);

		scrollPane_1.setViewportView(textAreaStatus);

		JMenuItem mntmOpen = new JMenuItem("Open");
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fc = new JFileChooser();

				int izabrano = fc.showOpenDialog(contentPane);

				if (izabrano == JFileChooser.APPROVE_OPTION) {
					File f = fc.getSelectedFile();
					zaStatus += "Ucitan fajl: " + f.getAbsolutePath() + "\n";
					textAreaStatus.setText(zaStatus);
				}
			}
		});
		mntmOpen.setIcon(new ImageIcon(MenjacnicaGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/Directory.gif")));
		mntmOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		mnFile.add(mntmOpen);

		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fc = new JFileChooser();

				int izabrano = fc.showSaveDialog(contentPane);

				if (izabrano == JFileChooser.APPROVE_OPTION) {
					File f = fc.getSelectedFile();
					zaStatus += "Sacuvan fajl: " + f.getAbsolutePath() + "\n";
					textAreaStatus.setText(zaStatus);
				}
			}
		});
		mntmSave.setIcon(new ImageIcon(MenjacnicaGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/FloppyDrive.gif")));
		mntmSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnFile.add(mntmSave);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ugasiProgram();
			}
		});

		mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.ALT_MASK));
		mnFile.add(mntmExit);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
