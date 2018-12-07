import java.util.Random;

public class AIS {
	double[] randomPrices;
	int numberofGoods;
	PricingProblem f;
	Random rng;

	public AIS() {
		rng = new Random();
		numberofGoods = 20;
		randomPrices = new double[numberofGoods];

		f = PricingProblem.courseworkInstance();
	}

	public void run() {
		
	}
	public double[] generateRandomPrices() {
		for (int i = 0; i < randomPrices.length; i++) {
			randomPrices[i] = rng.nextDouble() * 10;

		}
		return randomPrices;
	}
}
