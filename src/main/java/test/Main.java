package test;
import org.apache.commons.math3.fitting.PolynomialCurveFitter;
import org.apache.commons.math3.fitting.WeightedObservedPoints;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	
	private static final Logger logger = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {

		try {
			
			doFirstDegreeFitter();
			doSecondDegreeFitter();
			doThirdDegreeFitter();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.exit(0);
		}
		
	}
	
	private static void doFirstDegreeFitter(){
		logger.debug("doFirstDegreeFitter...");
		
		// Collect data.
		final WeightedObservedPoints obs = new WeightedObservedPoints();
		
		obs.add(1, 1);
		obs.add(2, 2);
		obs.add(3, 3);
		obs.add(4, 4);
		obs.add(5, 5);

		// Instantiate a third-degree polynomial fitter.
		final PolynomialCurveFitter fitter = PolynomialCurveFitter.create(1);
		
		logger.debug("{}", fitter);

		// Retrieve fitted parameters (coefficients of the polynomial function).
		final double[] coeff = fitter.fit(obs.toList());
		
		logger.debug("coeff length: {}, c1: {}, c2: {}", coeff.length, coeff[0], coeff[1]);
	}
	
	private static void doSecondDegreeFitter(){
		logger.debug("doSecondDegreeFitter...");
		
		// Collect data.
		final WeightedObservedPoints obs = new WeightedObservedPoints();
		
		obs.add(-4, 16);
		obs.add(-3, 9);
		obs.add(-2, 4);
		obs.add(-1, 1);
		obs.add(1, 1);
		obs.add(2, 4);
		obs.add(3, 9);
		obs.add(4, 16);

		// Instantiate a third-degree polynomial fitter.
		final PolynomialCurveFitter fitter = PolynomialCurveFitter.create(2);
		
		logger.debug("{}", fitter);

		// Retrieve fitted parameters (coefficients of the polynomial function).
		final double[] coeff = fitter.fit(obs.toList());
		
		logger.debug("coeff length: {}, c1: {}, c2: {}, c3: {}", coeff.length, coeff[0], coeff[1], coeff[2]);
	}
	
	private static void doThirdDegreeFitter(){
		logger.debug("doThirdDegreeFitter...");
		
		// Collect data.
		final WeightedObservedPoints obs = new WeightedObservedPoints();
		
		obs.add(-1.00, 2.021170021833143);
		obs.add(-0.99, 2.221135431136975);
		obs.add(-0.98, 2.09985277659314);
		obs.add(-0.97, 2.0211192647627025);
		// ... Lots of lines omitted ...
		obs.add(0.99, -2.4345814727089854);

		// Instantiate a third-degree polynomial fitter.
		final PolynomialCurveFitter fitter = PolynomialCurveFitter.create(3);
		
		logger.debug("{}", fitter);

		// Retrieve fitted parameters (coefficients of the polynomial function).
		final double[] coeff = fitter.fit(obs.toList());
		
		logger.debug("coeff length: {}, c1: {}, c2: {}, c3: {}, c4: {}", coeff.length, coeff[0], coeff[1], coeff[2], coeff[3]);
	}
}
