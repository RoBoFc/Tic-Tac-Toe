import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class TicTacToe implements ActionListener
{
	Random random = new Random();
	
	JFrame frame = new JFrame("Tic Tac Toe");
	JLabel label = new JLabel("Tic Tac Toe");
	JPanel panel = new JPanel();
	JButton[] button = new JButton[9];
	
	boolean player1;
	
	TicTacToe()
	{
		frame.setSize(500,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		label.setSize(300,100);
		label.setFont(new Font(null,Font.PLAIN,50));
		label.setBackground(Color.black);
		label.setForeground(Color.blue);
		label.setOpaque(true);
		label.setHorizontalAlignment(JLabel.CENTER);
		
		panel.setLayout(new GridLayout(3,3,4,4));
		panel.setSize(500,500);
		panel.setBackground(Color.yellow);
		for(int i=0;i<9;i++)
		{
			button[i] = new JButton();
			button[i].setFocusable(false);
			button[i].setBackground(Color.black);
			button[i].setForeground(Color.yellow);
			button[i].setFont(new Font(null,Font.BOLD,90));
			button[i].setBorderPainted(false);
			button[i].setFocusPainted(true);
			button[i].addActionListener(this);
			
			panel.add(button[i]);
		}
		
		frame.add(label,BorderLayout.NORTH);
		frame.add(panel);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
		firstTurn();
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		for(int i=0;i<9;i++)
		{
			if(e.getSource() == button[i])
			{
				if(player1==true)
				{
					if(button[i].getText()=="")
					{
						button[i].setText("X");
						player1=false;
						label.setText("O's Turn");
						check();
					}
				}
				else
				{
					if(button[i].getText()=="")
					{
						button[i].setText("O");
						player1=true;
						label.setText("X's Turn");
						check();
					}
				}
			}
		}
	}
	
	public void firstTurn()
	{
		try
		{
			Thread.sleep(1000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		if(random.nextInt(2)==0)
		{
			player1=true;
			label.setText("X's Turn");
		}
		else
		{
			player1=false;
			label.setText("O's Turn");
		}
	}
	
	public void check()
	{
		//xWin condition
		
		if((button[0].getText()=="X") && (button[1].getText()=="X") && (button[2].getText()=="X"))
		{
			xWins(0,1,2);
		}
		if((button[3].getText()=="X") && (button[4].getText()=="X") && (button[5].getText()=="X"))
		{
			xWins(3,4,5);
		}
		if((button[6].getText()=="X") && (button[7].getText()=="X") && (button[8].getText()=="X"))
		{
			xWins(6,7,8);
		}
		if((button[0].getText()=="X") && (button[3].getText()=="X") && (button[6].getText()=="X"))
		{
			xWins(0,3,6);
		}
		if((button[1].getText()=="X") && (button[4].getText()=="X") && (button[7].getText()=="X"))
		{
			xWins(1,4,7);
		}
		if((button[2].getText()=="X") && (button[5].getText()=="X") && (button[8].getText()=="X"))
		{
			xWins(2,5,8);
		}
		if((button[0].getText()=="X") && (button[4].getText()=="X") && (button[8].getText()=="X"))
		{
			xWins(0,4,8);
		}
		if((button[2].getText()=="X") && (button[4].getText()=="X") && (button[6].getText()=="X"))
		{
			xWins(2,4,6);
		}
		
		//oWin condition
		
		if((button[0].getText()=="O") && (button[1].getText()=="O") && (button[2].getText()=="O"))
		{
			oWins(0,1,2);
		}
		if((button[3].getText()=="O") && (button[4].getText()=="O") && (button[5].getText()=="O"))
		{
			oWins(3,4,5);
		}
		if((button[6].getText()=="O") && (button[7].getText()=="O") && (button[8].getText()=="O"))
		{
			oWins(6,7,8);
		}
		if((button[0].getText()=="O") && (button[3].getText()=="O") && (button[6].getText()=="O"))
		{
			oWins(0,3,6);
		}
		if((button[1].getText()=="O") && (button[4].getText()=="O") && (button[7].getText()=="O"))
		{
			oWins(1,4,7);
		}
		if((button[2].getText()=="O") && (button[5].getText()=="O") && (button[8].getText()=="O"))
		{
			oWins(2,5,8);
		}
		if((button[0].getText()=="O") && (button[4].getText()=="O") && (button[8].getText()=="O"))
		{
			oWins(0,4,8);
		}
		if((button[2].getText()=="O") && (button[4].getText()=="O") && (button[6].getText()=="O"))
		{
			oWins(2,4,6);
		}
		
	}
	
	public void xWins(int a, int b, int c)
	{
		button[a].setBackground(new Color(50,255,50));
		button[b].setBackground(new Color(50,255,50));
		button[c].setBackground(new Color(50,255,50));
		label.setText("X wins");
		for(int i=0;i<9;i++)
		{
			button[i].setEnabled(false);
		}
	}
	
	public void oWins(int a, int b, int c)
	{
		button[a].setBackground(new Color(50,255,50));
		button[b].setBackground(new Color(50,255,50));
		button[c].setBackground(new Color(50,255,50));
		label.setText("O wins");
		for(int i=0;i<9;i++)
		{
			button[i].setEnabled(false);
		}
	}
}
