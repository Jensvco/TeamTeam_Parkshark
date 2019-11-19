package com.switchfully.teamteam.parkshark.domain.divisions;

import com.switchfully.teamteam.parkshark.domain.directors.Director;

import javax.persistence.*;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "DIVISION")
public class Division {

    @Id
    @GeneratedValue(strategy =  GenerationType.SEQUENCE, generator = "sequenceDivision")
    @SequenceGenerator(name = "sequenceDivision", sequenceName = "PARKSHARK_DIVISION_SEQ", allocationSize = 1)
    private long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ORIGINAL_NAME")
    private String originalName;

    @OneToOne(cascade = {PERSIST, MERGE, REMOVE, REFRESH, DETACH})
    @JoinColumn(name = "DIRECTOR_ID")
    private Director director;

    /* Required by JPA */
    private Division() {
    }

    public Division(DivisionBuilder builder) {
        name = builder.name;
        originalName = builder.originalName;
        director = builder.director;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOriginalName() {
        return originalName;
    }

    public Director getDirector() {
        return director;
    }

    public static class DivisionBuilder {
        private String name;
        private String originalName;
        private Director director;

        public static DivisionBuilder division() {
            return new DivisionBuilder();
        }

        public DivisionBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public DivisionBuilder withOriginalName(String originalName) {
            this.originalName = originalName;
            return this;
        }

        public DivisionBuilder withDirector(Director director) {
            this.director = director;
            return this;
        }

        public Division build() {
            return new Division(this);
        }
    }

}
