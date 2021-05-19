package hu.bme.mit.train.interfaces;

public interface TrainUser {

	int getJoystickPosition();

	boolean getAlarmFlag();
	
	void setAlarmState(boolean alarmFlag);
	boolean getAlarmState();

	void overrideJoystickPosition(int joystickPosition);

}
