import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.stream.*;

import com.sun.xml.internal.ws.policy.spi.PolicyAssertionValidator.Fitness;

public class EVO {
//Steps for EVO
	// step1- Data structure for environment--in this case
	double[] prices;
	int numberofGoods;
	// step 2- Data structure for candidate solutions -- which is the evaluated
	// price of all
	// products
	ArrayList<double[]> candidSolution;
	Random rng;
	PricingProblem f;

	public EVO() {
		rng = new Random(0);
		numberofGoods = 20;

		// step 3- Evaluation functuin
		PricingProblem f = PricingProblem.courseworkInstance();

		PricingProblem r = PricingProblem.randomInstance(20);

		prices = new double[numberofGoods];
		candidSolution = new ArrayList<double[]>();

	}

	// Step 4- generate random solutions and add to candidate solutions storage

	public void generateRandomPrices() {
		for (int i = 0; i < prices.length; i++) {
			prices[i] = rng.nextDouble() * 10;

		}
		candidSolution.add(prices);
	}

	// step 5 mutation operator (two opt swap)

	public double[] ParentSelection() {
		double probs = rng.nextDouble();
		double[] tempParent = new double[20];
		double sum = 0;
		double fitProb = 0;
		double sumProbs = 0;
		double[] fitLvls = new double[20];

		double[][] rouletteWheel = new double[candidSolution.size()][1];
		int i = 0;
		for (double[] solutions : candidSolution) {
			double fitLvl = f.evaluate(solutions);
			fitLvls[i] = fitLvl;

			sum += fitLvls[i];
			rouletteWheel[i] = fitLvls;
			i++;
		}
		Arrays.sort(rouletteWheel);
		for (int j = 0; j < 20; j++) {
			
			
			 fitProb = sumProbs +(fitLvls[j]/ sum);
			 sumProbs += fitProb;

			rouletteWheel[j][0] = fitProb;

		}
	
		for (int a = 0; a < rouletteWheel.length; a++) {
			if(a == 0 ) {
				if (probs <= rouletteWheel[a][0] && probs >= rouletteWheel[a][0] -rouletteWheel[a][0] ) {
					tempParent = candidSolution.get(a);
				}
			}
			if (probs <= rouletteWheel[a][0] && probs >= rouletteWheel[a][0] -rouletteWheel[a-1][0] ) {
				tempParent = candidSolution.get(a);
			}
		}
		return tempParent;
	}
}
