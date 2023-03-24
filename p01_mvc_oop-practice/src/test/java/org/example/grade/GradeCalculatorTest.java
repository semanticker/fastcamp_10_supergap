package org.example.grade;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * 요구사항
 * 평균학점 계산 방법 = (학점수x교과목 평점)의 합계/수강신청 총학점 수
 * 일급 컬렉션 사용
 */
public class GradeCalculatorTest {
    // 학점 계산기 도메인 : 이수한 과목, 학점 계산기
    // 객체들 간의 관계 고민 : 계산기가 과목의 평균을 계산
    // 정적인 타입으로 추상화 해서 도메인 모델링
    // 이수한 과목 : 객체지향프로그래밍, 자료구조, 중국어회화
    // -> 과목, 클래스로 표현
    // 평균학점을 계산하기 위해서 -> 이수한 과목을 학점 계산기 -> 전달하여 평균학점 계산 요청
    // 학점수x교과목 평점의 합계, 수강신청 총합점 수


    @DisplayName("평균 학점을 계산한다.")
    @Test
    void calculateGradeTest() {
        List<Course> courseList = List.of(
                new Course("OOP",3,"A+"),
                //new Course("",1,""),
                new Course("자료구조",3,"A+")
        );

        //GradeCalculator gradeCalculator = new GradeCalculator(courseList);
        GradeCalculator gradeCalculator = new GradeCalculator(new Courses(courseList));
        double result = gradeCalculator.calculateGrade();

        assertThat(result).isEqualTo(4.5);
    }
}
