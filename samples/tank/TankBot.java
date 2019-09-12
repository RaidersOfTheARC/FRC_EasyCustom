/*----------------------------------------------------------------------------*/
/* This sample robot is a tank drive                                          */
/* By: Jackson Isenberg                                                       */
/*----------------------------------------------------------------------------*/

/**
 * Subsytems used:
 * - One Motor Elevator
 * - Two Motor Conveyor
 * - One Motor Conveyor
 * - Cylinder Trigger
 */

/**
 * Robot functions:
 * - Pick up field elements using intake
 * - Cycle elements through internal lift mechanism
 * - Set elevator height so that elements land in holding mechanism at specified height
 * - Eject elements using outtake pistons
 */

package frc.robot.samples.tank;

import edu.wpi.first.wpilibj.*;
import com.ctre.phoenix.motorcontrol.can.*;
import edu.wpi.first.wpilibj.smartdashboard.*;
import frc.robot.subsystems.*;
import frc.robot.*;
import java.util.concurrent.TimeUnit;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
// If you rename or move this class, update the build.properties file in the project root
public class TankBot extends IterativeRobot {
	
	private static final String DEFAULT_AUTO = "Default";
	private static final String CUSTOM_AUTO = "Sandstorm";
	private static final long AUTO_DURATION = 7000;
	private SendableChooser<String> chooser = new SendableChooser<>();
	
	// declare any objects needed here
	private OneMotorElevator elev;
	private TwoMotorConveyor intake;
	private OneMotorConveyor lift;
	private CylinderTrigger outtake;
	
	private Compressor cpress;
	private Solenoid outtakeLeft, outtakeRight;
	
	/**
	 * declare your motors here
	 * WPI: DMC60, Jaguar, PWMTalonSRX, PWMVictorSPX, SD540, Spark, Talon, Victor, VictorSP, NidecBrushless
	 * CTRE: WPI_VictorSPX, TalonSRX
	 *
	 * i.e. private Spark driveFL;
	 */
  	private Talon driveLeft, driveRight;
  	private NidecBrushless elevatorMotor;
	private Spark intakeLeft, intakeRight, conveyorLift;
	
	// if you need any speed controller groups, declare them here
	
	/**
	 * this is your drivetrain
	 * view DriveTrain.java for details, methods, and constructors
	 */
	private DriveTrain myDrive;
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		// send auto chooser to the radio/management
		chooser.addDefault("Do Nothing", DEFAULT_AUTO);
		chooser.addObject("Run Auto", CUSTOM_AUTO);
		SmartDashboard.putData("Auto Choices", chooser);
		
		// create the robot map
		TankBotMap.createMap();
		
		// create the OI
		TankOI.createOI();
		
		// instantiate your devices here
		// i.e. driveFL = new Spark(MyRobotMap.map.get("driveFL"));
    		driveLeft = new Talon(TankBotMap.map.get("driveLeft"));
    		driveLeft = new Talon(TankBotMap.map.get("driveRight"));
		elevatorMotor = new NidecBrushless(TankBotMap.map.get("elevatorPWM"), TankBotMap.map.get("elevatorDIO"));
		conveyorLift = new Spark(TankBotMap.map.get("conveyorLift"));
		intakeLeft = new Spark(TankBotMap.map.get("intakeLeft"));
		intakeRight = new Spark(TankBotMap.map.get("intakeRight"));
		outtakeLeft = new Solenoid(TankBotMap.map.get("outtakeLeft"));
		outtakeRight = new Solenoid(TankBotMap.map.get("outtakeRight"));
		
		elev = new OneMotorElevator(elevatorMotor, "left", 0.5);
		intake = new TwoMotorConveyor(intakeLeft, intakeRight, 1.0);
		lift = new OneMotorConveyor(conveyorLift, "right", 0.35);
		outtake = new CylinderTrigger(new Solenoid[]{outtakeLeft, outtakeRight});
		
		cpress = new Compressor(TankBotMap.map.get("cpress"));
		cpress.setClosedLoopControl(true);
		
		myDrive = new DriveTrain();
		// customize your drivetrain here
		/**
		 * sample below for a DifferentialDrive:
		 *
		 * myDrive.addSC(left);
		 * myDrive.addSC(right);
		 * myDrive.createDrive(2);
		 */
    		myDrive.addSC(driveLeft);
    		myDrive.addSC(driveRight);
    		myDrive.createDrive(2);
    
	}
	
	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString line to get the auto name from the text box below the Gyro
	 * <p>
	 * <p>You can add additional auto modes by adding additional comparisons to
	 * the switch structure below with additional strings. If using the
	 * SendableChooser make sure to add them to the chooser code above as well.
	 */
	@Override
	public void autonomousInit() {
		// if chooser -> default
		if (chooser.equals(DEFAULT_AUTO)) {
			Timer.delay(AUTO_DURATION);
		}
		// if chooser -> custom
		else if (chooser.equals(CUSTOM_AUTO)) {
			autonomousPeriodic();
		}
	}
	
	@Override
	public void autonomousPeriodic() {
    		// insert autonomous code here
	}

	
	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		myDrive.getDrive().tankDrive(TankOI.oi.get(0).getY(), TankOI.oi.get(1).getY());
		
		// elevator up when 'A' is pressed
		elev.elevatorUp(TankOI.oi.get(2).getAButtonPressed());
		
		// elevator down when 'B' is pressed
		elev.elevatorDown(TankOI.oi.get(2).getBButtonPressed());
		
		// stop elevator when 'X' is pressed
		if (TankOI.oi.get(2).getXButtonPressed()) {
			elev.elevatorStop();
		}
		
		// the intake activates when the left bumper is held
		intake.runConveyor(TankOI.oi.get(2).getBumper(GenericHID.Hand.kLeft));
		
		// the lift and intake act in conjunction
		lift.runConveyor(TankOI.oi.get(2).getBumper(GenericHID.Hand.kLeft));
		
		// the outtake activates when the right bumper is held
		outtake.push(TankOI.oi.get(2).getBumper(GenericHID.Hand.kRight));
		// the outtake retracts when the right bumper is released
	}
}
