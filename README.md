# 🔐Password Challenge

Uma API para validar o nível de segurança da senha fornecida pelo usuário. Será considerada uma senha válida aquela que seguir as regras abaixo.

## 📃 Descrição

Considere uma senha sendo válida quando a mesma possuir as seguintes definições:

Nove ou mais caracteres
Ao menos 1 dígito
Ao menos 1 letra minúscula
Ao menos 1 letra maiúscula
Ao menos 1 caractere especial
Considere como especial os seguintes caracteres: !@#$%^&*()-+
Não possuir caracteres repetidos dentro do conjunto
Exemplo:

IsValid("") // false  
IsValid("aa") // false  
IsValid("ab") // false  
IsValid("AAAbbbCc") // false  
IsValid("AbTp9!foo") // false  
IsValid("AbTp9!foA") // false
IsValid("AbTp9 fok") // false
IsValid("AbTp9!fok") // true
```

## 🖱 Como utilizar


Ao iniciar a aplicação é exposta a URN `/v1/password/valida`


#### Via Swagger

Após iniciar a aplicação o swagger estará disponível `http://localhost:8085/itau-password-challenge`.

![swagger](https://user-images.githubusercontent.com/51891680/146822473-8dba72b5-7616-4aae-b8bd-5d1b4c4dbe67.PNG)

Clicar em Try it out

![swagger2](https://user-images.githubusercontent.com/51891680/146823806-2b639dc3-86b7-4601-95c2-9d91ba0349f1.PNG)

Executar o teste de password

![swagger3](https://user-images.githubusercontent.com/51891680/146824765-280ec962-0162-46c0-8537-ce0cceb94e69.PNG)


#### Via Term

Utilizando o método HTTP POST realizar a requisição você deve passar o seguinte body (formato: application/JSON):

{
	"password":"your_password"
}
cURL:

curl --request POST \
  --url http://localhost:8085/v1/password/validate \
  --header 'Content-Type: application/json' \
  --data '{
	"password":"AsbvcE2!34875"
}'
