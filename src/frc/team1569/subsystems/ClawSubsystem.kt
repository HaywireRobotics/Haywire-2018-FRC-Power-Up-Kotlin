package frc.team1569.subsystems

import edu.wpi.first.wpilibj.DoubleSolenoid
import edu.wpi.first.wpilibj.VictorSP
import edu.wpi.first.wpilibj.command.Subsystem
import frc.team1569.RobotMap

/**
 *
 */
class ClawSubsystem: Subsystem() {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private val claw = VictorSP(RobotMap.clawPort)
  private val clawSolenoid = DoubleSolenoid(RobotMap.solenoid0OpenPort, RobotMap.solenoid0ClosePort)

  override fun initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  fun setRotateClaw(speed: Double) = this.claw.set(speed)

  fun setClawOpen() = this.clawSolenoid.set(DoubleSolenoid.Value.kForward)

  fun setClawClose() = this.clawSolenoid.set(DoubleSolenoid.Value.kReverse)

  fun setClawSolenoidStop() = this.clawSolenoid.set(DoubleSolenoid.Value.kOff)

}