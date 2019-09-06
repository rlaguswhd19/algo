# Jenkins

# **Jenkins란**

###### 소프트웨어 개발시 지속적 통합 서비스를 제공하는 툴이다. 다수의 개발자들이 하나의 프로그램을 개발할 때 버전 충돌을 방지하기 위해 각자 작업한 내용을 공유 영역에 있는 저장소에 빈번히 업로드함으로써 지속적 통합이 가능하도록 해준다.

######  지속적 통합(Continuous Integration, CI)과 지속적 배포(Continuous Delivery, CD)를 위한 대표적인 도구입니다.

### **Jenkins의 이점**

- 지속적 통합을 사용하여 빌드, 테스트, 배포 과정을 자동화하여 개발 생산성을 향상할 수 있습니다.
- 자동화 테스트를 통하여 소프트웨어 품질을 향상할 수 있습니다.
- 지속적인 통합을 통해 안정적인 릴리즈를 빠르게 배포할 수 있습니다.

### **젠킨스 파이프라인**

######  pipeline은 한 데이터 처리 단계의 출력이 다음 단계의 입력으로 이어지는 형태로 연결된 구조

###### 젠킨스 파이프라인에서는 groovy 언어를 사용한다.

**예제** 

![파이프라인 예제](C:\Users\multicampus\Desktop\파이프라인 예제.PNG)

1. pipeline : 젠킨스 파이프라인 플러그인을 호출하기 위한 필수 외부 블록
2. agent : 파이프라인을 실행하고 싶은 위치 정의
   any : 파이프라인이나 스테이지를 실행하기 위해 사용가능한 어느 agent도 사용 할 수 있음 정의 
3. echo : 간단한 console output 을 찍을 수 있다.
4. stages : stage의 모음
5. steps : 실제 작업 수행하는 블록



### 파이프라인 선언

파이프라인 선언은 간단하게 아래와 같은 block으로 이루어 진다. 모든 파이프라인은 반드시 pipeline block으로 감싸져야 한다. 파이프라인 안쪽의 statement, expression은 groovy 언어를 따른다.

- 파이프라인의 top level은 반드시 pipeline {} block 으로 이루어져야 한다.
- 세미콜론은 없음



### 섹션(Sections)

섹션은 파이프라인에서 하나이상의 스텝(Steps)이나 지시(Directives)로 이루어져 있다.

- agent : agent를 선택할 경우, 젠킨스 environment가 해당 agent로 설정된다.

- | 필수여부 | 필수                                                         |
  | -------- | ------------------------------------------------------------ |
  | 파라미터 | any : 사용가능한 agentnone : global agent는 설정되지 않음. 대신 각 stage에 설정 필요label : 특정 label 명으로 된 environment로 설정node : label과 유사docker : 특정 도커 이미지로 수행dockerfile : 도커 파일 기반으로 수행 |
  | 위치     | pipeline top level(필수)stage block(선택)                    |

- post : 특정 스테이지 이전 혹은 이후에 실행될 condition block

- | 필수여부 | 선택                                                         |
  | -------- | ------------------------------------------------------------ |
  | 파라미터 | always : 실행 끝나고나서 실행되는 stepchanged : previous run과 다른 status이면 실행되는 stepfailure : 실패하면 실행되는 stepsuccess : 성공하면 실행되는 stepunstable : test fail, code violation 등일때 실행되는 stepaborted : 강제로 중지됬을 때 실행되는 step |
  | 위치     | pipeline top level(선택)stage block(선택)                    |



- stages : 스테이지의 모음

- | 필수여부 | 필수                       |
  | -------- | -------------------------- |
  | 위치     | pipeline block에서 단 한번 |

- steps : stage 내부 block에서 여러번 호출 될 수 있는 block

- | 필수여부 | 필수                      |
  | -------- | ------------------------- |
  | 위치     | 각 stage block에서 여러번 |



### Directives(파이프라인 configure)

- environment : key-value style로 파이프라인 내부에서 사용할 변수로 선언 가능하다.

- | 필수여부 | 선택                               |
  | -------- | ---------------------------------- |
  | 위치     | 파이프라인 혹은 스테이지 블락 내부 |

- options : pipeline의 옵션을 선택적으로 집어 넣을 수 있다.

- | 필수여부 | 선택                         |
  | -------- | ---------------------------- |
  | 위치     | 파이프라인 블락 안쪽 단 한번 |

- - 

- parameters : 유저로부터 트리거링 받은 변수들에 대해서 선언할 수 있다.

- | 필수여부 | 선택                         |
  | -------- | ---------------------------- |
  | 위치     | 파이프라인 블락 안쪽 단 한번 |

- triggers : cront, pollSCM, upstream 등 여러방식으로 트리거를 구성할 수 있다.