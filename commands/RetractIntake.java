package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.IntakeSubsystem;

public class RetractIntake extends CommandBase
{
    private static IntakeSubsystem mIntakeSubsystem;
    private Joystick mDriverController;
    
    public RetractIntake(Joystick m_driver_controller)
    {
        mDriverController = m_driver_controller;
        mIntakeSubsystem = RobotContainer.m_intake;
    }
    
    @Override
    public void initialize()
    {
        mIntakeSubsystem.setActuatorMotor(Constants.kIntakeActuatorRetractSpeed);
    }
    
    @Override
    public void execute()
    {
    }
    
    @Override
    public boolean isFinished()
    {
        return !mDriverController.getRawButton(Constants.kIntakeRetractBtn);
    }
    
    @Override
    public void end(boolean interrupted)
    {
        mIntakeSubsystem.setActuatorMotor(0);
    }
}
