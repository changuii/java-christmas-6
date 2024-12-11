## 기능 목록

### 입력

- [x]  사용자에게 예상 방문 날짜를 입력받아라
  - [x]  방문할 날짜는 1 이상 31 이하의 숫자로만 입력받아라
  - [x]  1 이상 31 이하의 숫자가 아닌 경우, "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."라는 에러 메시지를 보여 주세요.

```
12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)
3
```

- [ ]  사용자에게 주문할 메뉴와 개수를 입력받아라
  - [ ]  고객이 메뉴판에 없는 메뉴를 입력하는 경우, "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."라는 에러 메시지를 보여 주세요.
  - [ ]  메뉴의 개수는 1 이상의 숫자만 입력되도록 해주세요. 이외의 입력값은 "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."라는 에러 메시지를 보여 주세요.
  - [ ]  메뉴 형식이 예시와 다른 경우, "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."라는 에러 메시지를 보여 주세요.
  - [ ]  중복 메뉴를 입력한 경우(e.g. 시저샐러드-1,시저샐러드-1), "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."라는 에러 메시지를 보여 주세요.

```
주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)
티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1
```

### 출력

- [ ]  이벤트 소개 메시지를 출력하라

```
안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.
```

- [ ]  방문 날짜를 입력받기 위한 안내 메시지를 출력하라

```
12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)
```

- [ ]  주문할 메뉴와 메뉴 개수를 입력받기 위한 안내 메시지를 출력하라

```
주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)
```

- [ ]  우테코 식당에서 받을 이벤트 혜택 미리보기 소개 메시지를 출력하라

```
12월 3일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!
```

- [ ]  주문 메뉴를 출력하라
  - [ ]  주문 메뉴의 출력 순서는 자유롭게 출력해 주세요.

```
<주문 메뉴>
티본스테이크 1개
바비큐립 1개
초코케이크 2개
제로콜라 1개
```

- [ ]  할인 전 총 금액을 출력하라

```
<할인 전 총주문 금액>
142,000원
```

- [ ]  증정 메뉴를 출력하라
  - [ ]  증정 이벤트에 해당하지 않는 경우, 증정 메뉴 "없음"으로 보여 주세요.

```
<증정 메뉴>
샴페인 1개
```

- [ ]  혜택 내역을 출력하라
  - [ ]  고객에게 적용된 이벤트 내역만 보여 주세요.
  - [ ]  적용된 이벤트가 하나도 없다면 혜택 내역 "없음"으로 보여 주세요.
  - [ ]  혜택 내역에 여러 개의 이벤트가 적용된 경우, 출력 순서는 자유롭게 출력해주세요.

```
<혜택 내역>
크리스마스 디데이 할인: -1,200원
평일 할인: -4,046원
특별 할인: -1,000원
증정 이벤트: -25,000원
```

- [ ]  총 혜택 금액을 출력하라

```
<총혜택 금액>
-31,246원
```

- [ ]  할인 후 예상 결제 금액을 출력하라
  - [ ]  할인 후 예상 결제 금액 = 할인 전 총주문 금액 - 할인 금액

```
<할인 후 예상 결제 금액>
135,754원
```

- [ ]  12월 이벤트 배지를 출력하라
  - [ ]  총혜택 금액에 따라 이벤트 배지의 이름을 다르게 보여 주세요.
  - [ ]  총혜택 금액 = 할인 금액의 합계 + 증정 메뉴의 가격
  - [ ]  이벤트 배지가 부여되지 않는 경우, "없음"으로 보여 주세요.

```
<12월 이벤트 배지>
산타
```

### 실행 결과 예시

```
안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.
12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)
3
주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)
티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1
12월 3일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!
 
<주문 메뉴>
티본스테이크 1개
바비큐립 1개
초코케이크 2개
제로콜라 1개
 
<할인 전 총주문 금액>
142,000원
 
<증정 메뉴>
샴페인 1개
 
<혜택 내역>
크리스마스 디데이 할인: -1,200원
평일 할인: -4,046원
특별 할인: -1,000원
증정 이벤트: -25,000원
 
<총혜택 금액>
-31,246원
 
<할인 후 예상 결제 금액>
135,754원
 
<12월 이벤트 배지>
산타
```

**적용된 이벤트가 없는 경우**

```
안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.
12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)
26 
주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)
타파스-1,제로콜라-1 
12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!
 
<주문 메뉴>
타파스 1개
제로콜라 1개

<할인 전 총주문 금액>
8,500원
 
<증정 메뉴>
없음
 
<혜택 내역>
없음
 
<총혜택 금액>
0원
 
<할인 후 예상 결제 금액>
8,500원
 
<12월 이벤트 배지>
없음
```

### 기능

**이벤트**

