package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import java.lang.Math;

@TeleOp(name = "Drive2")
public class Drive2 extends LinearOpMode {

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
      
        // forward
        double drive = gamepad1.left_stick_y;
        double turn = gamepad1.left_stick_x;
        boolean forward = true;
        boolean left_turn = false;
        if (turn > 0) {
          forward = false;
          left_turn = true;
        } else if (turn < 0) {
          forward = false;
        }
        double power = drive*2;
        if (!forward) {
          power = power + Math.abs(turn);
        }
        if (forward) {
          frontRight.setPower(-power);
          backRight.setPower(power);
          frontLeft.setPower(power);
          backLeft.setPower(-power);
        } else {
          if (left_turn) {
            frontRight.setPower(-power);
            backRight.setPower(0.0);
            frontLeft.setPower(power);
            backLeft.setPower(-power);
          } else {
            frontRight.setPower(-power);
            backRight.setPower(power);
            frontLeft.setPower(power);
            backLeft.setPower(0.0);
          }
        }
      }
    }
  }
  
}
