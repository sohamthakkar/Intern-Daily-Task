package com.example.userorg.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class Orgenization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="org_id")
    private long orgId;

    @NotEmpty(message = "Organization Name Must Required")
    @Column(name="org_name")
    private String orgName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Valid
    private List<User> users;

}
