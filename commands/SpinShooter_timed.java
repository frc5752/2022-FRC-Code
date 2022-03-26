package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ShooterSubsystem;

public class SpinShooter_timed extends CommandBase
{
    Timer my_timer = new Timer();
    double timeout = 0;

    private static ShooterSubsystem mShooterSubsystem;

    public SpinShooter_timed(double t)
    {
        mShooterSubsystem = RobotContainer.m_shooter;
        timeout = t;
    }
    
    
    @Override
    public void initialize()
    {
        my_timer.reset();
        mShooterSubsystem.setShooterMotor(Constants.kShooterSpeedInAuto);
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
		mShooterSubsystem.setShooterMotor(0);
    }
}
