## 기능 요구 사항

_디자인 시안을 참고하여 새 태스크 생성 모달을 구현한다._

- 새 태스크 생성 버튼에 모달을 연결한다.
- 각 상태별 태스크 개수를 트래킹한다.
- 상태(To-Do, In Progress, Done)별 태스크 개수가 노출된다.
- 전체 할 일 중 완료된 일의 비율을 계산한다.

## 프로그래밍 요구 사항

- Row와 Column, LazyRow와 LazyColumn 등 요구 사항에 적절한 컴포넌트를 선택한다.
- 재사용 가능한 컴포넌트에 대해 고민해본다.
- 적절한 테스트 방법을 활용하여 기능 요구 사항을 테스트한다.
- 모든 요구 사항이 테스트 가능하진 않다. 스스로 판단해서 구분한다.
- 특정 조건에 따라 Snackbar를 노출한다.

## 디자인 시안

[![Figma](https://img.shields.io/badge/Figma-F24E1E?style=for-the-badge&logo=figma&logoColor=white)](https://www.figma.com/design/3aBG3UfkTwmHM8BnPyahtT/8%EA%B8%B0-Android-%EB%A0%88%EB%B2%A81-%EB%AF%B8%EC%85%98-%EB%94%94%EC%9E%90%EC%9D%B8?node-id=21642-2&t=SPJymlvCZzu3Soms-1)

# 🚀 2단계 - 칸반 보드 생성(보드)

## 기능 목록

1. 칸반 보드 구현
    - [x] 태스크 생성 버튼 클릭 시 모달 노출
    - [x] 각 상태별 태스크 개수 트래킹
        - [x] 상태별 태스크 개수 노출
        - [x] 전체 할 일 중 완료된 일의 비율 계산
        - [x] 해당 비율을 %와 프로그래스바로 노출
    - [x] 상태별 태스크를 분리하여 노출

- [x] 태스크 생성 완료 시 SnackBar 노출
