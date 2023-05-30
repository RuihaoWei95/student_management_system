package cm.stu.bean;

public class TeacherCourse {
    private String UID;
    private String userAccount;
    private String courseId;

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public TeacherCourse(String UID, String userAccount, String courseId) {
        this.UID = UID;
        this.userAccount = userAccount;
        this.courseId = courseId;
    }

    public TeacherCourse() {
    }

    @Override
    public String toString() {
        return "TeacherCourse{" +
                "UID='" + UID + '\'' +
                ", userAccount='" + userAccount + '\'' +
                ", courseId='" + courseId + '\'' +
                '}';
    }
}
