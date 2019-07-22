package frc.robot.samples.arcade;

import frc.robot.*;

public class ArcadeBotMap {
	
	public static RobotMap map = new RobotMap();
	public static void createMap() {
    
  		// add your devices here
		// i.e. myMap.addDevice("driveFL", 10);
    		map.addDevice("driveLeft", 5);
		map.addDevice("driveRight", 6);
		map.addDevice("leftStick", 0);
		map.addDevice("rightStick", 1);
		map.addDevice("toolOp", 2);
	  

    	}
  
}
