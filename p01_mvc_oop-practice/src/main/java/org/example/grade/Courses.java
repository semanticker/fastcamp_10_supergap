package org.example.grade;

import java.util.List;

public class Courses {

    private final List<Course> courses;

    public Courses(List<Course> courses) {
        this.courses = courses;
    }

    public double multiplyCreditAndCourseGrade() {

        // (학점수x교과목 평점)의 합계
        /*double resultCredit = 0;

        for (Course course : courses) {
            // resultCredit += course.getCredit() * course.getGradeToNumber();
            resultCredit += course.multiplyCreditAndCourseGrade();

        }

        return resultCredit;*/
        return courses.stream()
                .mapToDouble(Course::multiplyCreditAndCourseGrade)
                .sum();
    }

    public int calculateTotalCompletedCredit() {

        return courses.stream()
                .mapToInt(Course::getCredit)
                .sum();
    }
}
