// SummitRobotics on Github
// https://raw.githubusercontent.com/SummitRobotics/FRC2022/main/src/main/java/frc/
// https://github.com/wpilibsuite/allwpilib/tree/main/wpilibjExamples/src/main/java/edu/wpi/first/wpilibj/examples/frisbeebot

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.AutonomousCommand;
import frc.robot.commands.ExtendIntake;
import frc.robot.commands.RetractIntake;
import frc.robot.commands.ReverseUptake;
import frc.robot.commands.SpinShooter;
import frc.robot.commands.SpinSpinner;
import frc.robot.commands.Uptake;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

/**
* This class is where the bulk of the robot should be declared. Since
* Command-based is a
* "declarative" paradigm, very little robot logic should actually be handled in
* the {@link Robot}
* periodic methods (other than the scheduler calls). Instead, the structure of
* the robot (including
* subsystems, commands, and button mappings) should be declared here.
*/
public class RobotContainer 
{
    // Subsystems
    public final static DrivetrainSubsystem m_drivetrain = new DrivetrainSubsystem();
    public final static ShooterSubsystem m_shooter = new ShooterSubsystem();
    public final static IntakeSubsystem m_intake = new IntakeSubsystem();
    //private final ClimberSubsystem m_climber = new ClimberSubsystem();
    //public final static VisionSubsystem m_vision = new VisionSubsystem();
    private final Joystick m_driverController = new Joystick(0);
    
    private final Command m_autoCommand = new AutonomousCommand();
    
    /**
    * The container for the robot. Contains subsystems, OI devices, and commands.
    */
    public RobotContainer() 
    {
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
        return m_autoCommand;
    }
} 
        
