package frc.team1569.subsystems

import edu.wpi.first.wpilibj.Counter
import edu.wpi.first.wpilibj.DigitalInput
import edu.wpi.first.wpilibj.Spark
import edu.wpi.first.wpilibj.command.Subsystem
import frc.team1569.RobotMap

/**
 *
 */
class LiftSubsystem : Subsystem() {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private val liftMotor0 = Spark(RobotMap.liftPort0)
  private val liftMotor1 = Spark(RobotMap.liftPort1)

  private val reedSwitch = DigitalInput(RobotMap.reedSwitchPort)

  private val counter = Counter(reedSwitch)

  var movingToPosition = false

  override fun initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  fun liftUp(speed: Double) = this.setLiftSpeed(speed)

  fun liftDown(speed: Double) = this.setLiftSpeed(-speed)

  fun stopLift() = this.setLiftSpeed(0.0)

  fun setLift(speed: Double) = this.setLiftSpeed(speed)

  private fun setLiftSpeed(speed: Double) {
    this.liftMotor0.set(speed)
    this.liftMotor1.set(speed)
  }

  fun initCounter() = this.counter.reset()

  fun hasSwitchActivated(): Boolean = this.counter.get() > 0

}