package terrainbuilder;
import terrainbuilder.Level;
import terrainbuilder.RandListGen;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
public class TerrainBuilder {
	public static void main(String a[]) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter width of terrain : ");
		int widthOfTerrain = sc.nextInt();
		RandListGen r = new RandListGen(widthOfTerrain);
		int ter[] = r.giveList();
		int maxheight = 0,maxdepth = 0,sum=0;
		for(int i : ter) {
			sum+=i;
			if(maxheight<sum) {
				maxheight = sum;
			}
			if(maxdepth>sum) {
				maxdepth = sum;
			}
		}
		int nlevels = maxheight-maxdepth;
		ArrayList<Level> levels = new ArrayList<Level>();
		for(int i = 0;i<=nlevels;i++)
		levels.add(new Level(ter.length));
		int currentlevel = maxheight;
		for(int i = 0;i<ter.length;i++) {
			if(ter[i]==1) {
				levels.get(currentlevel).make(i, '/');
				currentlevel--;
			}
			else if(ter[i]==0) {
				levels.get(currentlevel).make(i, '_');
			}
			else if(ter[i]==-1) {
				currentlevel++;
				levels.get(currentlevel).make(i,'\\');
			}
		}
		Iterator<Level> it = levels.iterator();
		while(it.hasNext())
		System.out.println(it.next().levelcore);
	}
}
