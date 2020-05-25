package com.dona.practica.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(schema = "public",name = "importancia")
public class Importance {
    
    @Column(name = "c_importancia")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codImportance;

    @NotEmpty(message = "El campo no debe estar vacio")
    @Size(max = 30, message = "El campo no debe tener mas de 30 caracteres")
    @Column(name = "s_importancia")
    private String importance;

    @OneToMany(mappedBy = "importance",fetch = FetchType.LAZY)
    private List<Contributor> contributors;

    public Importance() {}

    public Integer getCodImportance() {
        return this.codImportance;
    }

    public void setCodImportance(Integer codImportance) {
        this.codImportance = codImportance;
    }

    public String getImportance() {
        return this.importance;
    }

    public void setImportance(String importance) {
        this.importance = importance;
    }



    public List<Contributor> getImportances() {
        return this.contributors;
    }

    public void setImportances(List<Contributor> contributors) {
        this.contributors = contributors;
    }


}