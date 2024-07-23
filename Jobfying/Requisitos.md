# Requisitos do Sistema

## R1: CRUD de profissionais (requer login de administrador)
- [X] Implementado
- [ ] Parcialmente implementado
- [ ] Não implementado

---

## R2: CRUD de empresas (requer login de administrador)
- [X] Implementado
- [ ] Parcialmente implementado
- [ ] Não implementado

---

## R3: Cadastro de vagas de estágio/trabalho (requer login da empresa via e-mail + senha)
Depois de fazer login, a empresa pode cadastrar uma vaga de estágio/trabalho. O cadastro de vagas deve possuir os seguintes dados:
- CNPJ da empresa
- Descrição (perfil profissional, habilidades desejadas, etc.)
- Remuneração
- Data limite de inscrição

O período de candidaturas (processo seletivo) para essa vaga encerra-se na data limite de inscrição.
- [ ] Implementado
- [X] Parcialmente implementado
- [ ] Não implementado

---

## R4: Listagem de todas as vagas (em aberto) em uma única página (não requer login)
O sistema deve prover a funcionalidade de filtrar as vagas (em aberto) por cidade.
- [ ] Implementado
- [X] Parcialmente implementado
- [ ] Não implementado

---

## R5: Candidatura a vaga de estágio/trabalho (requer login do profissional via e-mail + senha)
Ao clicar em uma vaga (requisito R4), o profissional pode se candidatar à vaga. Nesse caso, é necessário que ele apresente suas qualificações para a vaga -- pode ser através do upload de seu currículo em formato PDF. O sistema deve restringir que cada candidato se candidate apenas uma vez à cada vaga.
- [ ] Implementado
- [X] Parcialmente implementado
- [ ] Não implementado

---

## R6: Listagem de todas as vagas de uma empresa (requer login da empresa via e-mail + senha)
Depois de fazer login, a empresa pode visualizar todas suas vagas cadastradas.
- [ ] Implementado
- [X] Parcialmente implementado
- [ ] Não implementado

---

## R7: Listagem de todas as candidaturas de um profissional (requer login do profissional via e-mail + senha)
Depois de fazer login, o profissional pode visualizar todas suas candidaturas cadastradas com seus respectivos status. 
- ABERTO indica que a data limite de inscrição ainda não se encerrou ou ainda se encontra em fase de análise pela empresa (requisito R8).
- NÃO SELECIONADO indica que a empresa considera que o perfil do profissional não se adequa à vaga.
- ENTREVISTA indica que o candidato foi (ou será) chamado para uma entrevista.

- [ ] Implementado
- [X] Parcialmente implementado
- [ ] Não implementado

---

## R8: Fase de análise após o término do período de inscrição
A empresa (requer login da empresa via e-mail + senha) deve analisar as qualificações (currículo) de cada candidato e atualizar o status da candidatura para NÃO SELECIONADO ou ENTREVISTA. Nos dois casos, o candidato deve ser informado (via e-mail) sobre a decisão. No caso do status ENTREVISTA, a empresa deve também informar um horário para uma entrevista (via videoconferência) com o candidato -- o link da videoconferência (Google Meet, Zoom, etc.) deve estar presente no corpo da mensagem enviada.
- [ ] Implementado
- [ ] Parcialmente implementado
- [X] Não implementado

---

## R9: Internacionalização do sistema
O sistema deve ser internacionalizado em pelo menos dois idiomas: português + outro de sua escolha.
- [X] Implementado
- [ ] Parcialmente implementado
- [ ] Não implementado

---

## R10: Tratamento de erros no CRUD
O sistema deve tratar todos os erros possíveis (cadastros duplicados, problemas técnicos, etc.) mostrando uma página de erros amigável ao usuário e registrando o erro no console.
- [ ] Implementado
- [ ] Parcialmente implementado
- [X] Não implementado
