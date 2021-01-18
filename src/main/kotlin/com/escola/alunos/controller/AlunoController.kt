package com.escola.alunos.controller

import com.escola.alunos.model.Aluno
import com.escola.alunos.model.ErrorMessage
import com.escola.alunos.model.RespostaJSON
import com.escola.alunos.service.AlunoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*


@RestController
@RequestMapping(value = ["/alunos"])
class AlunoController {

    @Autowired
    lateinit var alunoService: AlunoService

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<Any> {
        var status = HttpStatus.NOT_FOUND
        if (this.alunoService.getById(id) != null) {
            status = HttpStatus.ACCEPTED
            this.alunoService.delete(id)

        }
        return ResponseEntity(Unit, status)
    }


    @PostMapping()
    fun create(@RequestBody aluno: Aluno): ResponseEntity<RespostaJSON> {
        this.alunoService.create(aluno)
        val respostaJSON = RespostaJSON("Ok")
        return ResponseEntity(respostaJSON, HttpStatus.CREATED)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Unit> {

        var status = HttpStatus.NOT_FOUND
        if (this.alunoService.getById(id) != null) {
            status = HttpStatus.ACCEPTED
            this.alunoService.delete(id)

        }
        return ResponseEntity(Unit, status)
    }


}