package fiit.stuba.sk.chovanak;

import fiit.stuba.sk.chovanak.GAME_MODEL.GameMap;
import fiit.stuba.sk.chovanak.GUI.GameView;

public class testMain {

	public static void main(String[] args){
		GameMap map = new GameMap(5,10,5);
		GameView view = new GameView();
		view.outputMap(map);
	}
	
}
