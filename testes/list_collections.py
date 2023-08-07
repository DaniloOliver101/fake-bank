import pymongo

def listar_bancos_de_dados():
    # Configuração da conexão com o MongoDB
    usuario = "root"
    senha = "root123"
    host = "localhost"
    porta = 27017

    # Conexão ao MongoDB
    try:
        client = pymongo.MongoClient(f"mongodb://{usuario}:{senha}@{host}:{porta}/")
        print("Conexão ao MongoDB estabelecida com sucesso!")
    except pymongo.errors.ConnectionFailure as e:
        print(f"Erro ao conectar ao MongoDB: {e}")
        return

    # Listar bancos de dados
    try:
        lista_bancos = client.list_database_names()
        print("Lista de bancos de dados:")
        for banco in lista_bancos:
            print(banco)
    except pymongo.errors.OperationFailure as e:
        print(f"Erro ao listar bancos de dados: {e}")
    finally:
        # Fechar a conexão
        client.close()

if __name__ == "__main__":
    listar_bancos_de_dados()
