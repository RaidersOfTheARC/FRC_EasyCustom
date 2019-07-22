/**
 * All control modules go here
 */

package frc.robot;

import edu.wpi.first.wpilibj.*;
import frc.robot.subsystems.*;

public class OI {
  
  private GenericHID[] controls;
  
  public OI() {
    // default constructor, leave empty
  }
  
  // user inputs a custom array of controllers
  // i.e. OI my_OI = new OI(new GenericHID[]{joystick, gamepad});
  public OI(GenericHID[] ctrls) {
    controls = ctrls;
  }
  
  public GenericHID getUI(int index) { return controls[index]; }
  
}
