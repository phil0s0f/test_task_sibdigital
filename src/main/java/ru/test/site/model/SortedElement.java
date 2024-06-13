package ru.test.site.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class SortedElement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long elementId;
    private Integer value;
    private Integer indexNumber;
    @ManyToOne
    @JoinColumn(name = "sort_result_id", referencedColumnName = "id")
    private SortResult sortResultId;
}
