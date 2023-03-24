package org.example.grade;

import java.util.List;

public class GradeCalculator {

    // 일급 클래스 : 리스트 형태로 된 코스 리스트를 인스턴스 변수로만 가진 클래스
    // 해당
    private final Courses courses;


    public GradeCalculator(List<Course> courses) {
        this.courses = new Courses(courses);
    }

    public GradeCalculator(Courses courses) {
        this.courses = courses;
    }

    /**
     * 요구사항
     * 평균학점 계산 방법 = (학점수x교과목 평점)의 합계/수강신청 총학점 수
     * 일급 컬렉션 사용
     *
     * 평균학점을 계산하기 위해서 -> 이수한 과목을 학점 계산기 -> 전달하여 (학점수X교과목 평점) 평균학점 계산 요청  --> 과목(코스) 일급 컬렉션
     * 학점수x교과목 평점의 합계, 수강신청 총합점 수 --> 과목(코스) 일급 컬렉션
     */
    public double calculateGrade() {

        // (학점수 * 교과목 평점)의 합계
        double totalMultipliedCreditAndCourseGrade = courses.multiplyCreditAndCourseGrade();

        // 수강신청 총학점 수
        int totalCompletedCredit = courses.calculateTotalCompletedCredit();

        return totalMultipliedCreditAndCourseGrade/totalCompletedCredit;
    }
}
