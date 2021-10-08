package project.productionplanning.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;
    @Column(name = "product_name")
    private String productName;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "machine_id", referencedColumnName = "machineId")
    private Integer machineId;
}
