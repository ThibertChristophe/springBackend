package com.example.springBackend.entities;

import com.example.springBackend.enums.TypeRole;
import jakarta.persistence.*;

@Entity
@Table(name = "ROLE")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private TypeRole typeRole;

    public Role() {
    }

    public Role(int id, TypeRole typeRole) {
        this.id = id;
        this.typeRole = typeRole;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TypeRole getTypeRole() {
        return typeRole;
    }

    public void setTypeRole(TypeRole typeRole) {
        this.typeRole = typeRole;
    }
}
