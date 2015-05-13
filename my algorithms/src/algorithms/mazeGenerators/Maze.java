package algorithms.mazeGenerators;

/**
 * <h2>Maze</h2>
 * The maze is the main matrix. It includes cells for the maze. All the functions are here.
 * @author Hido Pinto
 * @see Cell
 */
public class Maze{
	private Cell[][] matrix;
	private int rows;
	private int cols;
	
	public Maze(int rows, int cols) {
		super();
		this.rows = rows;
		this.cols = cols;
		
		this.matrix = new Cell[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				matrix[i][j] = new Cell();
				matrix[i][j].setVisited(false);
			}
		}
		getCell(0,0).setHasLeftWall(false);
		getCell(rows-1, cols-1).setHasRightWall(false);
	}
	/**
	 * Prints the matrix
	 */
	public void print() 
	{
		System.out.print(" ");
		for (int j = 0; j < cols; j++)
			System.out.print("_ ");
		System.out.println("");
		
		for (int i = 0; i < rows; i++) {
			if(i!=0)
				System.out.print("|");
			if(i==0)
				System.out.print(" ");
			for (int j = 0; j < cols; j++) {				
				Cell cell = matrix[i][j];
				if (cell.getHasBottomWall())
					System.out.print("_");
				else
					System.out.print(" ");
				
				if (cell.getHasRightWall())
					System.out.print("|");
				else
					System.out.print(" ");	
								
			}
			System.out.println();
		}
	}
	/**
	 * just get the cell by row and col
	 * @param RowI rows
	 * @param ColJ cols
	 * @return Cell the cell
	 */
	public Cell getCell(int RowI, int ColJ)
	{
		return (matrix[RowI][ColJ]);
	}
	
	
	/**
	 * return the matrix, cel[]
	 * @return matrix the matrix
	 */
	public Cell[][] getMatrix() {
		return matrix;
	}

	/**
	 * sets the matrix to a matrix that gets in by ref.
	 * @param matrix
	 */
	public void setMatrix(Cell[][] matrix) {
		this.matrix = matrix;
	}

	/**
	 * returns the rows
	 * @return rows the rows
	 */
	public int getRows() {
		return rows;
	}

	/**
	 * sets the rows
	 * @param rows
	 */
	public void setRows(int rows) {
		this.rows = rows;
	}

	/**
	 * returns the cols
	 * @return cols the cols
	 */
	public int getCols() {
		return cols;
	}

	/**
	 * sets the cols
	 * @param cols
	 */
	public void setCols(int cols) {
		this.cols = cols;
	}
	/**
	 * creates and deletes walls from the matrix'es cells
	 * @param where where to put the wall insert numbers as the arrows on the numlock keys
	 * @param flag true=build wall,false=delete wall
	 * @param i row number
	 * @param j col number
	 */
	public void setCellWallPosition(int where, boolean flag, int i, int j) {
		switch(where) {
		case 4:
			this.matrix[i][j].setHasLeftWall(flag);
			break;
		case 8:
			this.matrix[i][j].setHasTopWall(flag);
			break;
		case 6:
			this.matrix[i][j].setHasRightWall(flag);
			break;
		case 2:
			this.matrix[i][j].setHasBottomWall(flag);
			break;
		}
	}
	
}
