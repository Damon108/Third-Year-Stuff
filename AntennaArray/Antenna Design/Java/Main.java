import java.util.Random;

import com.sun.jndi.url.corbaname.corbanameURLContextFactory;

public class Main {
	private AntennaArray array = new AntennaArray(3, 90.0);
	private Random rnd;
	private Particle particle;

	public Main() {
		// particle = new Particle(0, 0, 0);
		rnd = new Random();
		double[] design = new double[3];
		design[0] = 0.5;
		design[1] = 1.0;
		design[2] = 1.5;

		run();
	}

	public void run() {
		// generateSolution();
		// PSOSolution();
		PSOsolution();

	}

	private double[] generateSolution() {

		double value1 = 0;
		double value2 = 0;

		double value3 = 0;

		double[] solution = new double[3];
		boolean works = false;

		double val1 = 0;
		double val2 = 0;

		double val3 = 0;

		do {
			value1 = rnd.nextDouble() * 0.5;
			val1 = value1;
			solution[0] = val1;

			value2 = rnd.nextDouble() * (1.0 - val1) + val1;
			val2 = value2;
			solution[1] = val2;

			value3 = rnd.nextDouble() * (1.5 - val2) + val2;
			val3 = value3;
			solution[2] = 1.5;
			System.out.println(solution[0] + " " + solution[1] + " " + solution[2]);

			if (array.is_valid(solution) == true) {
				works = true;
				System.out.print("		valid solution	: ");
			}

		} while (!works);
		System.out.println(array.evaluate(solution));
		return solution;

	}

	// -Initialisation of the particle values must be random-
	// Velocity is the difference between the pbPos and Cpos halved
	private void ConstructParticle(double velocity, double cPos, double pbPos) {

	}

	/*
	 * private double PSOSolution() { // Represent the problem through an array.
	 * double[] solution = new double[3];
	 * 
	 * // Boolean value initialised to terminate loop boolean bestFound = false;
	 * 
	 * // Initialise Population for particle swarm int population = 3;
	 * 
	 * // Set random position for the particle's current position to a temp //
	 * variable double TcPos = rnd.nextDouble();
	 * 
	 * // Set current Position to equals the temp position double cPos = TcPos;
	 * 
	 * // intialise Personal best Postition to current Position. double pbPos =
	 * cPos;
	 * 
	 * // Initialise velocity double velocity = 0;
	 * 
	 * // Initialise Global best value double globalBest = 0;
	 * 
	 * do {
	 * 
	 * // Update Global Best if (pbPos < globalBest) { globalBest = pbPos; }
	 * 
	 * for (int i = 0; i <= population; i++) { ConstructParticle(velocity, cPos,
	 * pbPos); // Update velocity and Position velocity = (pbPos - cPos) / 2; //
	 * Evaluate new position solution[i] = cPos; if (cPos > pbPos) { // Update
	 * Personal Best pbPos = cPos; } System.out.println("Personal Best is : " +
	 * pbPos); } bestFound = true; } while (!bestFound);
	 * 
	 * System.out.println("Global Best is : " + globalBest); return globalBest;
	 * }
	 * 
	 * private double[] PSOsolution() { // Initialise Population for particle
	 * swarm int population = 3;
	 * 
	 * // Represent the problem through an array. double[] solution1 = new
	 * double[3];
	 * 
	 * // Create an Array of particles Particle[] arrayParticle = new
	 * Particle[population];
	 * 
	 * // Boolean value initialised to terminate loop boolean bestFound = false;
	 * 
	 * // Initialise velocity double velocity = 0;
	 * 
	 * // Initialise Global best value double globalBest = 0;
	 * 
	 * // set Personal best to current best double pbPos = 0; int counter = 0;
	 * do {
	 * 
	 * if (pbPos < globalBest)
	 * 
	 * for (int i = 0; i < population; i++ /* p : arrayParticle ) {
	 * System.out.println(".");
	 * 
	 * // Set random position for the particle's current position // to a //
	 * temp variable double TcPos = rnd.nextDouble();
	 * 
	 * // Set current Position to equals the temp position double cPos = TcPos;
	 * // Check current Position is in feasible region if
	 * (!checkParticlePosition(cPos)) { // reset the current Position if its not
	 * cPos = rnd.nextDouble() * (1.25 - 0.25) + 0.25;
	 * 
	 * } velocity = (cPos - pbPos) / 2;
	 * 
	 * solution1[i] = velocity;
	 * 
	 * if (cPos < pbPos) { pbPos = cPos; }
	 * 
	 * // counter++; solution1[2] = 1.5; System.out.println("particle number " +
	 * i + "solution " + array.evaluate(solution1)); } bestFound = true;
	 * 
	 * } while (!bestFound);
	 * 
	 * return solution1; }
	 * 
	 * 
	 * }
	 */

