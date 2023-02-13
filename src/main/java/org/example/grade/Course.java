package org.example.grade;

public class Course {
    /** 과목명 */
    private final String subject;
    /** 학점 */
    private final int credit;
    /** 성적 */
    private final String grade;

    public Course(String subject, int credit, String grade) {
        this.subject = subject;
        this.credit = credit;
        this.grade = grade;

    }
}
