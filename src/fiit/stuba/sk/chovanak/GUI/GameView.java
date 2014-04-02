package fiit.stuba.sk.chovanak.GUI;


import fiit.stuba.sk.chovanak.GAME_MODEL.GameMap;

/**
 * Trieda zabezpecujuca kontrolu gui
 * @author Tomas
 *
 */
public class GameView {
	
	public void outputMap(GameMap map) {
		for(int i = 0; i < map.getHeight(); i++){
			for(int j = 0; j < map.getWeight(); j++){
				System.out.print(map.getMap()[i][j]);
			}
			System.out.println();
		}
		
	}
	
	
}
