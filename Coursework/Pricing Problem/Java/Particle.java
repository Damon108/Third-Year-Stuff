
public class Particle {
	private double[] velocity;
	private double[] cPrices;
	private double[] pbPrices;
	private double BestRevenue;

	public Particle(double[] velocity, double[] cPrices, double[] pbPrices, double BestRevenue) {
		this.velocity = velocity;
		this.cPrices = cPrices;
		this.pbPrices = pbPrices;
		this.BestRevenue = BestRevenue;
	}
	
	public double[] getPB() {

		System.out.println("pb is : " + pbPrices);

		// System.out.println("pb is : " +pbPrices);

		return pbPrices;
	}

	public void savePB(double[] cPrices) {
		pbPrices = cPrices;
	}

	public void savecPrices(double[] cPrices) {
		this.cPrices = cPrices;

	}

	public double[] getcPrices() {
		// System.out.println("pb is : " +pbPrices);
		return cPrices;
	}

	public void saveRevenue(double newRevenue) {
		BestRevenue = newRevenue;
	}

	public double getRevenue() {
		// System.out.println("SSL is : " + SSLValue);
		return BestRevenue;
	}

	public double[] getVelocity() {
		return velocity;
	}

	public void setVelocity(double[] newVelocity) {

		velocity = newVelocity;
	}
}


