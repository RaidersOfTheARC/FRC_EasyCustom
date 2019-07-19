/**
 * Your drivetrain
 * You can customize it to fit your robot's design and drive system
 */

package frc.robot;

import edu.wpi.first.wpilibj.drive.*;
import edu.wpi.first.wpilibj.*;
import java.util.ArrayList;

public class DriveTrain {
  
  private RobotDriveBase drive;
  private ArrayList<SpeedController> list;
  
  public DriveTrain() {
    list = new ArrayList<SpeedController>();
  }
  
  // create your motor list
  // they must be in the proper order!
  
  public void addSC(SpeedController ctrl) { list.add(ctrl); }
  
  public SpeedController getSC(int index) { return list.get(index); }
  
  public void addSC(SpeedController ctrl, int index) { list.add(index, ctrl); }
  
  public void clearList() { list.clear(); }
  
  // create your custom drive
  public void createDrive(int type) {
    switch (type) {
      case 0:
        // KilloughDrive(left, right, back);
        drive = new KilloughDrive(list.get(0), list.get(1), list.get(2));
        break;
      case 1:
        // MecanumDrive(fL, bL, fR, bR);
        drive = new MecanumDrive(list.get(0), list.get(1), list.get(2), list.get(3));
        break;
      default:
        // DifferentialDrive(left, right);
        drive = new DifferentialDrive(list.get(0), list.get(1));
    }
  }
  
  public RobotDriveBase getDrive() { return drive; }
  
}
