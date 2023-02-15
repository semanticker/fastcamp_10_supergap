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


    public double multiplyCreditAndCourseGrade() {
        return credit * getGradeToNumber();
    }

    public int getCredit() {
        return credit;
    }

    public double getGradeToNumber() {

        double gradeNumber = 0;

        switch (this.grade) {
            case "A+":
                gradeNumber = 4.5;
                break;
            case "A":
                gradeNumber = 4.0;
                break;
            case "B+":
                gradeNumber = 3.5;
                break;
            case "B":
                gradeNumber = 3.0;
                break;
            case "C+":
                gradeNumber = 2.5;
                break;
            case "C":
                gradeNumber = 2.0;
                break;
        }

        return gradeNumber;
    }

}
