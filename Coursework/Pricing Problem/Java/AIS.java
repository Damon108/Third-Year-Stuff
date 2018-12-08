import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public class AIS {
	private double[] randomPrices;
	private int numberofGoods;
	private PricingProblem f;
	private Random rng;
	private int u;
	private Double temp;
	private double revenue;
	private HashMap<double[], Double> hmap;
	private ArrayList<double[]> solutions;
	private double normalisedFitness;

	public AIS() {
		temp = new Double(revenue);
		hmap = new HashMap<double[], Double>();
		solutions = new ArrayList<double[]>();
		u = 5;
		rng = new Random();
		numberofGoods = 20;
		randomPrices = new double[numberofGoods];

		f = PricingProblem.courseworkInstance();
	}

	public void run() {

		generateRandomPrices();

		for (Map.Entry<double[], Double> me : hmap.entrySet()) {

			System.out.println("Key is at the end" + me.getKey() + " " + "value end: " + me.getValue());
		}
		contigMutate();
		// getBestFitness();
		// createInitialPop();

	}

	public ArrayList<double[]> generateRandomPrices() {
		for (int counter = 0; counter < u; counter++) {
			// solutions = new ArrayList<double[]>();
			randomPrices = new double[numberofGoods];
			System.out.println("Number " + counter);
			for (int i = 0; i < numberofGoods; i++) {

				randomPrices[i] = rng.nextDouble() * 10;
				System.out.println(randomPrices[i]);
			}

			// hmap = new HashMap<double[], Double>();
			revenue = f.evaluate(randomPrices);

			temp = new Double(revenue);
			solutions.add(randomPrices);
			hmap.put(randomPrices, temp);

			// System.out.println("revenue is " + hmap.get(solutions));

		}

		NormaliseFitness();
		clone();
		return solutions;
	}

	private void createInitialPop() {
		for (int i = 0; i < u; i++) {
			ArrayList<double[]> tempS = new ArrayList<double[]>();
			tempS = generateRandomPrices();
			revenue = f.evaluate(randomPrices);
			temp = new Double(revenue);
			// hmap.put((ArrayList<double[]>) tempS.clone(), temp);
		}

		for (double[] key : hmap.keySet()) {

			System.out.println("key " + key);
			System.out.println("value : " + hmap.get(key));

		}

	}

	private double getBestFitness() {
		// Map.Entry<ArrayList<double[]>, Double> entry =
		// hmap.entrySet().iterator().next();
		// normalisedFitness = entry.getValue();
		normalisedFitness = Collections.max(hmap.values());

		System.out.println("best revenue is " + normalisedFitness);
		return normalisedFitness;
	}

	private double[] NormaliseFitness() {
		double[] nF = new double[u];
		int i = 0;
		for (Map.Entry<double[], Double> me : hmap.entrySet()) {
			nF[i] = me.getValue() / getBestFitness();
			// System.out.println("Key is " + me.getKey() + " " + "value : " +
			// me.getValue());
			System.out.println("normalised Fitness " + nF[i]);
			i++;
		}
		return nF;
	}

	public HashMap<double[], Double> clone() {
		HashMap<double[], Double> clone1 = new HashMap<double[], Double>();
		clone1 = hmap;
		for (Map.Entry<double[], Double> me : clone1.entrySet()) {

			System.out.println("clone Key is at the end" + me.getKey() + " " + "clone value end: " + me.getValue());
		}

		return clone1;
	}

	private void contigMutate() {
		ArrayList<HashMap<double[], Double>> clonalPool = new ArrayList<HashMap<double[], Double>>();
		clonalPool = createClonalPool();
		Random rnd = new Random();
		int p = 4;
		// l = -p * NormaliseFitness();
		double mutationRate = 0;
		HashMap<double[], Double> bigBoi = new HashMap<double[], Double>();

		for (HashMap<double[], Double> solutions : clonalPool) {
			int counter = 0;
			// for (ArrayList<double[]> priceSolutions : solutions.keySet()) {

			for (double[] prices : solutions.keySet()) {
				mutationRate = 1 * NormaliseFitness()[counter];
				System.out.println("mutation rate is " + mutationRate);
				double length = numberofGoods * mutationRate;
				System.out.println("lengh is " + length);
				
				for (int i = p; i < length; i++) {

					prices[i] = (prices[i] * mutationRate);
					System.out.println("new prices " + prices[i]);
				}

				double revenue = f.evaluate(prices);
				Double temp = new Double(revenue);
				bigBoi.put(prices, temp);
				// tempPrices = prices;
				counter++;
			}

		}

		// }
		// p = rnd.nextInt(numberofGoods);
		// l = numberofGoods * mutationRate;
	}

	public ArrayList<HashMap<double[], Double>> createClonalPool() {
		int numOfClones = 5;
		ArrayList<HashMap<double[], Double>> clones = new ArrayList<HashMap<double[], Double>>();
		for (int i = 0; i < numOfClones; i++) {
			clones.add(clone());
		}
		return clones;
	}
}
