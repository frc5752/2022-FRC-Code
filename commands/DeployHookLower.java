package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ClimberSubsystem;

public class DeployHookLower extends CommandBase
{
    private static ClimberSubsystem mClimberSubsystem;
    private Joystick mDriverController;

    public DeployHookLower(Joystick m_driver_controller)
    {
        mClimberSubsystem = RobotContainer.m_climber;
        mDriverController = m_driver_controller;
    }
    
    @Override
    public void initialize()
    {
        mClimberSubsystem.setDeployHookMotor(Constants.kDeployHookSpeedDown);
    }
    
    @Override
    public void execute()
    {

       }
    
    @Override
    public boolean isFinished()
    {
		return !mDriverController.getRawButton( Constants.kDeployHookDownBtn );
	}
    
    @Override
    public void end(boolean interrupted)
    {
        mClimberSubsystem.setDeployHookMotor(0);
    }
}
