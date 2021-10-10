package project.productionplanning.dto;

import lombok.Data;

@Data
public class WarehouseDto {
    private Integer warehouseId;
    private MaterialDto materialId;
    private SupplierDto supplierId;
}
