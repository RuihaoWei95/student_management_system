package cm.stu.bean;

public class Course {
    private String courseName;
    private String courseId;
    private String courseTime;

    public Course(String courseName, String courseId, String courseTime) {
        this.courseName = courseName;
        this.courseId = courseId;
        this.courseTime = courseTime;
    }

    public Course() {
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime;
    }

    @Override
    public String toString() {
        return "Course{" +
                "CourseName='" + courseName + '\'' +
                ", CourseId='" + courseId + '\'' +
                ", CourseTime='" + courseTime + '\'' +
                '}';
    }
}
