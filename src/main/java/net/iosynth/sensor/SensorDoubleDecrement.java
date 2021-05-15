/**
 *
 */
package net.iosynth.sensor;

/**
 * @author afsana
 *
 */
public class SensorDoubleDecrement extends Sensor {
	private double min, max,state;
        //public double state = max;
	private double step;


	/**
	 *
	 */
	public SensorDoubleDecrement() {
		this.format = "%.4f";
		this.min = 0.0;
		this.max = 1.0;
                this.step  = 1;
		this.state = max;
	}
	/* (non-Javadoc)
	 * @see net.iosynth.sensor.Sensor#step(long)
	 */
	@Override
	public void step(long step) {
                //state = max;
		state = state - (rnd.nextDouble()*(2.5-0.5)+0.5);
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
		/*if (min >= max) {
			max = min + 1;
		}*/
	}


	public double getValue(){
		return state;
	}

	@Override
	public String getString() {
		return String.format(format, getValue());
	}

}

