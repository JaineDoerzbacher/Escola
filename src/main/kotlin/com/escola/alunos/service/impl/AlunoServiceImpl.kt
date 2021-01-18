package com.escola.alunos.service.impl

import com.escola.alunos.model.Aluno
import com.escola.alunos.repository.AlunosRepository
import com.escola.alunos.service.AlunoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Component

@Component
class AlunoServiceImpl : AlunoService {

    @Autowired
    lateinit var alunosRepository: AlunosRepository

    override fun create(aluno: Aluno) {
        this.alunosRepository.save(aluno)
    }

    override fun getById(id: Long): Aluno? {

        return alunosRepository.findById(id).orElseGet(null)
    }

    override fun delete(id: Long) = this.alunosRepository.deleteById(id)

    override fun update(id: Long, aluno: Aluno) {

        create(aluno)
    }

    override fun searchByNome(id: Long): List<Aluno> =

        this.alunosRepository.findAll(Sort.by("nome").descending()).toList()




    override fun getAll(): List<Aluno> {
        val todosAlunos = alunosRepository.findAll().sortedBy { it.nome }
        return todosAlunos
    }

    override fun count(): Long =
        this.alunosRepository.count()



}