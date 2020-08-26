/*
    문제 4분면 확인하기
    2차원 평면상에 존재하는 임의의 x, y가 있다. x, y의 값을 입력받아 
    그 두값을 좌표로 하는 위치가 어느 분면에 존재하는지 출력하시오.
    Author : Hangyeol Lee
*/

package java08262020;

import java.util.Scanner;

public class TernaryOperator {
	public static void main(String[] args) {
		// Define Variables
        double xPosition, yPosition;
        String nPosition;
        Scanner sc = new Scanner(System.in);

        // Input values
        System.out.print("Input x value(real number): ");
        xPosition = sc.nextDouble();
        System.out.print("Input y value(real number): ");
        yPosition = sc.nextDouble();

        // Process (Ternary Operator)
		nPosition = (xPosition == 0 && yPosition == 0) ? "0 position" :
					(xPosition == 0 && yPosition !=0) ? "y-axis" :
					(xPosition != 0 && yPosition ==0) ? "x-axis" :
					(xPosition > 0 && yPosition > 0) ? "1 quadrants" :
					(xPosition > 0 && yPosition < 0) ? "4 quadrants" :
					(xPosition < 0 && yPosition > 0) ? "2 quadrants" : "3 quadrants";
        System.out.println("This value are positioned at " + nPosition +".");
    }

}
