package frc.robot;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.ArcadeDrive_timed;
import frc.robot.commands.AutonomousCommand;
import frc.robot.commands.ClimberDown;
import frc.robot.commands.ClimberUp;
import frc.robot.commands.DeployHookLower;
import frc.robot.commands.DeployHookRaise;
import frc.robot.commands.ExtendIntake;
import frc.robot.commands.RetractIntake;
import frc.robot.commands.ReverseUptake;
import frc.robot.commands.SpinShooter;
import frc.robot.commands.SpinSpinner;
import frc.robot.commands.Uptake;
import frc.robot.subsystems.ClimberSubsystem;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class RobotContainer 
{
    SendableChooser<Command> autoChooser;

	// Subsystems
	// 2022 03 22 - mkpellegrino

	public static AHRS ahrs;

	public final static DrivetrainSubsystem m_drivetrain = new DrivetrainSubsystem();
    public final static ShooterSubsystem m_shooter = new ShooterSubsystem();
    public final static IntakeSubsystem m_intake = new IntakeSubsystem();
    public final static ClimberSubsystem m_climber = new ClimberSubsystem();
    //public final static VisionSubsystem m_vision = new VisionSubsystem();
    private final Joystick m_driverController = new Joystick(0);
    
    private /*final*/ Command m_autoCommand; // = new AutonomousCommand();
    
    /**
    * The container for the robot. Contains subsystems, OI devices, and commands.
    */
    public RobotContainer() 
    {
        // mkpellegrino - 2022 03 23
        autoChooser = new SendableChooser<Command>();
        autoChooser.setDefaultOption("<Select a command>", null);
        autoChooser.addOption("Shoot and Go", new AutonomousCommand());
        autoChooser.addOption("Just Go", new ArcadeDrive_timed(0.75, 1));
        SmartDashboard.putData("Init/Auto Selector", autoChooser);


        // if you want to process the camera feed and have it automatically
        // identify targets, comment out the two lines below and uncomment the 
		// "public final static VisionSubsystem m_vision... line above

	
        UsbCamera camera = CameraServer.startAutomaticCapture(); // line to comment out
        camera.setResolution(640, 480); //                       // the other line to comment out
	
	

        configureButtonBindings();
	
        // This is going to perpetually run while in TeleOp
        m_drivetrain.setDefaultCommand(new ArcadeDrive(m_driverController, m_drivetrain));
    }
    
    
    
    private void configureButtonBindings() 
    {
        new JoystickButton(m_driverController, Constants.kShootBtn).whenPressed( new SpinShooter(m_driverController ) );
        new JoystickButton(m_driverController, Constants.kSpinnerBtn).whenPressed( new SpinSpinner(m_driverController) );
        new JoystickButton(m_driverController, Constants.kIntakeRetractBtn).whenPressed( new RetractIntake(m_driverController) );
        new JoystickButton(m_driverController, Constants.kIntakeExtendBtn).whenPressed( new ExtendIntake(m_driverController) );
        new JoystickButton(m_driverController, Constants.kUptakeBtn).whenPressed( new Uptake(m_driverController) );
		new JoystickButton(m_driverController, Constants.kReverseUptakeBtn).whenPressed( new ReverseUptake(m_driverController) );
		
		new JoystickButton(m_driverController, Constants.kClimbUpBtn).whenPressed( new ClimberUp(m_driverController) );
		new JoystickButton(m_driverController, Constants.kClimbDownBtn).whenPressed( new ClimberDown(m_driverController) );
		new JoystickButton(m_driverController, Constants.kDeployHookUpBtn).whenPressed( new DeployHookRaise(m_driverController) );
		new JoystickButton(m_driverController, Constants.kDeployHookDownBtn).whenPressed( new DeployHookLower(m_driverController) );
    }
    
 
    
    /**
    * runs when the robot gets disabled.
    */
    public void disabledInit() 
    {
        
    }
    
    /**
    * runs when the robot is powered on.
    */
    public void robotInit() 
    {
		// mkpellegrino - 2022 03 22
		try
		{
			ahrs = new AHRS(SPI.Port.kMXP);
			//ahrs.reset();
			//ahrs.zeroYaw();
	
		}
		catch (RuntimeException e)
		{
			DriverStation.reportError("*** navx-mxp not connected.  Error: " + e.getMessage() + " ***", true);
		}

		// Clean out the SmartDashboard Values of Old
		for( int i=0; i<=9; i++ )
		{
			showOnDash(i, "");
		}
	
    }
    
    /**
    * runs once every ~20ms when in teleop.
    */
    public void teleopPeriodic() 
    {
    }
    
    /**
    * runs when robot is inited to teleop.
    */
    public void teleopInit() 
    {
        //scheduler.schedule(teleInit);
    }
    
    /**
    * Use this to pass the autonomous command to the main {@link Robot} class.
    *
    * @return the command to run in autonomous
    */
    public Command getAutonomousCommand()
    {
        m_autoCommand = autoChooser.getSelected();
        return m_autoCommand;
	}
	
	public void showOnDash(int x, String y )
	{
		if( ( x>=0 )&&( x<=9 ) )
		{
			String s = new String( "DB/String " + Integer.toString(x) );
			SmartDashboard.putString( s, y );
		}

	}
} 
        
