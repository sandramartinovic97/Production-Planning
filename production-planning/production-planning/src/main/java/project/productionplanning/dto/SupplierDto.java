package project.productionplanning.dto;

import lombok.Data;

@Data
public class SupplierDto {
    private Integer supplierId;
    private String supplierName;
    private String supplierEmail;
    private String supplierPhone;
    private String supplierCountry;
    private String supplierCity;
    private String supplierAddress;
}
