package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.IntakeSubsystem;

public class ExtendIntake extends CommandBase
{
    private static IntakeSubsystem mIntakeSubsystem;
    private Joystick mDriverController;

    public ExtendIntake(Joystick m_driver_controller)
    {
        mIntakeSubsystem = RobotContainer.m_intake;
        mDriverController = m_driver_controller;
    }
    
    @Override
    public void initialize()
    {
        mIntakeSubsystem.setActuatorMotor(Constants.kIntakeActuatorExtendSpeed);
    }
    
    @Override
    public void execute()
    {

       }
    
    @Override
    public boolean isFinished()
    {
		return (!mDriverController.getRawButton( Constants.kIntakeExtendBtn ) | mIntakeSubsystem.frontLimitSwitch());
    }
    
    @Override
    public void end(boolean interrupted)
    {
        mIntakeSubsystem.setActuatorMotor(0);
    }
}
