package peripherals;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.text.DecimalFormat;

import javax.swing.*;

import engine.GameEngine;
import java.awt.FlowLayout;



public class GameGUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = -107785653906635L;

	
	@Override
	public void actionPerformed(ActionEvent e) {
		int solution = Integer.parseInt(e.getActionCommand());
		boolean correct = myGame.checkSolution(currentGame, solution);
		int score = myGame.getScore(); 
		int level=myGame.getLevel();
		if (correct) {
			System.out.println("YEAH!");
			currentGame = myGame.nextGame(); 
			ImageIcon ii = new ImageIcon(currentGame);
			questArea.setIcon(ii);
			infoArea.setText("Good!  Score: "+score);
			infoArea.setFont(new Font("Senserif",Font.ITALIC,18));

			lblLevel.setText("Level:"+level);

			timer.stop();
			second =30;
			minute =0;
			counterLabel.setText("00:30");
			countdownTimer();
			timer.start();

			
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



	JLabel lblLevel = new JLabel("Level");
	//Set timer to game
	JLabel counterLabel;
	Font font1 = new Font("Arial", Font.PLAIN, 30);	
	Timer timer;	
	int second=0, minute=1;
	String ddSecond, ddMinute;	
	DecimalFormat dFormat = new DecimalFormat("00");

	private void initGame(String player) {
		setBounds(450, 100,701, 512);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(242, 149, 103));

		myGame = new GameEngine(player);
		currentGame = myGame.nextGame();
		

		infoArea = new JTextArea(1, 40);
		infoArea.setForeground(new Color(138, 43, 226));
		infoArea.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		panel.add(infoArea);
		
		infoArea.setEditable(false);
		infoArea.setText("What is the missing value?   Score: 0");
		
		JScrollPane infoPane = new JScrollPane();
		panel.add(infoPane);

		ImageIcon ii = new ImageIcon(currentGame);
		questArea = new JLabel(ii);
	    questArea.setSize(330, 600);
	    
		JScrollPane questPane = new JScrollPane(questArea);
	  		panel.add(questPane);
	  		lblLevel.setForeground(new Color(255, 0, 0));
	  		questPane.setColumnHeaderView(lblLevel);
	  		lblLevel.setFont(new Font("Tahoma", Font.BOLD, 25));
	  		lblLevel.setText("Level: 1");
	    

		// for (int i = 0; i < 10; i++) {
		// 	JButton btn = new JButton(String.valueOf(i));
		// 	panel.add(btn);
		// 	btn.addActionListener(this);
		// 	btn.setBackground(Color.LIGHT_GRAY);
		// 	btn.setForeground(Color.WHITE);
		// }

		for (int i = 0; i < 10; i++) {
			JButton btn = new JButton(String.valueOf(i));
			panel.add(btn);
			btn.addActionListener(this);
		}

		getContentPane().add(panel);
        panel.repaint();


		counterLabel = new JLabel("");
		counterLabel.setForeground(new Color(30, 144, 255));
		counterLabel.setHorizontalAlignment(JLabel.CENTER);
		counterLabel.setFont(font1);
		panel.add(counterLabel);
		panel.setVisible(true);
		
		counterLabel.setText("00:30");

		JButton btnQuite = new JButton("Quit");
		btnQuite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//new GameGUI().setVisible(true);
				dispose();
			}
		});
		btnQuite.setBackground(new Color(244, 164, 96));
		btnQuite.setForeground(new Color(220, 20, 60));
		btnQuite.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(btnQuite);
/**
* when the time is zero the player will be redirect to the EndGame JFrame
*/
		
		countdownTimer();
		timer.start();		

	}

	public void countdownTimer() {// Used the https://www.youtube.com/watch?v=zWw72j-EbqI video to set count down timer for the game
		
		timer = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				second--;
				ddSecond = dFormat.format(second);
				ddMinute = dFormat.format(minute);	
				counterLabel.setText(ddMinute + ":" + ddSecond);
				
				if(second==-1) {
					second = 30;
					minute--;
					ddSecond = dFormat.format(second);
					ddMinute = dFormat.format(minute);	
					counterLabel.setText(ddMinute + ":" + ddSecond);
				}
				if(minute==0 && second==0) {
					timer.stop();
					//new EndGame().setVisible(true);
					dispose();
				}
			}
		});		
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