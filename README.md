# shoesshop_refactor
2409 팀프로젝트를 리팩토링


# 👟 Shoes 프로젝트 (리팩토링 버전)

## 📌 프로젝트 개요
- **주제**: 신발 쇼핑몰 웹 애플리케이션
- **목적**: 기존 프로젝트를 리팩토링하여 가독성, 유지보수성, 품질을 개선
- **핵심 포인트**: 객체지향 설계 원칙 적용, 테스트 코드 작성, 오류 분석 기록, 문서화

---

## 🛠 기술 스택
### Backend
- Java 17, Spring Boot
- Spring Data JPA, MySQL
- JUnit5


### Infra & Tools
- GitHub, IntelliJ IDEA
- Gradle or Maven
- Docker (선택)

---

## 🎯 리팩토링 목표
1. **코드 이해 기반 작성**  
   - 의미를 모르는 코드는 복붙하지 않고, 이해 후 작성 + 주석 달기
2. **테스트 코드 강화**  
   - JUnit 기반 단위/통합 테스트 작성, 테스트 커버리지 향상
3. **오류 분석 기록**  
   - 오류 메세지, 원인, 해결 방법을 문서화
4. **코드 구조 개선**  
   - 중복 제거, 책임 분리, 객체지향 설계 원칙(SRP) 적용
5. **문서화 & 커밋 관리**  
   - 리팩토링 전후 차이 기록, 작은 단위 커밋, 기술적 선택 근거 문서화

---

## 📂 프로젝트 구조 (예시)
shoes-refactor/
├── backend/ # Spring Boot API 서버
│ ├── src/main/java
│ ├── src/test/java # JUnit 테스트
│ └── build.gradle
├── frontend/ # React 프론트엔드
│ ├── src
│ └── package.json
├── docs/ # 문서
│ ├── REFACTORING_PRINCIPLES.md
│ ├── ERROR_LOG.md
│ └── CHANGE_LOG.md
└── README.md



---

## ✅ 개선 포인트 예시
- `OrderService` 클래스: 서비스 레이어에서 DB 직접 접근 → Repository 패턴 도입
- 컨트롤러 로직 분리: DTO 도입으로 계층 간 의존성 줄임
- 테스트 코드: `주문 생성/취소` 단위 테스트 및 통합 테스트 작성
- 프론트엔드: API 호출 로직을 `services/` 레이어로 분리

---

## 🧪 테스트
- JUnit5 + Mockito로 단위/통합 테스트 작성
- 주요 시나리오: 회원가입, 로그인, 상품 조회, 장바구니, 주문/결제
- 목표: **테스트 커버리지 70% 이상**

---

## 📖 문서
- [리팩토링 원칙](./docs/REFACTORING_PRINCIPLES.md)  
- [오류 로그 및 해결 기록](./docs/ERROR_LOG.md)  
- [변경 이력](./docs/CHANGE_LOG.md)

---

## 🚀 실행 방법
### Backend
```bash
cd backend
./gradlew bootRun


🙋‍♂️ 회고

이번 리팩토링을 통해 단순한 CRUD 구현을 넘어서,
문제 원인을 추적하고 해결하는 능력
테스트 기반 개발 경험
코드 품질과 설계에 대한 고민
을 체득할 수 있었습니다.
