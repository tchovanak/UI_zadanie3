package fiit.stuba.sk.chovanak.GAME_MODEL;

public class GameMap {

	private MapEntity[][] map;
	
	private int height;
	
	private int weight;
	
	public GameMap(int height, int weight, int numOfStones){
		map = generateMap(height,weight,numOfStones);	
		this.height = height;
		this.weight = weight;
	}

	private MapEntity[][] generateMap(int height, int weight, int maxNumOfStones) {
		
		MapEntity[][] ret = new MapEntity[height][weight];

		for(int i = 0; i < height; i++){
			for(int j = 0; j < weight; j++){
				ret[i][j] = MapEntity.N;
			}
		}
		
		for(int i = 0; i < maxNumOfStones; i++){
		
			int h = (int) (Math.random() * height);
			int w = (int) (Math.random() * weight);			
			ret[h][w] = MapEntity.S;
		
		}
		
		return ret;
	
	}

	public MapEntity[][] getMap() {
		return map;
	}

	public int getHeight() {
		return height;
	}

	public int getWeight() {
		return weight;
	}
	
	
}
