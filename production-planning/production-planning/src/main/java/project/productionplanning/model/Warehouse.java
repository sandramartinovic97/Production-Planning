package project.productionplanning.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "warehouse")
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer warehouseId;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "material_id", referencedColumnName = "materialId")
    private Material materialId;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "supplier_id", referencedColumnName = "supplierId")
    private Supplier supplierId;
}
