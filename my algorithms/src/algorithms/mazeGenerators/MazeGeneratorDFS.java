package algorithms.mazeGenerators;

import java.util.Random;



/**
 * <h2>MazeGeneratorDFS</h2>
 * maze generator is a class that creates matrix. this class implements MazeGenerator. the code is based on DFS maze creating algorithm.
 * @author Hido Pinto
 * @see Cell
 * @see Maze
 * @see MazeGenerator
 */
public class MazeGeneratorDFS implements MazeGenerator {

	/**
	 * creates maze generator dfs object
	 */
	public MazeGeneratorDFS() {
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
	public void generateMaze(Maze m,int i,int j) {
		Random rand = new Random();
		int rnd = 0;
		m.getCell(i, j).setVisited(true);
		int n=1234;
		
		while(n>0)
		{
			//choose randomly
				
			rnd = rand.nextInt(4);
			
			
			int h = (int) (n/(Math.pow(10, 4-rnd)));
			int l=(int) (n%Math.pow(10, 3-rnd));
			int dig = (int) (n/Math.pow(10, 3-rnd))%10;
			n=(int) (h*Math.pow(10, 3-rnd)+l);
			
			if(dig == 1)
			{
				if((i+1)<m.getRows())	//choose down neighbor
				{
						if( (m.getCell(i+1, j).isVisited() == false)  )
						{
							//m.getCell(i, j).setHasBottomWall(false);
							//m.getCell(i+1, j).setHasTopWall(false);
							m.setCellWallPosition(2, false, i, j);
							m.setCellWallPosition(8, false, i+1, j);
							generateMaze(m, (i+1), j);
						}
				}
			}
			if(dig ==2)
			{
				if((j+1)<m.getCols())		//choose right neighbor
				{
						if( (m.getCell(i, j+1).isVisited() == false)  )
						{
							//m.getCell(i, j).setHasRightWall(false);
							//m.getCell(i, j+1).setHasLeftWall(false);
							m.setCellWallPosition(6, false, i, j);
							m.setCellWallPosition(4, false, i, j+1);
							generateMaze(m, i, j+1);
						}
				}
			}
				
			if(dig==3)
			{
				if(i>0)		//choose up neighbor
				{
						if( (m.getCell(i-1, j).isVisited() == false) )
						{
							//m.getCell(i, j).setHasTopWall(false);
							//m.getCell(i-1, j).setHasBottomWall(false);
							m.setCellWallPosition(8, false, i, j);
							m.setCellWallPosition(2, false, i-1, j);
							generateMaze(m, i-1, j);
						}
				}
			}
				
			if(dig==4)
			{
				if(j>0)		//choose left neighbor
				{
						if( (m.getCell(i, j-1).isVisited() == false) )
						{
							//m.getCell(i, j).setHasLeftWall(false);
							//m.getCell(i, j-1).setHasRightWall(false);
							m.setCellWallPosition(4, false, i, j);
							m.setCellWallPosition(6, false, i, j-1);
							generateMaze(m, i, j-1);
						}
				}
			}
		}
		
		return;
	}
	
	
}




	


