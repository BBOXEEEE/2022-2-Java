import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2022년도 2학기
 * @author 김상진 
 * QueueTest.java
 * 최대 면적 섬 찾기. Queue를 이용한 BFS
 */
public class QueueTest {
	private static record Location(int r, int c){
		static int width;
		static int height;
		public boolean isValid() {
			return r>=0&&r<height&&c>=0&&c<width;
		}
	}
	private static int[][] d = {{0,-1},{-1,0},{0,1},{1,0}};
	private static int computeArea(int r, int c, int[][] grid){
		Location.height = grid.length;
		Location.width = grid[0].length;
		int size = 0;
		Queue<Location> queue = new ArrayDeque<>(Location.height*Location.width/2);
		//Queue<Location> queue = new LinkedList<>();
		queue.add(new Location(r,c));
		while(!queue.isEmpty()){
			Location curr = queue.poll();
			++size;
			for(int i=0; i<d.length; ++i) {
				Location next = new Location(curr.r+d[i][0], curr.c+d[i][1]);
				if(next.isValid()&&grid[next.r][next.c]==1){ 
					queue.add(next);
					grid[next.r][next.c] = 0;
				}
			}
		}   
		return size;
	}
	public static int maxAreaOfIsland(int[][] grid) {
		int maxArea = 0;
		for(int r=0; r<grid.length; r++)
			for(int c=0; c<grid[r].length; c++)
				if(grid[r][c]==1){
					grid[r][c]=0;
					int area = computeArea(r,c,grid);
					maxArea = Math.max(area, maxArea);
				}
		return maxArea;
	}
	public static void maxAreaOfIsland_test() {
		int[][] map = {	
			{0,0,1,0,0,0,0,1,0,0,0,0,0},
			{0,0,0,0,0,0,0,1,1,1,0,0,0},
			{0,1,1,0,1,0,0,0,0,0,0,0,0},
		 	{0,1,0,0,1,1,0,0,1,0,1,0,0},
		 	{0,1,0,0,1,1,0,0,1,1,1,0,0},
		 	{0,0,0,0,0,0,0,0,0,0,1,0,0},
		 	{0,0,0,0,0,0,0,1,1,1,0,0,0},
		 	{0,0,0,0,0,0,0,1,1,0,0,0,0}	
		};
		System.out.println(maxAreaOfIsland(map));
		map = new int[][]{	
			{1,1,1,1,1,1,1,1,0,0,0,0,0},
			{0,0,0,0,0,0,0,1,1,1,0,0,0},
			{0,1,1,0,1,0,0,0,0,0,0,0,0},
			{0,1,0,0,1,1,0,0,1,0,1,0,0},
			{0,1,0,0,1,1,0,0,1,1,1,0,0},
			{0,0,0,0,0,0,0,0,0,0,1,0,0},
			{1,1,0,0,0,0,0,1,1,1,0,0,0},
			{1,1,0,0,0,0,0,1,1,0,0,0,0}	
		};
		System.out.println(maxAreaOfIsland(map));
	}
	public static void main(String[] args) {
		maxAreaOfIsland_test();
	}
}
