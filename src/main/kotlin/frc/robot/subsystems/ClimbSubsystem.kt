package frc.team1569.subsystems

import edu.wpi.first.wpilibj.Spark
import edu.wpi.first.wpilibj.command.Subsystem
import frc.team1569.RobotMap

/**
 *
 */
class ClimbSubsystem : Subsystem() {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private val tapeMotor = Spark(RobotMap.climbTapePort)
  private val winchMotor = Spark(RobotMap.climbWinchPort)

  override fun initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  fun setTapeSpeed(speed: Double) = this.tapeMotor.set(speed)

  fun setWinchSpeed(speed: Double) = this.winchMotor.set(speed)

}