package com.tpe.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@NoArgsConstructor
public class Book {  // one Student/ many book
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonProperty("bookName") // JSON çıktıda isminin "bookName" olmasını sağladık
    private String name;

    @JsonIgnore // sonsuz döngüye girilmesin diye @JsonIgnore eklendi
    @ManyToOne
    @JoinColumn(name="student_id")
    private Student student;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Student getStudent() {
        return student;
    }
}
