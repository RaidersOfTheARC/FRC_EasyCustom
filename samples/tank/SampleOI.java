/**
 * You will create your custom OI here
 */

package frc.robot.samples.tank;

import edu.wpi.first.wpilibj.*;
import frc.robot.*;

public class TankOI {

  // declare your HIDs here
  // i.e. Joystick leftStick;
  private Joystick leftStick, rightStick;
  private XboxController toolOp;
  
  // this is your OI
  public static OI oi;

  public static void createOI() {
    // instantiate your HIDs here
    // i.e. leftStick = new Joystick(MyRobotMap.map.get("leftStick"));
    leftStick = new Joystick(SampleRobotMap.map.get("leftStick"));
    rightStick = new Joystick(SampleRobotMap.map.get("rightStick"));
    toolOp = new XboxController(SampleRobotMap.map.get("toolOp"));
    
    // create your OI
    // i.e. oi = new OI(GenericHID[]{joystick, gamepad});
    oi = new OI(GenericHID[]{leftStick, rightStick, toolOp});
  }

}
