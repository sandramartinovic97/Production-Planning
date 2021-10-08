package project.productionplanning.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "document")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer documentId;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "product_id", referencedColumnName = "productId")
    private Product productId;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "worker_id", referencedColumnName = "workerId")
    private User workerId;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "manager_id", referencedColumnName = "managerId")
    private User managerId;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "machine_id", referencedColumnName = "machineId")
    private Machine machineId;
}
