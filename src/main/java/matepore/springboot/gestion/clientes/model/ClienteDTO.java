package matepore.springboot.gestion.clientes.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(
        name = "ClienteDTO",
        description = "Objeto de transferencia de datos que representa a un cliente del sistema."
)
public class ClienteDTO {

    @Schema(
            description = "Identificador único del cliente.",
            example = "1",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private Long id;

    @Schema(
            description = "Nombre del cliente.",
            example = "Marcelo"
    )
    private String nombre;

    @Schema(
            description = "Apellido del cliente.",
            example = "Ocampo"
    )
    private String apellido;

    @Schema(
            description = "Edad actual del cliente.",
            example = "25",
            minimum = "0"
    )
    private Integer edad;

    @Schema(
            description = "Fecha de nacimiento del cliente en formato ISO (yyyy-MM-dd).",
            example = "2000-05-17"
    )
    private LocalDate fechaNacimiento;

    @Schema(
            description = "Edad completa del cliente desglosada en años, meses y días.",
            implementation = EdadCompletaDTO.class,
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private EdadCompletaDTO edadCompleta;
}
