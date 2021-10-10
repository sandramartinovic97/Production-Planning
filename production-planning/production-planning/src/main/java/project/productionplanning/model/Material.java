package project.productionplanning.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "material")
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer materialId;
    @Column
    private String materialName;
    @Column
    private String materialSerialNumber;
    @Column
    private Integer materialQuantity;
    //@ManyToOne(cascade = CascadeType.MERGE)
    //@JoinColumn(name = "document_id", referencedColumnName = "documentId")
    //private Document documentId;
}
