package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ShooterSubsystem;

public class SpinShooter extends CommandBase
{
    private static ShooterSubsystem mShooterSubsystem;
    private Joystick mDriverController;

    public SpinShooter(Joystick m_driver_controller)
    {
        mDriverController = m_driver_controller;
        mShooterSubsystem = RobotContainer.m_shooter;
    }
    
    
    @Override
    public void initialize()
    {
        mShooterSubsystem.setShooterMotor(Constants.kShooterSpeed);
    }
    
    @Override
    public void execute()
    {
    }
    
    @Override
    public boolean isFinished()
    {
        return !mDriverController.getRawButton(Constants.kShootBtn);
    }
    
    @Override
    public void end(boolean interrupted)
    {
        mShooterSubsystem.setShooterMotor(0);
    }
}
