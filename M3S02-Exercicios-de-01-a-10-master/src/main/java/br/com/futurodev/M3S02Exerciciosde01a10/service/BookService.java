package br.com.futurodev.M3S02Exerciciosde01a10.service;

import br.com.futurodev.M3S02Exerciciosde01a10.entity.Author;
import br.com.futurodev.M3S02Exerciciosde01a10.entity.Book;
import br.com.futurodev.M3S02Exerciciosde01a10.repository.BookRepository;
import br.com.futurodev.M3S02Exerciciosde01a10.service.interfaces.BookInterface;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class BookService implements BookInterface {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book salvar(Book book) {
        return this.bookRepository.save(book);
    }

    @Override
    public Book atualizar(Long id, Book book) {
        Optional<Book> bookPesquisado = this.bookRepository.findById(id);
        if (bookPesquisado.isPresent()){
            BeanUtils.copyProperties(book, bookPesquisado.get(), "id");
            return this.salvar(bookPesquisado.get());
        }
        return null;
    }

    @Override
    public Book buscar(Long id) {
        return this.bookRepository.findById(id).orElseThrow(() -> {
            throw new EntityNotFoundException("Book com id " +  id + " nao encontrado");});
    }

    @Override
    public List<Book> listar() {
        return this.bookRepository.findAll();
    }

    @Override
    public void deletar(Long id) {
        Book book = this.buscar(id);
        this.bookRepository.delete(book);
    }
}
