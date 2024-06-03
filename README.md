# Java API com Spring Boot e PostgreSQL


Este projeto é um exemplo de API RESTful desenvolvida com Java 17 e Spring Boot configurada para ser executada dentro de um contêiner Docker. 

## Requisitos

- Docker instalado na sua máquina
- Maven instalado na sua máquina
- Eclipse ou outro IDE com suporte a Maven
- Java 17

## Passos para construir e executar o projeto

### 1. Importar o projeto no Eclipse

1. Abra o Eclipse.
2. Vá em `File > Import > Maven > Existing Maven Projects`.
3. Selecione o diretório onde o seu projeto está localizado e clique em `Finish`.

### 2. Atualizar as dependências do Maven

1. Clique com o botão direito no seu projeto no `Project Explorer`.
2. Selecione `Maven > Update Project...`.
3. Marque a caixa do seu projeto e clique em `OK`.

### 3.Construir o projeto
1. Clique com o botão direito no seu projeto no `Project Explorer`.
2. Selecione `Run As > Maven build...`.
3. Na caixa de diálogo que aparece, digite `package` no campo de `Goals` e clique em `Run`.
Isso irá gerar o arquivo JAR e colocá-lo na pasta `target` do seu projeto.
