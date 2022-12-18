package br.com.futurodev.M3S02Exerciciosde01a10.repository;
import br.com.futurodev.M3S02Exerciciosde01a10.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
