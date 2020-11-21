/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.IntakeRollers.IntakeRollersState;

/**
 * An example command that uses an example subsystem.
 */
public class SetIntakeRollersState extends CommandBase {
  private IntakeRollersState _wantedState;

  public SetIntakeRollersState(IntakeRollersState wantedState) {
    addRequirements(Robot.intakeRollers);

    this._wantedState = wantedState;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("ROLLERS SET TO " + this._wantedState.toString() + " FROM " + Robot.intakeRollers.getState().toString());
    Robot.intakeRollers.setState(this._wantedState);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
