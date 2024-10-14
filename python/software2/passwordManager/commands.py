from password_manager import PasswordManager


class Command:
    def execute(self, *args):
        pass


class SetMasterPasswordCommand(Command):
    def __init__(self, manager):
        self.manager = manager

    def execute(self, *args):
        if len(args) != 1:
            print("Usage: set_master_password <master_password>")
            return
        master_password = args[0]
        self.manager.set_master_password(master_password)
        print("Master password set successfully.")


class VerifyMasterPasswordCommand(Command):
    def __init__(self, manager):
        self.manager = manager

    def execute(self, *args):
        if len(args) != 1:
            print("Usage: verify_master_password <master_password>")
            return
        master_password = args[0]
        if self.manager.verify_master_password(master_password):
            print("Master password verified successfully.")
        else:
            print("Invalid master password.")


class AddPasswordCommand(Command):
    def __init__(self, manager):
        self.manager = manager

    def execute(self, *args):
        if len(args) < 3:
            print("Usage: add <service> <username> <password> [service_name]")
            return
        service, username, password = args[:3]
        service_name = args[3] if len(args) > 3 else ""
        self.manager.add_password(service, username, password, service_name)
        print(f"Password for '{service}' added successfully.")


class GetPasswordCommand(Command):
    def __init__(self, manager):
        self.manager = manager

    def execute(self, *args):
        if len(args) != 1:
            print("Usage: get <service>")
            return
        service = args[0]
        data = self.manager.get_password(service)
        if data:
            print(f"Service: {service}")
            print(f"Username: {data['username']}")
            print(f"Password: {data['password']}")
            if data["service_name"]:
                print(f"Service Name: {data['service_name']}")
        else:
            print(f"No password found for '{service}'.")


class UpdatePasswordCommand(Command):
    def __init__(self, manager):
        self.manager = manager

    def execute(self, *args):
        if len(args) < 3:
            print("Usage: update <service> <username> <new_password> [service_name]")
            return
        service, username, new_password = args[:3]
        service_name = args[3] if len(args) > 3 else ""
        self.manager.update_password(service, username, new_password, service_name)
        print(f"Password for '{service}' updated successfully.")


class DeletePasswordCommand(Command):
    def __init__(self, manager):
        self.manager = manager

    def execute(self, *args):
        if len(args) != 1:
            print("Usage: delete <service>")
            return
        service = args[0]
        self.manager.delete_password(service)
        print(f"Password for '{service}' deleted successfully.")


class CommandManager:
    def __init__(self):
        self.manager = PasswordManager()
        self.commands = {
            "set_master_password": SetMasterPasswordCommand(self.manager),
            "verify_master_password": VerifyMasterPasswordCommand(self.manager),
            "add": AddPasswordCommand(self.manager),
            "get": GetPasswordCommand(self.manager),
            "update": UpdatePasswordCommand(self.manager),
            "delete": DeletePasswordCommand(self.manager),
        }

    def execute(self, command_line):
        parts = command_line.split()
        if not parts:
            print("No command entered. Type 'help' for a list of commands.")
            return
        command_name = parts[0]
        if command_name == "exit":
            print("Exiting Password Manager. Goodbye!")
            exit(0)
        args = parts[1:]
        command = self.commands.get(command_name)
        if command:
            command.execute(*args)
        else:
            print(
                f"Unknown command: {command_name}. Type 'help' for a list of commands."
            )
