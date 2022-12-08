package peripherals;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.*;

import engine.GameEngine;



public class GameGUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = -107785653906635L;

	
	@Override
	public void actionPerformed(ActionEvent e) {
		int solution = Integer.parseInt(e.getActionCommand());
		boolean correct = myGame.checkSolution(currentGame, solution);
		int score = myGame.getScore(); 
		if (correct) {
			System.out.println("YEAH!");
			currentGame = myGame.nextGame(); 
			ImageIcon ii = new ImageIcon(currentGame);
			questArea.setIcon(ii);
			infoArea.setText("Good!  Score: "+score);
			infoArea.setFont(new Font("Senserif",Font.ITALIC,18));

			
		} else { 
			System.out.println("Not Correct"); 
			infoArea.setText("Oops. Try again!  Score: "+score);
			infoArea.setFont(new Font("Senserif",Font.ITALIC,18));
		}
	}

	JLabel questArea = null;
	GameEngine myGame = null;
	URL currentGame = null;
	JTextArea infoArea = null;
	

	private void initGame(String player) {
		setSize(690, 500);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("What is the value of the heart?");
		JPanel panel = new JPanel();

		myGame = new GameEngine(player);
		currentGame = myGame.nextGame();

		infoArea = new JTextArea(1, 40);

		
		
		infoArea.setEditable(false);
		infoArea.setText("What is the value of the Heart?   Score: 0");
		infoArea.setFont(new Font("Senserif",Font.ITALIC,18));
		
		JScrollPane infoPane = new JScrollPane(infoArea);
		panel.add(infoPane);

		ImageIcon ii = new ImageIcon(currentGame);
		questArea = new JLabel(ii);
	    questArea.setSize(330, 600);
	    
		JScrollPane questPane = new JScrollPane(questArea);
		panel.add(questPane);

		for (int i = 0; i < 10; i++) {
			JButton btn = new JButton(String.valueOf(i));
			panel.add(btn);
			btn.addActionListener(this);
			btn.setBackground(Color.LIGHT_GRAY);
			btn.setForeground(Color.WHITE);
		}

		getContentPane().add(panel);
		setBounds(450,200,690,500);
		setBackground(Color.blue);
		setForeground(Color.WHITE);
		panel.repaint();

	}

	public GameGUI() {
		super();
		initGame(null);
	}


	public GameGUI(String player) {
		super();
		initGame(player);
	}

	
	public static void main(String[] args) {
		GameGUI myGUI = new GameGUI();
		myGUI.setVisible(true);

	}
}