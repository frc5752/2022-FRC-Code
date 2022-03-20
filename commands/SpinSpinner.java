package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.IntakeSubsystem;

//import java.io.OutputStream;
//import javax.print.event.PrintEvent;
//import edu.wpi.first.networktables.LogMessage;

public class SpinSpinner extends CommandBase
{
    // the subsystems that this command accesses
    //private IntakeSubsystem mIntake;
    private static IntakeSubsystem mIntakeSubsystem;
    private Joystick mDriverController;
    
    public SpinSpinner(Joystick m_driver_controller)
    {
        mDriverController = m_driver_controller;
        mIntakeSubsystem = RobotContainer.m_intake;
    }
    
    
    @Override
    public void initialize()
    {
        mIntakeSubsystem.setSpinnerMotor(Constants.kIntakeSpinnerSpeed);

    }
    
    @Override
    public void execute()
    {
    }
    
    @Override
    public boolean isFinished()
    {
        return !mDriverController.getRawButton(Constants.kSpinnerBtn );
    }
    
    @Override
    public void end(boolean interrupted)
    {
        mIntakeSubsystem.setSpinnerMotor(0);
    }
}
