# AI

### **용어 정리**

- **머신러닝:** 인공 지능의 한 분야로, 컴퓨터가 학습할 수 있도록 하는 알고리즘과 기술을 개발하는 분입니다.
- **데이터 마이닝:** 정형화된 데이터를 중심으로 분석하고 이해하고 예측하는 분야
- **지도학습 (Supervised learning):** 정답을 주고 학습시키는 머신러닝의 방법론. 대표적으로 regression과 classification이 입니다.
- **비지도학습 (Unsupervised learning):** 정답없는 데이터를 어떻게 구성되었는지를 알아내는 머신러닝의 학습 방법론. 지도 학습 혹은 강화 학습과는 달리 입력값에 대한 목표치가 주어지지 않습니다.
- **강화학습 (Reinforcement Learning):** 설정된 환경속에 보상을 주며 학습하는 머신러닝의 학습 방법론입니다.
- **Representation Learning:** 부분적인 특징을 찾는 것이 아닌 하나의 뉴럴 넷 모델로 전체의 특징을 학습하는 것을 의미합니다.
- **선형 회귀 (Linear Regression):** 종속 변수 y와 한개 이상의 독립 변수 x와의 선형 상관 관계를 모델링하는 회귀분석 기법입니다. ([위키링크](https://ko.wikipedia.org/wiki/선형_회귀))
- **자연어처리 (NLP):** 인간의 언어 형상을 컴퓨터와 같은 기계를 이용해서 모사 할 수 있도록 연구하고 이를 구현하는 인공지능의 주요 분야 중 하나입니다. ([위키링크](https://ko.wikipedia.org/wiki/자연어_처리))
- **학습 데이터 (Training data):** 모델을 학습시킬 때 사용할 데이터입니다. 학습데이터로 학습 후 모델의 여러 파라미터들을 결정합니다.
- **테스트 데이터 (Test data):** 실제 학습된 모델을 평가하는데 사용되는 데이터입니다.



# 실습

```
import numpy as np


def main():
    print(matrix_nom_var())
    print(matrix_uni_std())

def matrix_nom_var():
    
    #A = np.array[[5,2,3,0], [3,4,5,1], [3,2,7,9]] 값을 갖는 A 메트릭스를 선언합니다.
    A = np.array([[5,2,3,0], [3,4,5,1], [3,2,7,9]])

    # 주어진 A 메트릭스의 원소의 합이 1이 되도록 표준화 (Normalization) 합니다.
    A = A/np.sum(A) //표준화
    print(A)
    print(A.shape)
    print(np.sum(A, axis=0)) 
    #axis가 0이면 3을 없애서 세로로 더한거고 axis가 1이면 4를 없앰 가로로 더하겠지

    # 표준화 된 A 메트릭스의 분산을 구하여 리턴합니다.
    return np.var(A)

def matrix_uni_std():
    
    # 모든 값이 1인 4 by 4 A 메트릭스를 생성합니다.
    A = np.ones((4,4))
    print(A)

    # 표준화 된 A 메트릭스의 분산을 구하여 리턴합니다.
    return np.var(A) 

main()
```

#### 결과

```
[[5 2 3 0]
 [3 4 5 1]
 [3 2 7 9]]
(3, 4)
[11  8 15 10] //axis가 0 일때
5.888888888888889
[[1. 1. 1. 1.]
 [1. 1. 1. 1.]
 [1. 1. 1. 1.]
 [1. 1. 1. 1.]]
0.0
```



#### 기계학습(M.L)

* 비지도학습(unsupervised)

* 지도학습(supervised)

* 강화학습(RL)

###### supervised

* regression(리니어)
* clustering(center로부터 가까운점 집합)



###### regression

teget function 최대한 타겟과 가깝게?

loss function 손실 최대한 적게



