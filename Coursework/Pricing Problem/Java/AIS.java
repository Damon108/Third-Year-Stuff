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
	private HashMap<ArrayList<double[]>, Double> hmap;
	private ArrayList<double[]> solutions;
	private double normalisedFitness;

	public AIS() {
		temp = new Double(revenue);
		hmap = new HashMap<ArrayList<double[]>, Double>();
		solutions = new ArrayList<double[]>();
		u = 5;
		rng = new Random();
		numberofGoods = 20;
		randomPrices = new double[numberofGoods];

		f = PricingProblem.courseworkInstance();
	}

	public void run() {

		generateRandomPrices();

		for (Map.Entry<ArrayList<double[]>, Double> me : hmap.entrySet()) {

			System.out.println("Key is " + me.getKey() + " " + "value : " + me.getValue());
		}
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

			// hmap = new HashMap<ArrayList<double[]>, Double>();
			revenue = f.evaluate(randomPrices);

			temp = new Double(revenue);
			solutions.add(randomPrices);
			hmap.put(solutions, temp);

			// System.out.println("revenue is " + hmap.get(solutions));

		}

		getBestFitness();
		return solutions;
	}

	private void createInitialPop() {
		for (int i = 0; i < u; i++) {
			ArrayList<double[]> tempS = new ArrayList<double[]>();
			tempS = generateRandomPrices();
			revenue = f.evaluate(randomPrices);
			temp = new Double(revenue);
			hmap.put((ArrayList<double[]>) tempS.clone(), temp);
		}

		for (ArrayList<double[]> key : hmap.keySet()) {

			System.out.println("key " + key);
			System.out.println("value : " + hmap.get(key));

		}

	}

	private double getBestFitness() {
	//	Map.Entry<ArrayList<double[]>, Double> entry = hmap.entrySet().iterator().next();
		// normalisedFitness = entry.getValue();
		normalisedFitness = Collections.max(hmap.values());

		
		System.out.println("best revenue is " + normalisedFitness);
		return normalisedFitness;
	}
	
	private void NormaliseFitness(){
		double[] nF = new double[u];
		
	}
}
