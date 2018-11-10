package frc.team1569.commands

import edu.wpi.first.wpilibj.command.Command
import frc.team1569.Robot

import java.lang.Math.max


class DriveRightTurn(private val inputAngle: Double) : Command() {

  private var startLoop: Boolean = false
  private var turnAngle: Double = 0.toDouble()
  private val speed: Double
  private var rampSpeed: Double = 0.toDouble()
  private val oneQuarterAngle: Double
  private val threeQuarterAngle: Double
  private val currentProgress: Double
  private val beforeAngle: Double

  init {
    requires(Robot.driveTrainSubsystem)
    this.startLoop = true
    this.turnAngle = Robot.driveTrainSubsystem.getGyroValue() + inputAngle
    this.speed = 0.4
    this.rampSpeed = 0.0
    this.oneQuarterAngle = 0.0
    this.threeQuarterAngle = 0.0
    this.currentProgress = 0.0
    this.beforeAngle = 0.0
  }

  override fun initialize() {}

  override fun execute() {
    if (this.startLoop) {
      this.turnAngle = this.inputAngle * .66 + Robot.driveTrainSubsystem.getGyroValue()
      this.rampSpeed = 0.0
      this.startLoop = false
    }

    this.rampSpeed -= 0.05
    this.rampSpeed = max(this.rampSpeed, this.speed)
    Robot.driveTrainSubsystem.tankDrive(this.rampSpeed, -2 * this.rampSpeed)
  }

  override fun isFinished(): Boolean {
    return Robot.driveTrainSubsystem.getGyroValue() >= this.turnAngle
  }

  override fun end() {
    Robot.driveTrainSubsystem.stopRobot()
    this.startLoop = true
  }
}
