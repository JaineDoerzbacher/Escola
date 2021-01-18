package com.escola.alunos.model

import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "TBL_ALUNOS")
data class Aluno(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val nome: String,
    val nota: Double
)
