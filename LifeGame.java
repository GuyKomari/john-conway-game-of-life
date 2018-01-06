import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class LifeGame 
{
	private JFrame frame;
	private GameGraphics matrix;
	public LifeGame(int length)
	{
		this.frame = new JFrame("Game Of Life");
		this.matrix= new GameGraphics(length);
	}
	public void runGame()
	{
		int result=0;
		this.frame.add(this.matrix);
		this.frame.setResizable(false);
		this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.frame.setSize(708, 730);
		this.frame.setVisible(true);
		while(result==0) 
		{
			result=JOptionPane.showConfirmDialog(null, "Do you want to move on to the next generation?");
			if(result==-1 || result==2)//cancel / close 
				System.exit(0);
			if(result==1)// No
				break;
			else 
			{
				this.matrix.getGameMatrix().nextGeneration();
				this.matrix.repaint();
			}
		}
	}
}
