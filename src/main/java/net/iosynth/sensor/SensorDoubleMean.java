/**
 * 
 */
package net.iosynth.sensor;

/**
 * @author rradev
 *
 */
public class SensorDoubleMean extends Sensor {
	private double values[];
	transient private long state;
        private double mean;
        private double anomaly;
	
	/**
	 * 
	 */
	public SensorDoubleMean() {
		this.format = "%.4f";
		this.state = 0;
                this.anomaly = 0;
	}
	
	/* (non-Javadoc)
	 * @see net.iosynth.sensor.Sensor#replicate()
	 */
	@Override
	public void replicate() {
		state = rnd.nextInt(values.length);
	}
	
	/* (non-Javadoc)
	 * @see net.iosynth.sensor.Sensor#checkParameters()
	 */
	@Override
	public void checkParameters() {
		if (values == null) {
			values = new double[2];
			values[0] = 0.0;
			values[1] = 1.0;
                        mean = 0.0;
		}
	}
	
	/* (non-Javadoc)
	 * @see net.iosynth.sensor.Sensor#step(long)
	 */
	@Override
	public void step(long step){
		state = (state + step) % values.length;
	}
	
	/**
	 * @return Sensor value
	 */
	public double getValue(){
                
		return mean + (rnd.nextDouble()*(anomaly-0)+0) + values[(int)state];
	}

	@Override
	public String getString() {
		return String.format(format, getValue());
	}


}
