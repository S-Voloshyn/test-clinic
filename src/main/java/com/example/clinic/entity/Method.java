package com.example.clinic.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name = "METHOD")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Method {

    @Id
    @Column(name = "id_method")
    private Integer idMethod;

    @NotNull
    @Column(name = "method_identifier")
    private String methodIdentifier;

}
