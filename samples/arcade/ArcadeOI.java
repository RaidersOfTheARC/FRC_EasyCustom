/**
 * You will create your custom OI here
 */

package frc.robot.samples.tank;

import edu.wpi.first.wpilibj.*;
import frc.robot.*;

public class ArcadeOI {

  // declare your HIDs here
  // i.e. Joystick leftStick;
  private Joystick joystick;
  private XboxController gamepad;
  
  // this is your OI
  public static OI oi;

  public static void createOI() {
    // instantiate your HIDs here
    // i.e. leftStick = new Joystick(MyRobotMap.map.get("leftStick"));
    joystick = new Joystick(ArcadeBotMap.map.get("joystick"));
    gamepad = new XboxController(ArcadeBotMap.map.get("gamepad"));
    
    // create your OI
    // i.e. oi = new OI(GenericHID[]{joystick, gamepad});
    oi = new OI(GenericHID[]{joystick, gamepad});
  }

}
