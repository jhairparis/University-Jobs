from cryptography.fernet import Fernet


class EncryptionManager:
    def __init__(self):
        self.key = self.load_key()
        self.cipher_suite = Fernet(self.key)

    def load_key(self):
        try:
            with open("secret.key", "rb") as key_file:
                return key_file.read()
        except FileNotFoundError:
            key = Fernet.generate_key()
            with open("secret.key", "wb") as key_file:
                key_file.write(key)
            return key

    def encrypt(self, password):
        return self.cipher_suite.encrypt(password.encode()).decode()

    def decrypt(self, encrypted_password):
        return self.cipher_suite.decrypt(encrypted_password.encode()).decode()
