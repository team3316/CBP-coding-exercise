package frc.robot.commandGroups;

import edu.wpi.first.wpilibj2.command.PrintCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.SetElevatorState;
import frc.robot.commands.SetIntakeArmState;
import frc.robot.commands.SetIntakeRollersState;
import frc.robot.subsystems.Elevator.ElevatorState;
import frc.robot.subsystems.IntakeArm.IntakeArmState;
import frc.robot.subsystems.IntakeRollers.IntakeRollersState;

/**
 * Collect
 */
public class Collect extends SequentialCommandGroup {

    public Collect() {
        addCommands(
            new SetElevatorState(ElevatorState.BOTTOM),
            parallel(
                new SetIntakeArmState(IntakeArmState.OPEN),
                new SetIntakeRollersState(IntakeRollersState.IN)
            ),
            new PrintCommand("COMMAND GROUP FINISHED")
        );
    }
}