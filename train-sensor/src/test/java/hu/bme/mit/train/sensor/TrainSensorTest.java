package hu.bme.mit.train.sensor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;

import static org.mockito.Mockito.*;


public class TrainSensorTest {

	TrainSensor sensor;
	TrainUser mockUser;
	TrainController mockController;
	
	@Before
	public void init() {
		
		mockUser = mock(TrainUser.class);
		mockController = mock(TrainController.class);
		
		sensor = new TrainSensorImpl(mockController, mockUser);
	}
	
	@Test
	public void speedlimit_greater_than_500() {
		when(mockController.getReferenceSpeed()).thenReturn(150);
		
		sensor.overrideSpeedLimit(501);
		verify(mockUser).setAlarmState(true);
	}
	
	@Test
	public void speedlimit_smaller_than_0() {
		when(mockController.getReferenceSpeed()).thenReturn(150);
		
		sensor.overrideSpeedLimit(-1);
		verify(mockUser).setAlarmState(true);
	}
	
	@Test
	public void speedlimit_between_0_and_500() {
		when(mockController.getReferenceSpeed()).thenReturn(150);
		
		sensor.overrideSpeedLimit(120);
		verify(mockUser, times(0)).setAlarmState(true);
	}
	
	@Test
	public void speedlimit_smaller_than_reference_by_50_percent() {
		when(mockController.getReferenceSpeed()).thenReturn(150);
		
		sensor.overrideSpeedLimit(60);
		verify(mockUser).setAlarmState(true);
	}

	

	
	
}
