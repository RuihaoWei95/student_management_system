package cm.stu.bean;

public class StudentGrade extends Person{
    private double grade;

    public StudentGrade() {
    }

    public StudentGrade(String userAccount, String userName, String userSex, String userBirthday, String userIdCard, String userPassword, int userIdentify, String userOtherName, double grade) {
        super(userAccount, userName, userSex, userBirthday, userIdCard, userPassword, userIdentify, userOtherName);
        this.grade = grade;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "StudentGrade{" +
                "grade=" + grade +
                '}';
    }
}
