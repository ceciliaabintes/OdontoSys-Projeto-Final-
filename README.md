# OdontoSys

O OdontoSys é uma aplicação desenvolvida para otimizar o fluxo de agendamentos de consultas em clínicas odontológicas. O sistema visa facilitar o fluxo de agendamentos dos horários de atendimento dos dentistas, possibilitando o cadastro de pacientes evitando conflito de agendas e substituindo processos manuaus por uma solução digital integrada.

```
classDiagram
    direction TB

    %% ==================== MODEL ====================
    namespace model {
        class Pessoa {
            <<abstract>>
            -int id
            -String nome
            -String telefone
            -String email
            +getDados()* String
        }

        class Paciente {
            -String cpf
            -String dataNascimento
            -String endereco
            +atualizarCadastro() void
            +getDados() String
        }

        class Dentista {
            -String cro
            -String especialidade
            -List~Horario~ horarios
            +definirHorario(Horario h) void
            +getDados() String
        }

        class Horario {
            -int idHorario
            -String diaSemana
            -String horaInicio
            -String horaFim
            -boolean disponivel
            +bloquear() void
            +liberar() void
        }

        class Consulta {
            -int idConsulta
            -String dataHora
            -String tipoConsulta
            -String status
            -String observacoes
            +agendar(Paciente p, Dentista d, Horario h) void
            +cancelar() void
            +confirmar() void
        }
    }

    %% ==================== SERVICE ====================
    namespace service {
        class IValidador {
            <<interface>>
            +validar()* boolean
        }

        class ValidadorHorario {
            -Horario horario
            +validar() boolean
        }

        class ValidadorPaciente {
            -Paciente paciente
            +validar() boolean
        }

        class SistemaAgendamento {
            -List~Pessoa~ pessoas
            -List~Consulta~ consultas
            -List~IValidador~ validadores
            -List~Horario~ horarios
            +getPacientes() List~Paciente~
            +getDentistas() List~Dentista~
            +adicionarPessoa(Pessoa p) void
            +adicionarHorario(Horario h) void
            +confirmarConsulta(int id) boolean
            +cancelarConsulta(int id) boolean
            +agendarConsulta(Consulta c, Paciente p, Dentista d, Horario h) boolean
        }
    }

    %% ==================== VIEW ====================
    namespace view {
        class TelaPrincipal {
            -SistemaAgendamento sistema
            +exibir() void
            +abrirTelaAgendarConsulta() void
        }

        class TelaAgendarConsulta {
            -SistemaAgendamento sistema
            +agendarConsulta() void
            +confirmar() void
            +cancelar() void
        }

        class TelaCadastroHorario {
            -SistemaAgendamento sistema
            +cadastrarHorario() void
            +confirmar() void
            +cancelar() void
        }

        class TelaCadastroPaciente {
            -SistemaAgendamento sistema
            +cadastrarPaciente() void
            +confirmar() void
            +cancelar() void
        }

        class TelaCadastroDentista {
            -SistemaAgendamento sistema
            +cadastrarDentista() void
            +confirmar() void
            +cancelar() void
        }

        class TelaGerenciarConsultas {
            -SistemaAgendamento sistema
            +carregarConsultas() void
            +confirmar() void
            +cancelar() void
        }

        class TelaListarConsultas {
            -SistemaAgendamento sistema
            +listar() void
        }

        class TelaListarDentistas {
            -SistemaAgendamento sistema
            +listar() void
        }

        class TelaListarPacientes {
            -SistemaAgendamento sistema
            +listar() void
        }
    }

    %% ==================== ROOT ====================
    class Main {
        +main(String[] args)$ void
    }

    %% ====== RELACIONAMENTOS COM DESCRIÇÃO TEXTUAL ======
    %% Herança / Implementação
    Pessoa <|-- Paciente : "Herança (Paciente herda de Pessoa)"
    Pessoa <|-- Dentista : "Herança (Dentista herda de Pessoa)"
    IValidador <|.. ValidadorHorario : "Implementação (ValidadorHorario implementa IValidador)"
    IValidador <|.. ValidadorPaciente : "Implementação (ValidadorPaciente implementa IValidador)"

    %% Associações dentro do Model
    Consulta "1" --> "1" Paciente : "Composição - Consulta depende de Paciente"
    Consulta "1" --> "1" Dentista : "Composição - Consulta depende de Dentista"
    Consulta "1" --> "1" Horario : "Composição - Consulta depende de Horario"
    Dentista "1" --> "*" Horario : "Associação - Dentista possui vários Horarios"

    %% Conexões do SERVICE
    SistemaAgendamento "1" --> "*" Pessoa : "Agregação - Sistema gerencia Pessoas"
    SistemaAgendamento "1" --> "*" Consulta : "Agregação - Sistema gerencia Consultas"
    SistemaAgendamento "1" --> "*" Horario : "Agregação - Sistema gerencia Horarios"
    SistemaAgendamento "1" --> "*" IValidador : "Agregação - Sistema utiliza IValidadores"

    %% Conexões da camada VIEW -> SERVICE
    TelaPrincipal "1" --> "1" SistemaAgendamento : "Dependência - Usa SistemaAgendamento"
    TelaAgendarConsulta "1" --> "1" SistemaAgendamento : "Dependência - Usa SistemaAgendamento"
    TelaCadastroDentista "1" --> "1" SistemaAgendamento : "Dependência - Usa SistemaAgendamento"
    TelaCadastroHorario "1" --> "1" SistemaAgendamento : "Dependência - Usa SistemaAgendamento"
    TelaCadastroPaciente "1" --> "1" SistemaAgendamento : "Dependência - Usa SistemaAgendamento"
    TelaGerenciarConsultas "1" --> "1" SistemaAgendamento : "Dependência - Usa SistemaAgendamento"
    TelaListarConsultas "1" --> "1" SistemaAgendamento : "Dependência - Usa SistemaAgendamento"
    TelaListarDentistas "1" --> "1" SistemaAgendamento : "Dependência - Usa SistemaAgendamento"
    TelaListarPacientes "1" --> "1" SistemaAgendamento : "Dependência - Usa SistemaAgendamento"

    %% Fluxo inicial
    Main "1" ..> "1" SistemaAgendamento : "Cria instância do SistemaAgendamento"
    Main "1" ..> "1" TelaPrincipal : "Abre a TelaPrincipal"
```