	public boolean checkParticlePosition(double Cposition) {
		if (Cposition < 0.25 | Cposition > 1.25) {

			return false;
		}
		return true;
	}

	private double PSOsolution() {
		System.out.println("him im gay");
		int population = 3;
		boolean bestFound = false;
		double[] solution = new double[3];
		Particle[] particles = new Particle[population];
		double cPos = 0;
		double pbPos = 0;
		double globalBest = 0;
		double velocity = 0;
		int counter = 0;
		double SSLvalue = 0;
		double temSSLvalue = 0;
		Particle part = new Particle(0, 0, 0);
		double[] SSLValues = new double[population];
		cPos = rnd.nextDouble() * (1.25 - 0.25) + 0.25;
		pbPos = cPos;
		do {
			// update globalBest

			/*
			 * for (int o = 0; o < population; o++) { if (globalBest <
			 * particles[o].getPB()) { globalBest = particles[o].getPB(); } }
			 */

			for (Particle p : particles) {

				// for (int i = 0; i < population; i++) {
				velocity = (cPos - pbPos) / 2;
				// velocity = velocity + (pbPos - cPos) + (globalBest - cPos);
				cPos = cPos + velocity;
				solution[counter] = cPos;
				System.out.println("Position of antenna : " + counter + "   " + cPos);
				solution[2] = 1.5;

				SSLvalue = array.evaluate(solution);

				SSLValues[counter] = SSLvalue;
				System.out.println("Current solution " + SSLvalue);
				// System.out.println(array.evaluate(solution));
				System.out.println(counter);
				if (counter == population - 1) {
					System.out.print("global best : " + globalBest);
				} else
					System.out.println(SSLValues[counter]);
				for (int ah = 0; ah < SSLValues.length - 1; ah++) {
					if (SSLValues[ah] < SSLValues[ah + 1]) {
						System.out.println("lulllll" + SSLValues[ah]);
						System.out.println("lulllll" + SSLValues[ah + 1]);

						part.savePB(cPos);

						particles[counter] = part;
						// System.out.println(cPos);
						pbPos = cPos;
						System.out.println("WORK" + particles[counter].getPB());
						globalBest = getGlobalBest(particles);

					}
				}
				counter++;
			}
			bestFound = true;

		} while (!bestFound);

		return globalBest;
	}

	public double getGlobalBest(Particle[] particles) {
		int length = particles.length;
		double globalBest = 0;

		for (int i = 0; i < particles.length; i++) {
			if (i == length - 1) {
				return globalBest;
			}
			System.out.println("I number " + i);
			if (particles[i].getPB() < particles[i + 1].getPB() && particles[i].getPB() <= particles[0].getPB()) {
				globalBest = particles[i].getPB();
			}
		}
		return globalBest;
	}

	private void PSOsolution2() {
		double[] array = new double[3];
		double cPos = 0;
		double pbPos = 0;
		double globalBest = 0;
		double velocity = 0;
		int population = 3;
		Particle[] particles = new Particle[population];

		for (Particle p : particles) {
			// update velocity and cPos
			velocity = (pbPos - cPos) / 2;
			cPos += velocity;

			// Evaluate new position based on SSLValue
			// if SSLValue < previousSSLValue
			// Set PbPos to cPos
		}
	}

	private void PsoSolution3() {
		double[] array = new double[3];
		double cPos = 0;
		double pbPos = 0;
		double globalBest = 0;
		double velocity = 0;
		int population = 3;
		boolean solutionsFound = false;
		cPos = rnd.nextDouble();
		double randomTempPoint = rnd.nextDouble();
		velocity = (randomTempPoint - cPos) /2;
		do {
			for (int i = 0; i < population; i++) {
				velocity = (pbPos - cPos) / 2;
				cPos = cPos + velocity;
				
				if(cPos )
			}
		} while (solutionsFound == false);
	}
}
