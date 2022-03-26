package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.IntakeSubsystem;

public class ExtendIntake_timed extends CommandBase
{
    Timer my_timer = new Timer();
    double timeout = 0;

    private static IntakeSubsystem mIntakeSubsystem;

    public ExtendIntake_timed(double t)
    {
        mIntakeSubsystem = RobotContainer.m_intake;
        timeout = t;
        addRequirements(RobotContainer.m_intake);

    }
    
    
    @Override
    public void initialize()
    {
        if( mIntakeSubsystem.frontLimitSwitch() ) return;
        my_timer.reset();
        mIntakeSubsystem.setActuatorMotor(Constants.kIntakeActuatorExtendSpeed);
        my_timer.start();
        
    }
    
    @Override
    public void execute()
    {

    }
    
    @Override
    public boolean isFinished()
    {
        
        return (my_timer.hasElapsed(timeout) || mIntakeSubsystem.frontLimitSwitch());
    }
    
    @Override
    public void end(boolean interrupted)
    {
        mIntakeSubsystem.setActuatorMotor(0);
    }
}
