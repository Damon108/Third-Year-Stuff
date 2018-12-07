import java.util.Random;

public class PSO {
	private double[] globalbestPrices;
	private double globalBest;

	private double[] prices;
	int numberofGoods;
	private Random rng;
	PricingProblem f;

	public void run() {

		PSOsolution();
	}

	public PSO() {
		numberofGoods = 20;
		rng = new Random();
		f = PricingProblem.courseworkInstance();
		prices = new double[numberofGoods];
	}

	public double[] generateRandomPrices() {
		for (int i = 0; i < prices.length; i++) {
			prices[i] = rng.nextDouble() * 10;

		}
		return prices;
	}

	private void PSOsolution() {
		int population = 50;
		Random rnd = new Random();
		int iter_max = 200;
		double bestRevenue = 0;
		double revenue = 0;
		double[] velocity = new double[prices.length];
		double[] cPrices = new double[prices.length];
		double[] pbPrices = new double[prices.length];
		double[] tempPrices = new double[prices.length];

		Particle swarm[] = new Particle[population];

		for (int i = 0; i < swarm.length; i++) {
			cPrices = generateRandomPrices();
			tempPrices = generateRandomPrices();
			pbPrices = cPrices;

			for (int h = 0; h < prices.length; h++) {

				velocity[h] = (cPrices[h] - tempPrices[h]) / 2;
			}
			revenue = f.evaluate(cPrices);
			// System.out.println(SSLValue);

			System.out.println("original revenue " + revenue);

			swarm[i] = new Particle(velocity, cPrices, pbPrices, revenue);
		
			if (bestRevenue < swarm[i].getRevenue()) {

				bestRevenue = swarm[i].getRevenue();
				globalbestPrices =  swarm[i].getPB().clone();
				System.out.println("new best revenue Found`" + bestRevenue);
			}
		}
		//}
		
		//bestRevenue = swarm[0].getRevenue();
		//globalbestPrices = swarm[0].getcPrices();
	//	System.out.println("china " + bestRevenue);

		for (int counter = 0; counter < iter_max; counter++) {
			System.out.println("global best revenue is " + bestRevenue);
			/*for (Particle pies : swarm) {
				if (bestRevenue < pies.getRevenue()) {

					bestRevenue = pies.getRevenue();
					globalbestPrices = pies.getPB();
					System.out.println("new best revenue Found`" + bestRevenue);
				}
			}*/
			
			for (Particle particles : swarm) {
				velocity = new double[prices.length];
				for (int p = 0; p < velocity.length; p++) {
					
			
					velocity[p] = 0.721 * particles.getVelocity()[p]
							+ 1.1193 * rnd.nextDouble()
									* (particles.getPB()[p] - particles.getcPrices()[p] /* cPos[p] */)
							+ 1.1193 * rnd.nextDouble() * (globalbestPrices[p] - particles.getcPrices()[p]);

					
					//particles.setVelocity(velocity);
					cPrices[p] = particles.getcPrices()[p] +  velocity[p];

				}

				// cPos =cPos;
				//particles.savecPrices(cPrices);
				// System.out.println("nope" + f.evaluate(cPrices));
			//particles.setVelocity(velocity);
				prices = particles.getcPrices();
				double tempRev = 0;

				if (f.is_valid(particles.getcPrices())) {
					particles.savecPrices(cPrices);
					particles.setVelocity(velocity);
					tempRev = f.evaluate(particles.getcPrices());

					System.out.println("current revenue " + particles.getRevenue());

					if (tempRev > particles.getRevenue()) {
						System.out.println("new personal best found ");
						System.out.println("|||||||||||||||||||||" + tempRev);
						particles.savePB(cPrices);
						particles.saveRevenue(tempRev);
						// }
if(tempRev > bestRevenue) {
	bestRevenue = tempRev;
	globalbestPrices =  particles.getcPrices().clone();
	System.out.println("new global best found " + tempRev);
}
					}

				}
				System.out.println("NOOOOOOOOOOOOOOOOOOOOO");
			}

		}
		int poo = 0;
		for (Particle pies : swarm) {
			double pieSSL = pies.getRevenue();
			System.out.println("ALL rebenue " + " " + poo + " " + pieSSL);
			poo++;
		}
		for(int l = 0 ; l < prices.length; l++) {
			System.out.println(	globalbestPrices[l]);
		}
		System.out.println("india " + bestRevenue);

	}

}
