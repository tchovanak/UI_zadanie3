package fiit.stuba.sk.chovanak.GAME_MODEL;

import java.util.ArrayList;
import java.util.List;

public class Population {

	public static final int POPULATION_LIMIT = 10;
	
	private List<Chromosome> chromosomes = new ArrayList<Chromosome>();
	
	private int populationNumber = 1;
	
	public Population(int num){
		populationNumber = num;
	}
	
	public void add(Chromosome c){
		if(chromosomes.size() < POPULATION_LIMIT){
			chromosomes.add(c);
		}
	}

	public List<Chromosome> getChromosomes() {
		return chromosomes;
	}

	public int getPopulationNumber() {
		return populationNumber;
	}
	
}
