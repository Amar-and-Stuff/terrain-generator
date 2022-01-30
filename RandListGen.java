package terrainbuilder;
import java.util.Random;
import java.util.ArrayList;

public class RandListGen {
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
