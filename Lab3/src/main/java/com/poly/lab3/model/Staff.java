package poly.edu.lab3.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Staff {
    private String email;
    private String fullname;
    private String photo = "photo.jpg";
    private Boolean gender = true;
    private Date birthday = new Date();
    private Double salary = 12345.6789;
    private Integer level = 0;
}
