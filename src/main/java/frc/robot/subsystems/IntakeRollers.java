/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeRollers extends SubsystemBase {
  private VictorSP _victor;
  private IntakeRollersState _currentState;

  public IntakeRollers() {
    this._victor = new VictorSP(2);
    this._currentState = IntakeRollersState.OFF;
  }

  public enum IntakeRollersState {
    IN,
    OUT,
    OFF;
  }

  public void setState(IntakeRollersState state) {
    if (state == IntakeRollersState.IN) this._victor.set(1);
    else if (state == IntakeRollersState.OUT) this._victor.set(-1);
    else this._victor.set(0);
  }

  public IntakeRollersState getState() {
    return this._currentState;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
