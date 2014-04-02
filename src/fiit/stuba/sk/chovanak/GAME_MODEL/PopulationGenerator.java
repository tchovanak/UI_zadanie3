package fiit.stuba.sk.chovanak.GAME_MODEL;

public class PopulationGenerator {
	
	
	public Population createInitialPopulation(){
		
		PopulationBuilder popBuilder = new PopulationBuilder();
		ChromosomeGenerator chromGen = new ChromosomeGenerator();
		
		popBuilder.add(chromGen.generateChrom(chrom1,chrom2));
		
		
	}
	
}
