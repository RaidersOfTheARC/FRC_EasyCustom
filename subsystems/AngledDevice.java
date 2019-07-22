package frc.robot.subsystems;

public interface AngledDevice {

  // manipulate angle
  public void changeAngle();
  
  // reset to default positon
  public void reset();
  
  // get current position
  public void getPositon();

}
