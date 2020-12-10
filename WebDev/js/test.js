/**
 * 
 */

// 문자열을 웹상에 출력하는 메소드???
document.write("외부파일 다시 환영 데스");
document.write("가나다라 '아귀차나' 마바사아");
document.write('가나다라 "아귀차나" 마바사아');
document.write("가나다라 \"아귀차나\" 마바사아");

// 변수 선언
var str = "100";

// html 태그삽입
document.write("<h1>"+str+"문자열"+"</h1>");


// 형변환 
var num = Number(str)
var num2 = 50
document.write(num+num2)

// undefined
var undef;
var varNull = null;

// 변수타입 판단 
num = 100;
str = "JS";
var flag = true;
var obj = {};
var func = function() {};

document.write("<br>");
document.write(typeof num);
document.write("<br>");
document.write(typeof str);
document.write("<br>");
document.write(typeof flag);
document.write("<br>");
document.write(typeof obj);
document.write("<br>");
document.write(typeof func);
document.write("<br>");
document.write(typeof undef);
document.write("<br>");
document.write(typeof varNull);

// 비교연산자
document.write("<br>");
document.write(-5 > "10");
document.write("<br>");
document.write(20 < "10");
document.write("<br>");
document.write(10 == "10");
document.write("<br>"); // 자료형을 무시하고 비교
document.write(10 === "10"); // 자료형까지 비교


