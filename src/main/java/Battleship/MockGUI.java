package Battleship;

import static java.awt.Font.PLAIN;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class MockGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JTextArea display;
	JTextArea display2;
	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	JButton button5;
	JButton button6;
	JButton button7;
	JButton button8;
	JButton button9;
	JButton button0;

	JButton buttonA;
	JButton buttonB;
	JButton buttonC;
	JButton buttonD;
	JButton buttonE;
	JButton buttonF;
	JButton buttonG;
	JButton buttonH;
	JButton buttonI;
	JButton buttonJ;

	JButton buttonY;
	JButton buttonN;

	JButton enter;

	private String value = "-1";
	private boolean isPressed = false;

	public MockGUI() {

		initDisplay();
		initbuttones();
		initAcciones();
		initPantalla();

	}

	public String getvalue() {
		return value;
	}

	public JTextArea getDisplay() {
		return display;
	}

	public boolean getPress() {
		return isPressed;
	}

	public String getDisplayValue() {

		String diplayValue = value;
		value = "-1";
		return diplayValue;
	}

	private void initPantalla() {

		setTitle("BattleShip");
		setSize(1920, 1000);
		setResizable(false);
		setLayout(null);
		getContentPane().setBackground(Color.BLACK);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}

	private void initDisplay() {

		display = new JTextArea("");
		display.setBounds(15, 15, 195, 60);
		display.setSize(1300, 900);
		display.setOpaque(true);
		display.setBackground(Color.BLACK);
		display.setForeground(Color.YELLOW);
		display.setBorder(new LineBorder(Color.DARK_GRAY));
		display.setFont(new Font("MONOSPACED", PLAIN, 14));

		display.setFocusable(true);
		add(display);

		display2 = new JTextArea("");

		display2.setBounds(1315, 800, 1, 1);
		display2.setSize(700, 600);
		display2.setOpaque(true);
		display2.setBackground(Color.BLACK);
		display2.setForeground(Color.GREEN);
		display2.setBorder(new LineBorder(Color.DARK_GRAY));
		display2.setFont(new Font("MONOSPACED", PLAIN, 14));

		display2.setFocusable(true);
		add(display2);

		display.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				display.setText(display.getText());

			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

		});

	}

	private void initbuttones() {

		button1 = new JButton("1");
		button1.setBounds(1330, 90, 100, 50);
		button1.setOpaque(true);
		add(button1);

		button2 = new JButton("2");
		button2.setBounds(1450, 90, 100, 50);
		button2.setOpaque(true);
		add(button2);
		button3 = new JButton("3");
		button3.setBounds(1570, 90, 100, 50);
		button3.setOpaque(true);
		add(button3);

		button4 = new JButton("4");
		button4.setBounds(1330, 150, 100, 50);
		button4.setOpaque(true);
		add(button4);
		button5 = new JButton("5");
		button5.setBounds(1450, 150, 100, 50);
		button5.setOpaque(true);
		add(button5);
		button6 = new JButton("6");
		button6.setBounds(1570, 150, 100, 50);
		button6.setOpaque(true);
		add(button6);

		button7 = new JButton("7");
		button7.setBounds(1330, 220, 100, 50);
		button7.setOpaque(true);
		add(button7);
		button8 = new JButton("8");
		button8.setBounds(1450, 220, 100, 50);
		button8.setOpaque(true);
		add(button8);
		button9 = new JButton("9");
		button9.setBounds(1570, 220, 100, 50);
		button9.setOpaque(true);
		add(button9);

		button0 = new JButton("0");
		button0.setBounds(1450, 290, 100, 50);
		button0.setOpaque(true);
		add(button0);

		buttonA = new JButton("A");
		buttonA.setBounds(1330, 360, 100, 50);
		buttonA.setOpaque(true);
		add(buttonA);
		buttonB = new JButton("B");
		buttonB.setBounds(1450, 360, 100, 50);
		buttonB.setOpaque(true);
		add(buttonB);

		buttonC = new JButton("C");
		buttonC.setBounds(1570, 360, 100, 50);
		buttonC.setOpaque(true);
		add(buttonC);

		buttonD = new JButton("D");
		buttonD.setBounds(1330, 430, 100, 50);
		buttonD.setOpaque(true);
		add(buttonD);
		buttonF = new JButton("F");
		buttonF.setBounds(1450, 430, 100, 50);
		buttonF.setOpaque(true);
		add(buttonF);

		buttonG = new JButton("G");
		buttonG.setBounds(1570, 430, 100, 50);
		buttonG.setOpaque(true);
		add(buttonG);

		buttonH = new JButton("H");
		buttonH.setBounds(1330, 500, 100, 50);
		buttonH.setOpaque(true);
		add(buttonH);
		buttonI = new JButton("I");
		buttonI.setBounds(1450, 500, 100, 50);
		buttonI.setOpaque(true);
		add(buttonI);
		buttonJ = new JButton("J");
		buttonJ.setBounds(1570, 500, 100, 50);
		buttonJ.setOpaque(true);
		add(buttonJ);

		buttonY = new JButton("YES (Y)");
		buttonY.setBounds(1330, 570, 160, 50);
		buttonY.setOpaque(true);
		add(buttonY);

		buttonN = new JButton("NO (N)");
		buttonN.setBounds(1500, 570, 160, 50);
		buttonN.setOpaque(true);
		add(buttonN);

		enter = new JButton("Enter");
		enter.setBounds(1330, 640, 340, 50);
		enter.setOpaque(true);
		add(enter);
	}

	private void initAcciones() {
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				display2.setText(display2.getText() + "1");
				isPressed = false;
			}
		});
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				display2.setText(display2.getText() + "2");
				isPressed = false;
			}
		});
		button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				display2.setText(display2.getText() + "3");
				isPressed = false;
			}
		});
		button4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				display2.setText(display2.getText() + "4");
				isPressed = false;
			}
		});
		button5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				display2.setText(display2.getText() + "5");
				isPressed = false;
			}
		});
		button6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				display2.setText(display2.getText() + "6");
				isPressed = false;
			}
		});
		button7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				display2.setText(display2.getText() + "7");
				isPressed = false;
			}
		});
		button8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				display2.setText(display2.getText() + "8");
				isPressed = false;
			}
		});
		button9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				display2.setText(display2.getText() + "9");
				isPressed = false;
			}
		});
		button0.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				display2.setText(display2.getText() + "0");
				isPressed = false;
			}
		});

		buttonA.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				display2.setText(display2.getText() + "A");
				isPressed = false;
			}
		});

		buttonB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				display2.setText(display2.getText() + "B");
				isPressed = false;
			}
		});
		buttonC.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				display2.setText(display2.getText() + "C");
				isPressed = false;
			}
		});

		buttonD.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				display2.setText(display2.getText() + "D");
				isPressed = false;
			}
		});

		buttonF.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				display2.setText(display2.getText() + "F");
				isPressed = false;
			}
		});

		buttonG.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				display2.setText(display2.getText() + "G");
				isPressed = false;
			}
		});

		buttonH.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				display2.setText(display2.getText() + "H");
				isPressed = false;

			}
		});

		buttonI.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				display2.setText(display2.getText() + "I");
				isPressed = false;
			}
		});

		buttonJ.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				display2.setText(display2.getText() + "J");
				isPressed = false;
			}
		});

		buttonY.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				display2.setText(display2.getText() + "Y");
				isPressed = false;

			}
		});

		buttonN.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				display2.setText(display2.getText() + "N");
				isPressed = false;

			}
		});

		enter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String text = display2.getText();
				display2.append(text);
				value = text;
				isPressed = true;
				display2.setText("");

			}
		});
	}

	public static void main(String[] args) throws InterruptedException {

		MockGUI obj = new MockGUI();
		GameMaster gm = new GameMaster(obj);
		gm.printMainMenu();
	}

}
