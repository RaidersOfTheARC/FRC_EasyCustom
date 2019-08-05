
/*----------------------------------------------------------------------------*/
/* This sample robot is a mecanum drive                                       */
/* By: Jackson Isenberg                                                       */
/*----------------------------------------------------------------------------*/

package frc.robot.samples.mecanum;

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
public class MecanumBot extends IterativeRobot {
	
	private static final String DEFAULT_AUTO = "Default";
	private static final String CUSTOM_AUTO = "Custom";
	private static final long AUTO_DURATION = 7000;
	private SendableChooser<String> chooser = new SendableChooser<>();
	
	// declare any objects needed here
	private OneMotorElevator elev;
	private TwoMotorConveyor intake, channel;
	private CylinderTrigger hatch;
	
	private Compressor cpress;
	private Solenoid solIn, solOut;
	
	/**
	 * declare your motors here
	 * WPI: DMC60, Jaguar, PWMTalonSRX, PWMVictorSPX, SD540, Spark, Talon, Victor, VictorSP, NidecBrushless
	 * CTRE: WPI_VictorSPX, TalonSRX
	 *
	 * i.e. private Spark driveFL;
	 */
  
  
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
		MecanumBotMap.createMap();
		
		// create the OI
		MecanumOI.createOI();
		
		// instantiate your devices here
		// i.e. driveFL = new Spark(MyRobotMap.map.get("driveFL"));
    
		
		cpress = new Compressor(ArcadeBotMap.map.get("cpress"));
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
     myDrive.createDrive(1);
    
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
		myDrive.getDrive().arcadeDrive(ArcadeOI.oi.get(0).getY(), ArcadeOI.oi.get(0).getX());
		
		// gate opens when 'A' is held
		intake.push(ArcadeOI.oi.get(1).getAButton());
		
		// gate closes when 'A' is released
		if (ArcadeOI.oi.get(1).getAButtonReleased()) {
			intake.retract();
		}
		
		// the lift activates when the left bumper is held
		lift.runConveyor(ArcadeOI.oi.get(1).getBumper(GenericHID.Hand.kLeft));
		
		// the lift inverts when 'X' is pressed
		if (ArcadeOI.oi.get(1).getXButtonPressed()) {
			lift.invertConveyor();
		}
		
		// the outtake activates when the right bumper is held
		outtake.runConveyor(ArcadeOI.oi.get(1).getBumper(GenericHID.Hand.kRight));
		
		// the climbing hook activates when 'Y' is held
		climb.push(ArcadeOI.oi.get(1).getYButton);
		
		// the climbing hook retracts when 'Y' is released
		if (ArcadeOI.oi.get(1).getYButtonReleased()) {
			climb.retract();
		}
	}
}
