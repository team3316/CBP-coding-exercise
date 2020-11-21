package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Elevator extends SubsystemBase {
  private VictorSP _victor;
  private Encoder _encoder;
  
  public Elevator() {
    this._victor = new VictorSP(0);
    this._encoder = new Encoder(0, 1);
  }

  public enum ElevatorState {
    TOP,
    INTERMEDIATE,
    BOTTOM;
  }

  public void setState(ElevatorState state) {
    if (state == ElevatorState.TOP) this._victor.set(1);
    if (state == ElevatorState.BOTTOM) this._victor.set(-1);
  }

  public void zeroMotor() {
    this._victor.set(0);
  }

  public ElevatorState getState() {
    if (this._encoder.get() == 0) return ElevatorState.BOTTOM;
    else if (this._encoder.get() == 10) return ElevatorState.TOP;
    else return ElevatorState.INTERMEDIATE;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
