import java.util.Iterator;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;


class Level {
	int len;
	StringBuffer levelcore = new StringBuffer();
	Level(int l){
		len=l;
		for(int i = 0;i<len;i++) {
			levelcore.append(" ");
		}
	}
	void make(int position,char piece) {
		levelcore.setCharAt(position, piece);
	}
	
	
}
class RandListGen {
	int n;
	public RandListGen(int number){
        n = number;
	}
	public int[] giveList() {
		Random rng = new Random();
        int a[] = {-1,0,1};
        int arr[] = new int[n];
		for(int i = 0;i<n;i++) {
			arr[i]=a[rng.nextInt(3)];
		}
		return arr;
	}
}
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
