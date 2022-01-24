/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package life;

public class Grid {

	private int [][] grid;
	private int [][] gridtemp;
	public Grid() {}
	
	public void random_state(int Width,int Height)
	{
		this.grid = new int[Height][Width];
		this.gridtemp = new int[Height][Width];
		for(int i = 0;i < Height; i++)
		{
			for(int j = 0; j<Width; j++)
			{
				grid[i][j] = (int) Math.round( Math.random() );	
			}
		}
	}
	
	public void GliderGun()
	{
		
	}
	
	public void board_state()
	{
		for(int i = 0;i < grid.length; i++)
		{
			System.out.println();
			System.out.print("|");
			for(int j = 0; j<grid[0].length; j++)
			{
				if(grid[i][j] == 1)
				{
				System.out.print("~");	
				}
				else{
					System.out.print("x");
				}
			}
			System.out.print("|");
			
		}
	}
	
	private void assign(int cell,int count,int i,int j) // cell value of the cell , count no. of live neighbor cells , and i and j are its index
	{
		if(cell == 1)
		{
			if(count <= 1)
				gridtemp[i][j] = 0;
			else if(count == 2 || count == 3)
				gridtemp[i][j] = 1;
			else
				gridtemp[i][j] = 0;
		}
		else
		{
			if(count == 3)
				gridtemp[i][j] = 1;
		}
	}
	
	private int neighbors(int i,int j)
	{
		int count = 0;
		
		boolean Left = false;
		boolean Top = false;
		boolean Right = false;
		boolean Bottom = false;
		
		
		if(i == 0)
			Top = true;
		if(j==0)
			Left = true;
		if(i == (grid.length-1))
			Bottom = true;
		if(j == (grid[0].length-1))
			Right = true;
		
		
		if(!Top)
		{
			 if(grid[i-1][j] == 1)
			 count++; 
			 if(!Right && grid[i-1][j+1] == 1)
				 count++;
			 if(!Left && grid[i-1][j-1] == 1)
				 count++;
		}
		if(!Bottom)
		{
			 if(grid[i+1][j] == 1)
				 count++;  
			 if(!Right && grid[i+1][j+1] == 1)
				 count++;
			 if(!Left && grid[i+1][j-1] == 1)
			
				 count++;
		}
		
		if(!Left && grid[i][j-1] ==1)
			count++;
		if(!Right && grid[i][j+1] ==1)
			count++;
		
		/*
		for( int v = i - 1;
        v >= 0 && v < ( i + 2 ) && v < grid.length;
        i++ )  
		{
      for( int k = j - 1;
           k >= 0 && k < ( j + 2 ) && k < grid[ 0 ].length;
           k++ ) {
           		if(grid[v][k] == 1)
           		{
           		count++;
           		}
           }
           }
          */
		/*
		for( int v = i - 1;v >= 0 && v < ( i + 2 ) && v < grid.length;i++ )  
				{
		      		for( int k = j - 1;k >= 0 && k < ( j + 2 ) && k < grid[ 0 ].length;k++ ) 
		      		{
		           		if(grid[v][k] == 1)
		           		{
		           		count++;
		           		}
		           }
		         }
		*/
		return count;
		
		
	}
	
	public void next_state()
	{
		for(int i = 0;i < grid.length;i++)
		{
			for(int j =0;j< grid[0].length; j++)
			{
				 assign(grid[i][j],neighbors(i,j),i,j);
			}
		}
		
		for(int i = 0;i < grid.length;i++)
		{
			for(int j =0;j< grid[0].length; j++)
			{
				 grid[i][j] = gridtemp[i][j];
			}
		}
	}
	
	
}
