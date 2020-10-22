# Bank System

URL

[https://github.com/Aivyss/SCIT/tree/master/ToyProject/src/bankSystem](https://github.com/Aivyss/SCIT/tree/master/ToyProject/src/bankSystem)

초반부에 짜놓은 코드라 각 클래스(객체)의 특징에 맞지 않는 메소드들이 조금 있음. 또한 ArrayList보다 계좌번호를 key값으로 HashMap을 이용하는 편이 더 나음.

# Account (VO class)

## member variables

계좌주

은행명

계좌번호

계좌종류

비밀번호

잔고

lock여부

## methods

입금

출금

잔액조회

비밀번호 체크

lock  set, get 등

# ManageAccount (manager Class)

## member variables

계좌 vo 객체를 저장하는 ArrayList

## methods

입금

출금

송금

조회

잔액조회

비밀번호 체크