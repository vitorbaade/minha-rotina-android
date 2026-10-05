package com.example.minharotina

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var edtAtividade: EditText
    private lateinit var tvAtividades: TextView
    private val atividades = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtAtividade = findViewById(R.id.edtAtividade)
        tvAtividades = findViewById(R.id.tvAtividades)

        val btnAdicionar = findViewById<Button>(R.id.btnAdicionar)
        val btnLimpar = findViewById<Button>(R.id.btnLimpar)

        btnAdicionar.setOnClickListener {
            adicionarAtividade()
        }

        btnLimpar.setOnClickListener {
            limparAtividades()
        }
    }

    private fun adicionarAtividade() {
        val atividade = edtAtividade.text.toString()

        if (atividade.isBlank()) {
            atividades.add(atividade)
            atualizarTela()
            edtAtividade.text.clear()
        }
    }

    private fun limparAtividades() {
        atividades.clear()
        atualizarTela()
    }

    private fun atualizarTela() {
        if (atividades.isEmpty()) {
            tvAtividades.text = "Nenhuma atividade cadastrada."
        } else {
            tvAtividades.text =
                atividades.joinToString("\n") { " $it" }
        }
    }
}