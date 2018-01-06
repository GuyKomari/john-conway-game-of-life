import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;
/**
 *  This class represents the graphics of the game
 */
public class GameGraphics extends JPanel 
{
	private GameLogic gameMatrix;
	private int length;
	private int sizeW;
	private int sizeL;
	public GameGraphics(int length)
	{
		this.gameMatrix=new GameLogic(length);
		this.length=this.gameMatrix.getLength();
	}
	public GameLogic getGameMatrix()
	{
		return this.gameMatrix;
	}
	public void paint(Graphics g)
	{
		int w = getWidth();
		int h = getHeight();
		this.sizeW=w/this.length;
		this.sizeL=h/this.length;
		super.paint(g);
		System.out.println("");
		for(int i=0;i<this.length;i++)
		{
			for(int j=0;j<this.length;j++)
			{
				if(this.gameMatrix.getLifeMatrix()[i][j]==false)
				{
					g.setColor(Color.black);
					g.drawRect(sizeW*j, sizeL*i, sizeL,  sizeW);
				}
				else
				{
					g.setColor(Color.yellow);
					g.fillRect(sizeW*j, sizeL*i, sizeL,  sizeW);
					g.setColor(Color.black);
					g.drawRect(sizeW*j, sizeL*i, sizeL,  sizeW);
				}
			}
		}
	}

}
