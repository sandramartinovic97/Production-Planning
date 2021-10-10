package project.productionplanning.dto;

import lombok.Data;

@Data
public class MaterialDto {
    private Integer materialId;
    private String materialName;
    private String materialSerialNumber;
    private Integer materialQuantity;
    private DocumentDto documentId;
}