- [ ]  크리스마스 디데이 할인
  - [ ]  12월 1일부터 25일이 다가올수록 할인 금액을 1,000원으로 시작하여 100원씩 증가시켜라
  - [ ]  12월 1일 ~ 25일 사이라면 총 주문 금액에서 할인 금액만큼 할인시켜라
- [ ]  평일 할인
  - [ ]  일요일 ~ 목요일이라면, 디저트 메뉴를 1개당 2023원 할인해라
- [ ]  주말 할인
  - [ ]  금요일 ~ 토요일이라면, 메인 메뉴를 1개당 2023원 할인해라
- [ ]  특별 할인
  - [ ]  달력에 별이 있다면, 총 주문 금액에서 1000원 할인하라
  - [ ]  특별 할인 날짜는 `[3, 10, 17, 24, 25, 31]`이다.
- [ ]  증정 이벤트
  - [ ]  할인 전 총 주문금액이 12만원 이상이라면, 샴페인 1개를 증정하라
- [ ]  크리스마스 디데이 할인을 제외한 이벤트는 12월 한달동안 적용하라

**이벤트 배지**

- [ ]  총 금액에 따라 이벤트 배지를 부여하라
  - [ ]  혜택 금액이 5천원 이상이라면 별 배지를 부여하라
  - [ ]  혜택 금액이 1만원 이상이라면 트리 배지를 부여하라
  - [ ]  혜택 금액이 2만원 이상이라면 산타 배지를 부여하라
- [ ]  총혜택 금액 = 할인 금액의 합계 + 증정 메뉴의 가격

**이벤트 예외 상황**

- [ ]  총 주문 금액이 10,000원 이상부터 이벤트가 적용된다.
- [ ]  음료만 주문 시, 주문할 수 없다.
- [ ]  메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.
  - (e.g. 시저샐러드-1, 티본스테이크-1, 크리스마스파스타-1, 제로콜라-3, 아이스크림-1의 총개수는 7개)

**메뉴**

```
<애피타이저>
양송이수프(6,000), 타파스(5,500), 시저샐러드(8,000)

<메인>
티본스테이크(55,000), 바비큐립(54,000), 해산물파스타(35,000), 크리스마스파스타(25,000)

<디저트>
초코케이크(15,000), 아이스크림(5,000)

<음료>
제로콜라(3,000), 레드와인(60,000), 샴페인(25,000)
```

### 실행 흐름

1. 이벤트 플래너 소개 메시지를 출력한다.
2. 예상 방문 날짜를 입력받기 위한 메시지를 출력한다.
3. 예상 방문 날짜를 사용자로부터 입력받는다.
4. 주문할 메뉴와 개수를 입력받기 위한 메시지를 출력한다.
5. 주문할 메뉴와 개수를 사용자로부터 입력받는다.
6. 이벤트 미리보기 소개 메시지를 출력한다.
7. 주문 메뉴 가격의 총 합을 계산한다.
8. 이벤트를 체크한다.
  1. 크리스마스 디데이 할인 금액을 계산한다.
  2. 증정 메뉴를 계산한다.
  3. 평일이라면 평일 할인을 적용한다.
  4. 주말이라면 주말 할인을 적용한다.
9. 전체 혜택 금액을 계산한다.
  1. 배지를 받을 수 있는지 체크한다.
10. 주문 메뉴를 출력한다.
11. 할인 전 총 주문 금액을 출력한다.
12. 증정 메뉴를 출력한다.
13. 혜택 내역을 출력한다.
14. 총 혜택 금액을 출력한다.
15. 할인 후 예상 결제 금액을 출력한다.
16. 이벤트 배지를 출력한다.

```
안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.
12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)
3
주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)
티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1
12월 3일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!
 
<주문 메뉴>
티본스테이크 1개
바비큐립 1개
초코케이크 2개
제로콜라 1개
 
<할인 전 총주문 금액>
142,000원
 
<증정 메뉴>
샴페인 1개
 
<혜택 내역>
크리스마스 디데이 할인: -1,200원
평일 할인: -4,046원
특별 할인: -1,000원
증정 이벤트: -25,000원
 
<총혜택 금액>
-31,246원
 
<할인 후 예상 결제 금액>
135,754원
 
<12월 이벤트 배지>
산타
```

### 예외 상황

**예상 방문 날짜**

1. 입력값에 문자가 있다면 예외가 발생한다.
2. 사용자가 1미만의 값을 입력했다면 예외가 발생한다.
3. 사용자가 31초과의 값을 입력했다면 예외가 발생한다.

**주문하실 메뉴와 개수**

1. 입력값의 형식이 올바르지 않다면 예외가 발생한다.
2. 메뉴의 개수가 1개 미만이라면 예외가 발생한다.
3. 메뉴의 총 개수가 20개 초과라면 예외가 발생한다.
4. 존재하지 않는 메뉴가 있다면 예외가 발생한다.