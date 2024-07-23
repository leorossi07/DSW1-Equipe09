R1: CRUD 1 de profissionais (requer login de administrador)
(X) Implementado ( ) Parcialmente implementado ( ) Não implementado
Divisão na implementação da funcionalidade: Membro1 (100%)
---------------------------------------------------------------------------------------------------
R2: CRUD de empresas (requer login de administrador)
(X) Implementado ( ) Parcialmente implementado ( ) Não implementado
Divisão na implementação da funcionalidade: Membro1 (100%)
---------------------------------------------------------------------------------------------------
R3: Cadastro de vagas de estágio/trabalho (requer login da empresa via e-mail + senha).
Depois de fazer login, a empresa pode cadastrar uma vaga de estágio/trabalho. O cadastro
de vagas deve possuir os seguintes dados: CNPJ da empresa, descrição (perfil profissional,
habilidades desejadas etc), remuneração e data limite de inscrição. O período de
candidaturas (processo seletivo) para essa vaga encerra-se na data limite de inscrição.
() Implementado (X) Parcialmente implementado ( ) Não implementado
Divisão na implementação da funcionalidade: Membro1 (100%)
---------------------------------------------------------------------------------------------------
R4: Listagem de todas as vagas (em aberto) em uma única página (não requer login). O
sistema deve prover a funcionalidade de filtrar as vagas (em aberto) por cidade
() Implementado (X) Parcialmente implementado ( ) Não implementado
Divisão na implementação da funcionalidade: Membro1 (100%)
---------------------------------------------------------------------------------------------------
R5: Candidatura a vaga de estágio/trabalho (requer login do profissional via e-mail + senha).
Ao clicar em uma vaga (requisito R4), o profissional pode se candidatar à vaga. Nesse caso, é
necessário que ele apresente suas qualificações para a vaga -- pode ser através do upload de
seu currículo em formato PDF. O sistema deve restrigir que cada candidato se candidate
apenas uma vez à cada vaga.
() Implementado (X) Parcialmente implementado ( ) Não implementado
Divisão na implementação da funcionalidade: Membro1 (100%)
---------------------------------------------------------------------------------------------------
R6: Listagem de todas as vagas de uma empresa (requer login da empresa via e-mail +
senha). Depois de fazer login, a empresa pode visualizar todas suas vagas cadastradas.
(X) Implementado () Parcialmente implementado ( ) Não implementado
Divisão na implementação da funcionalidade: Membro1 (100%)
---------------------------------------------------------------------------------------------------
R7: Listagem de todas as candidaturas de um profissional (requer login do profissional via email
+ senha). Depois de fazer login, o profissional pode visualizar todas suas candidaturas
cadastradas com seus respectivos status. ABERTO indica que a data limite de inscrição ainda não se encerrou ou ainda encontrase
em fase de análise pela empresa (requisito R8). NÃO SELECIONADO indica que a
empresa considera que o perfil do profissional não se adequa à vaga. ENTREVISTA
indica que o candidato foi (ou será) chamado para uma entrevista.

() Implementado (X) Parcialmente implementado ( ) Não implementado
Divisão na implementação da funcionalidade: Membro1 (100%)
---------------------------------------------------------------------------------------------------



R8: Ao término do período de inscrição, inicia-se a fase de análise. A empresa (requer login
da empresa via e-mail + senha), para cada candidato, deve analisar as suas qualificações
(currículo) e atualizar o status da candidatura para NÃO SELECIONADO ou ENTREVISTA. Nos
dois casos, o candidato deve ser informado (via e-mail) sobre a decisão. No caso do status
ENTREVISTA, a empresa deve também informar um horário para uma entrevista (via
videoconferência) com o candidato -- o link da videoconferência (google meet, zoom, etc)
deve estar presente no corpo da mensagem enviada.
() Implementado () Parcialmente implementado (X) Não implementado
Divisão na implementação da funcionalidade: Membro1 (100%)
---------------------------------------------------------------------------------------------------
R9: O sistema deve ser internacionalizado em pelo menos dois idiomas: português + outro
de sua escolha.
(X) Implementado () Parcialmente implementado () Não implementado
Divisão na implementação da funcionalidade: Membro1 (100%)
---------------------------------------------------------------------------------------------------
R10. CRUD: Create, Read, Update & Delete. ↩
O sistema deve tratar todos os erros possíveis (cadastros duplicados, problemas técnicos, etc)
mostrando uma página de erros amigável ao usuário e registrando o erro no console.
(X) Implementado () Parcialmente implementado () Não implementado
Divisão na implementação da funcionalidade: Membro1 (100%)
---------------------------------------------------------------------------------------------------
