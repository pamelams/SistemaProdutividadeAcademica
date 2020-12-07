# Sistema de Produtividade Acadêmica

## Como executar:

Para executar o sistema, basta compilar todas as classes juntas e executar a classe App. Isso pode ser feito pelo terminal executando os seguintes comandos na pasta raiz do projeto:

### No Windows:

dir /s /B *.java > sources.txt
javac @sources.txt -d .\build
java -cp .\build App

### No Linux:

find -name "*.java" > sources.txt
javac @sources.txt -d .\build
java -cp .\build App

## Para fazer login como administrador:

Usuário: admin
Senha: 1234

## Sobre o sistema:

### Login:

O administrador é responsável pela manutenção de todas as informações do sistema. Para os colaboradores, é possível fazer login no sistema apenas ver as informações dos projetos, colaboradores e das produções acadêmicas.


