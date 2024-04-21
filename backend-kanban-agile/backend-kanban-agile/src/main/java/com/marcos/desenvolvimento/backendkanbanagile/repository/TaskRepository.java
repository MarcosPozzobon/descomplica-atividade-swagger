package com.marcos.desenvolvimento.backendkanbanagile.repository;

import com.marcos.desenvolvimento.backendkanbanagile.entity.Task;
import com.marcos.desenvolvimento.backendkanbanagile.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query(value = "SELECT * FROM tasks WHERE id = %:identificador%", nativeQuery = true)
    public Task findTaskById(@Param("identificador") Long identificador);

    @Query(value = "SELECT * FROM tasks WHERE titulo LIKE %:titulo%", nativeQuery = true)
    public List<Task> findByTitulo(@Param("titulo") String titulo);

    @Query(value = "SELECT * FROM tasks WHERE descricao LIKE %:descricao%", nativeQuery = true)
    public List<Task> findByDescricao(String descricao);

    @Query(value = "SELECT * FROM tasks WHERE estado LIKE %:estado%", nativeQuery = true)
    public List<Task> findByEstado(String estado);

    @Transactional
    @Modifying
    @Query(value = "UPDATE tasks SET estado = 'Backlog' WHERE id = :taskId", nativeQuery = true)
    void atualizarParaBacklog(@Param("taskId") Long taskId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE tasks SET estado = 'Doing' WHERE id = :taskId", nativeQuery = true)
    void atualizarParaDoing(@Param("taskId") Long taskId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE tasks SET estado = 'Review' WHERE id = :taskId", nativeQuery = true)
    void atualizarParaReview(@Param("taskId") Long taskId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE tasks SET estado = 'Done' WHERE id = :taskId", nativeQuery = true)
    void atualizarParaDone(@Param("taskId") Long taskId);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM tasks WHERE id = :id", nativeQuery = true)
    void deletarTarefaPorId(@Param("id") Long id);



}
