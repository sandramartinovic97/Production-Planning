package project.productionplanning.dto;

import lombok.Data;

@Data
public class ProductDto {
    private Integer productId;
    private String productName;
    private MachineDto machineId;
}
