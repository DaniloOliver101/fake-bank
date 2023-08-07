import pymongo

# URL de conexão com o MongoDB local e o nome do banco de dados
MONGO_URL = "mongodb://localhost:27017/fake-bank"

def main():
    try:
        # Conecte-se ao MongoDB
        client = pymongo.MongoClient(MONGO_URL)

        # Acesse o banco de dados
        db = client.get_database()

        # Acesse a coleção que você deseja visualizar os logs (substitua "nome-da-colecao" pelo nome correto)
        collection = db["nome-da-colecao"]

        # Mostre todos os registros da coleção (logs)
        for log in collection.find():
            print(log)

    except pymongo.errors.ConnectionFailure as e:
        print("Falha ao conectar ao MongoDB:", e)
    except Exception as e:
        print("Erro:", e)

if __name__ == "__main__":
    main()
