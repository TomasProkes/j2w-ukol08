package cz.czechitas.java2webapps.ukol8.entity;

import org.hibernate.validator.constraints.Length;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import javax.validation.Constraint;
import javax.validation.constraints.Max;
import java.math.BigInteger;
import java.time.LocalDate;

/**
 * Entity for storing blog post records
 */
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Length(max = 100)
    private String slug;

    @Length(max = 100)
    private String author;

    @Length(max = 255)
    private String title;

    private String perex;

    private String body;

    private LocalDate published;
}
