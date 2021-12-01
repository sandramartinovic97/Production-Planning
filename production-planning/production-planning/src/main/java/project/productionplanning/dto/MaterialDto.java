package project.productionplanning.dto;

import lombok.Data;

@Data
public class MaterialDto {
    private Integer materialId;
    private String materialName;
    private String materialSerialNumber;
    private Integer currentMaterialQuantity;
    private Integer startingMaterialQuantity;
    private DocumentDto documentId;
}
