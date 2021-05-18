package hu.bme.mit.train.controller;

import hu.bme.mit.train.interfaces.TrainController;

public class TrainSpeedUpdater implements Runnable{

	private TrainController controller;
	private long timeUnitMillisec = 1000;
	
	public TrainSpeedUpdater(TrainController controller) {
		this.controller = controller;
	}

	@Override
	public void run() {
		while(true) {
			controller.followSpeed();
			try {
				Thread.sleep(timeUnitMillisec);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
