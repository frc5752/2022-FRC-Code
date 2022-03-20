package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.IntakeSubsystem;

public class SpinSpinner_timed extends CommandBase
{  
    public static IntakeSubsystem mIntakeSubsystem;
    Timer my_timer = new Timer();
    double timeout = 0;

    public SpinSpinner_timed( double t )
    {
        mIntakeSubsystem = RobotContainer.m_intake;
        timeout = t;
    }
    
    
    @Override
    public void initialize()
    {
        my_timer.reset();
        mIntakeSubsystem.setSpinnerMotor(Constants.kIntakeSpinnerSpeed);
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
        mIntakeSubsystem.setSpinnerMotor(0);
    }
}
