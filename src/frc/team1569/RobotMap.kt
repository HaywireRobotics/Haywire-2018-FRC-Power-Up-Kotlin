package frc.team1569

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
object RobotMap {
    // Joystick constants
    const val joystickLeftPort = 1
    const val joystickRightPort = 0
    const val joystickManipulator0Port = 2
    const val joystickManipulator1Port = 3

    //Motor constants
    const val driveTrainLeft0Port = 0
    const val driveTrainLeft1Port = 1
    const val driveTrainRight0Port = 8
    const val driveTrainRight1Port = 9

    const val liftPort0 = 5
    const val liftPort1 = 6
    const val clawPort = 4

    const val climbTapePort = 2
    const val climbWinchPort = 3

    //Button constants
    const val extendPistonPort = 1
    const val retractPistonPort = 3

    const val clawRotatePos = 4
    const val clawRotateNeg = 5

    const val tapeOut = 6
    const val tapeIn = 7

    const val winchIn = 10
    const val winchOut = 9

    //Pneumatics constants
    const val solenoid0OpenPort = 0
    const val solenoid0ClosePort = 1

    //Sensors constants
    const val reedSwitchPort = 2
}