package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DrivetrainSubsystem;


public class ArcadeDrive_timed extends CommandBase {

  public Joystick mDriverController;
  public static DrivetrainSubsystem m_drivetrain;
  Timer my_timer = new Timer();
  double timeout = 0;
  double moveSpeed = 0;
  double rotateSpeed = 0;

  // for s>0 the machine moves in the reverse direction
  // t is in seconds
  public ArcadeDrive_timed(double s, double t) 
  {
    timeout = t;
    moveSpeed = s;
    m_drivetrain = RobotContainer.m_drivetrain;
    addRequirements(RobotContainer.m_drivetrain);
  }
  
  @Override
  public void initialize()
  {
    my_timer.reset();
    m_drivetrain.arcadeDrive(0, 0);
    my_timer.start();
  }
  
  @Override
  public void execute() 
  { 
    m_drivetrain.arcadeDrive(0.5*rotateSpeed, 0.7*moveSpeed);
  }
  
  @Override
  public void end(boolean interrupted) 
  {
    /* stops the motors */
    m_drivetrain.arcadeDrive(0, 0);
  }
  
  @Override
  public boolean isFinished() 
  {
    return my_timer.hasElapsed(timeout);
}
}
