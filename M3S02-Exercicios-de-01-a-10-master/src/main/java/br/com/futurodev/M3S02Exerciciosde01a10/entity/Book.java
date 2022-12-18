package br.com.futurodev.M3S02Exerciciosde01a10.entity;

import lombok.*;

import javax.persistence.*;
import java.nio.DoubleBuffer;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;


    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    private Integer quantity;

    private Double preco;
}