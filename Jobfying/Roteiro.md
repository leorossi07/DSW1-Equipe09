## Guia de Configuração do Projeto

### 1. Configuração do Banco de Dados

#### Criação e População do Banco de Dados

1. **Criação das Tabelas**: Foram criadas as tabelas `Usuario`, `Empresa`, `Profissional`, `Vaga` e `Candidatura` com as colunas e restrições necessárias.
2. **Inserção de Dados**: Foram inseridos dados de exemplo em cada tabela para garantir que a aplicação tenha dados para exibir.

### 2. Classes de Domínio

1. **Criação das Classes de Domínio**: Foram criadas classes Java correspondentes às tabelas do banco de dados.
    - `Usuario.java`: Representa os usuários da aplicação.
    - `Empresa.java`: Representa as empresas.
    - `Profissional.java`: Representa os profissionais.
    - `Vaga.java`: Representa as vagas de emprego.
    - `Candidatura.java`: Representa as candidaturas.

### 3. DAO (Data Access Object)

1. **Criação das Classes DAO**: Foram criadas classes DAO para lidar com as operações de banco de dados para cada entidade.
    - `GenericDAO.java`: Um DAO genérico para gerenciar conexões de banco de dados e operações comuns.
    - `UsuarioDAO.java`: Gerencia operações para a tabela `Usuario`.
    - `EmpresaDAO.java`: Gerencia operações para a tabela `Empresa`.
    - `ProfissionalDAO.java`: Gerencia operações para a tabela `Profissional`.
    - `VagaDAO.java`: Gerencia operações para a tabela `Vaga`.
    - `CandidaturaDAO.java`: Gerencia operações para a tabela `Candidatura`.

### 4. Controladores

1. **Criação das Classes de Controladores**: Foram criados servlets controladores para gerenciar solicitações e respostas HTTP.
    - `IndexController.java`: Gerencia a página inicial.
    - `EmpresaController.java`: Gerencia operações relacionadas às empresas.
    - `ProfissionalController.java`: Gerencia operações relacionadas aos profissionais.
    - `VagaController.java`: Gerencia operações relacionadas às vagas de emprego.
    - `CandidaturaController.java`: Gerencia operações relacionadas às candidaturas.

### 5. Aplicação Web (Páginas JSP)

1. **Criação das Páginas JSP**: Foram projetadas páginas JSP para exibir dados e gerenciar interações.
    - `index.jsp`: A página inicial.
    - `login.jsp`: Página de login para usuários.
    - `erro.jsp`: Página de erro.
    - `noAuth.jsp`: Página de acesso não autorizado.
    - `empresa`: Diretório contendo JSPs para gerenciar empresas.
        - `formulario.jsp`: Formulário para criação ou atualização de empresas.
        - `lista.jsp`: Exibe uma lista de empresas.
        - `campos.jsp`: Contém os campos de entrada de dados para empresas.
    - `profissional`: Diretório contendo JSPs para gerenciar profissionais.
        - `formulario.jsp`: Formulário para criação ou atualização de profissionais.
        - `lista.jsp`: Exibe uma lista de profissionais.
        - `campos.jsp`: Contém os campos de entrada de dados para profissionais.
    - `vaga`: Diretório contendo JSPs para gerenciar vagas de emprego.
        - `formulario.jsp`: Formulário para criação ou atualização de vagas.
        - `lista.jsp`: Exibe uma lista de vagas de emprego.
        - `campos.jsp`: Contém os campos de entrada de dados para vagas de emprego.
    - `candidatura`: Diretório contendo JSPs para gerenciar candidaturas.
        - `formulario.jsp`: Formulário para criação ou atualização de candidaturas.
        - `lista.jsp`: Exibe uma lista de candidaturas.
        - `campos.jsp`: Contém os campos de entrada de dados para candidaturas.
    - `usuario`: Diretório contendo JSPs para gerenciar usuários.
        - `formulario.jsp`: Formulário para criação ou atualização de usuários.
        - `lista.jsp`: Exibe uma lista de usuários.
        - `campos.jsp`: Contém os campos de entrada de dados para usuários.

### Como rodar o código...?

## Rode o banco de dados com Apache Derby
1. Vá ao diretório do projeto e execute `java -Dderby.system.home=<caminho para db> -Dij.protocol=jdbc:derby: -jar C:\db-derby-10.15.2.0-bin/lib/derbyrun.jar ij`
2. Após isso, execute `db/Derby/create.sql`.
3. Inicie o server com ` java -Dderby.system.home=<caminho para db> -jar  C:\db-derby-10.15.2.0-bin/lib/derbyrun.jar server start `
 

## Maven Compile

No terminal com o diretório no caminho do projeto, execute

1. `mvn compile`
2. `mvn exec:java -Dexec.mainClass="br.ufscar.dc.dsw.AcessaBD" -Dexec.cleanupDaemonThreads=false`
3. `mvn tomcat7:deploy` (certifique-se de estar com o servidor tomcat rodando)



### Conclusão

Essa configuração garante que a aplicação Jobfying esteja totalmente funcional, com um backend que interage com um banco de dados para gerenciar usuários, empresas, profissionais, vagas de emprego e candidaturas, e um frontend que exibe esses dados e permite interações dos usuários. Os arquivos `campos.jsp` estão incluídos em cada diretório específico de entidade para modularizar e reutilizar os campos de entrada em diferentes formulários.

### Considerações finais

Até o momento, há algumas coisas faltando para que o projeto esteja do jeito que eu queria. Entretanto, com a falta de tempo, vou debuggar algumas páginas e adicionar outras features futuramente
O problema do banco de dados foi resolvido alterando para MySQL e fazendo atualizações no create.sql
Entretanto, algumas modificações feitas fizeram com que o programa rodasse no Derby, no qual é executado a partir desse roteiro.
