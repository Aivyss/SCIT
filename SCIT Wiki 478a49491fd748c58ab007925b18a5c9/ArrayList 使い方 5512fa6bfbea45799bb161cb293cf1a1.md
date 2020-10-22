# ArrayList 使い方

# ArrayList Data type

- Object
- import 필요함 (import java.util.ArrayList;)

# ArrayListの長所

- ArrayList를 이용해 메서드에서 반환값을 여러개로 할 수 있음. 자바 메소드의 한계를 극복가능.
- Array와 다르게 size를 유동적으로 다룰 수 있음.
- 

# ArrayList에 담을 수 있는 자료형

`<>` general을 사용하므로 지정한 객체를 담을 수 있다.

다형적 형변환을 이용하면 다양한 자식 객체를 받을 수도 있다.

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

어레이리스트의 사이즈를 integer 타입으로 반환

### .isEmpty()

리승트의 사이즈가 0인지 아닌지 boolean 값으로 반환

# 例

[https://github.com/Aivyss/SCIT/tree/master/ToyProject/src/postIt](https://github.com/Aivyss/SCIT/tree/master/ToyProject/src/postIt)

[https://github.com/Aivyss/SCIT/tree/master/ToyProject/src/parkingSystem](https://github.com/Aivyss/SCIT/tree/master/ToyProject/src/parkingSystem)

[https://github.com/Aivyss/SCIT/tree/master/Problem1/src/addressbook](https://github.com/Aivyss/SCIT/tree/master/Problem1/src/addressbook)

[https://github.com/Aivyss/SCIT/tree/master/Problem2/src/global/sesoc/baseball](https://github.com/Aivyss/SCIT/tree/master/Problem2/src/global/sesoc/baseball)