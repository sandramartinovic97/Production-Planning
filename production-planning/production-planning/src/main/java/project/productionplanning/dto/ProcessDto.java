package project.productionplanning.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ProcessDto {
    private Integer processId;
    private Date processTime;
}
