package fiit.stuba.sk.chovanak.GAME_MODEL;

public class GameMap {

	private String[][] map;
	
	private int height;
	
	private int weight;
	
	public GameMap(int height, int weight, int numOfStones){
		map = generateMap(height,weight,numOfStones);	
		this.height = height;
		this.weight = weight;
	}

	
	/**
	 * vytvori kopiu mapy
	 * @param map2
	 */
	public GameMap(GameMap map2) {
		
		String[][] mapToCopy = map2.getMap();
		this.map = new String[map2.getHeight()][map2.getWeight()];
		this.height = map2.getHeight();
		this.weight = map2.getWeight();
		
		for(int i = 0; i < map2.getHeight(); i++){
			for(int j = 0; j < map2.getWeight();j++){
				this.map[i][j] = mapToCopy[i][j];
			}
		}
		
	}

	private String[][] generateMap(int height, int weight, int maxNumOfStones) {
		
		String[][] ret = new String[height][weight];

		for(int i = 0; i < height; i++){
			for(int j = 0; j < weight; j++){
				ret[i][j] = "0";
			}
		}
		
		for(int i = 0; i < maxNumOfStones; i++){
		
			int h = (int) (Math.random() * height);
			int w = (int) (Math.random() * weight);			
			ret[h][w] = "S";
		
		}
		
		return ret;
	
	}

	public String[][] getMap() {
		return map;
	}

	public int getHeight() {
		return height;
	}

	public int getWeight() {
		return weight;
	}
	
	
}
