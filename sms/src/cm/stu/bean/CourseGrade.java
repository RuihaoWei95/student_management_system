package cm.stu.bean;

public class CourseGrade extends Course{
    private Double low;
    private Double median;
    private Double high;
    public CourseGrade(String courseName, String courseId, String courseTime, Double low, Double median, Double high) {
        super(courseName, courseId, courseTime);
        this.low = low;
        this.median = median;
        this.high = high;
    }

    public CourseGrade() {
    }

    public Double getLow() {
        return low;
    }

    public void setLow(Double low) {
        this.low = low;
    }

    public Double getMedian() {
        return median;
    }

    public void setMedian(Double median) {
        this.median = median;
    }

    public Double getHigh() {
        return high;
    }

    public void setHigh(Double high) {
        this.high = high;
    }

    @Override
    public String toString() {
        return "CourseGrade{" +
                "low=" + low +
                ", median=" + median +
                ", high=" + high +
                '}';
    }
}
