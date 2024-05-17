# Pagamento de contas
- microservice responsável por pelo pagamento de contas
  - via barcode ou pix
- fluxos:
  - validação do pagamento
     - fraude
     - risco
       - horario de pagamento
       - valor maximo de pagamento parametrizado no cadastro do cliente (service do cliente será via mockserver)
     - pagamento emitido/valido pelo emissor (emissor será um novo ms)
  - efetuar pagamento
   - calcular juros e multa pagamento vencido (detalhes do boleto vem na validacao junto ao emissor)  
   - saida do valor da conta do cliente (conta corrente será outro ms ou mockserver)
   - registro da baixa do barcode no emissor
   - registro do boleto pago pelo cliente
  - cancelamento do pagamento
   - emissor nao acatou o pagamento
     - pelo nao permitido o pagamento apos o vencimento
     - valor do pagamento acima do valor do boleto
    
# tecnologias utilizadas
- quarkus
- base relacional
- api rest
- kafka
- sqs
