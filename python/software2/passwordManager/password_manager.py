import sqlite3
from encryption import EncryptionManager


class PasswordManager:
    def __init__(self, db_file="passwords.db"):
        self.db_file = db_file
        self.conn = sqlite3.connect(self.db_file)
        self.encryption_manager = EncryptionManager()
        self.create_table()

    def create_table(self):
        with self.conn:
            self.conn.execute(
                """
                CREATE TABLE IF NOT EXISTS passwords (
                    service TEXT PRIMARY KEY,
                    username TEXT NOT NULL,
                    password TEXT NOT NULL,
                    service_name TEXT
                )
            """
            )
            self.conn.execute(
                """
                CREATE TABLE IF NOT EXISTS master_password (
                    id INTEGER PRIMARY KEY,
                    password TEXT NOT NULL
                )
            """
            )

    def is_master_password_set(self):
        cursor = self.conn.execute(
            """
            SELECT COUNT(*) FROM master_password
        """
        )
        row = cursor.fetchone()
        return row[0] > 0

    def set_master_password(self, master_password):
        encrypted_password = self.encryption_manager.encrypt(master_password)
        with self.conn:
            self.conn.execute(
                """
                INSERT INTO master_password (id, password)
                VALUES (1, ?)
                ON CONFLICT(id) DO UPDATE SET password=excluded.password
            """,
                (encrypted_password,),
            )

    def verify_master_password(self, master_password):
        cursor = self.conn.execute(
            """
            SELECT password FROM master_password WHERE id = 1
        """
        )
        row = cursor.fetchone()
        if row:
            encrypted_password = row[0]
            return (
                self.encryption_manager.decrypt(encrypted_password) == master_password
            )
        return False

    def add_password(self, service, username, password, service_name=""):
        encrypted_password = self.encryption_manager.encrypt(password)
        with self.conn:
            self.conn.execute(
                """
                INSERT INTO passwords (service, username, password, service_name)
                VALUES (?, ?, ?, ?)
            """,
                (service, username, encrypted_password, service_name),
            )

    def get_password(self, service):
        cursor = self.conn.execute(
            """
            SELECT username, password, service_name
            FROM passwords
            WHERE service = ?
        """,
            (service,),
        )
        row = cursor.fetchone()
        if row:
            username, encrypted_password, service_name = row
            return {
                "username": username,
                "password": self.encryption_manager.decrypt(encrypted_password),
                "service_name": service_name,
            }
        return {}

    def update_password(self, service, username, new_password, service_name=""):
        encrypted_password = self.encryption_manager.encrypt(new_password)
        with self.conn:
            self.conn.execute(
                """
                UPDATE passwords
                SET username = ?, password = ?, service_name = ?
                WHERE service = ?
            """,
                (username, encrypted_password, service_name, service),
            )

    def delete_password(self, service):
        with self.conn:
            self.conn.execute(
                """
                DELETE FROM passwords
                WHERE service = ?
            """,
                (service,),
            )
