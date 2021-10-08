package project.productionplanning.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "part_of_product")
public class PartProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer partProductId;
    @Column
    private String partProductName;
    @Column
    private String partProductDimension;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "product_id", referencedColumnName = "productId")
    private Product productId;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "material_id", referencedColumnName = "materialId")
    private Material materialId;
}
