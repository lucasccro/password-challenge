# 🔐Password Challenge

Uma API para validar o nível de segurança da senha fornecida pelo usuário. Será considerada uma senha válida aquela que seguir as regras abaixo.

## 📃 Regras

- Nove ou mais caracteres
- Ao menos 1 dígito
- Ao menos 1 letra minúscula
- Ao menos 1 letra maiúscula
- Ao menos 1 caractere especial
  - Considere como especial os seguintes caracteres: !@#$%^&*()-+
- Não possuir caracteres repetidos dentro do conjunto

Exemplos:  

```c#
IsValid("") // false  
IsValid("aa") // false  
IsValid("ab") // false  
IsValid("AAAbbbCc") // false  
IsValid("AbTp9!foo") // false  
IsValid("AbTp9!foA") // false
IsValid("AbTp9 fok") // false
IsValid("AbTp9!fok") // true
```


## 🔨 Como executar

Ao iniciar a aplicação é exposta a URN `/v1/password/valida` 

#### Via Swagger

Após iniciar a aplicação o swagger estará disponível `http://localhost:8085/itau-password-challenge`.

![swagger](https://user-images.githubusercontent.com/51891680/146826872-d378e76c-c8c4-4378-b917-3767cd2d2dbb.PNG)

Clicar em Try it out

![swagger2](https://user-images.githubusercontent.com/51891680/146827242-0b660f39-550f-4416-96bf-afb7bb371e20.PNG)

Executar o teste de password

![swagger3](https://user-images.githubusercontent.com/51891680/146827294-97587b39-fa1e-4102-b0d0-58ee63de62b7.PNG)





#### 💻 Via Term

Utilizando o método HTTP POST realizar a requisição você deve passar o seguinte body (formato: application/JSON):

{
	"password":"your_password"
}
cURL:

curl --request POST \
  --url http://localhost:8085/v1/password/valida \
  --header 'Content-Type: application/json' \
  --data '{
	"password":"AsbvcE2!34875"
}'





Lucas Costa Campos Rodrigues
