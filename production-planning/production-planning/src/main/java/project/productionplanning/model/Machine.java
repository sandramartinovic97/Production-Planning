package project.productionplanning.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "machine")
public class Machine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer machineId;
    @Column(name = "machine_serial_number")
    private String machineSerialNumber;
}
