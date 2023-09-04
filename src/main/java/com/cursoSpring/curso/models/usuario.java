package com.cursoSpring.curso.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Table(name = "Usuarios")
@Entity
@ToString
@EqualsAndHashCode
public class usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Getter @Setter

    private Long id;

    @Getter @Setter
    @Column(name = "name")
    private String nombre;

    @Getter @Setter
    @Column(name = "last_name")
    private String apellido;

    @Getter @Setter
    @Column(name = "email")
    private String email;

    @Getter @Setter
    @Column(name = "phone")
    private String telefono;

    @Getter @Setter
    @Column(name = "password")
    private String password;


    public usuario() {

    }

    public usuario(Long id, String nombre, String apellido, String email, String telefono, String password) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.password = password;
    }

    public usuario(String nombre, String apellido, String email, String telefono, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.password = password;
    }



}
