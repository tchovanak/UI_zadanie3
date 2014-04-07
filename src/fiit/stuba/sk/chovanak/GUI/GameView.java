package fiit.stuba.sk.chovanak.GUI;


import fiit.stuba.sk.chovanak.GAME_MODEL.Chromosome;
import fiit.stuba.sk.chovanak.GAME_MODEL.GameMap;

/**
 * Trieda zabezpecujuca kontrolu gui
 * @author Tomas
 *
 */
public class GameView {
	
	public static void outputMap(GameMap map) {
		for(int i = 0; i < map.getHeight(); i++){
			for(int j = 0; j < map.getWeight(); j++){
				System.out.printf("%3s", map.getMap()[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void outputChromosome(Chromosome chromosome) {
		System.out.println("CHROMOZOM :");
		System.out.println("\nFITNESS : " + chromosome.getFitness());
		System.out.println("START POSITION : " + chromosome.getStartPosition());
		System.out.println("END POSITION : " + chromosome.getEndPosition());
		System.out.println("MAP : \n");
		outputMap(chromosome.getMap());
	}
	
	
}
