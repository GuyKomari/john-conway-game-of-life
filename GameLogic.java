import java.util.Random;
/**
 * This class represents the logic of the game
 */
public class GameLogic 
{
	private boolean [][] lifeMatrix;//the matrix in the game
	private boolean [][] newLifeMatrix;//the matrix at the next generation
	private int length;//Matrix length
	final boolean ALIVE=true;//Live mode in the game
	/**
	 * GameLogic constructor
	 * @param height - Matrix height
	 * @param width - Matrix length
	 */
	public GameLogic(int length)
	{
		this.length=length;
		this.lifeMatrix=new boolean[this.length][this.length];
		this.newLifeMatrix=new boolean[this.length][this.length];
		Random rand=new Random();
		for(int i=0;i<this.length;i++)
			for(int j=0;j<this.length;j++)
				this.lifeMatrix[i][j]=rand.nextBoolean();
	}
	/**
	 * @return The matrix of life in the game
	 */
	public boolean[][] getLifeMatrix()
	{
		return this.lifeMatrix;
	}
	/**
	 * @return the matrix length
	 */
	public int getLength()
	{
		return this.length;
	}
	/**
	 * update the matrix to the next generation 
	 */
	public void nextGeneration()
	{
		int num;
		for(int i=0;i<this.length;i++)
		{
			for(int j=0;j<this.length;j++)
			{
				num=countAlive(i,j);
				if(this.lifeMatrix[i][j]==true)
				{
					switch(num)
					{
					case 0:
					case 1:
						this.newLifeMatrix[i][j]=false;
						break;
					case 2:
					case 3:
						this.newLifeMatrix[i][j]=true;
						break;
					default:
						this.newLifeMatrix[i][j]=false;
						break;
					}
				}
				else
				{
					switch(num)
					{
					case 3: 
						this.newLifeMatrix[i][j]=true;
						break;
					default:
						this.newLifeMatrix[i][j]=false;
						break;
					}
				}

			}
		}
		for(int i=0;i<this.length;i++)
			for(int j=0;j<this.length;j++)
				this.lifeMatrix[i][j]=this.newLifeMatrix[i][j];
	}
	/**
	 * @param i - position in cell 
	 * @param j - position in cell 
	 * @return Calculates How many alive neighbors around a cell
	 */
	private int countAlive(int i, int j) 
	{
		int count= 0;
		if(i-1>=0&&this.lifeMatrix[i-1][j]==ALIVE)
			count++;
		if(i+1<this.length&&this.lifeMatrix[i+1][j]==ALIVE)
			count++;
		if(i-1>=0&&j-1>=0&&this.lifeMatrix[i-1][j-1]==ALIVE)
			count++;
		if(i+1<this.length&&j+1<this.length&&this.lifeMatrix[i+1][j+1]==ALIVE)
			count++;
		if(j-1>=0&&this.lifeMatrix[i][j-1]==ALIVE)
			count++;
		if(j+1<this.length&&this.lifeMatrix[i][j+1]==ALIVE)
			count++;
		if(i-1>=0&&j+1<this.length&&this.lifeMatrix[i-1][j+1]==ALIVE)
			count++;
		if(i+1<this.length&&j-1>=0&&this.lifeMatrix[i+1][j-1]==ALIVE)
			count++;
		return count;	
	}

}
