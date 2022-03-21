package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class ArcadeDriveInAuto extends CommandBase
{  
    public static DrivetrainSubsystem mDrivetrainSubsystem;
    Timer my_timer = new Timer();
    double timeout = 0;

    public ArcadeDriveInAuto( double t )
    {
        mDrivetrainSubsystem = RobotContainer.m_drivetrain;
        timeout = t;
    }
    
    
    @Override
    public void initialize()
    {
        my_timer.reset();
        mDrivetrainSubsystem. arcadeDrive(0.5, 0);
        my_timer.start();
    }
    
    @Override
    public void execute()
    {
    }
    
    @Override
    public boolean isFinished()
    {
        return my_timer.hasElapsed(timeout);
    }
    
    @Override
    public void end(boolean interrupted)
    {
        mDrivetrainSubsystem.arcadeDrive(0,0);
    }
}
