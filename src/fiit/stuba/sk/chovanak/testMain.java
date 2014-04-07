package fiit.stuba.sk.chovanak;

import fiit.stuba.sk.chovanak.EXCEPTIONS.ChromeNotGeneratedException;
import fiit.stuba.sk.chovanak.GAME_MODEL.GameMap;
import fiit.stuba.sk.chovanak.GAME_MODEL.Population;
import fiit.stuba.sk.chovanak.GAME_MODEL.PopulationGenerator;
import fiit.stuba.sk.chovanak.GUI.GameView;

public class testMain {

	public static void main(String[] args) throws ChromeNotGeneratedException{
		PopulationGenerator popGenerator = new PopulationGenerator();
		Population initialPopulation = popGenerator.createInitialPopulation(new GameMap(7,7,2));
		
		for(int i = 0 ; i <  initialPopulation.getChromosomes().size(); i++){
			GameView.outputChromosome( initialPopulation.getChromosomes().get(i));
		}
		
		Population lastPop = initialPopulation;
		for(int i = 0; i < 100; i++){
			Population nextPop = popGenerator.crossoverPopulation(lastPop);
			System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<< NEXT POPULATION ");
			for(int j = 0 ; j <  nextPop.getChromosomes().size(); j++){
				GameView.outputChromosome( nextPop.getChromosomes().get(j));
			}
			lastPop = nextPop;	
			System.out.println("crossed");
			
			nextPop = popGenerator.mutatePopulation(lastPop);
			System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<< mutated POPULATION ");
			for(int j = 0 ; j <  nextPop.getChromosomes().size(); j++){
				GameView.outputChromosome( nextPop.getChromosomes().get(j));
			}
			lastPop = nextPop;	
			System.out.println("mutated");
		}
			
		System.out.println("here");
	}
	
}
