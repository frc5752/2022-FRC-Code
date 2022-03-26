// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DrivetrainSubsystem;

public class TurnLeft_timed extends CommandBase {
  /** Creates a new LT_timed. */
  public static DrivetrainSubsystem m_drivetrain;
  Timer my_timer = new Timer();
  double timeout = 0;
  double moveSpeed = 0;
  double rotateSpeed = 0;
  
  public TurnLeft_timed(double r, double t) {
    // Use addRequirements() here to declare subsystem dependencies.
    timeout = t;
    rotateSpeed = r;
    m_drivetrain = RobotContainer.m_drivetrain;
    addRequirements(RobotContainer.m_drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() 
  {
    my_timer.reset();
    m_drivetrain.arcadeDrive(0.5*rotateSpeed, 0.7*moveSpeed);
    my_timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) 
  {
    m_drivetrain.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() 
  {
    return my_timer.hasElapsed(timeout);
  }
}
