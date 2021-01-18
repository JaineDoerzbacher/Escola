package com.escola.alunos.service

import com.escola.alunos.model.Aluno
import org.springframework.stereotype.Service

@Service
interface AlunoService {

    fun create(aluno: Aluno)
    fun getById(id: Long): Aluno?
    fun delete(id: Long)
    fun update(id: Long, aluno: Aluno)
    fun searchByNome(id: Long): List<Aluno>
    fun getAll(): List<Aluno>
    fun count(): Long

}