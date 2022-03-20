package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ShooterSubsystem;

public class Uptake extends CommandBase
{  
    public static ShooterSubsystem mShooterSubsystem;
    private Joystick mDriverController;

    public Uptake(Joystick m_driver_controller)
    {
        mDriverController = m_driver_controller;
        mShooterSubsystem = RobotContainer.m_shooter;
    }
    
    
    @Override
    public void initialize()
    {
        mShooterSubsystem.setUptakeMotor(Constants.kUptakeSpeed);
    }
    
    @Override
    public void execute()
    {
    }
    
    @Override
    public boolean isFinished()
    {
        return !mDriverController.getRawButton(Constants.kUptakeBtn );
    }
    
    @Override
    public void end(boolean interrupted)
    {
        mShooterSubsystem.setUptakeMotor(0);
    }
}
