package fiit.stuba.sk.chovanak.GAME_MODEL;

import java.util.Random;

import fiit.stuba.sk.chovanak.EXCEPTIONS.ChromeNotGeneratedException;

public class ChromosomeGenerator {

	private static final int NUM_OF_TRIES_ON_CHROM = 20;
	private static final int NUM_OF_TRIES_ON_MAP = 20;
	
	private boolean[] possibleStarts;
	private int numOfPossibleStarts;
	
	public Chromosome generateInitialChrom(GameMap map) throws ChromeNotGeneratedException {
		
		numOfPossibleStarts = 2*map.getHeight() + 2*map.getWeight();		
		possibleStarts = new boolean[numOfPossibleStarts];
				
		for(int i = 0; i < numOfPossibleStarts; i++){
			possibleStarts[i] = true;
		}
		
		Chromosome chrom;
		boolean success;
		
		for(int i = 0; i < NUM_OF_TRIES_ON_MAP; i++){	
			
			chrom = new Chromosome(map);
		
			Random rand = new Random();
		
			// vyberie vhodne startovacie pole
			int from;
			do{
				from = rand.nextInt(numOfPossibleStarts);
			}while(possibleStarts[from] == false);
			
			possibleStarts[from] = false;
			
			//skusa 
			for(int j = 0; j < NUM_OF_TRIES_ON_CHROM; j++){
				success = chrom.goFrom(from);
				if(success){
					// zaznacim si ze na tejto pozicii som skoncil a teda nebudem moct odtialto uz zacat
					possibleStarts[chrom.getEndPosition()] = false;
					return chrom;
				}
			}
			
		}
		
		throw new ChromeNotGeneratedException();		
	}

}
