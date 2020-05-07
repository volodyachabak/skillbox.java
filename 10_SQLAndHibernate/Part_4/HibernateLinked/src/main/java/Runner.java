import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.Query;
import java.util.List;

public class Runner {

    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();

        List<Purchase> purchaseList = session.createQuery("FROM Purchase").list();

        purchaseList.forEach((p)-> {
            LinkedPurchase linkedPurchase = new LinkedPurchase();

            Query queryStudent = session.createQuery("from Student where name = :name");
            queryStudent.setParameter("name", p.getStudentName());
            Student student = (Student) queryStudent.getSingleResult();

            Query queryCourse = session.createQuery("from Course where name = :name");
            queryCourse.setParameter("name", p.getCourseName());
            Course course = (Course) queryCourse.getSingleResult();

            linkedPurchase.setStudentId(student.getId());
            linkedPurchase.setCourseId(course.getId());

            System.out.println(linkedPurchase);

            session.save(linkedPurchase);
        });


        session.createQuery("FROM LinkedPurchase").list().forEach(System.out::println);

        session.close();
    }
}
