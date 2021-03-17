/**
 *
 */
package net.iosynth.sensor;

/**
 * @author afsana
 *
 */
public class SensorDoubleIncrement extends Sensor {
	private double min, max;


	/**
	 *
	 */
	public SensorDoubleIncrement() {
		this.format = "%.4f";
		this.min = 0.0;
		this.max = 1.0;
	}

	/* (non-Javadoc)
	 * @see net.iosynth.sensor.Sensor#replicate()
	 */
	@Override
	public void replicate() {
		// nothing to do
		this.min = getValue() + 1;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.iosynth.sensor.Sensor#checkParameters()
	 */
	@Override
	public void checkParameters() {
		if (min >= max) {
			max = min + 1;
		}
	}

	/* (non-Javadoc)
	 * @see net.iosynth.sensor.Sensor#step(long)
	 */
	@Override
	public void step(long step) {
		// nothing to do
	}

	/**
	 * @return Sensor value
	 */
	public double getValue(){
		double step = rnd.nextDouble()*(8-2)+2;
		double val = min + step;
		return val;
	}

	@Override
	public String getString() {
		return String.format(format, getValue());
	}

}

