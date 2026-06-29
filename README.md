OdontoSys

O OdontoSys é uma aplicação desenvolvida para otimizar o fluxo de agendamentos de consultas em clínicas odontológicas. O sistema visa facilitar o fluxo de agendamentos dos horários de atendimento dos dentistas, possibilitando o cadastro de pacientes evitando conflito de agendas e substituindo processos manuais por uma solução digital integrada.

classDiagram
    direction TB

    %% ==================== MODEL ====================
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

    %% ==================== SERVICE ====================
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

    %% ==================== VIEW ====================
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

    %% ==================== ROOT ====================
    class Main {
        +main(String[] args) void$
    }

    %% ====== RELACIONAMENTOS ======
    %% Herança / Implementação
    Pessoa <|-- Paciente : herda
    Pessoa <|-- Dentista : herda
    IValidador <|.. ValidadorHorario : implementa
    IValidador <|.. ValidadorPaciente : implementa

    %% Associações dentro do Model
    Consulta "1" --> "1" Paciente : requer
    Consulta "1" --> "1" Dentista : requer
    Consulta "1" --> "1" Horario : requer
    Dentista "1" --> "*" Horario : contem

    %% Conexões do SERVICE
    SistemaAgendamento "1" --> "*" Pessoa : gerencia
    SistemaAgendamento "1" --> "*" Consulta : gerencia
    SistemaAgendamento "1" --> "*" Horario : gerencia
    SistemaAgendamento "1" --> "*" IValidador : utiliza

    %% Conexões da camada VIEW -> SERVICE
    TelaPrincipal "1" --> "1" SistemaAgendamento : depende
    TelaAgendarConsulta "1" --> "1" SistemaAgendamento : depende
    TelaCadastroDentista "1" --> "1" SistemaAgendamento : depende
    TelaCadastroHorario "1" --> "1" SistemaAgendamento : depende
    TelaCadastroPaciente "1" --> "1" SistemaAgendamento : depende
    TelaGerenciarConsultas "1" --> "1" SistemaAgendamento : depende
    TelaListarConsultas "1" --> "1" SistemaAgendamento : depende
    TelaListarDentistas "1" --> "1" SistemaAgendamento : depende
    TelaListarPacientes "1" --> "1" SistemaAgendamento : depende

    %% Fluxo inicial
    Main "1" ..> "1" SistemaAgendamento : inicializa
    Main "1" ..> "1" TelaPrincipal : instancia
