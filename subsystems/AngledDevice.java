package frc.robot.subsystems;

public interface AngledDevice {

  // manipulate angle
  public void changeAngle(double degrees);
  
  // reset to default positon
  public void reset();
  
  // get current position
  public double getPositon();

}
