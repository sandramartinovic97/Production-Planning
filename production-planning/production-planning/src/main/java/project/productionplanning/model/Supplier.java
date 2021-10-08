package project.productionplanning.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "supplier")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer supplierId;
    @Column
    private String supplierName;
    @Column
    private String supplierEmail;
    @Column
    private String supplierPhone;
    @Column
    private String supplierCountry;
    @Column
    private String supplierCity;
    @Column
    private String supplierAddress;
}
