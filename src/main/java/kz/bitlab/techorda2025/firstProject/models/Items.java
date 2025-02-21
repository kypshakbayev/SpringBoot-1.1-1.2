package kz.bitlab.techorda2025.firstProject.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Items {
    private Long id;
    private String name;
    private String description;
    private double price;
}
