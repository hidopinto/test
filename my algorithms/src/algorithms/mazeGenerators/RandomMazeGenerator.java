package algorithms.mazeGenerators;

import java.util.Random;


/**
 * <h2>RandomMazeGenerator</h2>
 * random maze generator is a class that creates matrix. is first makes a path to the exit door and then chooses to delete walls randomly. implements MazeGenerator
 * @author Hido Pinto
 * @see Cell
 * @see Maze
 * @see MazeGenerator
 */
public class RandomMazeGenerator implements MazeGenerator{
	
	
	/**
	 * creates random maze generator object
	 */
	public RandomMazeGenerator() {
		super();
	}
	
	
	/**
	 * generates a maze
	 * @param m maze=matrix of cells
	 * @param i row start index
	 * @param j col start index
	 * @see Maze
	 * @see Cell
	 */
	
	@Override
	public void generateMaze(Maze m, int i, int j) {
		int rnd;
		Random r = new Random();
		for(int k=0;k<m.getRows()-1;k++)
		{
			m.getCell(k, 0).setHasBottomWall(false);
			m.getCell(k+1, 0).setHasTopWall(false);
		}
		for(int l=0;l<m.getCols()-1;l++)
		{
			m.getCell(m.getRows()-1, l).setHasRightWall(false);
			m.getCell(m.getRows()-1, l+1).setHasLeftWall(false);
		}
		for(int k=0;k<m.getRows()-1;k++)
		{
			for(int l=1;l<m.getCols();l++)
			{
				rnd=r.nextInt(2);
				if(rnd==1)
				{
					m.getCell(k, l).setHasBottomWall(false);
					m.getCell(k+1, l).setHasTopWall(false);
				}
				else 
				{
					if(l!=(m.getCols()-1))
					{
						m.getCell(k, l).setHasRightWall(false);
						m.getCell(k, l+1).setHasLeftWall(false);
					}
					else
					{
						m.getCell(k, l).setHasLeftWall(false);
						m.getCell(k, l-1).setHasRightWall(false);
					}
				}
			}
		}
		
	}
	
}
