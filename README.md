## DI

Create again a DAO abstraction and two implementations:
one in-memory and one JDBC (don't bother implementing the methods).

Make sure that both DAO implementations are managed by Spring and use
either @Primary or @Quailifer to help Spring resolve deps
for the Service.