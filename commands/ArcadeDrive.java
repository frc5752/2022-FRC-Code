package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DrivetrainSubsystem;


public class ArcadeDrive extends CommandBase {

  public Joystick mDriverController;
  public static DrivetrainSubsystem m_drivetrain;
  
  public ArcadeDrive(Joystick m_driverController, DrivetrainSubsystem m_driveTrain) 
  {
    m_drivetrain = m_driveTrain;
    mDriverController = m_driverController;

    addRequirements(RobotContainer.m_drivetrain);
  }
  
  // Called when the command is initially scheduled.
  @Override
  public void initialize()
  {
	m_drivetrain.arcadeDrive(0, 0);
	//RobotContainer.ahrs.reset();
	//RobotContainer.ahrs.zeroYaw();
  }
  
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {
	//SmartDashboard.putNumber("IMU_CompassHeading", RobotContainer.ahrs.getCompassHeading() );

    double moveSpeed = mDriverController.getRawAxis(Constants.Controls.DRIVER_CONTROLLER_MOVE_AXIS);
    double rotateSpeed = mDriverController.getRawAxis(Constants.Controls.DRIVER_CONTROLLER_ROTATE_AXIS);
    
    m_drivetrain.arcadeDrive(0.5*rotateSpeed, 0.7*moveSpeed);
    // rotateSpeed and moveSpeed might be incorrectly swapped
  }
  
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) 
  {
    /* stops the motors */
    m_drivetrain.arcadeDrive(0, 0);
  }
  
  @Override
  public boolean isFinished() 
  {
    // because this should run indefinitely
    // it should _always_ return false
    // for a drive_train
    return false;
  }
}
