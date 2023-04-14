package sopt.org.firstSeminarAdvancedAssignment.service;

import sopt.org.firstSeminarAdvancedAssignment.domain.Client;
import sopt.org.firstSeminarAdvancedAssignment.repository.ClientRepository;

public class ClientService {
    private final ClientRepository clientRepository = new ClientRepository();

    public void registerClient(String accountNumber, String name, String birth, String tel, String address, String password) {
        Client client = new Client(accountNumber, name, birth, tel, address, password);
        clientRepository.register(client);
    }
}
