package com.example.labfinal7.entities;

import javax.persistence.*;

@Table(name = "documents")
@Entity
@NamedQueries({
        @NamedQuery(name = "Document.getAll",
                query = "select d from Document d")
})
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 256)
    private String name;

    @Column(name = "author", length = 256)
    private String author;

    @Column(name = "content", length = 256)
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}