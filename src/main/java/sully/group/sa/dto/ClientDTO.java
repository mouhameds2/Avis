package sully.group.sa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



public record ClientDTO(
        int id,
        String email,
        String phone
) {

}
