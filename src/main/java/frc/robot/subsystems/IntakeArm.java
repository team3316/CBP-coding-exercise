package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeArm extends SubsystemBase {
  private VictorSP _victor;
  private DigitalInput _openMS, _closedMS;

  public IntakeArm() {
    this._victor = new VictorSP(1);
    this._openMS = new DigitalInput(2);
    this._closedMS = new DigitalInput(3);
  }

  public enum IntakeArmState {
    OPEN,
    CLOSED,
    INTERMEDIATE;
  }

  public void setState(IntakeArmState state) {
    if (state == IntakeArmState.OPEN) this._victor.set(1);
    else if (state == IntakeArmState.CLOSED) this._victor.set(-1);
  }

  public void zeroMotor() {
    this._victor.set(0);
  }

  public IntakeArmState getState() {
    if (this._openMS.get()) return IntakeArmState.OPEN;
    else if (this._closedMS.get()) return IntakeArmState.CLOSED;
    else return IntakeArmState.INTERMEDIATE;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
