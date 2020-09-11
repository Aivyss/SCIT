# ArrayList 使い方

# ArrayList Data type

- Class 타입
- import 필요함 (import java.util.ArrayList;)

# ArrayListの長所

- ArrayList를 이용해 메서드에서 반환값을 여러개로 할 수 있음.
- Array와 다르게 size를 유동적으로 다룰 수 있음.

# ArrayList에 담을 수 있는 자료형

```java
import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListWay {
	public static void main(String[] args) {
		 /* 
		  * <Object> You can input class or others type.
		  * <Integer> You can input int type.
		  * <Double> You can input double type.
		  * <String> You can input String type.
		  */
		ArrayList<Object> aLObject = new ArrayList();
		ArrayList<Object> aLObjectTest = new ArrayList();
		ArrayList<Integer> aLInt = new ArrayList(); 		
		ArrayList<Double> aLDouble = new ArrayList(); 	
		ArrayList<String> aLString = new ArrayList(); 	
	}
}
```

- Object : 
기본적으로 객체
그러나 정수, 배열, 실수 등 여러 타입을 받고 강제형변환을 통해 반출 가능.
- Integer
- Double
- String

# Methods

### .add( 변수명 )

해당 변수를 새로운 어레이리스트의 인덱스 번지에 저장

### .get( 인덱스 )

어레이리스트 해당 인덱스 번지에 있는 변수를 인출

### .set( 인덱스, 변수명 )

해당 어레이리스트 인덱스 번지에 변수를 저장

### .remove ( 인덱스 )

해당 어레이리스트 인덱스 번지 공간을 삭제

### .size()

어레이리스트의 사이즈를 정수타입으로 반환