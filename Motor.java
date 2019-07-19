/**
 * A motor
 * You can create a motor object here
 */

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.*;
import edu.wpi.first.wpilibj.*;

public class Motor {

  private String name;

  public Motor(String motorType, String motorName, boolean isCTRE) {
    name = motorName;
  }

}
