package frc.team1569.subsystems

import edu.wpi.first.wpilibj.*
import edu.wpi.first.wpilibj.command.Subsystem
import edu.wpi.first.wpilibj.drive.DifferentialDrive
import frc.team1569.RobotMap

/**
 *
 */
class DriveTrainSubsystem : Subsystem() {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private val driveTrainLeft0 = PWMVictorSPX(RobotMap.driveTrainLeft0Port)
  private val driveTrainLeft1 = PWMVictorSPX(RobotMap.driveTrainLeft1Port)
  private val driveTrainLeftGroup = SpeedControllerGroup(driveTrainLeft0, driveTrainLeft1)

  private val driveTrainRight0 = PWMVictorSPX(RobotMap.driveTrainRight0Port)
  private val driveTrainRight1 = PWMVictorSPX(RobotMap.driveTrainRight1Port)
  private val driveTrainRightGroup = SpeedControllerGroup(driveTrainRight0, driveTrainRight1)

  private val myRobot = DifferentialDrive(driveTrainLeftGroup, driveTrainRightGroup)
  var drivingBackward: Boolean = false

  private val gyro = ADXRS450_Gyro(SPI.Port.kOnboardCS0)

  override fun initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  // TODO: Make sure the drive acts correctly
  fun takeJoystickInputs(left: Joystick, right: Joystick) = myRobot.tankDrive(left.y, right.y)

  fun tankDrive(left: Double, right: Double) = myRobot.tankDrive(left, right, false)

  fun stopRobot() = myRobot.tankDrive(0.0, 0.0)

  fun driveForward(speed: Double) = this.tankDrive(speed, speed)

  fun getGyroValue(): Double = this.gyro.angle

  fun resetGryo() = gyro.reset()

}