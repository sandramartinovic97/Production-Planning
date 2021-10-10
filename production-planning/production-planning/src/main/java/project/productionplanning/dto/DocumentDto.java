package project.productionplanning.dto;

import lombok.Data;

@Data
public class DocumentDto {
    private Integer documentId;
    private ProductDto productId;
    private UserDto userId; //manager
    private MachineDto machineId;
}
