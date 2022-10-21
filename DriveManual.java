package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "DriveManual")
public class DriveManual extends LinearOpMode {

  private DcMotor frontRight;
  private DcMotor frontLeft;
  private DcMotor backRight;
  private DcMotor backLeft;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    double rightPower;
    double leftPower;

    frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
    frontRight = hardwareMap.get(DcMotor.class, "frontRight");
    backLeft = hardwareMap.get(DcMotor.class, "backLeft");
    backRight = hardwareMap.get(DcMotor.class, "backRight");
    

    // Put initialization blocks here.
    waitForStart();
    if (opModeIsActive()) {
      // Put run blocks here.
      while (opModeIsActive()) {
        // Put loop blocks here.
      
        double drive = -gamepad1.left_stick_x;
        double turn  =  gamepad1.left_stick_y;
        leftPower    = Range.clip(drive*0.5 + turn, -1.0, 1.0) ;
        rightPower   = Range.clip(drive*0.5 - turn, -1.0, 1.0) ;
        drive = -gamepad1.right_stick_x;
        turn  =  gamepad1.right_stick_y;
        if (drive != 0.0) {
        leftPower    = Range.clip(drive + turn, -1.0, 1.0) ;
        rightPower   = Range.clip(drive - turn, -1.0, 1.0) ;
        }
        frontRight.setPower(rightPower);
        backRight.setPower(-rightPower);
        frontLeft.setPower(leftPower);
        backLeft.setPower(-leftPower);
        telemetry.update();
      }
    }
  }
  
}
