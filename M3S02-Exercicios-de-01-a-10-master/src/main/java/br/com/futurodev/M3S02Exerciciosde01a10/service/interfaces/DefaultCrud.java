package br.com.futurodev.M3S02Exerciciosde01a10.service.interfaces;

import java.util.List;

public interface DefaultCrud <T>{
    T salvar(T object);
    T atualizar(Long id, T object);
    T buscar(Long id);
    List<T> listar();
    void deletar(Long id);
}
