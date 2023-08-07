import pymongo

def get_customers():
    # Configuração da conexão com o MongoDB
    client = pymongo.MongoClient("mongodb://localhost:27017/")
    database = client["fake-bank"]  # Nome do banco "fake-bank"
    collection = database["customer"]  # Nome da coleção "customer"

    # Consulta todos os customers cadastrados no banco
    customers = collection.find()

    return customers

if __name__ == "__main__":
    customers_list = get_customers()
    print("Customers cadastrados:")
    for customer in customers_list:
        print(customer)
