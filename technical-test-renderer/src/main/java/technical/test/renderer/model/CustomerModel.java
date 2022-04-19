package technical.test.renderer.model;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerModel {
    @NotEmpty
    private String email;
    @NotEmpty
    private String lastName;
}
