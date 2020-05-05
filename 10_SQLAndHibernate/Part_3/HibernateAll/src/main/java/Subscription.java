import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Subscriptions")
public class Subscription implements Serializable{

    @Id
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Student student;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Course course;

    @Column(name = "subscription_date")
    private Date subscriptionsDate;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Date getSubscriptionsDate() {
        return subscriptionsDate;
    }

    public void setSubscriptionsDate(Date subscriptionsDate) {
        this.subscriptionsDate = subscriptionsDate;
    }

    @Override
    public String toString() {
        return "Subscriptions{" +
                "student=" + student +
                ", course=" + course +
                ", subscriptionsDate=" + subscriptionsDate +
                '}';
    }
}
