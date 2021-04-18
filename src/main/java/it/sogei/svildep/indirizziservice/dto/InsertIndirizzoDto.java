package it.sogei.svildep.indirizziservice.dto;

import it.sogei.svildep.indirizziservice.validation.XORFields;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;
@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@XORFields.List({
        @XORFields(
                field = "comuneId",
                fieldMatch = "statoEsteroId",
                message = "fuffa"
        )
})
public class InsertIndirizzoDto extends SvildepDto{

    @NotBlank
    private String civico;
    @NotBlank
    private String indirizzo;
    @NotBlank
    private String cap;
    private String dettaglio;
    private String ripartizione;
    @NotBlank
    private String tipoIndirizzoId;
    @NotBlank
    private String soggettoFisicoId;
    private String comuneId;
    private String statoEsteroId;
}
