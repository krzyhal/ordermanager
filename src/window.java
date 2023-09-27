import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;
import java.awt.Dimension;

public class window extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private String person;
	private String email;
	private String phone;
	private String orderedItem;
	private String userHome = System.getProperty("user.home");
	JButton btnZatwierdz = new JButton();
	JButton btnZapis = new JButton();
	JButton btnLast = new JButton();
	ImageIcon iconaccept = new ImageIcon(getClass().getClassLoader().getResource("accept.png"));
	final JFileChooser fileChooser = new JFileChooser(userHome +"/Desktop");
	
	
	File fileFolder = new File("");
	File file = new File(fileFolder.getAbsolutePath()+"/Zamówienia.txt");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window frame = new window();
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
	public window() {
		setResizable(false);
		setTitle("Menedżer zamówień");
		setFont(new Font("Courier New", Font.BOLD, 13));
		ImageIcon iconimg = new ImageIcon(getClass().getClassLoader().getResource("project-management.png"));
		setIconImage(iconimg.getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 265);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(41, 41, 41));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		panel_4.add(panel);
		panel.setBackground(Color.DARK_GRAY);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Imię i nazwisko:");
		lblNewLabel.setForeground(Color.WHITE);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setForeground(new Color(46, 46, 46));
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(textField);
		textField.setColumns(16);
		
		JPanel panel_1 = new JPanel();
		panel_4.add(panel_1);
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JLabel lblAdresEmail = new JLabel("Adres e-mail:");
		lblAdresEmail.setForeground(Color.WHITE);
		panel_1.add(lblAdresEmail);
		
		textField_1 = new JTextField();
		textField_1.setForeground(new Color(46, 46, 46));
		textField_1.setHorizontalAlignment(SwingConstants.LEFT);
		textField_1.setColumns(16);
		panel_1.add(textField_1);
		
		JPanel panel_2 = new JPanel();
		panel_4.add(panel_2);
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JLabel lblNumerTel = new JLabel("Numer tel.");
		lblNumerTel.setForeground(Color.WHITE);
		panel_2.add(lblNumerTel);
		
		textField_2 = new JTextField();
		textField_2.setForeground(new Color(46, 46, 46));
		textField_2.setHorizontalAlignment(SwingConstants.LEFT);
		textField_2.setColumns(16);
		panel_2.add(textField_2);
		
		JPanel panel_3 = new JPanel();
		panel_4.add(panel_3);
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setBackground(Color.DARK_GRAY);
		panel_3.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JLabel lblNewLabel_1 = new JLabel("Zamówiony produkt:");
		lblNewLabel_1.setForeground(Color.WHITE);
		panel_3.add(lblNewLabel_1);
		
		textField_3 = new JTextField();
		textField_3.setForeground(new Color(46, 46, 46));
		textField_3.setHorizontalAlignment(SwingConstants.LEFT);
		textField_3.setColumns(16);
		panel_3.add(textField_3);
		btnZatwierdz.setText("Zatwierdź i dodaj");
		
		btnZatwierdz.setName("Zatwierdź i dodaj");
		btnZatwierdz.setBackground(Color.GRAY);
		btnZatwierdz.addActionListener(this);
		
		btnZapis.setText("Ustal ścieżkę zapisu");
		btnZapis.setIcon(null);
		btnZapis.setBackground(Color.LIGHT_GRAY);
		btnZapis.setMinimumSize(new Dimension(89, 18));
		btnZapis.setMaximumSize(new Dimension(89, 18));
		btnZapis.addActionListener(this);
		panel_4.add(btnZapis);
		panel_4.add(btnZatwierdz);
		btnZatwierdz.setVisible(false);
		
		JLabel label = new JLabel("");
		contentPane.add(label);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()==btnZapis) {
			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int returnVal = fileChooser.showSaveDialog(this);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					fileFolder = fileChooser.getSelectedFile();
					file = new File(fileFolder.getAbsolutePath()+"/Zamówienia.txt");
					btnZatwierdz.setVisible(true);
					btnZapis.setIcon(iconaccept);
				}
			
		}
		
		if (e.getSource()==btnZatwierdz) {
			textField.getText();
			textField_1.getText();
			textField_2.getText();
			textField_3.getText();
			person = textField.getText();
			email = textField_1.getText();
			phone = textField_2.getText();
			orderedItem = textField_3.getText();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm");  
			LocalDateTime now = LocalDateTime.now(); 
			String order = "[ " + dtf.format(now) + " ] " + person + " | " + email + " | " + phone + " | " + orderedItem + "\n";
			FileOutputStream fos = null;
			try {
				fos = new FileOutputStream(file, true);
				if (!file.exists()) {
					file.createNewFile();
				}
				byte[] orderInBytes = order.getBytes();
				fos.write(orderInBytes);
			}
         catch (FileNotFoundException err) {
            err.printStackTrace();
        } catch (IOException err) {
            err.printStackTrace();
        } finally {
        		try {
        			if (fos != null) {
                    fos.close();
        			}
        		} catch (IOException err) {
        			err.printStackTrace();
        			}

			}
			textField.setText("");
			textField_1.setText("");
			textField_2.setText("");
			textField_3.setText("");
		}
		
	}
}
