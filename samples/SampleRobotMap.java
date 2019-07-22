package frc.robot.samples;

import frc.robot.*;

public class SampleRobotMap {
	
	public static RobotMap map = new RobotMap();
	public static void createMap() {
    
  		// add your devices here
		// i.e. myMap.addDevice("driveFL", 10);
    		map.addDevice("driveLeft", 5);
		map.addDevice("driveRight", 6);
		map.addDevice("leftStick", 0);
		map.addDevice("rightStick", 1);
		map.addDevice("toolOp", 2);
	  	map.addDevice("elevatorMotor", 4);
		map.addDevice("intakeLeft", 7);
		map.addDevice("intakeRight", 3);
		map.addDevice("conveyorLift", 8);


    	}
  
}
