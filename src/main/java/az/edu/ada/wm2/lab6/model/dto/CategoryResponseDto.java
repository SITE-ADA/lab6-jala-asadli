package az.edu.ada.wm2.lab6.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class CategoryResponseDto {
    private UUID id;
    private String name;
}