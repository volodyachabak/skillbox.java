import client.Client;
import client.ClientIndividual;
import client.ClientIndividualEntrepreneur;
import client.ClientLegalEntity;

public class Loader {



    public static void main(String[] args) {
        Client client1 = new ClientIndividual();;
//        client1 = new ClientLegalEntity();
//        client1 = new ClientIndividualEntrepreneur();

        System.out.println("Client balance " + client1.getBalance());
        client1.put(10000);
        System.out.println("Client balance after put " + client1.getBalance());
        client1.withDraw(1000);
        System.out.println("Client balance after withdraw " + client1.getBalance());


    }
}
