package com.dona.practica.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(schema = "public",name = "contribuyente")
public class Contributor {
    
    @Column(name = "c_contribuyente")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codContrib;

    @NotEmpty(message = "El campo no debe estar vacio")
    @Size(max = 30, message = "El campo no debe tener mas de 30 caracteres")
    @Column(name = "s_nombre")
    private String name;

    @NotEmpty(message = "El campo no debe estar vacio")
    @Size(max = 30, message = "El campo no debe tener mas de 30 caracteres")
    @Column(name = "s_apellido")
    private String lastName;

    @NotEmpty(message = "El campo no debe estar vacio")
    @Size(max = 14, min = 14, message = "Exactamente 14 caracteres")
    @Column(name = "s_nit")
    private String nit;

    @Column(name = "f_fecha_ingreso")
    private LocalDate inDate;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "c_importancia")
    private Importance importance;


    public Contributor() {}


    public Integer getCodContrib() {
        return this.codContrib;
    }

    public void setCodContrib(Integer codContrib) {
        this.codContrib = codContrib;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNit() {
        return this.nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public LocalDate getInDate() {
        return this.inDate;
    }

    public void setInDate(LocalDate inDate) {
        this.inDate = inDate;
    }


    public Importance getImportance() {
        return this.importance;
    }

    public void setImportance(Importance importance) {
        this.importance = importance;
    }

    public String getDateDelegate() {
        if(this.inDate == null)
            return "";
        else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String shortDate = this.inDate.format(formatter);
            return shortDate;
        }
    }
    
    @PrePersist
    public void prePersist() {
        this.inDate = LocalDate.now();
    }
}