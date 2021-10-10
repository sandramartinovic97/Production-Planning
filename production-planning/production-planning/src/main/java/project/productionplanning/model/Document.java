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
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private User userId; //manager
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "machine_id", referencedColumnName = "machineId")
    private Machine machineId;
}
