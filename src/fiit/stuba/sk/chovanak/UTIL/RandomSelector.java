package fiit.stuba.sk.chovanak.UTIL;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fiit.stuba.sk.chovanak.GAME_MODEL.Chromosome;
import fiit.stuba.sk.chovanak.GAME_MODEL.Population;

public class RandomSelector {
	    List<Chromosome> items = new ArrayList<Chromosome>();
	    Random rand = new Random();
	    private int totalSum = 0;

	    public RandomSelector(Population pop) {
	       items = pop.getChromosomes();
	    	for(Chromosome item : items) {
	            totalSum = totalSum + item.getFitness();
	        }
	    }
	    
	    public Chromosome getRandom() {

	        int index = rand.nextInt(totalSum);
	        int sum = 0;
	        int i=0;
	        while(sum < index ) {
	             sum = sum + items.get(i++).getFitness();
	        }
	        if(i != 0){
	        	return items.get(i - 1);
	        } else{
	        	return items.get(0);
	        }
	       
	    }
}
