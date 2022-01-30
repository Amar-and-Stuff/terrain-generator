package terrainbuilder;

public class Level {
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
