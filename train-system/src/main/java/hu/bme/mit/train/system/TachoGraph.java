package hu.bme.mit.train.system;

import java.util.Date;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class TachoGraph {
	
	//Table containing data: Date, Joystick position, Reference speed
	private Table<Date, Integer, Integer> tachoTable;
	
	public TachoGraph() {
		tachoTable = HashBasedTable.create();
	}
	
	public void addData(Date time, int joystickPosition, int referenceSpeed) {
		tachoTable.put(time, joystickPosition, referenceSpeed);
	}
	
	public void addData(int joystickPosition, int referenceSpeed) {
		long currentTime = System.currentTimeMillis();
		Date newDate = new Date(currentTime);
		tachoTable.put(newDate, joystickPosition, referenceSpeed);
		
	}
	
	public boolean isEmpty() {
		return tachoTable.isEmpty();
	}
}
