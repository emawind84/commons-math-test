package test;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.interpolation.HermiteInterpolator;
import org.apache.commons.math3.analysis.interpolation.SplineInterpolator;
import org.apache.commons.math3.analysis.interpolation.UnivariateInterpolator;
import org.apache.commons.math3.fitting.PolynomialCurveFitter;
import org.apache.commons.math3.fitting.WeightedObservedPoints;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	
	private static final Logger logger = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {

		try {
			
			//doFirstDegreeFitter();
			//doSecondDegreeFitter();
			//doThirdDegreeFitter();
			
			//testInterpolation();
			testInterpolation2();
			
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
	
	private static void testInterpolation(){
		
		double x[] = { -8, -4, 1, 2, 5, 10 };
		double y[] = { 64, 16, 1, 4, 25, 100};
		
		UnivariateInterpolator interpolator = new SplineInterpolator();
		UnivariateFunction fun = interpolator.interpolate(x, y);
		
		
		double interpolationX = 3;
		double interpolatedY = fun.value(interpolationX);
		
		logger.debug("f(" + interpolationX + ") = " + interpolatedY);
		
	}
	
	private static void testInterpolation2(){
		
		HermiteInterpolator interpolator = new HermiteInterpolator();
		
		interpolator.addSamplePoint(-8.0, new double[] { 64.0 });
		interpolator.addSamplePoint(-2.0, new double[] { 4.0 });
		interpolator.addSamplePoint(1.0, new double[] { 1.0 });
		interpolator.addSamplePoint(3.0, new double[] { 9.0 });
		interpolator.addSamplePoint(5.0, new double[] { 25.0 });
		
		//logger.debug("value at x = 8: " + interpolator.value(8)[0]);
		
		// should print "interpolation polynomial: 1 + 2 x + 4 x^2 - 4 x^3 + x^4"
		logger.debug("interpolation polynomial: " + interpolator.getPolynomials()[0]);
		
		for (int i = -50; i <= 50; i++) {
			logger.debug("value at x = {}: {}", i, interpolator.value(i)[0]);
		}
	}
}
