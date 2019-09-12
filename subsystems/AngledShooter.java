package frc.robot.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.*;

public abstract class AngledShooter extends Subsystem implements AngledDevice, Shooter {
  
  public Servo[] angleManips;
  public SpeedController[] shooters;
  public int[] servoStates;

  public AngledShooter(Servo[] anglers, SpeedController[] shooters, int[] servoStates) {
    angleManips = anglers;
    this.shooters = shooters;
    this.servoStates = servoStates;
  }
  
  public abstract int readServoState(int servo);
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  
}
