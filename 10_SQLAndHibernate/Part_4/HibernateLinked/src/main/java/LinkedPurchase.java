import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "LinkedPurchaseList")
public class LinkedPurchase implements Serializable {

    @Id
    @Column(name = "student_id", nullable = false, unique = true)
    private Integer studentId;

    @Id
    @Column(name = "course_id", nullable = false, unique = true)
    private Integer courseId;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "LinkedPurchase{" +
                "student_id=" + studentId +
                ", course_id=" + courseId +
                '}';
    }
}
