package project.productionplanning.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "process")
public class Process {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer processId;
    @Column
    private Date processTime;
}
