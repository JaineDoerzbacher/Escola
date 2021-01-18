package com.escola.alunos.repository

import com.escola.alunos.model.Aluno
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface AlunosRepository : PagingAndSortingRepository<Aluno, Long> {

}