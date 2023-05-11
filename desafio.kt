enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

class Formacao(val nome: String, var nivel: Nivel, var conteudos: MutableList<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        if (!inscritos.contains(usuario)) {
            inscritos.add(usuario)
            println("Usuário ${usuario.nome} matriculado na formação $nome.")
        } else {
            println("Usuário ${usuario.nome} já está matriculado na formação $nome.")
        }
    }

    fun cancelarMatricula(usuario: Usuario) {
        if (inscritos.contains(usuario)) {
            inscritos.remove(usuario)
            println("Usuário ${usuario.nome} cancelou sua matrícula na formação $nome.")
        } else {
            println("Usuário ${usuario.nome} não está matriculado na formação $nome.")
        }
    }

    fun adicionarConteudo(conteudo: ConteudoEducacional) {
        conteudos.add(conteudo)
        println("Conteúdo ${conteudo.nome} adicionado à formação $nome.")
    }

    fun removerConteudo(conteudo: ConteudoEducacional) {
        if (conteudos.contains(conteudo)) {
            conteudos.remove(conteudo)
            println("Conteúdo ${conteudo.nome} removido da formação $nome.")
        } else {
            println("Conteúdo ${conteudo.nome} não está presente na formação $nome.")
        }
    }

    fun exibirConteudos() {
        println("Conteúdos da formação $nome:")
        conteudos.forEach { conteudo ->
            println(" - ${conteudo.nome} (${conteudo.duracao} minutos)")
        }
    }
}

fun main() {
    val usuario1 = Usuario("Mario")
    val usuario2 = Usuario("Maria")

    val conteudo1 = ConteudoEducacional("Introdução a programação", 30)
    val conteudo2 = ConteudoEducacional("Estruturas de dados", 70)
    val conteudo3 = ConteudoEducacional("Algoritmos de busca", 45)

    val formacao1 = Formacao("Desenvolvimento Web", Nivel.INTERMEDIARIO, mutableListOf(conteudo1))
    formacao1.adicionarConteudo(conteudo2)
    formacao1.adicionarConteudo(conteudo3)
    formacao1.exibirConteudos()

    formacao1.matricular(usuario1)
    formacao1.matricular(usuario2)
    formacao1.matricular(usuario2)

    formacao1.cancelarMatricula(usuario1)
    formacao1.cancelarMatricula(usuario1)

    val formacao2 = Formacao("Inteligência Artificial", Nivel.DIFICIL, mutableListOf(conteudo2))
    formacao2.adicionarConteudo(conteudo3)
    formacao2.exibirConteudos()

    formacao2.matricular(usuario1)
    formacao2.matricular(usuario2)
}
