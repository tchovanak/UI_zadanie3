package fiit.stuba.sk.chovanak.GAME_MODEL;

import fiit.stuba.sk.chovanak.EXCEPTIONS.ChromeNotGeneratedException;
import fiit.stuba.sk.chovanak.UTIL.RandomSelector;

public class PopulationGenerator {
	
	
	public Population createInitialPopulation(GameMap map) throws ChromeNotGeneratedException{
		
		ChromosomeGenerator chromGen = new ChromosomeGenerator();
		Population pop = new Population(0);
		
		for(int i = 0 ; i < Population.POPULATION_LIMIT ;i++){
			pop.add(chromGen.generateInitialChrom(map));
		}
		
		return pop;
		
	}

	public Population crossoverPopulation(Population parentsPop) {
		
		Population newPop = new Population(1);
		for(int i = 0; i < Population.POPULATION_LIMIT; i++){
			
			Chromosome child = null;
			
			//do{
				// CHOOSE parents...
				RandomSelector randWithProb = new RandomSelector(parentsPop);
				Chromosome parent1 = randWithProb.getRandom();
				Chromosome parent2;
				//do{
					parent2 = randWithProb.getRandom();
				//}while(parent1 == parent2);
				
				// CROSSOVER
				if(parent2 != parent1){
					child = parent1.crossover(parent2);
				}
				
				
			//}while(child == null);
			if(child != null){
				newPop.add(child);
			}else{
				newPop.add(parent1);
			}
		}
		
		return newPop;
	}

	public Population mutatePopulation(Population lastPop) {
		
		Population newPop = new Population(1);
		for(int i = 0; i < Population.POPULATION_LIMIT; i++){			
			
			lastPop.getChromosomes().get(i).mutate();
			newPop.add(lastPop.getChromosomes().get(i));
			
		}
		
		return newPop;
	}
	
}
