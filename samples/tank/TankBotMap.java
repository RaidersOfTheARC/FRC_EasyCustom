package frc.robot.samples.tank;

import frc.robot.*;

public class TankBotMap {
	
	public static RobotMap map = new RobotMap();
	public static void createMap() {
    
  		// add your devices here
		// i.e. myMap.addDevice("driveFL", 10);
    		map.addDevice("driveLeft", 5);
		map.addDevice("driveRight", 6);
		map.addDevice("leftStick", 0);
		map.addDevice("rightStick", 1);
		map.addDevice("toolOp", 2);
	  	map.addDevice("elevatorPWM", 1);
		map.addDevice("elevatorDIO", 0);
		map.addDevice("intakeLeft", 7);
		map.addDevice("intakeRight", 3);
		map.addDevice("conveyorLift", 8);
		map.addDevice("outtakeLeft", 1);
		map.addDevice("outtakeRight", 2);
		map.addDevice("cpress", 1);

    	}
  
}
