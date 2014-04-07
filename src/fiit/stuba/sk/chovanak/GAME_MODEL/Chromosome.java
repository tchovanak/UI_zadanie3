package fiit.stuba.sk.chovanak.GAME_MODEL;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

enum Direction {
	right,left,down,up
}

public class Chromosome {
	
	private static int TRIES_LIMIT;
	
	//private GameMap map;
	private GameMap map;
	private List<Gene> genes = new ArrayList<Gene>();
	private String[][] mapArray;
	private int weight;
	private int height;
	private Direction direction;
	private Random rand = new Random();
	private int startPosition;
	private int endPosition;
	private int fitness = 0;
	private int populationNum = 1;
	
	// premenne udavajuce aktualnu poziciu na mape
	private int h_akt;
	private int w_akt;

	
	public Chromosome(GameMap map) {
		// vytvori kopiu mapy
		this.map = new GameMap(map);
		this.weight = map.getWeight();
		this.height = map.getHeight();
		TRIES_LIMIT = weight * height;
		this.mapArray = this.map.getMap();		

	}
	
	public Chromosome(Chromosome parent) {
		// vytvori kopiu mapy
		this.map = new GameMap(parent.getMap());
		this.weight = parent.getMap().getWeight();
		this.height = parent.getMap().getHeight();
		this.fitness = parent.getFitness();
		TRIES_LIMIT = weight * height - parent.getFitness();
		this.mapArray = this.map.getMap();
		this.populationNum = parent.getPopulationNum() + 1;
	}

	public boolean goFrom(int from) {
		
		startPosition = from;
		
		int h;
		int w;
		
		if(from < weight){
			h = 0;
			w = from;
			direction = Direction.down;
		}else if (from < weight + height ){
			h = from - weight;
			w = weight - 1;
			direction = Direction.left;
		}else if (from < weight + height + weight){
			h = height -1;
			w = weight - ( from - height - weight) - 1;
			direction = Direction.up;
		}else{
			h = (2*weight + 2*height) - from - 1;
			w = 0;
			direction = Direction.right;
		}
		
		h_akt = h;
		w_akt = w;
		
		if(!mapArray[h_akt][w_akt].equals("0")){
			return false;
		}
		
		for(int i = 0; i < TRIES_LIMIT; i++){
			
			if(step()){
				//System.out.println(startPosition + " " + endPosition);
				if(startPosition == endPosition){
					return false;
				}
				return true;
			}
		}
		
		
		
		return false;
		
	}
	
	
	private boolean step(){
	
		if(direction == Direction.down){
			
			if(h_akt != (height - 1) && mapArray[h_akt + 1][w_akt] == "0"){
				mapArray[h_akt][w_akt] = new String(String.valueOf(populationNum));
				h_akt = h_akt + 1;
				fitness++;
			}else if (h_akt == (height - 1) && mapArray[h_akt][w_akt] == "0"){
				mapArray[h_akt][w_akt] = new String(String.valueOf(populationNum));
				fitness++;
				calculateEndPosition();
				return true;
			}else{
				// som zablokovany... zmen smer
				if(rand.nextBoolean()){
					direction = Direction.left;
				}else{
					direction = Direction.right;
				}
			}
			
		}else if(direction == Direction.up){
			
			if(h_akt != 0 && mapArray[h_akt - 1][w_akt] == "0"){
				mapArray[h_akt][w_akt] = new String(String.valueOf(populationNum));
				h_akt = h_akt - 1;
				fitness++;
			}else if (h_akt == 0 && mapArray[h_akt][w_akt] == "0"){
				mapArray[h_akt][w_akt] = new String(String.valueOf(populationNum));
				fitness++;
				calculateEndPosition();
				return true;
			}else{
				// som zablokovany... zmen smer
				if(rand.nextBoolean()){
					direction = Direction.left;
				}else{
					direction = Direction.right;
				}
			}
			
		}else if(direction == Direction.left){
			
			if(w_akt != 0 && mapArray[h_akt][w_akt - 1] == "0"){
				mapArray[h_akt][w_akt] = new String(String.valueOf(populationNum));
				w_akt = w_akt - 1;
				fitness++;
			}else if (w_akt == 0 && mapArray[h_akt][w_akt] == "0"){
				mapArray[h_akt][w_akt] = new String(String.valueOf(populationNum));
				fitness++;
				calculateEndPosition();
				return true;
			}else{
				// som zablokovany... zmen smer
				if(rand.nextBoolean()){
					direction = Direction.up;
				}else{
					direction = Direction.down;
				}
			}
			
		}else if(direction == Direction.right){
			
			if(w_akt != (weight - 1) && mapArray[h_akt][w_akt + 1] == "0"){
				mapArray[h_akt][w_akt] = new String(String.valueOf(populationNum));
				w_akt = w_akt + 1;
				fitness++;
			}else if (w_akt == (weight - 1) && mapArray[h_akt][w_akt] == "0"){
				mapArray[h_akt][w_akt] = new String(String.valueOf(populationNum));
				fitness++;
				calculateEndPosition();
				return true;
			}else{
				// som zablokovany... zmen smer
				if(rand.nextBoolean()){
					direction = Direction.up;
				}else{
					direction = Direction.down;
				}
			}
			
		}
		
		return false;
	}

	private void calculateEndPosition() {
		if(w_akt == 0 && h_akt != 0){
			endPosition = (2*weight + 2*height) - w_akt - 1;
		}else if(w_akt == (weight - 1) && h_akt != 0){
			endPosition = (weight + h_akt);
		}else if(h_akt == 0){
			endPosition = w_akt;
		}else if(h_akt == (height - 1)){
			endPosition = (2*weight + 2*height) - height - w_akt;
		}
		
	}

	public GameMap getMap() {
		return map;
	}

	public int getEndPosition() {
		return endPosition;
	}

	public int getFitness() {
		return fitness;
	}

	public int getStartPosition() {
		return startPosition;
	}

	public int getPopulationNum() {
		return populationNum;
	}


	public Chromosome crossover(Chromosome parent2) {
		Chromosome child = new Chromosome(this);
		boolean success = false;
		if(!(success = child.goFrom(parent2.startPosition))){
			success = child.goFrom(parent2.endPosition);
		}
		
		if(success){
			return child;
		}else{
			return null;
		}
		
	}

	public void mutate() {
		Chromosome child = new Chromosome(this);

		this.populationNum++;
		int from = rand.nextInt(2*height + 2*weight);
		if(!child.goFrom(from)){
			this.populationNum--;
		}else{
			this.map = child.getMap();
			this.fitness = child.getFitness();
			TRIES_LIMIT = weight * height - child.getFitness();
			this.mapArray = this.map.getMap();
		}
	}

	
	

}
