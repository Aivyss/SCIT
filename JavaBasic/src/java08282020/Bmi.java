/*
    어떤 사람의 키(cm)와 몸무게(kg)을 입력받아 그 사람의 BMI를 구하고 아래와 같이
    비만여부의 결과를 출력하는 프로그램을 작성하시오.
    이때 비만여부 결과 판단기준은 계산된 BMI를 아래의 기준으로 판단합니다.


    비만여부 판단기준
    - 고도 비만 : 40 초과
    - 비만 30 초과 / 40 이하
    - 과체중 : 25 초과 / 30 이하
    - 정상 :   18.5 초과 / 25 이하
    - 저체중 : 18.5 이하

    Author: Hangyeol Lee
    Date: 07/09 - 2020
*/
package java08282020;

import java.util.Scanner;

public class Bmi {
    public static void main(String[] args) {
        //Define variables
        double height, weight;
        double bmi = 0;
        String grade = " ";

        // Input values
        Scanner sc = new Scanner(System.in);
        System.out.print("당신의 신장을 cm 단위로 입력하세요: ");
        height = sc.nextDouble();
        System.out.print("당신의 체중을 kg 단위로 입력하세요: ");
        weight = sc.nextDouble();

        // Process
        height = height*0.01;
        bmi = weight / (height*height);

        if (bmi>40) grade = "고도 비만";
        else if (bmi>30) grade = "비만";
        else if (bmi>25) grade = "과체중";
        else if (bmi>18.5) grade = "정상";
        else grade = "저체중";

        // Output
        System.out.println("당신의 BMI수치는 "+ bmi +"(으)로 " + grade + "입니다.");
        
        sc.close();
    }
}