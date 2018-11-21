import java.util.Arrays;
import java.util.Random;

public class Main {
	private AntennaArray array = new AntennaArray(4, 90.0);
	private Random rnd;
	private Particle particle;

	public Main() {
		// particle = new Particle(0, 0, 0);
		rnd = new Random();
		double[] design = new double[10];
		design[0] = 0.5;
		design[1] = 1.0;
		design[2] = 1.5;

		run();
	}

	public void run() {
		// generateSolution();
		// PSOSolution();

		// PSOsolution();
		// PsoSolution3();
		//
		// PSOsolution4();
		// PsoSolution5();
		PSOsolution6();

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
	private Particle ConstructParticle(double velocity, double cPos, double pbPos, double SSLValue) {
		Particle particle = new Particle(velocity, cPos, pbPos, SSLValue);
		return particle;
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
		Particle part = new Particle(0, 0, 0, 0);
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
						// globalBest = getGlobalBest(particles);

					}
				}
				counter++;
			}
			bestFound = true;

		} while (!bestFound);

		return globalBest;
	}

	public int getGlobalBestIndex(double[] personalBests) {
		int index = 0;
		double globalBest = personalBests[0];

		for (int i = 0; i < personalBests.length; i++) {
			// System.out.println("SSL Values : " + i + " " + personalBests[i]);
			if (personalBests[i] < globalBest) {
				globalBest = personalBests[i];
				index = i;
			}
		}

		return index;
	}

	public double getLowestSSL(double[] SSLValues) {

		double lowestVal = SSLValues[0];

		// Arrays.sort(SSLValues);

		Arrays.sort(SSLValues);

		for (int i = 0; i < SSLValues.length; i++) {
			// System.out.println("SSL Values : " + i + " " + personalBests[i]);
			if (SSLValues[i] < lowestVal && SSLValues[i] != 0) {
				lowestVal = SSLValues[i];

			}
		}

		return lowestVal;
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
		double[] antArray = new double[3];
		double SSLValue = 0;
		double[] SSLValues = new double[3];
		double[] pb = new double[3];
		double cPos = 0;
		double pbPos = 0;
		double globalBest = 0;
		double velocity = 0;
		int population = 3;
		Particle[] particles = new Particle[population];
		boolean solutionsFound = false;
		cPos = rnd.nextDouble() * (1.25 - 0.25) + 0.25;

		double randomTempPoint = rnd.nextDouble() * (1.25 - 0.25) + 0.25;
		velocity = (randomTempPoint - cPos) / 2;
		pbPos = cPos;
		pb[0] = pbPos;
		do {
			// globalBest = getGlobalBest(pb);

			for (int i = 0; i < population; i++) {

				int r1 = rnd.nextInt(2);
				int r2 = rnd.nextInt(2);

				System.out.println("i index is ------------" + i);
				double cogAttrac1 = pbPos - cPos;
				double cogAttrac2 = globalBest - cPos;

				velocity = 0.721 * velocity + cogAttrac1 * r1 * (pbPos - cPos) + cogAttrac2 * r2 * (globalBest - cPos);

				cPos = cPos + velocity;

				if (!checkParticlePosition(cPos)) {
					System.out.println("INVALID REGION REDO	" + cPos);
					cPos = rnd.nextDouble() * (1.25 - 0.25) + 0.25;
					System.out.println("VALID REGION REGENERATED...	" + cPos);

				}

				System.out.println("Position generated : " + cPos);
				antArray[i] = cPos;
				// antArray[1] = cPos+= velocity;
				antArray[2] = 1.5;

				System.out.println("Current Solution WTGF" + SSLValue + "\n");
				SSLValue = array.evaluate(antArray);

				SSLValues[i] = SSLValue;

				// SSLValues[2] = 3.25;

				System.out.println("Current Solution " + SSLValue + "\n");

				for (int j = 0; j < SSLValues.length - 1; j++) {

					// if (j == 2) {

					// System.out.println("Do something");
					// } else {

					if (SSLValues[j] < SSLValues[j + 1]) {
						// System.out.println("J index " + j);
						// System.out.println("J+1 index " + j + 1);

						pbPos = cPos;

						pb[i] = pbPos;
						System.out.println("PB------------	" + pb[i]);
					} else {
						pb[i] = pbPos;
					}
					// System.out.println(SSLValue);
					System.out.println("SSL------------	" + SSLValues[0] + " " + SSLValues[1] + "  " + SSLValues[2]);
					System.out.println("PB------------	" + pb[0] + " " + pb[1] + " " + pb[2]);

					// globalBest = getGlobalBest(pb[index]);

				}

				//
				System.out.println("Gbest " + globalBest);
				System.out.println("PARTICLE------------------");

			}

			int index = getGlobalBestIndex(SSLValues);

			System.out.println("Global best is " + pb[index]);
			solutionsFound = true;
		} while (solutionsFound == false);
		System.out.println("OverallGbest " + globalBest);
	}

	// getGlobalBestIndex(SSLValues);
	// globalBest = particles[index].getPB();
	// SSLLoop(SSLValues);
	// globalBest = particles[index].getPB();
	// getGlobalBestIndex(SSLValues);
	// System.out.println("GBEST IS : " + globalBest);

	public double getGlobalBest(Particle[] particles) {
		double lowestVal = particles[0].getPB();
		for (int i = 0; i < particles.length; i++) {
			if (particles[i].getPB() < lowestVal) {
				lowestVal = particles[i].getPB();
			}
		}
		System.out.print(lowestVal);
		return lowestVal;
	}

	private double PsoSolution5() {
		System.out.println("DIGIMON");

		boolean bestSolutionFound = false;
		double cPos = rnd.nextDouble() * (1.25 - 0.25) + 0.25;
		double TempPoint = rnd.nextDouble() * (1.25 - 0.25) + 0.25;
		double globalBest = 0;

		int population = 20;
		int iter_max = 100;

		double[] antArray = new double[3];
		Particle[] particles = new Particle[population];
		double[] SSLValues = new double[population];
		double SSLValue = 0;

		double pbPos = 0;
		double velocity = 0;
		antArray[0] = cPos;
		double globalBestSSL = 100;
		int counter = 0;
		boolean works = false;

		for (int i = 0; i < population; i++) {
			particles[i] = ConstructParticle(velocity, cPos, pbPos, SSLValue);

		}

		globalBest = particles[0].getPB();

		while (counter < iter_max) {

			if (counter == population) {
				for (int something = 0; something < particles.length; something++) {
					System.out.println("Particles SSL		" + particles[something].getSSLValue() + "	"
							+ "Particles velocity		" + particles[something].getVelocity());
					System.out.println("GLOBAL BEST SSL " + globalBestSSL);
				}

				System.out.println("global best is : " + globalBest);
				return globalBest;
			}

			for (Particle p : particles) {
				cPos = rnd.nextDouble() * (1.25 - 0.25) + 0.25;
				TempPoint = rnd.nextDouble() * (1.25 - 0.25) + 0.25;
				velocity = (TempPoint - cPos) / 2;
				pbPos = cPos;
				p.setVelocity(velocity);
				p.savePB(cPos);
				p.savecPos(cPos);
				antArray[0] = cPos;

				int r1 = rnd.nextInt(2);
				int r2 = rnd.nextInt(2);
				// globalBest = p.getPB();
				velocity = 0.721 * p.getVelocity() + 1.1193 * rnd.nextDouble() * (p.getPB() - p.getcPos())
						+ 1.1193 * rnd.nextDouble() * (globalBest - p.getcPos());

				cPos = cPos + velocity;
				// p.savecPos(cPos);
				// p.savePB(pbPos);
				double r3 = rnd.nextDouble();
				if (cPos < 0.25 || cPos > 1.25 || cPos < antArray[0] + 0.25 || cPos > antArray[0] - 0.25) {
					do {
						r3 = rnd.nextDouble();
						double r4 = rnd.nextDouble();
						double cPos1 = (r3 * ((antArray[0] - 0.25) - 0.25) + 0.25) + velocity;

						double cPos2 = (r3 * (1.25 - (antArray[0] + 0.25)) + (antArray[0] + 0.25)) + velocity;

						r1 = rnd.nextInt(2);
						r2 = rnd.nextInt(2);

						if (cPos1 > 0.25 && cPos < antArray[0] - 0.25) {
							cPos = cPos1;
							works = true;
							// cPos =cPos1;
						} else if (cPos2 < 1.25 && cPos2 > antArray[0] + 0.25) {
							cPos = cPos2;
							works = true;

						} else {
							System.out.println("DOESNT WORRKKKKKKKKKK");
						}

						System.out.println(cPos + "AYYYYYYE");

						System.out.println("NEW CURRENT POS : £" + cPos);

						antArray[1] = cPos;
						antArray[2] = 1.5;
					} while (works == false && array.is_valid(
							antArray) == false /*
												 * cPos < 0.25 || cPos > 1.25 ||
												 * array.is_valid(antArray) ==
												 * false
												 */);

				}
				p.setVelocity(velocity);
				p.savecPos(cPos);
				System.out.println("particle current position	" + p.getcPos());

				System.out.print("		valid solution------------------------------------------ ");
				SSLValue = array.evaluate(antArray);
				System.out.println("heyyyyyy " + SSLValue);
				SSLValues[counter] = SSLValue;

				if (p.getSSLValue() == 0.0) {
					p.saveSSLValue(SSLValue);
					System.out.println("-------------------" + p.getSSLValue() + "SSYTEM OF A DOWNNNNNN");
				}

				if (SSLValue < p.getSSLValue()) {
					pbPos = p.getcPos();
					p.savePB(pbPos);
					p.saveSSLValue(SSLValue);

				}

				if (p.getSSLValue() < globalBestSSL) {
					globalBestSSL = p.getSSLValue();
					globalBest = p.getPB();
				} else {
					System.out.println("AHAHAHAHAHAHAHAHA");

					// }

				}

			}
			counter++;
			// bestSolutionFound = true;

		}

		double poo = getLowestSSL(SSLValues);

		// double index = getGlobalBest(particles);
		// globalBest = index;
		SSLLoop(SSLValues);

		// globalBest = l;
		System.out.println("LOWEST SSL VALUE IS... " + poo);
		System.out.println("global bEST IS " + globalBest + "   ");

		return globalBest;
	}

	private void SSLLoop(double[] SSLValues) {
		for (int i = 0; i < SSLValues.length; i++) {
			System.out.println("------------------" + SSLValues[i] + "------------");
		}
	}

	private double PSOsolution6() {
		System.out.println("DIGIMON");
		double cPos2;
		boolean bestSolutionFound = false;
		double cPos = rnd.nextDouble() * (1.25 - 0.25) + 0.25;
		double TempPoint = rnd.nextDouble() * (1.25 - 0.25) + 0.25;
		double globalBest = 0;

		int population = 20;
		int iter_max = 100;

		double[] antArray = new double[4];
		int maxsize = antArray.length;
		Particle[] particles = new Particle[population];
		double[] SSLValues = new double[population];
		double SSLValue = 0;

		double pbPos = 0;
		double velocity = 0;
		antArray[0] = cPos;
		double globalBestSSL = 100;
		int counter = 0;
		boolean works = false;

		for (int swarm = 0; swarm < population; swarm++) {
			particles[swarm] = ConstructParticle(0, 0, 0, 0);
		}

		globalBest = particles[0].getPB();

		for (int i = 0; i < iter_max; i++) {
			for (Particle p : particles) {
				globalBest = particles[0].getPB();

				for (int antennaCount = 0; antennaCount < antArray.length; antennaCount++) {
					antArray[0] = cPos;
					if (antennaCount == 0) {
						cPos2 = rnd.nextDouble() * (1.75 - antArray[antennaCount]) + antArray[antennaCount];
					} else {
						cPos2 = rnd.nextDouble() * (1.75 - antArray[antennaCount - 1]) + antArray[antennaCount - 1];
						TempPoint = rnd.nextDouble() * (1.25 - 0.25) + 0.25;
						velocity = (TempPoint - cPos) / 2;
						pbPos = cPos;
						// 0

						// antArray[antennaCount] = cPos2;
						antArray[maxsize - 1] = antArray.length / 2;
						if (cPos2 < antArray[antennaCount] + 0.25 || cPos2 > antArray[antennaCount] - 0.25) {
							do {
								double r3 = rnd.nextDouble();
								double r4 = rnd.nextDouble();
								double cPos1 = (r3 * ((antArray[antennaCount] - 0.25) - 0.25) + 0.25) + velocity;

								double cPos3 = (r3 * (1.25 - (antArray[antennaCount] + 0.25)) + (antArray[antennaCount] + 0.25)) + velocity;

								if (cPos1 > 0.25 && cPos < antArray[antennaCount] - 0.25) {
									cPos2 = cPos3;
									works = true;
									// cPos =cPos1;
								} else if (cPos3 < 1.25 && cPos3 > antArray[antennaCount] + 0.25) {
									cPos2 = cPos3;
									works = true;

								} else {
									System.out.println("DOESNT WORRKKKKKKKKKK");
								}

								System.out.println(cPos2 + "AYYYYYYE");

								System.out.println("NEW CURRENT POS : £" + cPos2);

								antArray[antennaCount] = cPos2;
								antArray[0] = cPos;
								antArray[maxsize - 1] = antArray.length / 2;
							} while (works == false && array.is_valid(antArray) == false);
						}
					}
					// return globalBest;
				}
			}
		}
		System.out.print(array.evaluate(antArray));

		return globalBestSSL;
	}
}
