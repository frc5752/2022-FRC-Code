package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ShooterSubsystem;

public class Uptake_timed extends CommandBase
{  
    public static ShooterSubsystem mShooterSubsystem;
    Timer my_timer = new Timer();
    double timeout = 0;

    public Uptake_timed( double t )
    {
        mShooterSubsystem = RobotContainer.m_shooter;
        timeout = t;
    }
    
    
    @Override
    public void initialize()
    {
        my_timer.reset();
        mShooterSubsystem.setUptakeMotor(Constants.kUptakeSpeed);
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
        mShooterSubsystem.setUptakeMotor(0);
    }
}
