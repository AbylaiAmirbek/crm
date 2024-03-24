package crm.crmsystem.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "APPLICATION")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApplicationRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "coursename")
    private String coursename;

    @Column(name = "commentary")
    private String commentary;

    @Column(name = "phone")
    private String phone;

    @Column(name = "handled")
    private boolean handled;

}
