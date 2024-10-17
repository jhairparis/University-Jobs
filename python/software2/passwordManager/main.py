from commands import CommandManager


def main():
    command_manager = CommandManager()
    print("Welcome to the Password Manager CLI!")

    if not command_manager.manager.is_master_password_set():
        print("No master password set. Please set a master password.")
        while True:
            master_password = input("Set master password: ").strip()
            confirm_password = input("Confirm master password: ").strip()
            if master_password == confirm_password:
                command_manager.manager.set_master_password(master_password)
                print("Master password set successfully.")
                break
            else:
                print("Passwords do not match. Please try again.")
    else:
        while True:
            master_password = input("Enter master password: ").strip()
            if command_manager.manager.verify_master_password(master_password):
                print("Master password verified successfully.")
                break
            else:
                print("Invalid master password. Please try again.")

    print("Type 'help' to see the list of available commands.")
    while True:
        command = input("Enter command: ").strip()
        if command.lower() == "help":
            print_help()
        else:
            command_manager.execute(command)


def print_help():
    help_text = """
    Available commands:
    - set_master_password <master_password>: Set the master password.
    - verify_master_password <master_password>: Verify the master password.
    - add <service> <username> <password> [service_name]: Add a new password for a service.
    - get <service>: Retrieve the password for a service.
    - update <service> <username> <new_password> [service_name]: Update the password for a service.
    - delete <service>: Delete the password for a service.
    - list_services: List all stored services.
    - help: Show this help message.
    - exit: Exit the Password Manager.
    """
    print(help_text)


if __name__ == "__main__":
    main()
