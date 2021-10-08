package project.productionplanning.dto;

import lombok.Data;

@Data
public class PartProductDto {
    private Integer partProductId;
    private String partProductName;
    private String partProductDimension;
    private ProductDto productId;
    private MaterialDto materialId;
}
