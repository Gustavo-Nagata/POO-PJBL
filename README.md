# POO-PJBL



\# Sistema de Gerenciamento de Chamados (PjBL)



Projeto desenvolvido para a disciplina de Programação Orientada a Objetos (POO).

O sistema consiste numa aplicação desktop para gestão de tickets de suporte, implementando conceitos fundamentais de OO e persistência de dados.



---



\## Funcionalidades e Requisitos Atendidos



O projeto atende aos requisitos propostos divididos em duas partes:



\### Parte A: Fundamentos de POO

\* \*\*Encapsulamento:\*\* Todas as classes utilizam modificadores de acesso adequados.

\* \*\*Herança e Polimorfismo:\*\* Estrutura hierárquica com Pessoa (Abstrata) -> Colaborador (Abstrata) -> Cliente, AnalistaTI, AnalistaRH.

\* \*\*Classes e Métodos Abstratos:\*\* Implementação da classe Colaborador e do método obrigatório calcularSalario(), que possui comportamentos distintos (comissão para TI).

\* \*\*Coleções:\*\* Uso de ArrayList para gerenciamento dinâmico de chamados e usuários.



\### Parte B: Recursos Complementares

\* \*\*Interface Gráfica (GUI):\*\* Interface moderna construída com JavaFX (FXML + Controller), substituindo o menu de console.

\* \*\*Tratamento de Exceções:\*\* Criação de uma exceção personalizada (ChamadoException) para validar regras de negócio (ex: impedir fechamento de chamados já encerrados).

\* \*\*Persistência de Arquivos:\*\*

&nbsp;   \* \*\*Leitura:\*\* O sistema carrega automaticamente a base de dados inicial a partir de um arquivo CSV (colaboradores.csv).

&nbsp;   \* \*\*Escrita:\*\* Ao sair, o sistema salva os chamados pendentes em um arquivo de backup (chamados\_abertos.csv).



---



\## Estrutura do Projeto



\* \*\*src/\*\*: Contém todo o código fonte (.java) e arquivos de interface (.fxml).

\* \*\*lib/\*\*: Contém as bibliotecas do JavaFX (SDK) necessárias para a execução (garantindo portabilidade).

\* \*\*colaboradores.csv\*\*: Arquivo de dados inicial (localizado na raiz do projeto).



---



\## Como Executar o Projeto



IMPORTANTE: Devido às restrições de módulos das versões modernas do Java (JDK 11+), este projeto utiliza um inicializador especial (Launcher.java) para carregar as bibliotecas corretamente sem necessidade de configurações complexas de VM na IDE.



\### Passo a Passo (IntelliJ IDEA ou VS Code):



1\.  Abra a pasta do projeto na sua IDE.

2\.  Certifique-se de que a pasta "lib" foi reconhecida como biblioteca do projeto (ou adicione os arquivos .jar dela ao Classpath/Libraries).

3\.  Navegue até a pasta "src".

4\.  Localize o arquivo Launcher.java.

5\.  Clique com o botão direito e selecione "Run 'Launcher.main()'" (ou Executar).



Nota: Por favor, execute através do Launcher e não diretamente pelo MainFX. O Launcher garante o carregamento correto das dependências gráficas incluídas na pasta lib.



---



\## Guia de Uso



O sistema é dividido em duas abas principais:



1\.  \*\*Gestão de Chamados:\*\*

&nbsp;   \* Permite selecionar um Cliente e abrir um novo chamado.

&nbsp;   \* Visualização de todos os chamados em uma tabela.

&nbsp;   \* Opções para Atribuir um chamado a um Analista ou Fechar um chamado (regras de negócio aplicadas).



2\.  \*\*Visualizar Cadastros:\*\*

&nbsp;   \* Listagem completa de Clientes e Analistas carregados do arquivo CSV.

&nbsp;   \* Botão para verificar detalhes financeiros (Salário Base + Comissões) dos Analistas.



Para finalizar e salvar os dados, utilize o botão "Salvar Dados e Sair" na parte inferior da janela.



---



\*\*Autor:\*\* Brigitte Elaine Lee, Gustavo Iichiro Nagata, Lucas Andrzejewski de Lima,

\*\*Disciplina:\*\* Programação Orientada a Objetos

