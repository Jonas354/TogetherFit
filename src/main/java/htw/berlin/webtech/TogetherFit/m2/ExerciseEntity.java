package htw.berlin.webtech.TogetherFit.m2;

import javax.persistence.*;


@Entity(name= "exercises")
public class ExerciseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private Long id;

    @Column(name= "name", nullable = false)
    private String name;

    // just for Hibernate
    protected  ExerciseEntity() {}

    public ExerciseEntity(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
