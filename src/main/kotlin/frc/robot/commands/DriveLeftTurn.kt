package frc.team1569.commands

import edu.wpi.first.wpilibj.command.Command

import frc.team1569.Robot
import java.lang.Math.max

/**
 *
 */
class DriveLeftTurn(angle: Double): Command() {

  private var turnAngle: Double = Robot.driveTrainSubsystem.getGyroValue() + angle
  private val speed: Double = -0.4
  private var startLoop: Boolean = true
  private val inputAngle: Double = angle
  private var rampSpeed: Double = 0.0

  init {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.exampleSubsystem)
  }

  // Called just before this Command runs the first time
  override fun initialize() {}

  // Called repeatedly when this Command is scheduled to run
  override fun execute() {
    if (this.startLoop) {
      this.turnAngle = this.inputAngle * .66 + Robot.driveTrainSubsystem.getGyroValue()
      this.rampSpeed = 0.0
      this.startLoop = false
    }

    this.rampSpeed -= 0.05
    this.rampSpeed = max(this.rampSpeed, this.speed)
    Robot.driveTrainSubsystem.tankDrive(this.rampSpeed * 2, -1 * this.rampSpeed)
  }

  // Make this return true when this Command no longer needs to run execute()
  override fun isFinished(): Boolean {
    return Robot.driveTrainSubsystem.getGyroValue() <= this.turnAngle
  }

  // Make this return true when this Command no longer needs to run execute()
  override fun end() {
    Robot.driveTrainSubsystem.stopRobot()
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  override fun interrupted() {
    TODO("Not Implemented")
  }
}