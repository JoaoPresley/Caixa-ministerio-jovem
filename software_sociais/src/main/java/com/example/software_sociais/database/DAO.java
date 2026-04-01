package com.example.software_sociais.database;

import com.example.software_sociais.objects.Evento;

import java.util.List;

//T -> Qualquer objeto, permite usar o mesmo DAO para varios objetos
public interface DAO <T>{
    void insert(T t);
    void del(T t);
    void update (T t);
    List <T> listar();
}
