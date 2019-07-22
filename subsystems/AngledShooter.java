package frc.robot.subsystems;

import edu.wpi.first.wpilibj.*;

public abstract class AngledShooter implements AngledDevice, Shooter {
  
  public Servo[] angleManips;
  public SpeedController[] shooters;
  public int[] servoStates;

  public AngledShooter(Servo[] anglers, SpeedController[] shooters, int[] servoStates) {
    angleManips = anglers;
    this.shooters = shooters;
    this.servoStates = servoStates;
  }
  
  public abstract void readServoState(int servo);
  
}
