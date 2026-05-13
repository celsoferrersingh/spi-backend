# SPI - Sistema de Visão Computacional Industrial
## API REST - Sprint 1 Backend

API REST desenvolvida com **Spring Boot** para o projeto **SPI (Sistemas de Integração)**, 
no contexto da **Metaindústria**. O sistema gerencia ocorrências industriais detectadas por 
visão computacional na linha de produção.

---

## Entidade Principal: Ocorrência

Representa um defeito ou anomalia detectada automaticamente pelo sistema de visão computacional.

| Campo              | Tipo          | Descrição                                              |
|--------------------|---------------|--------------------------------------------------------|
| `id`               | Long          | Identificador único (gerado automaticamente)           |
| `descricao`        | String        | Descrição detalhada da ocorrência                      |
| `tipoDefeito`      | String        | Tipo do defeito: TRINCA, CORROSAO, DEFEITO_DIMENSIONAL, CONTAMINACAO, OUTRO |
| `localizacao`      | String        | Local na linha de produção (ex: "Linha A - Estação 3") |
| `gravidadeNivel`   | Integer       | Nível de gravidade de 1 (baixo) a 5 (crítico)         |
| `status`           | String        | Status: ABERTA, EM_ANALISE, RESOLVIDA                  |
| `dataHoraDeteccao` | LocalDateTime | Data e hora da detecção pela visão computacional       |
| `imagemReferencia` | String        | Caminho ou referência da imagem que gerou o alerta     |
| `observacoes`      | String        | Observações adicionais do operador                     |

---

## Endpoints Disponíveis

Base URL: `http://localhost:8080`

| Método   | Endpoint              | Descrição                        |
|----------|-----------------------|----------------------------------|
| `POST`   | `/ocorrencias`        | Registrar nova ocorrência        |
| `GET`    | `/ocorrencias`        | Listar todas as ocorrências      |
| `GET`    | `/ocorrencias/{id}`   | Buscar ocorrência por ID         |
| `PUT`    | `/ocorrencias/{id}`   | Atualizar ocorrência existente   |
| `DELETE` | `/ocorrencias/{id}`   | Remover ocorrência               |

### Exemplo de Body para POST / PUT

```json
{
  "descricao": "Trinca superficial detectada na peça #4471",
  "tipoDefeito": "TRINCA",
  "localizacao": "Linha A - Estação 3",
  "gravidadeNivel": 4,
  "status": "ABERTA",
  "dataHoraDeteccao": "2026-05-12T10:30:00",
  "imagemReferencia": "imagens/captura_4471.jpg",
  "observacoes": "Detectado pelo sensor de câmera S-03"
}
```

---

## Como Rodar o Projeto

### Pré-requisitos
- Java 17 instalado
- Maven instalado (ou use a wrapper `./mvnw`)

### Passo a Passo

1. **Clone o repositório**
   ```bash
   git clone <URL_DO_REPOSITORIO>
   cd spi-backend
   ```

2. **Compile e rode o projeto**
   ```bash
   mvn spring-boot:run
   ```
   Ou com a wrapper Maven:
   ```bash
   ./mvnw spring-boot:run
   ```

3. **Acesse a API**
   - API: `http://localhost:8080/ocorrencias`
   - Console H2: `http://localhost:8080/h2-console`
     - JDBC URL: `jdbc:h2:file:./data/spidb`
     - User: `sa` | Password: *(vazio)*

---

## Arquitetura do Projeto

```
src/main/java/br/com/metaindustria/spi/
├── SpiApplication.java          # Classe principal Spring Boot
├── controller/
│   └── OcorrenciaController.java   # Endpoints REST
├── service/
│   └── OcorrenciaService.java      # Regras de negócio
├── repository/
│   └── OcorrenciaRepository.java   # Acesso ao banco de dados
└── model/
    └── Ocorrencia.java             # Entidade JPA
```

---

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.2.5**
- **Spring Web** (API REST)
- **Spring Data JPA** (persistência)
- **Banco H2** (modo file - dados persistem após reinicialização)
- **Maven** (gerenciamento de dependências)

---

## Contexto do Projeto

Este backend faz parte do projeto **SPI - Sistemas de Integração**, desenvolvido para a 
disciplina de **Metaindústria**. O sistema integra-se com a etapa de **Visão Computacional** 
(Sprint anterior), recebendo e gerenciando as ocorrências detectadas automaticamente 
nas linhas de produção industrial.
