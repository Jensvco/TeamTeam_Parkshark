package com.switchfully.teamteam.parkshark.domain.directors;

import javax.persistence.*;

@Entity
@Table(name = "DIRECTOR")
public class Director {

    @Id
    @GeneratedValue(strategy =  GenerationType.SEQUENCE, generator = "sequenceDirector")
    @SequenceGenerator(name = "sequenceDirector", sequenceName = "PARKSHARK_DIRECTOR_SEQ", allocationSize = 1)
    private long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name="LAST_NAME")
    private String lastName;

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    /* Required by JPA */
    private Director() {
    }

    public Director(DirectorBuilder builder) {
        firstName = builder.firstName;
        lastName = builder.lastName;
    }

    public static class DirectorBuilder {
        private String firstName;
        private String lastName;

        public static DirectorBuilder director() {
            return new DirectorBuilder();
        }

        public DirectorBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public DirectorBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Director build() {
            return new Director(this);
        }
    }

}
