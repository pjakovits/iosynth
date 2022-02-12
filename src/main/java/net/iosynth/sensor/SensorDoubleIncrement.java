/**
 *
 */
package net.iosynth.sensor;

/**
 * @author afsana
 *
 */
public class SensorDoubleIncrement extends Sensor {
	private double min, max,state;
	private double step;
        private double slope;


	/**
	 *
	 */
	public SensorDoubleIncrement() {
		this.format = "%.4f";
		this.min = 0.0;
		this.max = 1.0;
                this.step  = 1;
		this.state = 0.0;
                this.slope = 1.0;
	}
	/* (non-Javadoc)
	 * @see net.iosynth.sensor.Sensor#step(long)
	 */
	@Override
	public void step(long step) {
		state = state + (rnd.nextDouble()*(slope-0)+0);
		if(state > max){
			state = max;
		}
		if(state < min){
			state = min;
		}
	}

	/**
	 * @return Sensor value
	 */

	/* (non-Javadoc)
	 * @see net.iosynth.sensor.Sensor#replicate()
	 */

	@Override
	public void replicate() {
		// nothing to do
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


	public double getValue(){
		return state;
	}

	@Override
	public String getString() {
		return String.format(format, getValue());
	}

}

