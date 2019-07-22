package frc.robot.samples.arcade;

import frc.robot.*;

public class ArcadeBotMap {
	
	public static RobotMap map = new RobotMap();
	public static void createMap() {
    
  		// add your devices here
		// i.e. myMap.addDevice("driveFL", 10);
    		map.addDevice("driveFL", 10);
		map.addDevice("driveFR", 11);
		map.addDevice("driveBL", 12);
		map.addDevice("driveBR", 13);
		map.addDevice("joystick", 0);
	  	map.addDevice("gamepad", 1);
		map.addDevice("gate", 7);
		map.addDevice("liftLeft", 5);
		map.addDevice("liftRight", 6);
		map.addDevice("hook", 1);

    	}
  
}
