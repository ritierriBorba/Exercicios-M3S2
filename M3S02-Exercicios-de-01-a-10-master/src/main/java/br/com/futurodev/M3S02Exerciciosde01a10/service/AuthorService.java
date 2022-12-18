package br.com.futurodev.M3S02Exerciciosde01a10.service;

import br.com.futurodev.M3S02Exerciciosde01a10.entity.Author;
import br.com.futurodev.M3S02Exerciciosde01a10.repository.AuthorRepository;
import br.com.futurodev.M3S02Exerciciosde01a10.interfaces.AuthorInterface;
import br.com.futurodev.M3S02Exerciciosde01a10.service.interfaces.AuthorInterface;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.AccessType;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService implements AuthorInterface {


    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Author salvar(Author author) {
        return this.authorRepository.save(author);
    }

    @Override
    public Author atualizar(Long id, Author author) {
        Optional<Author> authorPesquisado = this.authorRepository.findById(id);
        if (authorPesquisado.isPresent()){
            BeanUtils.copyProperties(author, authorPesquisado.get(), "id");
            return this.salvar(authorPesquisado.get());
        }
        return null;
    }

    @Override
    public Author buscar(Long id) {
        return this.authorRepository.findById(id).orElseThrow(() -> {
            throw  new EntityNotFoundException("Author com id " + id + " nao encontrado!");
        });
    }

    @Override
    public List<Author> listar() {
        return this.authorRepository.findAll();
    }

    @Override
    public void deletar(Long id) {
        Optional<Author> authorPesquisado = this.authorRepository.findById(id);
        if (authorPesquisado.isPresent()){
            this.authorRepository.delete(authorPesquisado.get());
        }
    }
}
