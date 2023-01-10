import math        # 내장함수중엔 소수점 이하를 버리는 기능이 없어서 math 모듈을 불러온다.
a, b = map(int, input().split())
print(a+b)
print(a-b)
print(a*b)
print(math.trunc(a/b))
