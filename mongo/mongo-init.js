// Definir o banco de dados
db = db.getSiblingDB('fake-bank');

// Criar um usuário root com senha
db.createUser({
  user: 'root',
  pwd: 'root123',
  roles: [
    {
      role: 'readWrite',
      db: 'fake-bank',
    },
  ],
});
